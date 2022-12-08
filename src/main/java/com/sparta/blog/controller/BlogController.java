package com.sparta.blog.controller;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.dto.BlogResponseDto;
import com.sparta.blog.dto.DeleteRequestDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index"); //생성자에 입력한 templates를 반환해줌
    }

    @PostMapping("/api/posts")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        return blogService.createBlog(requestDto);
    }

    @GetMapping("/api/posts")
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogs();
    }

    @GetMapping("/api/posts/{id}")
    public BlogResponseDto getBlog(@PathVariable Long id) {
        return blogService.getBlog(id);
    }

    @PutMapping("/api/posts/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deleteBlog(@PathVariable Long id, @RequestBody DeleteRequestDto requestDto) {
        return blogService.deleteBlog(id, requestDto.getPassword());
    }
}
