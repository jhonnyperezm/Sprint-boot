package com.aprendiendo.aprendiendo.controller;

import com.aprendiendo.aprendiendo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class controllerBasic {

    private List<Post> getPosts() {
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,"POST DESARROLLO WEB","http://localhost/img/post.jpg",new Date(),"Desarrollo web"));
        post.add(new Post(2,"POST DESARROLLO WEB","http://localhost/img/post.jpg",new Date(),"Desarrollo web"));
        post.add(new Post(3,"POST DESARROLLO WEB","http://localhost/img/post.jpg",new Date(),"Desarrollo web"));
        post.add(new Post(4,"POST DESARROLLO WEB","http://localhost/img/post.jpg",new Date(),"Desarrollo web"));
        return post;
    }

    @GetMapping(path = {"/post","/"})
    public String saludar(Model model){
        model.addAttribute("posts",this.getPosts());
        return "index";
    }

    @GetMapping(path = "/postNew")
    public ModelAndView getForm(Post post, Model model){
        return new ModelAndView("form").addObject("post", new Post());
    }

    @PostMapping(path = "/addNewPost")
    public String addNewPost(Post post, Model model){
        List<Post> posts = this.getPosts();
        posts.add(post);
        model.addAttribute("posts",posts);
        return "index";
    }


}
