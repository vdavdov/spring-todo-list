package by.vdavdov.todolist.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LanguageController {
    private final LocaleResolver localeResolver;

    @GetMapping("/change-language/{lang}")
    public String changeLanguage(@RequestParam("lang") String language, HttpServletRequest request, HttpServletResponse response) {
        localeResolver.setLocale(request, response, new Locale(language));
        return "redirect:/tasks";
    }
    //todo
}
