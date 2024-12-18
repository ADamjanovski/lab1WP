package mk.finki.ukim.mk.lab.model.exception;

public class NoEventFoundException extends Exception{
    public NoEventFoundException(long id) {
        super("No event found with id "+id);
    }
}
