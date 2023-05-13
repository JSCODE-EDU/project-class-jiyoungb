package com.jscode.projectclassjiyoungb.model;


import lombok.*;

import javax.persistence.*;


@Getter

@AllArgsConstructor
@RequiredArgsConstructor
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


}
