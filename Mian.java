package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(1);
		arr.add(3);
		arr.add(7);
		arr.add(3);
		System.out.println(minDiff(arr));
		
	}
	
	public static int minDiff(List<Integer> arr) {
		Integer[] intArray = new Integer[arr.size()];
        intArray = arr.toArray(intArray);
		Arrays.sort(intArray);
		final Integer[] target = intArray;
		int sum = IntStream.range(1, target.length).map(i->Math.abs(target[i]-target[i-1])).sum();
		return sum;
	}

}
	