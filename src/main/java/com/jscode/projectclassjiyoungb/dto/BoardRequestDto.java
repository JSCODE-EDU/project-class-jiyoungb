package com.jscode.projectclassjiyoungb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class BoardRequestDto {
    private Long boardId;
    private String title;
    private String content;

    @Builder
    public BoardRequestDto(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
