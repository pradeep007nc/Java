package dev.pradeep.SirmaAssignment.Repository;

import dev.pradeep.SirmaAssignment.Dao.ProjectDao;
import dev.pradeep.SirmaAssignment.Exceptions.ProjectNotFoundException;
import dev.pradeep.SirmaAssignment.Model.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ProjectRepository {
  private final ProjectDao projectDao;

  public void saveProject(Project project) {
    projectDao.save(project);
  }

  public Project findById(Long projectId) {
    return projectDao.findById(projectId).orElseThrow(ProjectNotFoundException::new);
  }

  public void deleteById(Long projectId) {
    projectDao.deleteById(projectId);
  }
}
