package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Domain_Exceptions.Domain_Exception;
import Entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		char op ='n';
		do {
		try {
			System.out.println("Room Numerbe: ");
			int roomNumber = Integer.parseInt(sc.next());

			System.out.println("Check-In date (yyyy/MM/dd): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.println("Check-Out date (yyyy/MM/dd): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation.toString());
			
			System.out.println("Do you want to add a new reservation? y = yes");
			op = sc.next().toLowerCase().charAt(0);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format!");
		} catch (IllegalArgumentException e) {
			System.out.println(e);}
		catch(Domain_Exception e)
		{
		System.out.println(e.toString());	
		}
			
		
		}while (op!='y');
		
		sc.close();
	}

}
