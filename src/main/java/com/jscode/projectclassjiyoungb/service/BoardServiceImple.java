package com.jscode.projectclassjiyoungb.service;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;
import com.jscode.projectclassjiyoungb.repository.Board2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImple implements BoardService{

    @Autowired
    private final Board2Repository board2Repository;


    @Override
    public List<Board2> getAllList() {
        return board2Repository.findAll();
    }

    @Override
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {

        Board2 board2 = Board2.builder()
               .title(boardRequestDto.getTitle())
               .content(boardRequestDto.getContent())
               .build();

        board2Repository.save(board2);
        return new BoardResponseDto(board2.getId(), board2.getTitle(), board2.getContent());
    }


}
