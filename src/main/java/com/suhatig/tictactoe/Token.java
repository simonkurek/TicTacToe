package com.suhatig.tictactoe;

public class Token {
    private int gameid;
    private int playerid;
    private State state;

    public Token(int gameid, int playerid, State state) {
        this.gameid = gameid;
        this.playerid = playerid;
        this.state = state;
    }

    public Token() {
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
