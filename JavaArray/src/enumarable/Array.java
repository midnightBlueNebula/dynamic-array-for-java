package enumarable;

public class Array<T> extends Enumarable<T>{
	private T[] objectArray;
	
	
	Array (){
		objectArray = (T[]) new Object[size];
	}
	
	
	Array (T[] arr){
		size = arr.length;
		objectArray = (T[]) new Object[size];
		
		for(int i = 0; i < size; i++) {
			add(arr[i]);
		}
	}
	
	
	void add(T object) {
		if(nextIndex >= size()) {
			resize(size()*2);
		}
		
		objectArray[nextIndex++] = (T) object;
	}
	
	
	void remove(int index) {
		if(index < 0 || index >= length()) return;
		
		for(int i = index; i < length()-1; i++) {
			objectArray[i] = get(i+1);
		}
		
		objectArray[--nextIndex] = null;
		reduceSize();
	}
	
	
	void remove(Object object) {
		for(int i = 0; i < length(); i++) {
			if(object.equals(get(i))) {
				remove(i);
				return;
			}
		}
	}
	
	
	void resize(int newSize) {
		size = newSize; 
		T[] newArray = (T[]) new Object[size];
		for(int i = 0; i < length(); i++) {
			newArray[i] = get(i);
		}
		objectArray = (T[]) new Object[size];
		objectArray = newArray;
	}
	
	
	void reduceSize() {
		if(length() < size()/3) {
			resize(size()/3);
		}
	}
	
	
	T get(int index) {
		return objectArray[index];
	}
	
	
	void print() {
		String track = "[";
		String output = track;
		for(int i = 0; i < length(); i++) {
			output = track;
			output += get(i);
			track = output + ", ";
		}
		output += "]";
		System.out.println(output);
	}
	
	
	void foreach(Foreach<T> f) {
		for(int i = 0; i < length(); i++) {
			f.apply(get(i));
		}
	}
	
	
	void foreach(ForeachWithIndex<T> f) {
		for(int i = 0; i < length(); i++) {
			f.apply(get(i), i);
		}
	}
	
	
	Array<T> map(MapAndFilter<T> f) {
		Array<T> newArray = new Array<T>();
		foreach((obj) -> { newArray.add(f.apply(obj)); });
		return newArray;
	}
	
	
    Array<T> map(MapAndFilterWithIndex<T> f) {
    	Array<T> newArray = new Array<T>();
		foreach((obj, i) -> { newArray.add(f.apply(obj, i)); });
		return newArray;
	}
    
    
    Array<T> filter(MapAndFilter<T> f){
    	Array<T> newArray = new Array<T>();
		foreach((obj) -> { if(f.apply(obj) != null) newArray.add(f.apply(obj)); });
		return newArray;
    }
    
    
    Array<T> filter(MapAndFilterWithIndex<T> f){
    	Array<T> newArray = new Array<T>();
		foreach((obj, i) -> { if(f.apply(obj, i) != null) newArray.add(f.apply(obj, i)); });
		return newArray;
    }
    
    
    boolean every(EveryAndAny<T> f) {
    	for(int i = 0; i < length(); i++) {
    		if(!f.apply(get(i))) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    boolean any(EveryAndAny<T> f) {
    	for(int i = 0; i < length(); i++) {
    		if(f.apply(get(i))) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
    T reduce(Reduce<T> f, T initialValue) {
    	for(int i = 0; i < length(); i++) {
    		initialValue = f.apply(initialValue, get(i));
    	}
    	
    	return initialValue;
    }
}
