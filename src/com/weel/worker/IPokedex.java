package com.weel.worker;

import com.weel.pokedex.domain.Pokedex;

import java.io.IOException;
import java.util.List;

public interface IPokedex {

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

    boolean edit(String name, int hp, String type, String moves) throws IOException;

    boolean fileWipe() throws IOException;

}
