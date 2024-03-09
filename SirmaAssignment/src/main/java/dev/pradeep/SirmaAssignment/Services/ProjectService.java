package dev.pradeep.SirmaAssignment.Services;

import dev.pradeep.SirmaAssignment.Dto.Request.CreateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Request.UpdateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectCreatedResponse;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectDeletedResponse;
import dev.pradeep.SirmaAssignment.Dto.Response.ProjectUpdatedResponse;
import dev.pradeep.SirmaAssignment.Mapper.ProjectMapper;
import dev.pradeep.SirmaAssignment.Model.Project;
import dev.pradeep.SirmaAssignment.Repository.ProjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {
  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  public ProjectCreatedResponse createProject(CreateProjectDto createProjectDto) {
    Project project = projectMapper.createProject(createProjectDto);
    projectRepository.saveProject(project);
    return new ProjectCreatedResponse();
  }

  public ProjectUpdatedResponse updateProject(UpdateProjectDto updateProjectDto) {
    Project project = projectRepository.findById(updateProjectDto.getProjectId());
    projectMapper.updateProject(project, updateProjectDto);
    projectRepository.saveProject(project);
    return new ProjectUpdatedResponse();
  }

  public ProjectDeletedResponse deleteProject(Long projectId) {
    // check if the project exists
    Project project = projectRepository.findById(projectId);
    projectRepository.deleteById(project.getId());
    return new ProjectDeletedResponse();
  }

  public Project findProject(Long projectId) {
    return projectRepository.findById(projectId);
  }

  public List<Project> findAllProjects() {
    return projectRepository.findAll();
  }
}
