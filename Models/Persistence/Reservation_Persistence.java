package Persistence;

import java.util.ArrayList;
import java.util.List;

import Domain_Exceptions.Persistence_Exception;
import Entities.Reservation;

public class Reservation_Persistence {

	private List<Reservation> persistedReservations = new ArrayList<>();

	public Reservation_Persistence() {

	}

	public void AddAnReservation(Reservation reservation) throws Persistence_Exception {
		if (this.persistedReservations.stream().anyMatch(r -> r.getRoomNumber() == reservation.getRoomNumber()))
			throw new Persistence_Exception("The Room number " + reservation.getRoomNumber() + " is ocuppied!");
		this.persistedReservations.add(reservation);
	}

	public List<Reservation> getReservations() throws Persistence_Exception {
		if (!(this.persistedReservations.size()>0))
			throw new Persistence_Exception("All Rooms is free!");
		return this.persistedReservations;
	}

	public void deleteReservation(Reservation reservation) throws Persistence_Exception {
		if (!this.persistedReservations.stream().anyMatch(r -> r.getRoomNumber() == reservation.getRoomNumber()))
			throw new Persistence_Exception("The Room number " + reservation.getRoomNumber() + " is not ocuppied!");

	}

}
