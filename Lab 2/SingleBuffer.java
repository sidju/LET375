import java.util.*;

public class SingleBuffer<T>{
	 private static final int DEFAULT_CAPACITY = 256;
	 private int capacity = DEFAULT_CAPACITY;
	 private int size = 0;
	 private T[] array;
	 private Comparator<? super T> comp;

	 public SingleBuffer(Comparator<? super T> comp) {
		 this.comp = comp;
		 array = (T[]) new Object[capacity];
	 }

	 public boolean put(T value) {
		 if(size == capacity)
			 return false;
		 insert(value);
		 return true;
	 }

	 private void insert( T value ) {
		 int i = size;
		 while (i > 0 && comp.compare(array[i-1], value) > 0) {
			 array[i] = array[i-1];
			 i--;
		 }
		 array[i] = value;
		 size++;
	 }

	 public T get(){
		 return array;
	 }
}
