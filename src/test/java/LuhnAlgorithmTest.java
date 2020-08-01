import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {
    private final LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();

   @Test
   void checkNumeric(){
    assertTrue(luhnAlgorithm.checkNumeric("678877466"));
    }

    @Test
    void checkIsNotNumeric(){
       assertFalse(luhnAlgorithm.checkNumeric("abk6776"));
        assertFalse(luhnAlgorithm.checkNumeric("78457-423-po"));
        assertFalse(luhnAlgorithm.checkNumeric("&%34)#87"));

    }

    @Test
    void checkValid(){
     assertTrue(luhnAlgorithm.validatCreditNumber("7657899876550", 1));

    }

    @Test
    void checkIsNotValid(){
     assertFalse(luhnAlgorithm.validatCreditNumber("7657899876550", 6));
    assertFalse(luhnAlgorithm.validatCreditNumber("677", 6));
    }

    @Test
    void checkValidLength(){
    assertTrue(luhnAlgorithm.validateLength("7657899876550256"));
    }

    @Test
    void checkNotValidLength(){
     assertFalse(luhnAlgorithm.validateLength("78988877"));
     assertFalse(luhnAlgorithm.validateLength("78988877879483298402"));
     assertFalse(luhnAlgorithm.validateLength("789"));

    }
}