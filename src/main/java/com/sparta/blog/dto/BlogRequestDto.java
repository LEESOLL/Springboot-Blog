package com.sparta.blog.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogRequestDto {
    private String author;
    private String contents;
    private String title;
    private String password;
    private LocalDateTime createAt;
}
