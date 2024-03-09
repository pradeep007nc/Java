package dev.pradeep.SirmaAssignment.Model;

import dev.pradeep.SirmaAssignment.Enum.ProjectStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.SQLType;
import java.time.LocalDate;
import java.util.List;

/*
    I'd defined in base entity where other metadata is also defined
    like created at and updated at
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
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
