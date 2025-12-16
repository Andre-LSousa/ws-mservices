package io.github.cursomservice.mscreditanalyzer.application.ex;

import lombok.Getter;

public class ServiceCommunicationException extends Exception{

    @Getter
    private Integer status;

    public ServiceCommunicationException(String msg, Integer status){
        super(msg);
        this.status = status;
    }
}
