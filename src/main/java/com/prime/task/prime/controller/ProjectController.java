package com.prime.task.prime.controller;

        import com.prime.task.prime.dto.ProjectDTO;
        import com.prime.task.prime.dto.ProjectItemDTO;
        import com.prime.task.prime.model.Project;
        import com.prime.task.prime.repository.ProjectRepository;
        import com.prime.task.prime.service.ProjectService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.Set;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getAllDetails(@PathVariable("id") Long id) {
        return projectService.getAllDetails(id);
    }

    @GetMapping("/{id}/siblings")
    public ResponseEntity<Set<ProjectDTO>> getAllSiblings(@PathVariable("id") Long id) {
        return projectService.getAllSiblings(id);
    }

    @PostMapping
    public ResponseEntity<Project> createSample(@Valid @RequestBody ProjectDTO projectDTO) {
        return new ResponseEntity(projectService.createProject(projectDTO), HttpStatus.CREATED);

    }

    @PostMapping(path = "/{projectId}")
    public ResponseEntity<Project> createProjectItems(@PathVariable long projectId, @Valid @RequestBody ProjectItemDTO projectItemDTO) {
        return new ResponseEntity(projectService.createProjectData(projectItemDTO, projectId), HttpStatus.CREATED);

    }

}