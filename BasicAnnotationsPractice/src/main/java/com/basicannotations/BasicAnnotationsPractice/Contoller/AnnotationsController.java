package com.basicannotations.BasicAnnotationsPractice.Contoller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationsController {

    @GetMapping("/")
    public String getName(){
        return "Basic Annotations";
    }

}
