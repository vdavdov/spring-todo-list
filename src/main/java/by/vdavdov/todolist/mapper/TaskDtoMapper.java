package by.vdavdov.todolist.mapper;

import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.model.entity.Task;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {TaskDtoMapper.class})
public interface TaskDtoMapper {
    TaskDtoMapper MAPPER = Mappers.getMapper(TaskDtoMapper.class);

    Task toEntity(TaskTo taskDto);

    TaskTo toDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskTo taskDto, @MappingTarget Task task);
}
