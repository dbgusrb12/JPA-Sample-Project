package com.hyungyu.webservice.domain;

import com.hyungyu.webservice.domain.post.Post;
import com.hyungyu.webservice.domain.post.PostRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         **/
        postRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        // given
        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("dbgusrb12@gmail.com")
                .build());
        // when
        List<Post> postList = postRepository.findAll();

        // then
        Post post = postList.get(0);
        assertThat(post.getTitle(), is("테스트 게시글"));
        assertThat(post.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        // given
        LocalDateTime now = LocalDateTime.now();
        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("dbgusrb12@gmail.com")
                .build());
        // when
        List<Post> postList = postRepository.findAll();

        // then
        Post post = postList.get(0);
        assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
    }

}
