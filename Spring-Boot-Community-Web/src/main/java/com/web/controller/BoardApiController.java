package com.web.controller;

import com.web.domain.Board;
import com.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KimYJ on 2017-07-18.
 */
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    @Autowired
    BoardService boardService;

    @PostMapping
    public void save(@RequestBody Board board) {
        boardService.saveAndUpdateBoard(board);
    }

    @PutMapping
    public void update() {

    }

    @DeleteMapping
    public void delete() {

    }

}
