package com.codingandfoo.heaps;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;

public class FibonacciMinHeap<T extends Comparable<T>> implements MinHeap<T> {

	private Node<T> root;
	private int rootListLength;
	
	@Override
	public T getMin() {
		return root != null ? root.value : null;
	}

	@Override
	public T extractMin() {
		Node<T> z = this.root;
		if (z != null) {
			// add all children of z to the root list
			Node<T> node = z.child;
			if (node != null) {
				do {				
					insertInList(root, node);
					node.parent = null;
					this.rootListLength++;
					
					node = node.right;		
				} while (node != z.child);
			}
			// remove z from the root list
			removeFromList(z);
			
			// update minimum
			if (z == z.right) {
				this.root = null; // heap is empty
			} else {
				this.root = this.root.right; // select a random node to be the temporary minimum 
				this.consolidate(); // and find the correct minimum
			}
		}		
		this.rootListLength--;
		return z.value;
	}

	private void consolidate() {
		// make sure that no two nodes in the root list have the same degree
		Hashtable<Integer, Node<T>> A = new Hashtable<Integer, Node<T>>();
		Node<T> node = this.root;
		do {
			Node<T> x = node;
			Integer d = x.degree;
			while (A.containsKey(d)) {
				Node<T> y = A.get(d);
				if (x.value.compareTo(y.value) > 0) {
					// swap x and y because y < x
					Node<T> tmp = x; x = y; y = tmp; 
				}
				// y becomes a child of x
				this.fibHeapLink(x, y);
				A.remove(d);
			}
			A.put(d, x);
		} while (node != this.root);
		
		// find the new minimum node in the root list
		Node<T> min = this.root;
		node = this.root;
		do {
			if (node.value.compareTo(min.value) < 0) {
				min = node;
			}
			node = node.right;
		} while (node != this.root);
		this.root = min;
	}
	
	private void fibHeapLink(Node<T> parent, Node<T> child) {
		// remove child form the root list
		child.left.right = child.right;
		child.right.left = child.left;
		// make child a child of parent
		if (parent.child == null) {
			parent.child = child;
		} else {
			insertInList(parent.child, child);
		}
		parent.degree++;
		child.parent = parent;
		child.marked = false;
	}
	
	private void insertInList(Node<T> root, Node<T> node) {
		root.right.left = node;
		node.right = root.right;
		
		root.right = node;
		node.left = root;
	}
	
	private void removeFromList(Node<T> node) {
		node.left.right = node.right;
		node.right.left = node.left;		
	}
	
	@Override
	public void insert(T t) {
		Node<T> node = new Node<T>(t);
		// add the new node to the root list
		if (this.root == null) {
			this.root = node;
		} else {
			insertInList(this.root, node);
			if (node.value.compareTo(this.root.value) < 0) {
				this.root = node; // new minimum
			}
		}		
		this.rootListLength++;
	}
	
	@Override
	public void decreaseKey(T t) {
		// find the node
		List<Node<T>> queue = new LinkedList<Node<T>>();
		if (this.root != null) {
			queue.add(this.root);
		}
		// perform a BFS
		Node<T> node;
		while (!queue.isEmpty()) {
			node = queue.remove(0);
			Node<T> sibling = node.left;
			do {
				if (node.value == t) {
					this.decreaseKey(node);
					return;
				}
				// add child to queue
				if (sibling.child != null) {
					queue.add(sibling.child);					
				}
			} while (sibling != node);
		}				
	}

	public void decreaseKey(Node<T> node) {
		throw new UnsupportedOperationException("decreaseKey is not implemented");
	}
	
	@Override
	public boolean isEmpty() {
		return this.rootListLength == 0;
	}

	@Override
	public String toString() {
		if (this.root == null) {
			return "";
		}
		
		StringBuilder ret = new StringBuilder();
		
		Node<T> node = root;
		do {
			if (ret.length() > 0) {
				ret.append("->");
			}
			ret.append(node.value);
			node = node.right;
		} while (node != root);
		return ret.toString();
	}

	/**
	 * A private container class for values inserted into the heap.
	 *
	 * @param <T> value
	 */
	@SuppressWarnings("hiding")
	private class Node<T extends Comparable<?>> {
		T value;
		int degree;
		@SuppressWarnings("unused")
		boolean marked;
		@SuppressWarnings("unused")
		Node<T> parent, child = null;
		Node<T> left, right = this;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
}