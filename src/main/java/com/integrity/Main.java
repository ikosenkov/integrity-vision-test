package com.integrity;

import com.integrity.service.ChallengeService;
import com.integrity.service.FileAccessService;
import com.integrity.service.impl.ChallengeServiceImpl;
import com.integrity.service.impl.FileAccessServiceImpl;

import java.io.IOException;
import java.util.List;

public class Main {

    private final static String PATH = "/home/igor/IdeaProjects/integrity-vision-test/src/main/resources/words.txt";


    public static void main(String[] args) throws IOException {

        FileAccessService<String> fileAccessService = new FileAccessServiceImpl(PATH);

        List<String> allWordsFromFile = fileAccessService.getAllWordsFromFile();

        ChallengeService challengeService = new ChallengeServiceImpl(allWordsFromFile);

        System.out.println("The longest and the 2nd longest concatenated words:");
        System.out.println(challengeService.getTwoLongestConcatenatedWord());
        System.out.print("\nThe total count of all the concatenated words in the file: ");
        System.out.println(challengeService.countAllConcatenatedWords());

    }

}