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

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static Map<String, Integer> readFile(String fileName) throws IOException{
        Map<String, Integer> storedWords = new HashMap<>();
        String text = FileUtils.readFileToString(new File(fileName),"UTF-8").toLowerCase();
        Arrays.stream(StringUtils.split(text," .,-/"))
                .forEach(
                        (word)->{
                                if(storedWords.containsKey(word)){
                                    storedWords.replace(word, storedWords.get(word) + 1);
                                }
                                else {
                                    storedWords.put(word, 1);
                                }
                            });
        return storedWords;
    }

    public static void writeFile(Map<String, Integer> storedWords, String output) throws IOException {
        File fileOutput = new File(output);
        FileWriter fwOutput = new FileWriter(fileOutput);
        storedWords.keySet().stream().forEach((word) -> {
            try {
                fwOutput.write(word + " - " + storedWords.get(word));
                fwOutput.write("\n");
                fwOutput.flush();

            } catch (IOException e) {
                logger.error(e);
            }
        });
        fwOutput.close();
    }

    public static void main(String[] args){

        try{
            writeFile(readFile("E:\\Solvd\\FileSearcher\\src\\main\\resources\\Input"),"Output");
        }
        catch (IOException e){
            logger.error(e);
        }

    }

}
