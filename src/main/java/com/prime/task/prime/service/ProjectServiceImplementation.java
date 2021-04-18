package com.prime.task.prime.service;

        import com.prime.task.prime.dto.ProjectDTO;
        import com.prime.task.prime.dto.ProjectItemDTO;
        import com.prime.task.prime.model.Project;
        import com.prime.task.prime.repository.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import static com.prime.task.prime.common.mappers.ProjectMapper.*;

        import java.util.Optional;
        import java.util.Set;

@Service
public class ProjectServiceImplementation implements ProjectService {

    //  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public ProjectDTO getProject(long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        ProjectDTO result = toProjectDTO(project.get());
        return result;
    }

    @Override
    public Project createProject(ProjectDTO projectDTO) {
        Project object = toProject(projectDTO);
        Project parent = projectDTO.getParent();
        object.setParent(parent);
        Project project = projectRepository.save(object);
        return  project;
    }

    @Override
    public Project createProjectItems(ProjectItemDTO projectItemDTO, long projectId) {
        //ProjectItemModel projectItemModel =  toProjectItemModel(projectItemDTO);
     /*   Optional<Project> project = projectRepository.findById(projectId);

        projectItemDTO.getProjectItems().stream().forEach(item -> {
            item.setProject(project.get());
            projectItemRepository.save(item);
        });

        return project.get(); */
        return null;
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
}


