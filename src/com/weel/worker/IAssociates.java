package com.weel.worker;

import com.weel.associates.domain.Associates;

import java.io.IOException;
import java.util.List;

public interface IAssociates {

    Associates convertInput(String name, String phone, String gender, String details);

    boolean write(Associates associates) throws IOException;

    boolean overWrite(List copyList) throws IOException;

    List readFileContents(String filename);

    Associates lineToObj(String line);

    Associates findByName(String name);

    List showFile(String filename);

    boolean delete(String name) throws IOException;

    boolean edit(String name, String phone, String gender, String details) throws IOException;

    boolean fileWipe() throws IOException;

}
