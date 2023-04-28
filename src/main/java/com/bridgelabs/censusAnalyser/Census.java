package com.bridgelabs.censusAnalyser;

public class Census {
    int SrNo;
    String state;
    String population;

    public Census(int srNo, String state, String population) {
        SrNo = srNo;
        this.state = state;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Census{" +
                "SrNo=" + SrNo +
                ", state='" + state + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}

