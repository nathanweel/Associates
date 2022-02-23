package com.weel.worker;

import com.weel.pokedex.domain.Pokedex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PokedexWorker implements IPokedex {
    @Override
    public Pokedex convertInput(String name, int hp, String type, String moves) {
        //TODO 4. Implement this method **DONE**
        Pokedex pokemon = new Pokedex();
        pokemon.setName(name);
        pokemon.setHp(hp);
        pokemon.setType(type);
        pokemon.setMoves(moves);
        return pokemon;
    }

    //TODO 7 : Implement the write function to file **DONE**
    @Override
    public boolean write(Pokedex pokedex) throws IOException {
        String filename = "C:\\temp\\pokedex.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(pokedex.toString());

        return true;
    }

    @Override
    public Pokedex findByName(String name) {
        return null;
    }
}
