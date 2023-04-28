package com.bridgelabz.censusAnalyserTest;

import com.bridgelabs.censusAnalyser.CensusAnalyser;
import com.bridgelabs.censusAnalyser.CustomException;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    @Test
    public void checkNumberOfRecordMatches() throws CsvValidationException, IOException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.analyser();
        Assert.assertEquals(5,count);
    }
    @Test
    public void fileIncorrectReturnCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            if (censusAnalyser.analyser() == 0)
                throw new CustomException();
        } catch (CustomException | IOException | CsvValidationException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void incorrectTypeThrowCustomException() throws CsvValidationException, IOException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = 0;
        count = censusAnalyser.analyser();
        Assert.assertEquals(4, count);
    }
}



