package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Check {
	private List<Integer> parastorage;
	private List<CheckQueue> queues;
	
	public Check(int NumOfQueues, int LengthOfQueues){
		/*
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers =
		    new ArrayList<Integer>(Arrays.asList(intArray));
		
		parastorage = Collections.synchronizedList(listOfIntegers);

		
		parastorage
	    .parallelStream()
	    .forEachOrdered(e -> System.out.println(e+" * 2 = "+(e*2)));
		
		/*
		queues = Collections.synchronizedList( new ArrayList<CheckQueue>() );
		int a = 0;
		queues
		.parallelStream()
		.forEachOrdered(e -> ( queues.add(new CheckQueue("abc")) ) );
		
		queues
		.parallelStream()
		.forEachOrdered(e -> System.out.println("# "+e.label));
		*/
	}
	
	class CheckQueue{
		public String label;
		
		public CheckQueue(String label){
			this.label = label;
		}
	}
}
