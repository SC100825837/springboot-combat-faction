package com.jc.research.controller;

import com.jc.research.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @program: springboot-combat-faction
 * @description:
 * @author: SunChao
 * @create: 2021-08-29 19:03
 **/
@Controller
public class TestValidator {

    @GetMapping("test")
    public String showForm(User user) {
        return "form";
    }

    @GetMapping("results")
    public String results() {
        return "results";
    }

    @PostMapping("test")
    public String checkUser(@Valid User user, BindingResult bingingResult, RedirectAttributes attributes) {
        //特别注意：实体中的属性都必须被验证过，否则不会成功
        if (bingingResult.hasErrors()) {
            return "form";
        }
        attributes.addFlashAttribute("user", user);
        return "redirect:/results";
    }
}
