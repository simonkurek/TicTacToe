package com.suhatig.tictactoe;

public class Table {

    private State[][] table;

    public Table(){
        table = new State[3][3];
    }

    public State[][] getAll() {
        return table;
    }

    public State get(int x, int y){
        return table[x][y];
    }

    public void set(int x, int y, State state){
        table[x][y] = state;
    }

    public void clear(){
        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                table[x][y] = State.NON;
            }
        }
    }
}
