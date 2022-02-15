package com.weel;

import com.weel.pokedex.domain.Pokedex;
import com.weel.worker.PokedexWorker;

public class Main {

    public static void main(String[] args) {

        //TODO: 5. All values coming from user **DONE**
        String name;
        int hp;
        String type;
        String moves;

        //TODO: 6. Ask user for all inputs here **DONE**
        name = System.console().readLine();
        hp = Integer.parseInt(System.console().readLine());
        type = System.console().readLine();
        moves = System.console().readLine();


        PokedexWorker worker = new PokedexWorker();
        Pokedex pokedex = worker.convertInput(name, hp, type, moves);

        System.out.println("This is our first test with git enabled");

    }
}
