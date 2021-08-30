package com.jc.research.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-combat-faction
 * @description:
 * @author: SunChao
 * @create: 2021-08-29 20:15
 **/
@RestController
public class AopLogController {

    @GetMapping("aoptest")
    public String aVoid() {
        return "hello aop test";
    }
}
