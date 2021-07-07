package com.solvd.main;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> storedWords = new HashMap<>();
        String text = FileUtils.readFileToString(new File("src/main/resources/Input"),"UTF-8").toLowerCase();
        Arrays.stream(StringUtils.split(text," .,-/")).forEach((word)->{
                            if(storedWords.containsKey(word))  storedWords.replace(word, storedWords.get(word) + 1);
                            else storedWords.put(word, 1);
                        });
        FileUtils.writeStringToFile(new File("src/main/resources/Output"), storedWords.toString(), "UTF-8");

    }

}
