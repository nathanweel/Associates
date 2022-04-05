package com.weel;

import com.weel.associates.domain.Associates;
import com.weel.worker.AssociateWorker;

import java.io.FileNotFoundException;
import java.io.IOException;

//Run this class!

public class AssociatesDB {

    public static void main(String[] args) throws IOException, InterruptedException {

        String name;
        String phone;
        String email;
        String details;

        //Welcome Signature
        System.out.println("                                                \n" + " \\    / _  |  _  _  ._ _   _                     \n" + "  \\/\\/ (/_ | (_ (_) | | | (/_                    \n" + " |_)      ._   _. _|_ |_   _. ._        _   _  | \n" + " |_) \\/   | | (_|  |_ | | (_| | | \\/\\/ (/_ (/_ | \n" + "     /                                           ");

        AssociateWorker worker = new AssociateWorker();

        System.out.println("Would you like to add a new associate, search for an associate, read the file, wipe the file, delete an entry, or edit an entry?\nType add, search, read, wipe, delete, or edit");
        String reply = System.console().readLine();

        if (reply.equalsIgnoreCase("add")) {
            System.out.println("\nWhat is your associate's name??");
            name = System.console().readLine();

            System.out.println("\nWhat is the associate's phone number?");
            phone = System.console().readLine();

            System.out.println("\nWhat is your associates gender?");
            email = System.console().readLine();

            System.out.println("\nAny details about your associate?");
            details = System.console().readLine();

            Associates associates = worker.convertInput(name, phone, email, details);

            System.out.println("\nWriting credentials to a file...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(500);

            try {
                worker.write(associates);
                System.out.println("\nDONE");

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.out.println("Make sure the file is labeled 'pokedex.txt' and that it is inside of a folder called 'Temp'.\nAlso make sure the folder is on the local disk.");
            }

        } else if (reply.equalsIgnoreCase("search")) {
            System.out.println("\nWhat is you associate's name?");
            name = System.console().readLine();

            System.out.println("\nHere are your results:-\nKey: name, phone, email, details");
            worker.findByName(name);

        } else if (reply.equalsIgnoreCase("read")) {
            System.out.println("\nHere is the file:-\nKey: name, phone, email, details\n");
            //Change filename to the file's location
            worker.showFile("C:\\Temp\\associates.txt");

        } else if (reply.equalsIgnoreCase("delete")) {
            System.out.println("\nWhat entry would you like to delete?\nType the name of the associate");
            name = System.console().readLine();

            System.out.println("\nDeleting entry...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(500);

            worker.delete(name);

        } else if (reply.equalsIgnoreCase("edit")) {
            System.out.println("\nWhich associate's data would you like to alter?\nType the name of the associate");
            name = System.console().readLine();

            System.out.println("You are updating the entry below");
            worker.findByName(name);

            System.out.println("\nWhat would you like to change the phone number to?");
            phone = System.console().readLine();

            System.out.println("\nWhat would you like to change the gender to?");
            email = System.console().readLine();

            System.out.println("\nWhat would you like to change the details to?");
            details = System.console().readLine();

            System.out.println("\nEditing entry...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(500);

            worker.edit(name, phone, email, details);
            System.out.println("Entry edited");

        } else if (reply.equalsIgnoreCase("wipe")) {
            System.out.println("\nAre you sure you want to wipe the file of all contents?\nType yes or no");
            reply = System.console().readLine();

            if (reply.equalsIgnoreCase("yes")) {
                System.out.println("\nWiping file...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(500);

                worker.fileWipe();
                System.out.println("File contents deleted");

            } else {
                System.out.println("\nCrisis averted");
            }

        } else {
            System.out.println("Unknown function");
        }
    }
}
