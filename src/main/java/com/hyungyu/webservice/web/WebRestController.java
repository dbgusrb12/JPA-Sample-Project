package com.hyungyu.webservice.web;

import com.hyungyu.webservice.dto.PostSaveRequestDto;
import com.hyungyu.webservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebRestController {
    private final PostService postService;

    @PostMapping(value = "/post")
    public Long savePost(@RequestBody PostSaveRequestDto dto) {
        return postService.save(dto);
    }

}
