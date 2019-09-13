package com.java8.streams;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("abc");
		stringList.add("def");
		Stream<String> stream = stringList.stream();
		stream.peek((value) -> {
			System.out.println("value:::" + value);
		});
		
		//flatMap
		Arrays.stream(streamFlatMap()).forEach((value) -> System.out.println(value));
		
		//Reduce
		System.out.println("Reduced:::: " + streamReduce());
		
		//Concatenated 
		
		System.out.println("Conncatenated and reduced::: " + streamConcat());
		
			Callable[] animals = new Callable[]{()->{return "Lion";}, ()->"Crocodile"};
			try {
				System.out.println("Animal called::: "+animals[0].call());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	/**
	 * Returns a flattened array of the separates words from each list item.
	 * */
	public static Object[] streamFlatMap() {
		List<String> stringList1 = new ArrayList<String>();
		stringList1.add("One flew over the cuckoo's nest");
		stringList1.add("To kill a muckingbird");
		stringList1.add("Gone with the wind");

		return stringList1.stream().flatMap((value) -> {
			String[] split = value.split(" ");
			return (Stream<String>) Arrays.asList(split).stream();
		}).toArray();
	}

	/**
	 * Return an array of values greater than 3 i.e. { 5, 4, 6, 8, 6, 10 }
	 * */
	public Object[] streamFilter() {
		return Arrays.asList(new Integer[] { 1, 3, 5, 3, 4, 6, 8, 6, 10, 0, 2, 3, 1 }).stream().filter(value -> {
			return (Integer) value >= 4;
		}).toArray();
	}
	
	/**
	 * Return a new array with each element squared {1,9,25,9,16}
	 * */
	public Object[] streamMap() {
		return Arrays.asList(new Integer[] { 1, 3, 5, 3, 4 }).stream().map(value -> {
			return (Integer) value * value;
		}).toArray();
	}	
	
	static int hurdleRace(int k, int[] height) {
		int max = Arrays.stream(height).max().getAsInt();
		if (max <= k)
			return 0;
		else
			return max - k;
	}

	/**
	 * Returns a sub-array of an array depending on the limit passed
	 */
	public int[] streamsLimit(int limit) {

		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int[] returnedArr = Arrays.stream(numbers).limit(limit).toArray();
		// print elements of the new array
		// Arrays.stream(returnedArr).forEach(element -> {
		// System.out.println(element);
		// });

		return returnedArr;
	}
	
	/**
	 * Return true if any of the array elements contains the given string (@param str) else false
	 * */
	public boolean streamAnyMatch(String str) {
		return Stream.of(new String[] { "One flew over the cuckoo's nest", "To kill a muckingbird", "Gone with the wind" }).anyMatch(value -> {
			return value.indexOf(str) != -1;
		});
	}

	/**
	 * Return true if all of the array elements contains the given string (@param str) else false
	 * */
	public boolean streamAllMatch(String str) {
		return Stream.of(new String[] { "One flew over the cuckoo's nest", "To kill a muckingbird", "Gone with the wind" }).allMatch(value -> {
			return value.indexOf(str) != -1;
		});
	}
	
	/**
	 * Return true if none of the array elements contains the given string (@param str) else false
	 * */
	public boolean streamNoneMatch(String str) {
		return Stream.of(new String[] { "One flew over the cuckoo's nest", "To kill a muckingbird", "Gone with the wind" }).noneMatch(value -> {
			return value.indexOf(str) != -1;
		});
	}
	
	/**
	 * Return the size of the resultant stream 
	 * */
	public long streamCount() {
		return Stream.of(new String[] { "One flew over the cuckoo's nest", "To kill a muckingbird", "Gone with the wind" })
				.flatMap(value -> {
					return Stream.of(value.split(" "));
				}).count();
	}
	
	/**
	 * Find any element from the stream. Uses the Optional class. If @Param present is true, return a value else return null
	 * */
	public String streamFindAny(boolean present) {
		Stream<String> stream = Stream.of(present ? new String[] { "one", "two", "three", "four" } : new String[] {});
		Optional<String> anyElement = stream.findAny();// using Optional here
//		return anyElement.orElseGet(null);//return null
		return anyElement.get();//return none
	}
	
	public String streamMinString() {
		return Stream.of("one", "two", "three").min((val1, val2) -> {
			return val1.compareTo(val2);
		}).get();
	}

	public int streamMinInt() {
		Integer min = Stream.of( 4, 56, 7, 89, 10 ).mapToInt(v -> v).min()
				.orElseThrow(NoSuchElementException::new);
		return min;
	}
	
	public String streamMaxString() {
		return Stream.of( "one", "two", "three" ).max((val1, val2) -> {
			return val1.compareTo(val2);
		}).get();
	}

	public int streamMaxInt() {
		Integer max = Stream.of( 4, 56, 7, 89, 10 ).mapToInt(v -> v).max()
				.orElseThrow(NoSuchElementException::new);
		return max;
	}
	
	/**
	 *Reduce the list to one value 
	 */
	public static String streamReduce(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");
		Stream<String> stream = stringList.stream();
		Optional<String> reduced = stream.reduce((value, combinedValue) -> {
			return combinedValue + " + " + value;
		});
		return reduced.orElseThrow(NoSuchElementException::new);
	}
	
	/**
	 * Concatenate two streams and reduce the elements to one string
	 **/
	public static String streamConcat() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");
		Stream<String> stream1 = stringList.stream();
		List<String> stringList2 = new ArrayList<>();
		stringList2.add("Lord of the Rings");
		stringList2.add("Planet of the Rats");
		stringList2.add("Phantom Menace");
		Stream<String> stream2 = stringList2.stream();
		Stream<String> concatStream = Stream.concat(stream1, stream2);
		Optional<String> reduced = concatStream.reduce((value, combinedVal) -> {
			return value + " + " + combinedVal;
		});
		return reduced.orElse(null);
	}

	/**
	 * Find first element from the stream. Uses the Optional class. If @Param present is true, return a value else return none / null
	 * */
	public String streamFindFirst(boolean present) {
		Stream<String> stream = Stream.of(present ? new String[] { "one", "two", "three", "four" } : new String[] {});
		Optional<String> anyElement = stream.findFirst();// using Optional here
		return anyElement.orElseGet(null);//return null
//		return anyElement.get();//return none
	}

	//Codility - email addresses formatting
	public String addresses(String S, String C) {
		String[] addrTokens = S.split("; ");// holds the seperate raw addresses
		StringBuilder result = new StringBuilder(); // final result string to return
		Map<String, Integer> addrMap = new HashMap<>();
		for (String addr : addrTokens) {
			String[] currentAddrTokens = addr.split(" ");// get the address components
			String currAddr = (currentAddrTokens[currentAddrTokens.length - 1]
					.concat("_")
					.concat(currentAddrTokens[0]))
					.replace("-", "");
			
			if (addrMap.containsKey(currAddr))
				addrMap.put(currAddr, addrMap.get(currAddr) + 1);
			else
				addrMap.put(currAddr, 1);
			currAddr = currAddr.concat("" + (addrMap.get(currAddr) != 1 ? addrMap.get(currAddr) : ""));
			result.append("; ").append(currAddr).append("@" + C.concat(".com"));
		}
		return result.toString().substring(2).toLowerCase();
	}
	
	
	//Codility - email addresses formatting
	public String addressesJ8(String S, String C) {
		String[] addrTokens = S.split("; ");// holds the various raw addresses
		Map<String, Integer> addrMap = new HashMap<>();
		return Arrays.stream(addrTokens)
		.map(addr -> addr.toLowerCase())
		.map(addr -> {
					String[] currentAddrTokens = addr.split(" ");
					String currAddr = (currentAddrTokens[currentAddrTokens.length - 1].concat("_")
							.concat(currentAddrTokens[0])).replace("-", "");
					if (addrMap.containsKey(currAddr))
						addrMap.put(currAddr, addrMap.get(currAddr) + 1);
					else
						addrMap.put(currAddr, 1);
					return currAddr.concat("" + (addrMap.get(currAddr) != 1 ? addrMap.get(currAddr) : "")).concat("@")
							.concat(C).concat(".com");
				}).collect(Collectors.joining("; "));
	}
	
	/**
	 * For a given number n, return an integer representation of a string made of the square of each digit of the number
	 * */
	public int squareDigits(int n) {
        return Integer.parseInt(String.valueOf(n)
                                      .chars()
                                      .map(i -> Integer.parseInt(String.valueOf((char) i)))
                                      .map(i -> i * i)
                                      .mapToObj(String::valueOf)
                                      .collect(Collectors.joining("")));
	}

}
