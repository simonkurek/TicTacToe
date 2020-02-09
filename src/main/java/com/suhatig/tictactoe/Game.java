package com.suhatig.tictactoe;

import java.util.HashMap;
import java.util.Random;

public class Game {

    private Table table;
    private GameState gameState;
    private int id;
    private State lastState = State.NON;
    private int players = 0;
    /*private String[][] authKeys;*/
    private HashMap<String, State> authKeys; /*cookie auth code*/

    public Game(int id){
        this.id = id;
        table = new Table();
        table.clear();
        gameState = GameState.BEFORE;
        authKeys = new HashMap<>();
        /*authKeys = new String[2][2];*/
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
        if (getStateFromCode(code) != lastState){
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
            players++;
            String code = Integer.toHexString(r.nextInt(1000000000));
            if (players==0){
                authKeys.put(code, State.X);
                /*authKeys[0][0] = code;
                authKeys[0][1] = String.valueOf(State.X);*/
            } else {
                authKeys.put(code, State.O);
                /*authKeys[1][0] = code;
                authKeys[1][1] = String.valueOf(State.O);*/
            }
            return code;
        }
        return "err.tmp";
    }

    public boolean accessBoth(String authCode){
        return authKeys.containsKey(authCode);
        /*if (authKeys[0][0] == authCode || authKeys[1][0] == authCode){
            return true;
        }
        return false;*/
    }

    public State getStateFromCode(String authCode){
        System.out.println(authKeys.containsKey(authCode));
        System.out.println(authKeys.containsValue(authCode));
        System.out.println(authKeys.get(authCode));
        return authKeys.get(authCode);
        /*if (authKeys[0][0] == authCode){
            return (State)authKeys[0][1];
        }*/
    }
}

/*podmienic hashmape na tablice 2 mianowa*/