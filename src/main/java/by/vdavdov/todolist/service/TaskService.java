package by.vdavdov.todolist.service;

import by.vdavdov.todolist.mapper.TaskDtoMapper;
import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.model.entity.Task;
import by.vdavdov.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;

    public Task create(TaskTo taskTo) {
        Task entity = taskDtoMapper.toEntity(taskTo);
        return taskRepository.save(entity);
    }

    public Task update(TaskTo taskTo) {
        Task entity = taskDtoMapper.toEntity(taskTo);
        return taskRepository.save(entity);
    }

    public Page<Task> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return taskRepository.findAll(pageable);
    }

    public TaskTo getById(Long id) {
        return taskDtoMapper.toDto(taskRepository.findById(id).orElse(null));
    }

    public List<TaskTo> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .stream()
                .map(taskDtoMapper::toDto)
                .toList();
    }

    public List<TaskTo> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskDtoMapper::toDto)
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
