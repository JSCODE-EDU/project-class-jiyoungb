package com.jscode.projectclassjiyoungb.controller;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;
import com.jscode.projectclassjiyoungb.service.BoardServiceImple;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImple boardService;


    @GetMapping("/board")
    public ResponseEntity<?> BoardList(){
        return ResponseEntity.ok()
                .body(boardService.getAllList());
    }


/*    @PostMapping("/board")
    public ResponseEntity<Board2> createBoard(@RequestBody BoardRequestDto boardRequestDto){
        Board2 board2 = boardService.createBoard(boardRequestDto);
        return ResponseEntity.ok().body(board2);

    }*/
    @PostMapping("/board")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto boardRequestDto){
        BoardResponseDto board2 = boardService.createBoard(boardRequestDto);
        return ResponseEntity.ok().body(board2);

    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Board2> boardView(@PathVariable Long id){
        Board2 board2 = boardService.getBoard(id);

        return ResponseEntity.ok().body(board2);
    }
}
