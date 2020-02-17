package com.integrity.service.impl;

import com.integrity.trie.Trie;
import com.integrity.service.ChallengeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChallengeServiceImpl implements ChallengeService {

    private List<String> allWords;
    private List<String> allConcatenatedWords;

    private Trie trie;

    public ChallengeServiceImpl(List<String> allWords) {
        this.allWords = allWords;
        this.allConcatenatedWords = getAllConcatenatedWords();
    }

    @Override
    public String getTwoLongestConcatenatedWord() {
        return allConcatenatedWords.stream()
                .sorted((word1, word2) -> word2.length() - word1.length())
                .limit(2)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public int countAllConcatenatedWords() {
        return allConcatenatedWords.size();
    }

    private List<String> getAllConcatenatedWords() {
        trie = new Trie();
        List<String> result = new ArrayList<>();

        for (String word : allWords) {
            trie.insert(word);
        }

        for (String word : allWords) {
            if (valid(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean valid(String word) {

        String string = "";
        String suffix;

        if (word.length() <= 1 && !trie.search(word)) {
            return false;
        }

        for (int i = 0; i < word.length() - 1; i++) {
            string += word.charAt(i);
            suffix = word.substring(i + 1);

            if (trie.search(string) && (trie.search(suffix) || valid(suffix))) {
                return true;
            }
        }
        return false;
    }
}
