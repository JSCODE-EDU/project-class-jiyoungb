package com.jscode.projectclassjiyoungb.dto;

import com.jscode.projectclassjiyoungb.model.Board2;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import oracle.jdbc.proxy.annotation.Post;

@Getter
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    // toEntity 적용
    public Board2 toEntity() {
        return Board2.builder()
                .title(title)
                .content(content)
                .build();
    }

}
