package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> listarTodos () {
        List<GameListDTO> result = gameListService.listarTodos();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> listarPorLista (@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.listarTodos();
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void mover (@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.mover(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
