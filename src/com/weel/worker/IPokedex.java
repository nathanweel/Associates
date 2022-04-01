package com.weel.worker;

import com.weel.PokedexDB;
import com.weel.pokedex.domain.Pokedex;

import java.io.IOException;
import java.util.List;

public interface IPokedex {

    //TODO 2. Enter every value that you want to store from input into Pokedex **DONE**
    Pokedex convertInput(String name, int hp, String type, String moves);

    boolean write(Pokedex pokedex) throws IOException;

    boolean overWrite(List copyList) throws IOException;

    List readFileContents(String filename);

    Pokedex lineToObj(String line);

    Pokedex findByName(String name);

    Pokedex findByType(String type);

    Pokedex findByMoves(String moves);

    List showFile(String filename);

    boolean delete(String name) throws IOException;

    boolean fileWipe() throws IOException;

}
