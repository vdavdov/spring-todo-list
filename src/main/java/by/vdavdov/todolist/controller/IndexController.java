package by.vdavdov.todolist.controller;

import by.vdavdov.todolist.mapper.TaskDtoMapper;
import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping(value = {"/index", "/tasks", "/"})
@RequiredArgsConstructor
public class IndexController {
    private final TaskService taskService;

    @GetMapping(value = {"/index", "/tasks", "/"})
    public String get(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
        List<TaskTo> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
