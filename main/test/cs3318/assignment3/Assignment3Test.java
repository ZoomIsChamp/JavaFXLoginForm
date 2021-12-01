package cs3318.assignment3;

public class Assignment3Test {
    final static Assignment3 tester = new Assignment3();
    
    @ParameterizedTest
    @ValueSource(strings = {"", "@gmail.com", "abc@.com", "fake email@address.com"})
    public void rejectsInvalidEmail(String testEmail) {
        assertThrows(IllegalArgumentException.class, () -> { tester.checkEmail(testEmail); });
    }

}
