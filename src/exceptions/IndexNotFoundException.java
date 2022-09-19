package exceptions;

public class IndexNotFoundException extends RuntimeException {
    public IndexNotFoundException(String s) {
        super(s);
    }
}
