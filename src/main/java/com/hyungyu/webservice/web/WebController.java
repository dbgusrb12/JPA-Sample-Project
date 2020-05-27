package com.hyungyu.webservice.web;

import com.hyungyu.webservice.dto.PostSaveRequestDto;
import com.hyungyu.webservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class WebController {

    private PostService postService;

    @GetMapping(value = "/")
    public String main() {
        return "main";
    }

    @PostMapping(value = "/post")
    public Long savePost(@RequestBody PostSaveRequestDto dto) {
        return postService.save(dto);
    }


}
