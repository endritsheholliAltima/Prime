
package com.prime.task.prime.service;

import com.prime.task.prime.dto.ProjectDTO;
import com.prime.task.prime.dto.ProjectItemDTO;
import com.prime.task.prime.model.Project;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ProjectService {

    ProjectDTO getProject(long projectId);

    Project createProject(ProjectDTO projectDTO);

    Project createProjectItems(ProjectItemDTO projectItemDTO, long projectId);

    Project createProjectData(ProjectItemDTO projectItemDTO, long projectId);

    ResponseEntity<ProjectDTO> getAllDetails(long id);

    ResponseEntity<Set<ProjectDTO>> getAllSiblings(long id);
}
