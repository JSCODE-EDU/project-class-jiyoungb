package com.jscode.projectclassjiyoungb.service;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;

import java.util.List;

public interface BoardService {

    List<Board2>  getAllList();
    BoardResponseDto createBoard(BoardRequestDto boardRequestDto);

}
