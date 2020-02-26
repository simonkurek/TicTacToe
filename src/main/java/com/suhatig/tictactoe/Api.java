package com.suhatig.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/ttt")
public class Api {

    @Autowired
    private Manager manager;

    @GetMapping("/createGame")
    public int addGame(){
        return manager.addGame();
    }

    @GetMapping("/getAll")
    public State[][] getAll(@RequestParam int gameid, String code){
        return manager.getAll(gameid, code);
    }

    @GetMapping("/get")
    public State get(@RequestParam int gameid, int x, int y, String code){
        return manager.get(gameid, x, y, code);
    }

    @GetMapping("/set")
    public void set(@RequestParam int gameid, int x, int y, String code){
        manager.set(gameid, x, y, code);
    }

    @GetMapping("/clear")
    public void clear(@RequestParam int gameid){
        manager.clear(gameid);
    }

    @GetMapping("/getAuthCode")
    public String getAuthCode(@RequestParam int gameid){
        return '"' + manager.getAuthCode(gameid) + '"';
    }

    @GetMapping("/checkWinner")
    public State checkWinner(@RequestParam int gameid, String code){
        return manager.getWinner(gameid, code);
    }

    @GetMapping("/isRemis")
    public boolean isRemis(@RequestParam int gameid, String code){
        return manager.isEndGame(gameid, code);
    }
}