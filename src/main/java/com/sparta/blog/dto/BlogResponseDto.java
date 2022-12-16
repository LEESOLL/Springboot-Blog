package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogResponseDto {
    private final String author;
    private final String contents;
    private final String title;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

//    public BlogResponseDto(String author, String contents, String title) {
//        this.author = author;
//        this.contents = contents;
//        this.title = title;
//    }

    public BlogResponseDto(Blog blog) {
        this.title = blog.getTitle();
        this.author = blog.getAuthor();
        this.contents = blog.getContents();
        this.createAt = blog.getCreatedAt();
        this.modifiedAt = blog.getModifiedAt();
    }
}
