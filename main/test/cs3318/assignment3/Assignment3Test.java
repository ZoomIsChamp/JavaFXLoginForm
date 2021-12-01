package cs3318.assignment3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class Assignment3Test {
    final static Assignment3 tester = new Assignment3();
    
    @ParameterizedTest
    @ValueSource(strings = {"", "@gmail.com", "abc@.com", "fake email@address.com"})
    public void rejectsInvalidEmail(String testEmail) {
        assertThrows(IllegalArgumentException.class, () -> { tester.checkEmail(testEmail); });
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"abc@gmail.com", "xyz@123.com", "real@address.co.uk", "real.email@address.ie"})
    public void acceptsValidEmail(String testEmail) {
        assertTrue(tester.checkEmail(testEmail));
    }

}
