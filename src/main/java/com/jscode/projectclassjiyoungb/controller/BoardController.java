package com.jscode.projectclassjiyoungb.controller;

import com.jscode.projectclassjiyoungb.dto.BoardRequestDto;
import com.jscode.projectclassjiyoungb.dto.BoardResponseDto;
import com.jscode.projectclassjiyoungb.model.Board2;
import com.jscode.projectclassjiyoungb.service.BoardServiceImple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImple boardService;


   /* @GetMapping("/board")
    public ResponseEntity<?> BoardList(@PageableDefault(sort="createdAt", direction = Sort.Direction.DESC, size = 5)Pageable pageable){
        return ResponseEntity.ok()
                .body(boardService.getAllList(pageable));
    }*/


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

    @GetMapping("/board")
    public ResponseEntity<?> BoardList(
            @RequestParam(required = false) String keyword,
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC, size = 5) Pageable pageable) {
        if (keyword != null && !keyword.isEmpty()) {
            List<Board2> searchResult = boardService.searchByTitle(keyword, pageable);
            return ResponseEntity.ok().body(searchResult);
        } else {
            List<Board2> boardList = boardService.getAllList(pageable);
            return ResponseEntity.ok().body(boardList);
        }
    }



    @GetMapping("/board/{id}")
    public ResponseEntity<Board2> boardView(@PathVariable Long id){
        Board2 board2 = boardService.getBoard(id);

        return ResponseEntity.ok().body(board2);
    }

    @PostMapping("/board/{id}")
    public ResponseEntity<BoardResponseDto> modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        BoardResponseDto boardResponseDto = boardService.updateBoard(id, boardRequestDto);
        return ResponseEntity.ok().body(boardResponseDto);

    }
    @DeleteMapping("/board/{id}")
    public ResponseEntity<Long> deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return ResponseEntity.ok().body(id);
    }
}
