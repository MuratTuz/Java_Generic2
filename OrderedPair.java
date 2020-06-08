
package generics.Aufgabe4;

public class OrderedPair implements Pair {
	private final Object first;
	private final Object second;
	
	public OrderedPair(Object first, Object second) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
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
		OrderedPair other = (OrderedPair) obj;
		if (first == null) {
			if (other.first != null) {
				return false;
			}
		} else if (!first.equals(other.first)) {
			return false;
		}
		if (second == null) {
			if (other.second != null) {
				return false;
			}
		} else if (!second.equals(other.second)) {
			return false;
		}
		return true;
	}
	
	@Override
	public OrderedPair clone() {
		return new OrderedPair(first, second);
	}
}
