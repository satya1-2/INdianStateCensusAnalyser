package com.bridgelabs.censusAnalyser;

import com.opencsv.CSVReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Header {
    String SrNo, state, population;
    public Header(String srNo, String state, String population) {
        this.SrNo = srNo;
        this.state = state;
        this.population = population;
    }
    @Override
    public String toString() {
        return this.SrNo + " " + this.state + " " + this.population;
    }
}

public class CensusAnalyser  {

    public int analyser() throws Exception {
        int count = 0, lineNumber = 0;
        List<Census> censusData = new ArrayList<>();
        File file;
        CSVReader reader;
        try {
            try {
                file = new File("census.csv");
                reader = new CSVReader(new FileReader(file));
            } catch (RuntimeException e) {
                //Catches custom incorrect file exception
                throw new CustomException();
            }
            String[] line;
            try {
                while ((line = reader.readNext()) != null) {
                    try {
                        if (lineNumber == 0) {
                            System.out.println(new Header(line[0], line[1], line[2]));
                            lineNumber++;
                            continue;
                        }
                        ++count;
                        censusData.add(new Census(Integer.valueOf(line[0]), line[1], line[2]));
                        //Catches custom incorrect type and header file exception
                    } catch (NumberFormatException e) {
                        throw new IncorrectType();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new HeaderException();
                    }
                }
            } catch (com.opencsv.exceptions.CsvMalformedLineException e) {
                //Catches custom incorrect delimiter exception
                      throw new DelimiterException();
            }
            if (count != censusData.size()) {
                //Catches custom incorrect file exception
                throw new CustomException();
            }
            censusData.forEach(System.out::println);

        } catch (CustomException | IncorrectType | HeaderException | DelimiterException e) {
            System.out.println(e);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int noOfLines = censusAnalyser.analyser();
        System.out.println(noOfLines);
    }
}