package com.weel.worker;

import com.weel.pokedex.domain.Pokedex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
        //Change filename to the file's location
        String filename = "C:\\Temp\\pokedex.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.append(pokedex.toString() + "\n");

        writer.close();
        return true;
    }

    @Override
    public boolean overWrite(List copyList) throws IOException {
        String filename = "C:\\Temp\\pokedex.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));

        for (Object str : copyList) {
            writer.write(str + System.lineSeparator());
        }

        writer.close();
        return true;
    }

    @Override
    public List readFileContents(String filename) {
        List lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Caught error");
        }
        return lines;
    }

    @Override
    public Pokedex lineToObj(String line) {
        String[] splitLine = line.split(",");

        Pokedex pokedex = new Pokedex();

        pokedex.setName(splitLine[0]);
        pokedex.setHp(Integer.parseInt(splitLine[1]));
        pokedex.setType(splitLine[2]);
        pokedex.setMoves(splitLine[3]);

        return pokedex;
    }

    @Override
    public Pokedex findByName(String name) {
        //Change filename to the file's location
        List list = readFileContents("C:\\Temp\\pokedex.txt");

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Pokedex pokedex = lineToObj(line);

            if (pokedex.getName().contains(name)) {
                System.out.println("\n" + line);
            }
        }
        return null;
    }

    @Override
    public Pokedex findByType(String type) {
        //Change filename to the file's location
        List list = readFileContents("C:\\Temp\\pokedex.txt");

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Pokedex pokedex = lineToObj(line);

            if (pokedex.getType().contains(type)) {
                System.out.println("\n" + line);
            }
        }
        return null;
    }

    @Override
    public Pokedex findByMoves(String moves) {
        //Change filename to the file's location
        List list = readFileContents("C:\\Temp\\pokedex.txt");

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Pokedex pokedex = lineToObj(line);

            if (pokedex.getMoves().contains(moves)) {
                System.out.println("\n" + line);
            }
        }
        return null;
    }

    @Override
    public List showFile(String filename) {
        //Change filename to the file's location
        List lines = readFileContents("C:\\Temp\\pokedex.txt");

        Iterator itr = lines.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return null;
    }

    @Override
    public boolean delete(String name) throws IOException {
        String filename = "C:\\Temp\\pokedex.txt";

        List list = readFileContents(filename);
        List copyList = new ArrayList();
        copyList.addAll(list);

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Pokedex pokedex = lineToObj(line);

            if (pokedex.getName().contains(name)) {
                System.out.println("\nDeleted\n" + line);
                copyList.remove(i);
            }
        }

        overWrite(copyList);

        return false;
    }
}
