package generics.Aufgabe4;

public class UnorderedPair implements Pair {
	private final Object first;
	private final Object second;
	
	public UnorderedPair(Object first, Object second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("null argument");
		}
		this.first = first;
		this.second = second;
	}

	@Override
	public Object getFirst() {
		return first;
	}

	@Override
	public Object getSecond() {
		return second;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result += (first == null) ? 0 : first.hashCode();
		result += (second == null) ? 0 : second.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UnorderedPair other = (UnorderedPair) obj;
		return equals(first, other.first) && equals(second, other.second) ||
				equals(first, other.second) && equals(second, other.first);
	}
	
	private boolean equals(Object obj1, Object obj2) {
		if (obj1 == null || obj2 == null) {
			return obj1 == obj2;
		} else {
			return obj1.equals(obj2);
		}
	}
	
	@Override
	public UnorderedPair clone() {
		return new UnorderedPair(first, second);
	}
}
