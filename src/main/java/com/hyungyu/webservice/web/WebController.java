package com.hyungyu.webservice.web;

import com.hyungyu.webservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final PostService postService;

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("posts", postService.findAllDesc());
        return "main";
    }

}
