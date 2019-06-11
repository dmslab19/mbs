package mbs.domain.service.booking;

public class UnavailableBookingException extends RuntimeException {

    private static final long serialVersionUID = 9044163931278942296L;

    public UnavailableBookingException(String message) {
        super(message);
    }
}