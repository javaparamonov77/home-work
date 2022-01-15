package com.sbrf.reboot;

public class Request {
    private String atmNumber;

    public Request(){
    }
    public Request(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public void setAtmNumber(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public String getAtmNumber() {
        return this.atmNumber;
    }
}
