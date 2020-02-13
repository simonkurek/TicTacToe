package com.suhatig.tictactoe;

import java.util.Random;

public class Game {

    private Table table;
    private GameState gameState;
    private int id;
    private State lastState = State.NON;
    private int players = 0;
    private String[] codes; //authcodes

    public Game(int id){
        this.id = id;
        table = new Table();
        table.clear();
        gameState = GameState.BEFORE;
        codes = new String[2];
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
        System.out.println(getStateFromCode("getStateFromCode: " + code));
        if (getStateFromCode(code) != lastState && getStateFromCode(code) != State.NON){
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
            System.out.println("inGame(id: " + id + ") codes[" + players + "] = " + code);
            codes[players] = code;
            players++;
            return code;
        }
        players++;
        return "err.tmp";
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