package com.weel.worker;

import com.weel.associates.domain.Associates;

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

public class AssociateWorker implements IAssociates {

    @Override
    public Associates convertInput(String name, int phone, String gender, String details) {
        Associates pokemon = new Associates();
        pokemon.setName(name);
        pokemon.setPhone(phone);
        pokemon.setGender(gender);
        pokemon.setDetails(details);
        return pokemon;
    }

    @Override
    public boolean write(Associates associates) throws IOException {
        //Change filename to the file's location
        String filename = "C:\\Temp\\associates.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.append(associates.toString() + "\n");

        writer.close();
        return true;
    }

    @Override
    public boolean overWrite(List copyList) throws IOException {
        //Change filename to the file's location
        String filename = "C:\\Temp\\associates.txt";

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
    public Associates lineToObj(String line) {
        String[] splitLine = line.split(",");

        Associates associates = new Associates();

        associates.setName(splitLine[0]);
        associates.setPhone(Integer.parseInt(splitLine[1]));
        associates.setGender(splitLine[2]);
        associates.setDetails(splitLine[3]);

        return associates;
    }

    @Override
    public Associates findByName(String name) {
        //Change filename to the file's location
        List list = readFileContents("C:\\Temp\\associates.txt");

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Associates associates = lineToObj(line);

            if (associates.getName().contains(name)) {
                System.out.println("\n" + line);
            }
        }
        return null;
    }

    @Override
    public Associates findByGender(String gender) {
        //Change filename to the file's location
        List list = readFileContents("C:\\Temp\\associates.txt");

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Associates associates = lineToObj(line);

            if (associates.getGender().contains(gender)) {
                System.out.println("\n" + line);
            }
        }
        return null;
    }

    @Override
    public List showFile(String filename) {
        //Change filename to the file's location
        List lines = readFileContents("C:\\Temp\\associates.txt");

        Iterator itr = lines.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return null;
    }

    @Override
    public boolean delete(String name) throws IOException {
        //Change filename to the file's location
        String filename = "C:\\Temp\\associates.txt";

        List list = readFileContents(filename);
        List copyList = new ArrayList();
        copyList.addAll(list);

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Associates associates = lineToObj(line);

            if (associates.getName().contains(name)) {
                System.out.println("\nDeleted\n" + line);
                copyList.remove(i);
            }
        }

        overWrite(copyList);

        return false;
    }

    @Override
    public boolean edit( String name, int phone, String gender, String details) throws IOException {
        //Change filename to the file's location
        String filename = "C:\\Temp\\associates.txt";

        List list = readFileContents(filename);
        List copyList = new ArrayList();
        copyList.addAll(list);

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);

            Associates associates = lineToObj(line);

            if (associates.getName().contains(name)) {
                Associates person = convertInput(name, phone, gender, details);

                copyList.remove(i);
                copyList.add(person);
            }
        }

        overWrite(copyList);

        return true;
    }

    @Override
    public boolean fileWipe() throws IOException {
        List copyList = new ArrayList();

        overWrite(copyList);

        return false;
    }
}
