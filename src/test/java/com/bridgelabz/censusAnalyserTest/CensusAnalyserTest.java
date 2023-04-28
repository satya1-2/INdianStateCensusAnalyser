package com.bridgelabz.censusAnalyserTest;

import com.bridgelabs.censusAnalyser.CensusAnalyser;
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
}

