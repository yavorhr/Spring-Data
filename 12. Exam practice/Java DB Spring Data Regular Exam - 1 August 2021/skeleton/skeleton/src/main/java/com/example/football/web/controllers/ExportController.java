package com.example.football.web.controllers;

import com.example.football.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {


    private final PlayerService playerService;


    public ExportController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/best-players")
    public ModelAndView exportCarsByPictures() throws JAXBException {
        String players = this.playerService
                .exportBestPlayers();
        return super.view("export/export-best-players", "players", players);
    }
}
