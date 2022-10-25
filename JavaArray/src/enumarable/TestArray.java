package enumarable;

public class TestArray {
	public static void main(String[] args) {
		Integer[] nums = {1, 2, 3};
		Array<Integer> numbers = new Array<Integer>(nums);
		numbers.print();
		System.out.println(numbers.get(1)+ numbers.get(0));
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(15);
		numbers.print();
		numbers.remove(Integer.valueOf(15));
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(-15);
		numbers.print();
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(564);
		numbers.print();
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(9);
		numbers.print();
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(123);
		numbers.print();
		System.out.println(numbers.length());
		System.out.println(numbers.size());
		numbers.add(-56);
		numbers.print();
		numbers.foreach((e) -> { System.out.println(e); });
		numbers.foreach((e, i) -> { System.out.println(i + " -> " + e); });
		Array<Integer> squares = numbers.map((e) -> { return e * e; });
		squares.print();
		Array<Integer> multiplyWithIndex = numbers.map((e, i) -> { return (int) e * (int) i; });
		multiplyWithIndex.print();
		Array<Integer> evenNumbers = numbers.filter((e) -> { if(e%2==0) return e; return null; });
		evenNumbers.print();
		Array<Integer> elementsWithOddIndicies = numbers.filter((e, i) -> { if(i%2==1) return e; return null; });
		elementsWithOddIndicies.print();
		System.out.println(squares.every((e) -> { return e > 0; }));
		System.out.println(elementsWithOddIndicies.reduce((previous, current) -> { return previous + current; }, 0));
		System.out.println(elementsWithOddIndicies.reduce((previous, current) -> { return previous * current; }, 1));
	}
}
