package com.sbrf.reboot;

import java.util.ArrayList;

public class Cassette {
    private ArrayList valueList;

    public Cassette(ArrayList<? extends Banknote> valueList) {
            this.valueList = valueList;
        }

    public int getCountBanknotes(){
        return valueList.size();
    }


}
