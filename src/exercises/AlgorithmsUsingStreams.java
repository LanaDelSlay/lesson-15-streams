package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlgorithmsUsingStreams {

	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream()				// 1. create stream
		.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
		.count();							// 3. terminal operation: reduce to an int
	}

	public static Object findTallest(List<Double> peeps) {
//		return Collections.max(peeps);
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	public static long addStringOfNumbers(String numbers) {
		return numbers
		 	.chars()		
		 	.mapToObj(c -> Character.toString(c))	
			.mapToInt(num -> Integer.parseInt(num))
			.sum();
	}

	public static long countPearls(List<Boolean> oysters) {
		return oysters.stream()
			   .filter(oyster -> oyster.equals(true))
			   .count();
		
	}
	
	public static String findLongestWord (List<String> words) {
		
		return words.stream()
        .sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1)
        .findFirst()
        .map(Object::toString)
        .orElse(null); // Why does this have to be included?

//		return words.stream()
//				.max(Comparator.comparingInt(String::length))
//				.get();
	}

	
	public static List<Double> sortScores(List<Double> results) {
		
		return results.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	
	public static List<String> sortDNA(List<String> unsortedSequences) {
		return unsortedSequences.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());	
	}


	public static List<String> sortWords(List<String> words) {
		
		return words.stream()
				.sorted(Comparator
				.comparing(n->n.toString()))
				.collect(Collectors.toList());
}

	
	public static Object getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {
		return spellsCastThisWeek.stream()
		.distinct()
		.sorted(Comparator
		.comparing(n->n.toString()))
		.collect(Collectors.toList());
	}

	
	public static String getBatPhrases(String[] batmanScript) {
        Stream<String> batStream = Arrays.stream(batmanScript);
       String[] newStr = batStream
        .map(s -> s.replace("Bam", "BAM"))
        .map(s -> s.replace("Pow", "POW"))
        .filter(s -> s.length() <= 4) 
        .map(s -> s.replace(" ", "")) //removing de extra spaces attached
        .toArray(size -> new String[size]);
       String phrasesCapped = Arrays.toString(newStr);
       return phrasesCapped;       
        
	}

	
	public static Integer countXs(String xString) {
		String newX = xString.replace("x", ""); //This is counting the ammount of O's and not X's.
	    return newX.length();
	}

	public static Integer addEven(String string) {
		//Yea, yea I know this code and I suck! I couldn't figure out how to do it the smart streamy way!
		int[] nums = new int[string.length()];
		int total = 0;
		for (int i = 0 ; i < string.length(); i++) {
			nums[i] = Integer.parseInt(string.substring(i, i+1));;
			if (nums[i] % 2 == 0)  {
				System.out.println();
				total = total + nums[i];
			}
		}

		return total;
	}

	
	public static Double getAverage(int[] numbers) {
        IntStream numStream = Arrays.stream(numbers);
		return numStream.average()
				.orElseGet(null);
	}

	public static Integer countOccurrences(String[] strArr, String string) {
		List<String> list = new ArrayList<String>(Arrays.asList(strArr));
		return Collections.frequency(list, string);
	}

	
	
	

}