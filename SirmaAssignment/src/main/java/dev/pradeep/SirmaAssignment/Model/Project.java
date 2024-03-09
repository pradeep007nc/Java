package dev.pradeep.SirmaAssignment.Model;

import dev.pradeep.SirmaAssignment.Enum.ProjectStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
  /*
     I'd defined in base entity where other metadata is also defined
     like created at and updated at
     id autoincrement
  */
  private String name;
  private String description;
  private LocalDate startDate;

  private LocalDate endDate;

  @JdbcTypeCode(SqlTypes.JSON)
  private List<String> technologies;

  @JdbcTypeCode(SqlTypes.JSON)
  private List<String> projectRequirements;

  private String projectType;

  @Enumerated(EnumType.STRING)
  private ProjectStatus status;
}
