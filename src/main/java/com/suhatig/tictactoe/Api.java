package com.suhatig.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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
    public State[][] getAll(@RequestParam int gameid){
        return manager.getAll(gameid);
    }

    @GetMapping("/get")
    public State get(@RequestParam int gameid, int x, int y){
        return manager.get(gameid, x, y);
    }

    @GetMapping("/set")
    public void set(@RequestParam int gameid, int x, int y){
        manager.set(gameid, x, y);
    }

    @GetMapping("/clear")
    public void clear(@RequestParam int gameid){
        manager.clear(gameid);
    }
}
