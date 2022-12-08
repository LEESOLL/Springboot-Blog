package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String author;
    private String contents;
    private String title;
    private String password;
}
