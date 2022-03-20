package com.weel;

import com.weel.pokedex.domain.Pokedex;
import com.weel.worker.PokedexWorker;

import java.io.FileNotFoundException;
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
            System.out.println("What is the name of the Pokemon?");
            name = System.console().readLine();

            System.out.println("How much health does this Pokemon have?");
            hp = Integer.parseInt(System.console().readLine());

            System.out.println("What type(s) is your Pokemon?");
            type = System.console().readLine();

            System.out.println("What move(s) can this Pokemon use?\nSeparate by coma");
            moves = System.console().readLine();

            Pokedex pokedex = worker.convertInput(name, hp, type, moves);

            System.out.println("Writing credentials to a file...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(500);

            try {
                worker.write(pokedex);
                System.out.println("\nDONE");

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.out.println("Make sure the file is labeled 'pokedex.txt' and that it is inside of a folder called 'Temp'.\nAlso make sure the folder is on the local disk.");
            }

        } else if (reply.equalsIgnoreCase("search")) {
            System.out.println("Would you like to search by name or by type?\nType name or type");
            reply = System.console().readLine();

            if (reply.equalsIgnoreCase("name")) {
                System.out.println("What is the name of the Pokemon?");
                name = System.console().readLine();

                System.out.println("Here are your results:-");
                worker.findByName(name);

            } else if (reply.equalsIgnoreCase("type")) {
                System.out.println("What is/are the Pokemon's type(s)");
                type = System.console().readLine();

                System.out.println("Here are your results:-");
                worker.findByType(type);

            } else {
                System.out.println("Unknown search request");
            }

        } else if (reply.equalsIgnoreCase("read")) {
            System.out.println("Here is the file:-\n");
            //Change filename to the file's location
            worker.showFile("C:\\Temp\\pokedex.txt");

        } else {
            System.out.println("Unknown function");
        }
    }
}
