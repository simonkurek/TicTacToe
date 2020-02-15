package com.suhatig.tictactoe;

import java.util.Random;

public class Game {

    private Table table;
    private GameState gameState;
    private int id;
    private State lastState;
    private int players;
    private String[] codes;

    public Game(int id){
        this.id = id;
        table = new Table();
        table.clear();
        players = 0;
        lastState = State.NON;
        codes = new String[2];
        gameState = GameState.BEFORE;
    }

    public State[][] getAll(String code){
        if (accessBoth(code)){
            return table.getAll();
        }
        return new State[0][];
    }

    public State get(int x, int y, String code){
        if (accessBoth(code)){
            return table.get(x, y);
        }
        return State.NON;
    }

    public void set(int x, int y, String code){
        if (getStateFromCode(code) != State.NON){
            if (getStateFromCode(code) != lastState){
                if (table.get(x, y) == State.NON){
                    State state = State.NON;
                    if (lastState == State.X){
                        state = State.O;
                    } else if (lastState == State.O){
                        state = State.X;
                    } else if (lastState == State.NON){
                        state = State.X;
                    }
                    table.set(x, y, state);
                    lastState = state;
                }
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

    public State getLastState(){
        return lastState;
    }

    public String generateAuthCode(){
        if (players<2){
            Random r = new Random();
            String code = Integer.toHexString(r.nextInt(1000000000));
            codes[players] = code;
            players++;
            return code;
        }
        players++;
        return "err.tmp";
    }

    public State winnerChecker(String code){
        if (accessBoth(code)){
            State st = State.X;
            for (int n=0; n<2; n++){
                if (n==1){
                    st = State.O;
                }
                for (int i=0; i<3; i++){
                    if (table.get(i,0).equals(st) && table.get(i,1).equals(st) && table.get(i, 2).equals(st)){
                        return st;
                    }
                }
                //horizontally
                for (int i=0; i<3; i++){
                    if (table.get(0,i).equals(st) && table.get(1,i).equals(st) && table.get(2, i).equals(st)){
                        return st;
                    }
                }
                //X-cross
                if (table.get(0,0).equals(st) && table.get(1,1).equals(st) && table.get(2,2).equals(st)){
                    return st;
                }
                if (table.get(0,2).equals(st) && table.get(1,1).equals(st) && table.get(2,0).equals(st)){
                    return st;
                }
            }
        }
        return State.NON;
    }

    private boolean accessBoth(String authCode){
        if (authCode.equals(codes[0]) || authCode.equals(codes[1])){
            return true;
        }
        return false;
    }

    private State getStateFromCode(String authCode){
        if (authCode.equals(codes[0])){
            return State.X;
        } else if (authCode.equals(codes[1])){
            return State.O;
        }
        return State.NON;
    }
}