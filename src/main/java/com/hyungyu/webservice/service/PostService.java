package com.hyungyu.webservice.service;

import com.hyungyu.webservice.domain.post.PostRepository;
import com.hyungyu.webservice.dto.PostMainResponseDto;
import com.hyungyu.webservice.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostMainResponseDto> findAllDesc() {
        return postRepository.findAllDesc().map(PostMainResponseDto::new).collect(Collectors.toList());
    }


}
