package com.codingandfoo.heaps;
public class BinaryMinHeap<T extends Comparable<T>> implements MinHeap<T> {

	private int last;
	private Object[] array;
	
	public BinaryMinHeap(int heapSize) {
		this.last = -1;
		this.array = new Object[heapSize];
	}
	
	@SuppressWarnings("unchecked")
	public T getMin() {
		return (T) this.array[0];
	}

	public T extractMin() {		
		T min = this.getMin();
		this.array[0] = this.array[this.last];
		this.array[this.last] = null;
		this.last--;
		this.heapify(0);
		return min;
	}

	@SuppressWarnings("unchecked")
	public void insert(T t) {
		this.array[++this.last] = t;

		int index = this.last;
		int parent_index;
		T node, parent;
		while (index > 0) {
			parent_index = (index - 1 + index%2) / 2;
			node = (T) this.array[index];		
			parent = (T) this.array[parent_index];
			if (parent.compareTo(node) > 0) {
				this.array[index] = parent;
				this.array[parent_index] = node;
				index = parent_index;
			} else {
				// we're done
				break;
			}
		}		
	}

	public void decreaseKey(T t) {
		for (int i=0; i<this.last; i++) {
			if (this.array[i] == t) {
				decreaseKey(t, i);
				break;
			}			
		}
	}
	
	public void decreaseKey(T t, int position) {
		throw new UnsupportedOperationException("decreaseKey is not implemented");
	}

	@SuppressWarnings("unchecked")
	private void heapify(int index) {
		// from top to bottom
		
		int child_index;
		T node, child, other_child;
		while (index * 2 + 1 <= this.last) { // as long as the left child exists
			child_index = index * 2 + 1;			
			node = (T) this.array[index];
			child = (T) this.array[child_index]; // left child
			
			if (child_index+1 <= this.last) {
				// only evaluate right child if it exists
				other_child = (T) this.array[child_index+1]; // right child				
				if (child.compareTo(other_child) >= 0) {
					// pick right (right path) might be shorter
					child_index += 1;
					child = other_child;
				}
			}
					
			if (node.compareTo(child) > 0) {
				this.array[index] = child;
				this.array[child_index] = node;
				index = child_index;
			} else {
				// we're done
				break;
			}
		}
	}
	@Override
	public boolean isEmpty() {
		return this.last < 0;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for (int i=0; i<=this.last; i++) {
			if (ret.length() > 0) 
				ret.append(", ");
			ret.append(this.array[i]);			
		}
		return ret.toString();
	}

}
