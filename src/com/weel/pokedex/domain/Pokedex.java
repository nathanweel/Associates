package com.weel.pokedex.domain;

public class Pokedex {

    //TODO: 1. Enter attributes of a Pokemon **DONE**
    private String name;
    private int hp;
    private String type;
    private String moves;


    // --- All Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    //TODO: 3. Add functionality to write object to a string **DONE**
    public String toString() {
        return getName() + "," + getHp() + "," + getMoves() + "," + getType();
    }
}
