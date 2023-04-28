package com.bridgelabs.censusAnalyser;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


    public class WriteCsvData {
        void writer() throws IOException {
            File file = new File("census.csv");
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] line1 = {"SrNo.", "State", "Population"};
            String[] line2 = {"1", "Bihar", "400000"};
            String[] line3 = {"2", "WestBengal", "500000"};
            String[] line4 = {"3", "Maharashtra", "300000"};
            String[] line5 = {"4", "UttarPradesh", "200000"};
            csvWriter.writeNext(line1);
            csvWriter.writeNext(line2);
            csvWriter.writeNext(line3);
            csvWriter.writeNext(line4);
            csvWriter.writeNext(line5);
            csvWriter.close();
            fileWriter.close();
        }

        public static void main(String[] args) throws IOException, CsvValidationException {
            System.out.println("Welcome To Census Analyser Of Indian state");
            WriteCsvData csvData = new WriteCsvData();
            csvData.writer();

        }
    }

