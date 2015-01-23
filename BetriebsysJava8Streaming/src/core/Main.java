package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import visualisation.Visualisation;

public class Main {
	private static int NUMBER_OF_PASSENGERS = 4;
	private static int DELAY_BETWEEN_MOVES = 1000; // in ms
	public static List<Person> p;

	public static void main(String[] args) {
		
		
		List<Person> tmp = new ArrayList<Person>();
		for(int i=0; i < NUMBER_OF_PASSENGERS; i++){
			tmp.add( new Person(String.valueOf(i)) );
		}
		
		p = Collections.synchronizedList(tmp);
		

		Visualisation v = new Visualisation();
		Airport ap = new Airport(DELAY_BETWEEN_MOVES, v);
		
		p
			.parallelStream()
			.forEach(person -> ap.move(person));
		
		
	}

}
