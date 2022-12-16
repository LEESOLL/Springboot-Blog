package com.sparta.blog.service;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.dto.BlogResponseDto;
import com.sparta.blog.dto.DeleteRequestDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Blog createBlog(BlogRequestDto requestDto) { //게시물을 작성해서 리턴해주는 메서드
        Blog blog = new Blog(requestDto); //RequestDto에서 정보를 받아서 blog 객체 생성
        blogRepository.save(blog); //DB에 블로그 객체 저장
        return blog; //블로그를 리턴해줌
    }

    @Transactional(readOnly = true) //읽기 전용
    public List<BlogResponseDto> getBlogs() { //블로그 전체 게시물 조회
        List<Blog> list = blogRepository.findAllByOrderByModifiedAtDesc();
        List<BlogResponseDto> responseDtoList = list.stream().map(x -> new BlogResponseDto(x)).toList();
//        List<BlogResponseDto> responseDtoList = new ArrayList<>();
//        for(Blog blog : list) {
//            BlogResponseDto blogResponseDto = new BlogResponseDto(blog.getAuthor(), blog.getContents(), blog.getTitle());
//            responseDtoList.add(blogResponseDto);
//        }
        return responseDtoList;
    }

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }

    @Transactional
    public String deleteBlog(Long id, String password) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 게시물 없음!"));
        if(password.equals(blog.getPassword())) {
            blogRepository.deleteById(id);
            return "삭제가 완료되었습니다.";
        }
        else {
            throw new IllegalArgumentException("비밀번호 틀림!");
        }
    }

    @Transactional
    public BlogResponseDto getBlog(Long id) { //하나의 블로그만 조회
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);
        return blogResponseDto;
    }
}

