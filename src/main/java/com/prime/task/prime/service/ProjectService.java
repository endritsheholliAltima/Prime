
package com.prime.task.prime.service;

import com.prime.task.prime.dto.ProjectDTO;
import com.prime.task.prime.dto.ProjectItemDTO;
import com.prime.task.prime.model.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    Project createProject(ProjectDTO projectDTO);

    Project createProjectData(ProjectItemDTO projectItemDTO, long projectId);

    ResponseEntity<ProjectDTO> getAllDetails(long id);

    ResponseEntity<Set<ProjectDTO>> getAllSiblings(long id);

    List<ProjectDTO> getAll();
}
