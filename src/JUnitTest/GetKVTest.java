package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.Rating;

import logic.GetKV;
import logic.LaanCheckTlf;

class GetKVTest {

    public enum kreditRating {
        A, B, C, D, error
    };
    private String cprnr = "1029294090";
    private String bilprisGetText = "400000";
    private String udbetalingGetText;
    private String laanleangdeGetText;
    private double renten, mdlYdelse;
    private double baserenten = InterestRate.i().todaysRate();
    private double kvcpr = 1;
    GetKV gg = new GetKV();
    LaanCheckTlf checkTlfNr = new LaanCheckTlf();


    @Test
    void rentevardi1() {
        udbetalingGetText = "100000";
        laanleangdeGetText = "1";
        renten = baserenten + kvcpr + 1;

        assertEquals(renten, gg.getRente(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText));
    }

    @Test
    void renteVaerdi2() {
        udbetalingGetText = "199000";
        laanleangdeGetText = "4";
        renten = baserenten + kvcpr + 2;

        assertEquals(renten, gg.getRente(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText));
    }

    @Test
    void renteVaerdi3() {
        udbetalingGetText = "300000";
        laanleangdeGetText = "2";
        renten = baserenten + kvcpr;

        assertEquals(renten, gg.getRente(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText));
    }

    @Test
    void mdlYdelseCheck() {
        udbetalingGetText = "300000";
        laanleangdeGetText = "2";
        mdlYdelse = 4166.666666666667;
        assertEquals(mdlYdelse, gg.getMdlYdelse(cprnr, bilprisGetText,  udbetalingGetText,  laanleangdeGetText));
    }


    }