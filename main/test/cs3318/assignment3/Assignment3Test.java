package cs3318.assignment3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class Assignment3Test {
    public static final String TEST_EMAIL = "randomMail";
    public static final String TEST_PASSWORD = "randomPassword";

    @ParameterizedTest
    @ValueSource(strings = {"", "@gmail.com", "abc@.com", "fake email@address.com"})
    public void rejectsInvalidEmail(String testEmail) {
        User tester = new User(testEmail, TEST_PASSWORD);
        assertFalse(tester.checkEmail(testEmail));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@gmail.com", "xyz@123.com", "real@address.co.uk", "real.email@address.ie"})
    public void acceptsValidEmail(String testEmail) {
        User tester = new User(testEmail, TEST_PASSWORD);
        assertTrue(tester.checkEmail(testEmail));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc123", "6digit", "2short", ""})
    public void rejectsInvalidLength(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertFalse(tester.checkPasswordLength(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"thispasswordisplentylongenough", "7digits", "l0ngp455w0rd5"})
    public void acceptsValidLength(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertTrue(tester.checkPasswordLength(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello*there", "abc@123", "!!what!!"})
    public void checkContainsCharacters(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertTrue(tester.passwordContainsSpecial(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"thispasswordisplentylongenough", "7digits", "l0ngp455w0rd5"})
    public void checkNotContainsCharacters(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertFalse(tester.passwordContainsSpecial(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"th1sh4s4numb3r", "h3ll0th3r3", "7digits"})
    public void checkContainsNumber(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertTrue(tester.passwordContainsNumber(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"thishasanumber", "hellothere", "sevendigits"})
    public void checkNotContainsNumber(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertFalse(tester.passwordContainsNumber(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234a56", "2H", "c"})
    public void checkContainsLetter(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertTrue(tester.passwordContainsLetter(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "2", ""})
    public void checkNotContainsLetter(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertFalse(tester.passwordContainsLetter(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"this15avalidpa55w*rd", "7dig!ts", "l0ngp@ssword"})
    public void checkValidPassword(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertTrue(tester.isValidPassword(testPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"this15avalidpa55w0rd", "7digits", "l0ngp4ssword"})
    public void checkInvalidPassword(String testPassword) {
        User tester = new User(TEST_EMAIL, testPassword);
        assertFalse(tester.isValidPassword(testPassword));
    }
}
