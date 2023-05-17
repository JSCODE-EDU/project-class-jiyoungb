package com.jscode.projectclassjiyoungb.model;


import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    private String content;

    @Builder
    public Board2(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public BoardResponseDto toDto() {
        return BoardResponseDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
