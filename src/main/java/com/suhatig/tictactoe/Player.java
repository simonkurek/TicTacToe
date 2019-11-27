package com.suhatig.tictactoe;

public class Player {
    private int id; //1 czy 2 gracz
    private State state; //stawia x czy o

    public Player(int id, State state) {
        this.id = id;
        this.state = state;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
