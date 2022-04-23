package lk.sliit.customerservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private Pattern regexPattern;
    private Matcher regMatcher;

    public boolean validateEmailAddress(String emailAddress) {

        regexPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        regMatcher = regexPattern.matcher(emailAddress);

        return regMatcher.matches();
    }

    public boolean validateMobileNumber(String mobileNumber) {
        regexPattern = Pattern.compile("^\\d{10}$");
        regMatcher = regexPattern.matcher(mobileNumber);
        return regMatcher.matches();
    }


}
