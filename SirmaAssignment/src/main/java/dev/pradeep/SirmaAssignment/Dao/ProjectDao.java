package dev.pradeep.SirmaAssignment.Dao;

import dev.pradeep.SirmaAssignment.Model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDao extends CrudRepository<Project, Long> {}
