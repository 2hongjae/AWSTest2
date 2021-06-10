package com.test.awstest.service.posts;

import com.test.awstest.domain.posts.Posts;
import com.test.awstest.domain.posts.PostsRepository;
import com.test.awstest.web.dto.PostsUpdateRequestDto;
import com.test.awstest.web.dto.PostsResponseDto;
import com.test.awstest.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 롬복기능. final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다.2 id="+id));

        return new PostsResponseDto(entity);
    }

}
