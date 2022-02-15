package com.weel.worker;

import com.weel.pokedex.domain.Pokedex;

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

    @Override
    public boolean write(Pokedex pokedex) {
        return false;
    }

    @Override
    public Pokedex findByName(String name) {
        return null;
    }
}
