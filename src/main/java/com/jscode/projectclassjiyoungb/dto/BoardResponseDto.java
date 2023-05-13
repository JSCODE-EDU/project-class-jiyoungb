package com.jscode.projectclassjiyoungb.dto;

import lombok.*;
import oracle.jdbc.proxy.annotation.Post;


@NoArgsConstructor

@Getter
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
