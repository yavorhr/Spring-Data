package softuni.exam.service;




import softuni.exam.models.Entity.Passenger;

import java.io.IOException;


public interface PassengerService {

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

	String getPassengersOrderByTicketsCountDescendingThenByEmail();

    Passenger findPassengerByEmail(String email);
}
