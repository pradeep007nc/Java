package dev.pradeep.SirmaAssignment.Dto.Request;

import dev.pradeep.SirmaAssignment.Enum.ProjectStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class UpdateProjectDto {
  @NotNull(message = "Project id is required")
  private Long projectId;

  private String name;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;
  private List<String> technologies;
  private List<String> projectRequirements;
  private String projectType;
  private ProjectStatus status;
}
