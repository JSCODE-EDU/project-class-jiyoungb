package com.jscode.projectclassjiyoungb.service;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    List<Board2>  getAllList(Pageable pageable);
    BoardResponseDto createBoard(BoardRequestDto boardRequestDto);
    Board2 getBoard(Long id);

    BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto);

    Long deleteBoard(Long id);

    List<Board2> searchByTitle(String keyword, Pageable pageable);
}
