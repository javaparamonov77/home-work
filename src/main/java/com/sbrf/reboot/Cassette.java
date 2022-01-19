package com.sbrf.reboot;

import java.util.List;

public class Cassette {
    private final List<? extends Banknote> valueList;

    public Cassette(List<? extends Banknote> valueList) {
        this.valueList = valueList;
    }

    public int getCountBanknotes(){
        return valueList.size();
    }


}

