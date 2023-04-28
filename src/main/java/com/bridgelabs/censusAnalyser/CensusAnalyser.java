package com.bridgelabs.censusAnalyser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CensusAnalyser {
    public int analyser() throws IOException, CsvValidationException {
        int count = 0;
        int lineNumber = 0;
        List<Census> censusList = new ArrayList<>();
        File file;
        CSVReader reader;
        try {
            try {
                file = new File("census.csv");
                reader = new CSVReader(new FileReader(file));
            } catch (RuntimeException e) {
                throw new DelimiterException();
            }

            String[] line;
            try {
                while ((line = reader.readNext()) != null) {
                    if (lineNumber == 0) {
                        lineNumber++;
                        continue;
                    }
                    ++count;
                    try {
                        censusList.add(new Census(Integer.valueOf(line[0]), line[1], line[2]));
                    } catch (NumberFormatException e) {
                        throw new IncorrectType();
                    }
                }
            } catch (com.opencsv.exceptions.CsvMalformedLineException e) {
                throw new DelimiterException();
            }
            if (count != censusList.size() - 1) {
                throw new DelimiterException();
            }
            censusList.forEach(System.out::println);

        } catch (IncorrectType exp) {
            System.out.println(exp);
        } catch (DelimiterException exception) {
            System.out.println(exception);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int noOfLines = censusAnalyser.analyser();
        System.out.println(noOfLines);
    }
}