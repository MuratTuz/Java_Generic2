
package generics.Aufgabe4;

public class OrderedPair<T> implements Pair, Comparable<OrderedPair<T>>{
	private final T first;
	private final T second;
	
	public OrderedPair(T first, T second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("null argument");
		}
		this.first = first;
		this.second = second;
	}


	public T getFirst() {
		return first;
	}


	public T getSecond() {
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
	public boolean equals(Object objO) {
		T obj = (T) objO;
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		OrderedPair<T> other = (OrderedPair<T>) obj;
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

	@Override
	public int compareTo(OrderedPair<T> other) {
		OrderedPair<Integer> otherObject = (OrderedPair<Integer>) other;
		OrderedPair<Integer> thisObject = this.clone();
		if (thisObject.first > otherObject.first) return 1;
		else if (thisObject.first < otherObject.first) return -1;
		else if (thisObject.second > otherObject.second) return 1;
		else if (thisObject.second < otherObject.second) return -1;

		return 0;
	}
}
