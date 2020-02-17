package com.integrity.service.impl;

import com.integrity.file_access.FileAccessDao;
import com.integrity.file_access.impl.FileAccessDaoImpl;
import com.integrity.service.FileAccessService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileAccessServiceImpl implements FileAccessService<String> {

    private FileAccessDao<String> fileAccessDao;

    public FileAccessServiceImpl(String path) throws FileNotFoundException {

        fileAccessDao = new FileAccessDaoImpl(new BufferedReader(new FileReader(path)));

    }

    @Override
    public List<String> getAllWordsFromFile() {
        return fileAccessDao.getAllWords();
    }
}
