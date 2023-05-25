package com.jscode.projectclassjiyoungb.service;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;
import com.jscode.projectclassjiyoungb.repository.Board2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImple implements BoardService{

    @Autowired
    private final Board2Repository board2Repository;


    @Override
    public List<Board2> getAllList(Pageable pageable) {

        //return board2Repository.findAll();
        return board2Repository.findAllByOrderByCreatedAtDesc(pageable);

    }

    @Override
    public List<Board2> searchByTitle(String keyword, Pageable pageable) {
        return board2Repository.findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(keyword, pageable);
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
    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board2 board2 = board2Repository.findById(id).orElseThrow(IllegalArgumentException::new);
        //board2.builder().title(boardRequestDto.getTitle()).content(boardRequestDto.getContent()).build();
        board2.setTitle(boardRequestDto.getTitle());
        board2.setContent(boardRequestDto.getContent());


        // Board2 생성
        Board2 updatedBoard = board2Repository.save(board2);


        // Board2 Entity -> Response DTO
        BoardResponseDto boardResponseDto = updatedBoard.toDto();
        /*return new BoardResponseDto(board2.getId(), board2.getTitle(), board2.getContent());*/
        return boardResponseDto;
    }

    @Override
    public Long deleteBoard(Long id) {
        board2Repository.deleteById(id);
        return id;


    }
}
