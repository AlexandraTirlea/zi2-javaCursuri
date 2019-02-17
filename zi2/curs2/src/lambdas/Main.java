package lambdas;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		
		lambda();
		
		Optional<Integer> integerOptional=Optional.of(200);
		if(integerOptional.isPresent()) {
			System.out.println(integerOptional.get());
		}
		else
			System.out.println(0);
		
		
		
		Optional<Integer>empty=Optional.empty();
		System.out.println(empty.orElse(0));
		System.out.println(empty.orElseGet(()->0));

	}
	
	

	private static void lambda() {
		NumberFunction doubleFunction =(nr)-> nr*2;
		
		NumberFunctionMultiple sumFunction =(nr1, nr2)-> {  //isi pune sg return
			System.out.println(nr1);
			System.out.println(nr2);

			return nr1*+nr2;  //daca am mai multe linii trb sa ii pun return ca nu stie
		};
		
		//Ex1.
		String testString="Hello";
		//testString="bye";
		FunctiePrimNrDivizCu2 fct = (numbers) -> {
			System.out.println(testString);  //poate fi folosit dar cu conditia ca testString sa fie final sau sa nu si modifice niciodata valoarea
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i]%2==0)
					return numbers[i];
			}
			return 0;
		};

		System.out.println(fct.compute(1,97,3,41,5,6,7,8,9));
		
		
		
		NumberFunction2 sameFunction =(nr,nr2)-> nr*2+"";
		System.out.println(sameFunction.compute(2, 2));
		
		//consumer
		Consumer<String> stringConsumer = n ->System.out.println(n.toUpperCase());
		stringConsumer.accept("small text");
		
		//supplier
		Supplier<String> stringSupplier=()-> "Show me the money!";
		System.out.println(stringSupplier.get());
		
		//function
		Function<Integer,String> stringFunction = number -> number.toString();
		
		String nrAsString=stringFunction.apply(200);
		System.out.println(nrAsString);
		
		//predicate
		Predicate<String> predicate=s->s.length()>4;
		System.out.println(predicate.test("three"));
		testThis(s->s%2==0);
	}
	
	private static void testThis(Predicate<Integer>predicate)
	{
		
	}
	interface NumberFunction{
		int compute(int number);
	}
	
	interface NumberFunctionMultiple{
		int compute(int number1, int number2);
	}

	
	//Ex1. creaza o interfata functionala cqare are o metoda compute care are int... ca param si returneaza un int
	//apoi creaza un lambda care returneaza primul nr divizibil cu 2
	@FunctionalInterface
	interface FunctiePrimNrDivizCu2{
		int compute(int...n);
	}
	
	
	interface NumberFunction2{
		String compute(int number, int number2);
	}
	
}
