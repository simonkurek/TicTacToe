package com.suhatig.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Table table;
    private GameState gameState;
    private int id;
    private State lastState = State.NON;

    public Game(int id){
        this.id = id;
        table = new Table();
        table.clear();
        gameState = GameState.BEFORE;
    }

    public State[][] getAll(){
        return table.getAll();
    }

    public State get(int x, int y){
        return table.get(x, y);
    }

    public void set(int x, int y){
        if (table.get(x, y) == State.NON){
            State state = State.NON;
            if (lastState==State.O){
                state = State.X;
            } else if (lastState==State.X){
                state = State.O;
            } else if (lastState==State.NON){
                state = State.X;
            } else {
                System.err.println("Error: game.setting func() error");
            }
            if (state!=State.NON){
                table.set(x, y, state);
                lastState = state;
            }
        }
    }

    public void clear(){
        table.clear();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getId() {
        return id;
    }
}
