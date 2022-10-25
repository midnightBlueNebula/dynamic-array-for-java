package enumarable;

interface Foreach<T> {
	void apply(T obj);
}

interface ForeachWithIndex<T> {
	void apply(T obj, int index);
}

interface MapAndFilter<T> {
	T apply(T obj);
}

interface MapAndFilterWithIndex<T> {
	T apply(T obj, int index);
}

interface EveryAndAny<T> {
	boolean apply(T obj);
}

interface Reduce<T> {
	T apply(T initialValue, T obj);
}


public abstract class Enumarable<T> {
	protected int size = 1;
	protected int nextIndex = 0;
	
	int size() {
		return size;
	}
	
	int length() {
		return nextIndex;
	}
	
	abstract void add(T obj);
	
	abstract void remove(int index);
	
	abstract void remove(Object obj);
	
	abstract T get(int index);
	
	abstract void print();
	
	abstract void foreach(Foreach<T> f);
	
	abstract void foreach(ForeachWithIndex<T> f);
	
	abstract Array<T> map(MapAndFilter<T> f);
	
	abstract Array<T> map(MapAndFilterWithIndex<T> f);
	
	abstract Array<T> filter(MapAndFilter<T> f);
	
	abstract Array<T> filter(MapAndFilterWithIndex<T> f);
	
	abstract boolean every(EveryAndAny<T> f);
	
	abstract boolean any(EveryAndAny<T> f);
	
	abstract T reduce(Reduce<T> f, T initialValue);
}
