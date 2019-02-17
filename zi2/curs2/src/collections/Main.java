package collections;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
	//	iterator();
		
		List<Integer> numbers=new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		System.out.println(numbers.get(2));       //specific lui list ca am notiunea de index
		System.out.println(numbers.contains(5));
		System.out.println(numbers.indexOf(4));   //specific lui list ca am notiunea de index
		
		numbers.remove(4);
		System.out.println(numbers);
		
		System.out.println(numbers.isEmpty());
		System.out.println(numbers.size());
		
		
		//suma elem unei liste
		int suma=0;
		for(int i=0;i<numbers.size();i++) {
			suma+=numbers.get(i);
		}
		System.out.println(suma);
		
		
		
		//template gen
		Box<String> stringBox=new Box<>();
		//Box<Object> stringBox=new Box<>();
		stringBox.setValue("Hello there");
		System.out.println(stringBox.getValue());
		
		
		//Box types
		List<Integer> integerList=new ArrayList<>(); //genericele sunt doar pt obiecte, nu putea fi List<int>
		
		Number nr=Integer.valueOf(20);
		List<Number> numbersList=new ArrayList<>();
		numbersList.add(12L);
		numbersList.add(12);
		
		//WildCard
		List<?> listaWildCard=new ArrayList<>();
		List<? extends Number> numbersList2=new ArrayList<Long>();
		List<? super Number> numbersList3=new ArrayList<Number>();


		
		//Map
		Map<String,Integer> map =new HashMap<>(); //cautarea se fa e dupa cheie
		map.put("ONE", 1);
		map.put("TWO", 1);
		map.put("TWO", 2); // nu pot exista 2 valori la o cheie

		map.put("THREE", 1);
		
		map.put(null, 10);
		System.out.println(map.get(null));
		//map.remove("TWO");
		map.remove("THREE",2);
		System.out.println(map);

		//creez o metoda care are o lista de string-uri ca parametru si care apoi returneaza 
		// un map unde cheia este string-ul si valoarea e lungimea stringului
		
		
		List<String> lista= new ArrayList<>();
		lista.add("america");
		lista.add("asia");
		lista.add("africa");
		lista.add("europa");
		
		Map<String,Integer> m=new HashMap<>();
	    m=metodaMap(lista);
	    System.out.println(m);
	    
	    
	    
	    
	    //hashset   //nu cunoaste notiunea de index => nu poate fi sortat
	    Set<Integer> setOfIntegers =new HashSet<>();
	    setOfIntegers.add(4);
	    setOfIntegers.add(2);
	    setOfIntegers.add(3);
	    setOfIntegers.add(3);
	    setOfIntegers.add(11);
	    setOfIntegers.add(7);
	    
	    Set<String> setOfStrings=new HashSet<>();
	    setOfStrings.add("Ana");
	    setOfStrings.add("Ioana");
	    setOfStrings.add("Catalina");
	    setOfStrings.add("Zoziana");
	    setOfStrings.add("Sonia");
	    setOfStrings.add("X");
	    
	    

	    System.out.println("-----Set-------");
        System.out.println(setOfIntegers);
        System.out.println(setOfStrings);
        
        //BigDecimlal
        
        BigDecimal n1= BigDecimal.valueOf(20.34);
        BigDecimal n2= BigDecimal.valueOf(14.03);
        BigDecimal multiply= n1.multiply(n2);
        System.out.println(n1.add(n2));
        System.out.println(n1.divide(n2,RoundingMode.FLOOR));
        
      
        
		iterator();
	}
	
	public static Map metodaMap(List<String> lista) {
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<lista.size();i++) {
			map.put(lista.get(i), lista.get(i).length());
		}
		
		return map;
	}

	private static void iterator() {
		List<Integer> numbers=new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		System.out.println("------Iterator-------");
		Iterator iterator=numbers.iterator(); //nu are pozitionare secventiala
		
		while(iterator.hasNext()) {
			int number =(int)(iterator.next());
			System.out.println(number);
			
			if(number==4) {
				iterator.remove();
			}
		}

		System.out.println(numbers);
		
		for(int i:numbers) {
			System.out.println(i);
		}
	}
	
	

}
