package bankapp2;
public class InsufficientBalanceException
        extends Exception {

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
