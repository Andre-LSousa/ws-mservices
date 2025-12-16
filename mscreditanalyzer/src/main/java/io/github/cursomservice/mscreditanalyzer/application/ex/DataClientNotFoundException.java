package io.github.cursomservice.mscreditanalyzer.application.ex;

public class DataClientNotFoundException extends Exception {

    public DataClientNotFoundException(){
        super("Customer data not found for the provided CPF!");
    }
}
