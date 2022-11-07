package exception;

public class AccountInvalidException extends Exception {
    public AccountInvalidException() {}
    public AccountInvalidException(String mess) {
        super(mess);
    }
}
