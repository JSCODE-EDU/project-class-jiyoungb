package com.jscode.projectclassjiyoungb.dto;

import lombok.*;
import oracle.jdbc.proxy.annotation.Post;


@NoArgsConstructor

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
