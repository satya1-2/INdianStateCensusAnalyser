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
        File file = new File("census.csv");
        CSVReader csvReader = new CSVReader(new FileReader(file));
        List<String> censusData = new ArrayList<>();
        String[] line;
        int count = 0;
        while ((line = csvReader.readNext()) != null) {
            ++count;
        }
        return count;
    }
}



