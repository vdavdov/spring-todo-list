package by.vdavdov.todolist.controller;

import by.vdavdov.todolist.model.dto.TaskTo;
import by.vdavdov.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class EditController {
    private final TaskService taskService;

    @PostMapping("/tasks/edit")
    public String updateTask(@ModelAttribute TaskTo task) {
        taskService.update(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        TaskTo task = taskService.getById(id);
        model.addAttribute("task", task);
        taskService.update(task);
        return "edit";
    }

}
