package cs3318.assignment3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private final String email;
    private final String password;

    public User (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean checkEmail(String testEmail) {
        final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_REGEX.matcher(testEmail);
        return matcher.find();
    }

    public boolean checkPasswordLength(String testPassword) {
        return testPassword.length() >= 7;
    }

    public boolean passwordContainsSpecial(String testPassword) {
        final Pattern PASSWORD_CONTAINS = Pattern.compile("[*^&@!]+");
        Matcher matcher = PASSWORD_CONTAINS.matcher(testPassword);
        return matcher.find();
    }

    public boolean passwordContainsNumber(String testPassword) {
        final Pattern PASSWORD_CONTAINS_NUMBER = Pattern.compile("\\d");
        Matcher matcher = PASSWORD_CONTAINS_NUMBER.matcher(testPassword);
        return matcher.find();
    }

    public boolean passwordContainsLetter(String testPassword) {
        final Pattern PASSWORD_CONTAINS_LETTER = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = PASSWORD_CONTAINS_LETTER.matcher(testPassword);
        return matcher.find();
    }

    public boolean isValidPassword(String testPassword) {
        return (checkPasswordLength(testPassword) && passwordContainsSpecial(testPassword) && passwordContainsNumber(testPassword) && passwordContainsLetter(testPassword));
    }
}
