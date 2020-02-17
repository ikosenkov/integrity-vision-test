package com.integrity.file_access;

import java.util.List;

public interface FileAccessDao<T> {

    List<T> getAllWords();

}
