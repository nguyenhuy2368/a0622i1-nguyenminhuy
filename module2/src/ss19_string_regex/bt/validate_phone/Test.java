package ss19_string_regex.bt.validate_phone;

public class Test {
    public static final String[] phoneList = new String[]{"(84)-(0905773938)", "(ok)-(090111102)", "(84)-(0795515595)"};

    public static void main(String[] args) {
        PhoneValidate phoneValidate = new PhoneValidate();
        for (String phones : phoneList) {
            boolean phoneValid = phoneValidate.validate(phones);
            System.out.println("Phone num " + phones + " valid: " + phoneValid);
        }
    }
}
