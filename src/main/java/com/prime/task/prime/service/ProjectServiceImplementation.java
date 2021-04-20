package com.prime.task.prime.service;

import com.prime.task.prime.dto.ProjectDTO;
import com.prime.task.prime.dto.ProjectItemDTO;
import com.prime.task.prime.model.Project;
import com.prime.task.prime.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.prime.task.prime.common.mappers.ProjectMapper.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImplementation implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public Project createProject(ProjectDTO projectDTO) {
        Project object = toProject(projectDTO);
        Project parent = projectDTO.getParent();
        object.setParent(parent);
        Project project = projectRepository.save(object);
        return project;
    }

    @Override
    public Project createProjectData(ProjectItemDTO projectItemDTO, long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (projectItemDTO.getTasks() != null && !projectItemDTO.getTasks().isEmpty()) {
            projectItemDTO.getTasks().stream().forEach(task -> {
                task.setProject(project.get());
                taskRepository.save(task);
            });
        }

        if (projectItemDTO.getNotes() != null && !projectItemDTO.getNotes().isEmpty()) {
            projectItemDTO.getNotes().stream().forEach(note -> {
                note.setProject(project.get());
                noteRepository.save(note);
            });
        }
        if (projectItemDTO.getAttachments() != null && !projectItemDTO.getAttachments().isEmpty()) {
            projectItemDTO.getAttachments().stream().forEach(attachment -> {
                attachment.setProject(project.get());
                attachmentRepository.save(attachment);
            });
        }

        return project.get();
    }

    @Override
    public ResponseEntity<ProjectDTO> getAllDetails(long id) {
        return projectRepository.findById(id).map(mapToProjectDTO).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Set<ProjectDTO>> getAllSiblings(long id) {
        return projectRepository.findById(id).map(findSiblings).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> projects = projectRepository.findAll();

        List<ProjectDTO> result = projects.stream().map(p -> ProjectDTO.builder().id(p.getId()).name(p.getName()).parent(p.getParent()).children(p.getChildren()).build()).collect(Collectors.toList());

        return result;

    }
}


