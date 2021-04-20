package com.prime.task.prime.common.mappers;

import com.prime.task.prime.dto.ProjectDTO;
import com.prime.task.prime.model.Project;
import org.modelmapper.ModelMapper;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDTO toProjectDTO(Project project) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(project, ProjectDTO.class);
    }

    public static Project toProject(ProjectDTO projectDTO) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(projectDTO, Project.class);
    }

    public static Function<Project, Set<ProjectDTO>> findSiblings = person -> person.getParent().getChildren().stream()
            .map(p -> ProjectDTO.builder().id(p.getId()).name(p.getName()).build()).collect(Collectors.toSet());

    public static Function<Project, ProjectDTO> mapToProjectDTO = p -> ProjectDTO.builder().id(p.getId()).name(p.getName()).parent(p.getParent()).children(p.getChildren()).build();
}


