package com.codingandfoo.heaps;
public interface MinHeap<T extends Comparable<?>> {

	public T getMin();
	public T extractMin();
	public void insert(T t);
	public void decreaseKey(T t);
	public boolean isEmpty();

}
