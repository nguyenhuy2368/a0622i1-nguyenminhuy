package ss19_string_regex.bt.validate_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidate {
    public static final String PHONE_REGEX="^[(][0-9]{2}[)][-][(][0-9]{10}[)]$";

    public PhoneValidate() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }


}
