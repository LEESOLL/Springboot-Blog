package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class BlogResponseDto {
    private String author;
    private String contents;
    private String title;

    public BlogResponseDto(String author, String contents, String title) {
        this.author = author;
        this.contents = contents;
        this.title = title;
    }
}
