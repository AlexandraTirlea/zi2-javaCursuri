package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Collection<String> stringCollection= Arrays.asList("Ionut","Ioan","Bogdan","Mihaela","Elena","Ana","Elena","Alexandra");
		
		stringCollection
		.stream()    //trece prin toate operatiunile pe rand
		.filter(s-> s.length()>4)
		.map(s->s.toUpperCase())
		.forEach(finalValue -> System.out.println(finalValue));
		
		
         System.out.println("\n");
		stringCollection
		.stream()
		.distinct()
		.forEach(s-> System.out.println(s));
		
		System.out.println("\nSortare:");
		Set<String> stringSet=new HashSet<>(stringCollection);
		stringCollection
		.stream()
		.filter(s->s.charAt(0)=='A')
		.peek(s-> System.out.println(s))    //e un fel de forEach, dar nu intrerupe streamul , ne afiseaza ce e in mom ala pe stiva
		.map(s->s.toLowerCase())
		.sorted()
		.forEach(s->System.out.println(s));
		
		
		
		//flatmap
		System.out.println("\nFlat map:");
		List<List<Integer>> listOfLists =new ArrayList<>();
		listOfLists.add(Arrays.asList(1,2,5));
		listOfLists.add(Arrays.asList(1,2,5));
		
		listOfLists.stream()
		.flatMap(m->m.stream())
		.peek(s->System.out.println(s+"\n"))
		.sorted()
		.forEach(s->System.out.println(s));
		
		System.out.println("---------------------------------");
		List<String> strings=stream(stringCollection)
		.collect(Collectors.toList());
		
		System.out.println(strings);
		
		//Set<String> stringSet1=stream.collect(Collectors.toSet());
		//System.out.println(stringSet);
	}

	private static Stream<String> stream (Collection<String> stringCollection) {
		return stringCollection
		.stream()
		.filter(s->s.charAt(0)=='A')
		.map(s->s.toLowerCase());
	}

}
