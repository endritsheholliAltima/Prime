package com.prime.task.prime.controller;

import com.prime.task.prime.dto.ProjectDTO;
import com.prime.task.prime.dto.ProjectItemDTO;
import com.prime.task.prime.model.Project;
import com.prime.task.prime.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getAllDetails(@PathVariable("id") Long id) {
        return projectService.getAllDetails(id);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProducts() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("/{id}/siblings")
    public ResponseEntity<Set<ProjectDTO>> getAllSiblings(@PathVariable("id") Long id) {
        return projectService.getAllSiblings(id);
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDTO projectDTO) {
        return new ResponseEntity(projectService.createProject(projectDTO), HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(path = "/{projectId}")
    public ResponseEntity<Project> createProjectItems(@PathVariable long projectId, @Valid @RequestBody ProjectItemDTO projectItemDTO) {
        return new ResponseEntity(projectService.createProjectData(projectItemDTO, projectId), HttpStatus.CREATED);

    }

}