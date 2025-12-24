package io.github.cursomservice.mscreditanalyzer.application.ex;

public class CardRequestException extends RuntimeException {
    public CardRequestException(String message) {
        super(message);
    }
}
