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
        // requestDto -> Board2 Entity
        Board2 board2 = boardRequestDto.toEntity();

        /*Board2 board2 = Board2.builder()
               .title(boardRequestDto.getTitle())
               .content(boardRequestDto.getContent())
               .build();*/

        // Board2 생성
        Board2 savedBoard = board2Repository.save(board2);


        // Board2 Entity -> Response DTO
        BoardResponseDto boardResponseDto = savedBoard.toDto();
        /*return new BoardResponseDto(board2.getId(), board2.getTitle(), board2.getContent());*/
        return boardResponseDto;
    }


    public Board2 getBoard(Long id) {
        Board2 board = board2Repository.findById(id).orElseThrow(IllegalArgumentException::new);
        return board;
    }
}
