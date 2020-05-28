package com.hyungyu.webservice.service;

import com.hyungyu.webservice.domain.post.Post;
import com.hyungyu.webservice.domain.post.PostRepository;
import com.hyungyu.webservice.dto.PostMainResponseDto;
import com.hyungyu.webservice.dto.PostSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanup () {
        postRepository.deleteAll();
    }

    @Test
    public void post테이블_저장() {
        // given
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .author("dbgusrb12@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();
        // when
        postService.save(dto);

        // then
        Post post = postRepository.findAll().get(0);
        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(post.getTitle()).isEqualTo(dto.getTitle());
        assertThat(post.getContent()).isEqualTo(dto.getContent());
    }

    @Test
    public void post테이블_데이터_뽑아오기() {
        // given

        // when
        List<PostMainResponseDto> posts = postService.findAllDesc();
        // then
        assertThat(posts.get(0).getAuthor()).isEqualTo("test2@gmail.com");
        assertThat(posts.get(0).getTitle()).isEqualTo("테스트2");
        assertThat(posts.get(1).getAuthor()).isEqualTo("test1@gmail.com");
        assertThat(posts.get(1).getTitle()).isEqualTo("테스트1");
    }

}
