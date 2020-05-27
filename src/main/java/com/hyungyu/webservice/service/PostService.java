package com.hyungyu.webservice.service;

import com.hyungyu.webservice.domain.post.PostRepository;
import com.hyungyu.webservice.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }
}
