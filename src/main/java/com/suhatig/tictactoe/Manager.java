package com.suhatig.tictactoe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class Manager {
    private List<Game> gameList;

    public Manager() {
        gameList = new ArrayList<>();
    }

    public int addGame() {
        int id = gameList.size();
        Game new_ = new Game(id);
        gameList.add(new_);
        return id;
    }

    public State[][] getAll(int gameid) {
        try {
            return gameList.get(gameid).getAll();
        } catch (Exception err){}
        return null;
    }

    public State get(int gameid, int x, int y) {
        State st = State.NON;
        try {
            st = gameList.get(gameid).get(x, y);
        } catch (Exception err){}
        return st;
    }

    public void set(int gameid, int x, int y) {
        try {
            gameList.get(gameid).set(x, y);
        } catch (Exception err){}
    }

    public void clear(int gameid) {
        try {
            gameList.get(gameid).clear();
        } catch (Exception err){}
    }

    public GameState getGameState(int gameid) {
        GameState gs = GameState.NON;
        try {
            gs = gameList.get(gameid).getGameState();
        } catch (Exception err){}
        return  gs;
    }

    public void setGameState(int gameid, GameState gameState) {
        try {
            gameList.get(gameid).setGameState(gameState);
        } catch (Exception err){}
    }
}
