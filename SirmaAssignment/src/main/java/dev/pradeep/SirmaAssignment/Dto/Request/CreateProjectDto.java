package dev.pradeep.SirmaAssignment.Dto.Request;

import dev.pradeep.SirmaAssignment.Enum.ProjectStatus;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class CreateProjectDto {

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Description is required")
  @Size(min = 10, message = "Description must contain at least 10 characters")
  private String description;

  @NotNull(message = "Start date is required")
  private LocalDate startDate;

  @NotNull(message = "End date is required")
  private LocalDate endDate;

  @NotEmpty(message = "Technologies are required")
  private List<String> technologies;

  @NotEmpty(message = "Project requirements are required")
  private List<String> projectRequirements;

  @NotBlank(message = "Project type is required")
  private String projectType;

  @NotNull(message = "Status is required")
  private ProjectStatus status;
}
