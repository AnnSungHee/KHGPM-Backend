package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.controller.request.BoardRequest;
import com.example.demo.domain.board.entity.Board;
import com.example.demo.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
// Lombok을 사용하여 Logger를 생성합니다.
@RestController
// REST API를 처리하는 컨트롤러임을 나타냅니다.
@RequestMapping("/board")
// RequestMapping을 지정합니다.
@RequiredArgsConstructor
// Lombok을 사용하여 final 필드를@가지는 생성자를 생성합니다.
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
// Cross-Origin Resource Sharing을 지원합니다.
public class BoardController {

    final private BoardService boardService;

    @PostMapping("/register")
    public Board boardRegister (@RequestBody BoardRequest boardRequest) {
        log.info("boardRegister()");

        return boardService.register(boardRequest);
    }

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("boardList()");

        return boardService.list();
    }

    @GetMapping("/{boardId}")
    public Board boardRead(@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void boardRemove(@PathVariable("boardId") Long boardId) {
        log.info("boardRemove()");

        boardService.remove(boardId);
    }

    @PutMapping("/{boardId}")
    public Board boardModify(@PathVariable("boardId") Long boardId,
                             @RequestBody BoardRequest boardRequest) {

        log.info("boardModify(): " + boardRequest + "id: " + boardId);

        return boardService.modify(boardId, boardRequest);
    }
}
