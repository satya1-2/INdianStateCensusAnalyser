package com.bridgelabz.censusAnalyserTest;

import com.bridgelabs.censusAnalyser.CensusAnalyser;
import com.bridgelabs.censusAnalyser.CustomException;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    @Test
    public void checkNumberOfRecordMatches() throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.analyser();
        Assert.assertEquals(4, count);
    }

    @Test
    public void fileIncorrectReturnCustomException() throws Exception {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            if (censusAnalyser.analyser() == 0)
                throw new CustomException();
        } catch (CustomException | IOException | CsvValidationException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void incorrectTypeThrowCustomException() throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = 0;
        count = censusAnalyser.analyser();
        Assert.assertEquals(4, count);
    }

    @Test
    public void incorrectDelimiterThrowCustomException() throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = 0;
        count = censusAnalyser.analyser();
        Assert.assertEquals(4, count);
    }

    @Test
    public void headerIncorrectThrowCustomException() throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = 0;
        count = censusAnalyser.analyser();
        Assert.assertEquals(4, count, 0);
    }
}




