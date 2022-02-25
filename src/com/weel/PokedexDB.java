package com.weel;

import com.weel.pokedex.domain.Pokedex;
import com.weel.worker.PokedexWorker;

import java.io.IOException;

public class PokedexDB {

    public static void main(String[] args) throws IOException, InterruptedException {

        //TODO: 5. All values coming from user **DONE**
        String name;
        int hp;
        String type;
        String moves;

        PokedexWorker worker = new PokedexWorker();

        //Welcome Signature
        System.out.println("                                                \n" + " \\    / _  |  _  _  ._ _   _                     \n" + "  \\/\\/ (/_ | (_ (_) | | | (/_                    \n" + " |_)      ._   _. _|_ |_   _. ._        _   _  | \n" + " |_) \\/   | | (_|  |_ | | (_| | | \\/\\/ (/_ (/_ | \n" + "     /                                           ");

        System.out.println("Would you like to add a new Pokemon, search for a Pokemon or read the full database?\nType add, search, or read");
        String reply = System.console().readLine();

        if (reply.equalsIgnoreCase("add")) {
            //TODO: 6. Ask user for all inputs here **DONE**
            System.out.println("What is the name of the Pokemon?");
            name = System.console().readLine();

            System.out.println("How much health does this Pokemon have?");
            hp = Integer.parseInt(System.console().readLine());

            System.out.println("What type(s) is your Pokemon?");
            type = System.console().readLine();

            System.out.println("What move(s) can this Pokemon use?\nSeparate by coma");
            moves = System.console().readLine();

            Pokedex pokedex = worker.convertInput(name, hp, type, moves);

            System.out.println("Writing credentials to the database...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(500);

            worker.write(pokedex);
            System.out.println("\nDONE");


        } else if (reply.equalsIgnoreCase("search")) {
            System.out.println("Functionality not yet added");

        } else if (reply.equalsIgnoreCase("read")) {
            System.out.println("Here is the full database:");
            worker.read("C:\\Temp\\pokedex.txt");

        } else {
            System.out.println("Unknown entry");
        }
    }
}