package com.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("abc");
		stringList.add("def");
		Stream<String> stream = stringList.stream();
		stream.peek((value) -> {
			System.out.println("value:::" + value);
		});
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

	//Codility test reviewed - email addresses formatting
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
	
	
	//Codility test reviewed with Java 8 features - email addresses formatting
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
	 * For a given number, return an integer representation of a string made of the square of each digit of the number
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
