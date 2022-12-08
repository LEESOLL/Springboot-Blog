package com.sparta.blog.entity;

import com.sparta.blog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    public Blog(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.contents = content;
    }

    public Blog(BlogRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(BlogRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
