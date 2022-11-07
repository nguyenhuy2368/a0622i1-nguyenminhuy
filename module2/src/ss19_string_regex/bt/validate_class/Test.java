package ss19_string_regex.bt.validate_class;

public class Test {
    public static final String[] validateClassName = new String[]{"C0318G", "A0622I", "P0443L","M0318G", "P0323A", "B02303"};

    public static void main(String[] args) {
        ValidateClass validateClass = new ValidateClass();
        for (String name:validateClassName ){
            boolean isValidate = validateClass.validate(name);
            System.out.println("class name "+name+" is validate : "+ isValidate);
        }

    }
}
