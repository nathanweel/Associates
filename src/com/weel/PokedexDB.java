package com.weel;

import com.weel.pokedex.domain.Pokedex;
import com.weel.worker.PokedexWorker;

import java.io.IOException;

//Run this class!

public class PokedexDB {

    public static void main(String[] args) throws IOException, InterruptedException {

        //TODO: 5. All values coming from user **DONE**
        String name;
        int hp;
        String type;
        String moves;

        //Welcome Signature
        System.out.println("                                                \n" + " \\    / _  |  _  _  ._ _   _                     \n" + "  \\/\\/ (/_ | (_ (_) | | | (/_                    \n" + " |_)      ._   _. _|_ |_   _. ._        _   _  | \n" + " |_) \\/   | | (_|  |_ | | (_| | | \\/\\/ (/_ (/_ | \n" + "     /                                           ");

        PokedexWorker worker = new PokedexWorker();

        System.out.println("Would you like to add a new Pokemon, search for a Pokemon or read the file\nType add, search or read");
        String reply = System.console().readLine();

        if (reply.equalsIgnoreCase("add")) {
            //TODO: 6. Ask user for all inputs here **DONE**
            System.out.println("\nWhat is the name of the Pokemon?");
            name = System.console().readLine();

            System.out.println("\nHow much health does this Pokemon have?");
            hp = Integer.parseInt(System.console().readLine());

            System.out.println("\nWhat type(s) is your Pokemon?");
            type = System.console().readLine();

            System.out.println("\nWhat move(s) can this Pokemon use?\nSeparate by coma");
            moves = System.console().readLine();

            Pokedex pokedex = worker.convertInput(name, hp, type, moves);

            System.out.println("\nWriting credentials to a file...");
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
            System.out.println("\nWhat Pokemon would you like to search for?");
            name = System.console().readLine();

            worker.findByName(name);

        } else if (reply.equalsIgnoreCase("read")) {
            System.out.println("\nHere is the file:-\n");
            worker.readAndWrite("C:\\Temp\\pokedex.txt");

        } else {
            System.out.println("Unknown function");
        }
    }
}
