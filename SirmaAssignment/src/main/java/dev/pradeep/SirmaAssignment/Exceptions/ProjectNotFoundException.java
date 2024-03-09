package dev.pradeep.SirmaAssignment.Exceptions;

import lombok.Data;

@Data
public class ProjectNotFoundException extends RuntimeException {
  private final String message = "Project doesn't exist";
}
