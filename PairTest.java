package generics.Aufgabe4;

public class PairTest {
	public static void main(String[] args) {
		testOrderedPairGetters();
		testUnorderedPairGetters();
		testOrderedPairClone();
		testUnorderedPairClone();
		testOrderedPairEquals();
		testUnorderedPairEquals();
		testInterPairEquals();
		testUnorderedPairCompare();
	}
	
	private static void testOrderedPairGetters() {
		Pair a = new OrderedPair(1, 2);
		check("Ordered first getter", a.getFirst().equals(1));
		check("Ordered second getter", a.getSecond().equals(2));
	}
	
	private static void testUnorderedPairGetters() {
		Pair a = new UnorderedPair(1, 2);
		check("Unordered first getter", a.getFirst().equals(1));
		check("Unordered second getter", a.getSecond().equals(2));
	}
	
	private static void testOrderedPairClone() {
		Pair a = new OrderedPair(1, 2);
		Pair clone = a.clone();
		check("Ordered clone type", clone instanceof OrderedPair);
		check("Ordered cloned first elements", a.getFirst().equals(clone.getFirst()));
		check("Ordered cloned secoond elements", a.getSecond().equals(clone.getSecond()));
	}
	
	private static void testUnorderedPairClone() {
		Pair a = new UnorderedPair(1, 2);
		Pair clone = a.clone();
		check("Ordered clone type", clone instanceof UnorderedPair);
		check("Ordered cloned first elements", a.getFirst().equals(clone.getFirst()));
		check("Ordered cloned secoond elements", a.getSecond().equals(clone.getSecond()));
	}
	
	private static void testOrderedPairEquals() {
		Pair a = new OrderedPair(1, 2);
		check("Ordered reflexive equality", a.equals(a));
		check("Ordered null inequality", !a.equals(null));
		Pair b = new OrderedPair(1, 2);
		check("Order regular equality case 1", a.equals(b));
		check("Order regular equality case 2", b.equals(a));
		check("Order regular equality case 3", a.hashCode() == b.hashCode());
	}
	
	private static void testUnorderedPairEquals() {
		Pair a = new UnorderedPair(1, 2);
		check("Unordered reflexive equality", a.equals(a));
		check("Unordered null inequality", !a.equals(null));
		Pair b = new UnorderedPair(1, 2);
		check("Unordered regular equality case 1", a.equals(b));
		check("Unordered regular equality case 2", b.equals(a));
		check("Unordered regular equality case 3", a.hashCode() == b.hashCode());
		Pair c = new UnorderedPair(2, 1);
		check("Unordered regular equality case 4", a.equals(c));
		check("Unordered regular equality case 5", c.equals(a));
		check("Unordered regular equality case 6", a.hashCode() == c.hashCode());
	}
	
	private static void testInterPairEquals() {
		Pair a = new OrderedPair(1, 2);
		Pair b = new UnorderedPair(1, 2);
		check("Inter pair inequality case 1", !a.equals(b));
		check("Inter pair inequality case 2", !b.equals(a));
	}
	
	private static void check(String message, boolean condition) {
		System.out.println(message + (condition ? " PASSED" : " FAILED"));
	}

	private static void testUnorderedPairCompare() {
		OrderedPair a = new OrderedPair(1, 2);
		OrderedPair b = new OrderedPair(1, 2);
		OrderedPair c = new OrderedPair(2, 1);

		System.out.println(c.compareTo(a));
		System.out.println(a.compareTo(c));
		System.out.println(a.compareTo(b));


	}
}
