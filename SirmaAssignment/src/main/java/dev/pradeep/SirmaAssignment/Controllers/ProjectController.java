package dev.pradeep.SirmaAssignment.Controllers;

import dev.pradeep.SirmaAssignment.Dto.Request.CreateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Request.UpdateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectCreatedResponse;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectDeletedResponse;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectUpdatedResponse;
import dev.pradeep.SirmaAssignment.Model.Project;
import dev.pradeep.SirmaAssignment.Services.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @DeleteMapping("/delete-project/{projectId}")
    public ProjectDeletedResponse deleteProject(@PathVariable Long projectId) {
        return projectService.deleteProject(projectId);
    }

    @PostMapping("update-project")
    public ProjectUpdatedResponse updateProject(@RequestBody @Valid UpdateProjectDto updateProjectDto) {
        return projectService.updateProject(updateProjectDto);
    }

    @PostMapping("/create-project")
    public ProjectCreatedResponse createProject(@RequestBody @Valid CreateProjectDto createProjectDto) {
        return projectService.createProject(createProjectDto);
    }

    @GetMapping("/read-project/{projectId}")
    public Project readProject(@PathVariable Long projectId) {
        return projectService.findProject(projectId);
    }
}
