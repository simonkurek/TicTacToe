package com.suhatig.tictactoe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class  Manager {
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

    public State[][] getAll(int gameid, String code) {
        try {
            return gameList.get(gameid).getAll(code);
        } catch (Exception err){}
        return new State[0][];
    }

    public State get(int gameid, int x, int y, String code) {
        State st = State.NON;
        try {
            st = gameList.get(gameid).get(x, y, code);
        } catch (Exception err){}
        return st;
    }

    public void set(int gameid, int x, int y, String code) {
        try {
            gameList.get(gameid).set(x, y, code);
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

    public String getAuthCode(int gameid){
        return gameList.get(gameid).generateAuthCode();
    }

    public State getWinner(int gameid, String code){
        return gameList.get(gameid).winnerChecker(code);
    }
}
