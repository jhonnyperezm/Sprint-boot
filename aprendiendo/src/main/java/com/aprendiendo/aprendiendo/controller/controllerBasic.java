package com.aprendiendo.aprendiendo.controller;

import com.aprendiendo.aprendiendo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class controllerBasic {

    private Object getPosts() {
    }


    @GetMapping(path = {"/post","/"})
    public String saludar(Model model){
        model.addAttribute("post",this.getPosts());
    }

    @GetMapping(path = "/postNew")
    public String addNewPost(Post post, Model model){

    }


}
