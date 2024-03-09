package dev.pradeep.SirmaAssignment;

import dev.pradeep.SirmaAssignment.Dto.Request.CreateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Request.UpdateProjectDto;
import dev.pradeep.SirmaAssignment.Enum.ProjectStatus;
import dev.pradeep.SirmaAssignment.Model.Project;
import dev.pradeep.SirmaAssignment.Services.ProjectService;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
public class ProjectServiceTest {

  @MockBean public ProjectService projectService;

  @Test
  @Order(2)
  public void updateProjectTest() {
    UpdateProjectDto updateProjectDto =
        UpdateProjectDto.builder()
            .name("kidney stone detector")
            .projectType("machine learning project")
            .status(ProjectStatus.IN_PROGRESS)
            .startDate(LocalDate.now())
            .endDate(LocalDate.now().plusMonths(2))
            .description("This is a machine learning project")
            .projectRequirements(List.of("4gb ram", "50gb ssd", "cpu 5 gen"))
            .technologies(List.of("java", "python", "kotlin"))
            .build();

    projectService.updateProject(updateProjectDto);

    // check if the start date is less than end date
    Assertions.assertThat(updateProjectDto.getEndDate()).isAfter(updateProjectDto.getStartDate());
  }

  @Test
  @Order(1)
  public void createProjectTest() {
    CreateProjectDto createProjectDto =
        CreateProjectDto.builder()
            .name("kidney stone detector")
            .projectType("machine learning project")
            .status(ProjectStatus.IN_PROGRESS)
            .startDate(LocalDate.now())
            .endDate(LocalDate.now().plusMonths(2))
            .description("This is a machine learning project")
            .projectRequirements(List.of("4gb ram", "50gb ssd", "cpu 5 gen"))
            .technologies(List.of("java", "python", "kotlin"))
            .build();

    projectService.createProject(createProjectDto);

    // check if the start date is less than end date
    Assertions.assertThat(createProjectDto.getEndDate()).isAfter(createProjectDto.getStartDate());
  }

  /*
     before adding to the database, it is pretested and validated
     null initially test fails
  */
  @Test
  @Order(3)
  public void getTest() {
    Project project = projectService.findProject(1L);
    Assertions.assertThat(project.getId()).isEqualTo(1L);
  }

  /*
     dummy test to check if the database is not empty
     test fails as the list is empty by default as an in-memory database.
  */
  @Test
  @Order(4)
  public void getListProjects() {
    List<Project> projects = projectService.findAllProjects();
    Assertions.assertThat(projects.size()).isGreaterThan(0);
  }

  /*
     check if the project is deleted
     if null then successfully deleted
  */
  @Test
  @Order(5)
  public void deleteProjectTest() {
    projectService.deleteProject(1L);
    Project project = projectService.findProject(1L);
    Assertions.assertThat(project).isNull();
  }
}
