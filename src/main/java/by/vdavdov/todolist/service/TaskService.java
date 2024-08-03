package by.vdavdov.todolist.service;

import by.vdavdov.todolist.mapper.TaskDtoMapper;
import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.model.entity.Task;
import by.vdavdov.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public Task create(TaskTo taskTo) {
        Task entity = TaskDtoMapper.MAPPER.toEntity(taskTo);
        return taskRepository.save(entity);
    }

    public TaskTo getById(Long id) {
        return TaskDtoMapper.MAPPER.toDto(taskRepository.findById(id).orElse(null));
    }

    public List<TaskTo> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskDtoMapper.MAPPER::toDto)
                .toList();
    }

    public long count() {
        return taskRepository.count();
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public void deleteAll(List<Task> tasks) {
        taskRepository.deleteAll(tasks);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
