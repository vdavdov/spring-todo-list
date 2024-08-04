package by.vdavdov.todolist.mapper;

import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.model.entity.Task;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface TaskDtoMapper {
    Task toEntity(TaskTo taskDto);

    TaskTo toDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskTo taskDto, @MappingTarget Task task);
}
