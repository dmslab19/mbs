package mbs.app.booking;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingForm implements Serializable {
	private static final long serialVersionUID = -8448997924742459324L;
	private LocalDate bookingDate;
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
}
