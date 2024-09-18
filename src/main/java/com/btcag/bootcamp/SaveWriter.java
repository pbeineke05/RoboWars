package com.btcag.bootcamp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveWriter extends FileWriter {
    public SaveWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public void writeLine(String input) throws IOException {
        this.write(System.lineSeparator());
        this.write(input);
    }
}
