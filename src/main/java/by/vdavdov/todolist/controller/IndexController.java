package by.vdavdov.todolist.controller;

import by.vdavdov.todolist.mapper.TaskDtoMapper;
import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.model.entity.Task;
import by.vdavdov.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/index", "/tasks", "/"})
@RequiredArgsConstructor
public class IndexController {

    private final TaskService taskService;

    @GetMapping
    public String get(@RequestParam(defaultValue = "0") int page,
                      @RequestParam(defaultValue = "5") int size,
                      Model model) {
        List<TaskTo> tasks = taskService.getAll();
        model.addAttribute("newTask", new Task());
        model.addAttribute("tasks", tasks);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", taskService.findPaginated(page + 1, size).getTotalPages());
        return "index";
    }

    @PostMapping
    public String post(@ModelAttribute TaskTo task, Model model) {
        model.addAttribute("newTask", taskService.create(task));;
        return "redirect:/index";
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        taskService.deleteById(id);
        return "redirect:/index";
    }
}
