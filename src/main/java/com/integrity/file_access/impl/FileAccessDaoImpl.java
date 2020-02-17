package com.integrity.file_access.impl;

import com.integrity.file_access.FileAccessDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAccessDaoImpl implements FileAccessDao<String> {

    private BufferedReader bufferedReader;

    public FileAccessDaoImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> getAllWords() {

        List<String> words = new ArrayList<>();

        while (true) {
            String word = null;
            try {
                word = bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            if (word == null) {
                break;
            }
            words.add(word);
        }
        return words;

    }
}
