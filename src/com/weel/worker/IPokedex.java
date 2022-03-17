package com.weel.worker;

import com.weel.pokedex.domain.Pokedex;

import java.io.IOException;
import java.util.List;

public interface IPokedex {

    //TODO 2. Enter every value that you want to store from input into Pokedex **DONE**
    public Pokedex convertInput(String name, int hp, String type, String moves);

    public boolean write(Pokedex pokedex) throws IOException;

    public Pokedex findByName(String name);

    List read(String filename);
}
