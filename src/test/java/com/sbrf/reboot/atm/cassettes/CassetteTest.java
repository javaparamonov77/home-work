package com.sbrf.reboot.atm.cassettes;

import com.sbrf.reboot.Banknote;
import com.sbrf.reboot.Cassette;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CassetteTest {

    class OneHundred extends Banknote {
    }

    class OneThousand extends Banknote {
    }

    @Test
    void getCountBanknotes() {
        OneHundred oneHundred = new OneHundred();
        OneThousand oneThousand = new OneThousand();

        Cassette cassette = new Cassette(new ArrayList<OneHundred>() {{
            add(oneHundred);
        }});

        Assertions.assertEquals(1, cassette.getCountBanknotes());

        Cassette cassette2 = new Cassette(new ArrayList<OneThousand>() {{
            add(oneThousand);
        }});

        Assertions.assertEquals(1, cassette2.getCountBanknotes());
    }
}