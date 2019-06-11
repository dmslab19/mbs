package mbs.domain.service.booking;

public class AlreadyBookedException extends RuntimeException {

    private static final long serialVersionUID = -4745523761146600645L;

    public AlreadyBookedException(String message) {
        super(message);
    }
}