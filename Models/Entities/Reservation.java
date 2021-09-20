package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Domain_Exceptions.Domain_Exception;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws Domain_Exception {
		checkDates(checkIn, checkOut);
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {

		return TimeUnit.DAYS.convert((this.checkOut.getTime() - this.checkIn.getTime()), TimeUnit.MICROSECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws Domain_Exception {
		checkDates(checkIn, checkOut);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {

		return "Reservation: Room=" + roomNumber + ", Check-in:" + sdf.format(checkIn) + ", Check-Out:"
				+ sdf.format(checkOut) + ", " + this.duration() + " nights";
	}

	public void checkDates(Date checkIn, Date checkOut) throws Domain_Exception {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			throw new Domain_Exception("Reservations date must be future dates!");
		if (checkOut.before(checkIn))
			throw new Domain_Exception("Error in reservation: Check-out date must be after check-in date");
	}
}
