package dev.pradeep.SirmaAssignment.Mapper;

import dev.pradeep.SirmaAssignment.Dto.Request.CreateProjectDto;
import dev.pradeep.SirmaAssignment.Dto.Request.UpdateProjectDto;
import dev.pradeep.SirmaAssignment.Model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/*
   using mapstruct to reduce boilerplate
   automatically, the member variables will be mapped by name
*/
@Mapper
public interface ProjectMapper {

  @Mapping(target = "id", ignore = true)
  Project createProject(CreateProjectDto createProjectDto);

  @Mapping(target = "id", ignore = true)
  void updateProject(@MappingTarget Project project, UpdateProjectDto updateProjectDto);
}
