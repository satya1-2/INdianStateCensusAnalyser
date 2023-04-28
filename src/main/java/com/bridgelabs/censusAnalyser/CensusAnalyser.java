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
        List<Census> censusData = new ArrayList<>();
        try {
            File file = new File("census.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                ++count;
                try {
                    censusData.add(new Census(Integer.valueOf(line[0]), line[1], line[2]));
                } catch (NumberFormatException e) {
                    throw new IncorrectType();
                }
            }
            if (count != censusData.size() - 1) {
                throw new IncorrectType();
            }
            censusData.forEach(System.out::println);
        } catch (IncorrectType e) {
            System.out.println(e);
        }
        return count;
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numberOfLines = censusAnalyser.analyser();
        System.out.println(numberOfLines);
    }
}