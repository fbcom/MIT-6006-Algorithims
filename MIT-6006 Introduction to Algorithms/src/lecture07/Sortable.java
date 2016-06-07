package lecture07;

public class Sortable<T> implements HasIntKey, HasValue<T> {

	private int key;
	private T value;
	
	public Sortable(int key, T value) {
		this.setKey(key);
		this.setValue(value);
	}
	
	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public T getValue() {
		return this.value;
	}
	@Override
	public void setValue(T value) {
		this.value = value;
	}
	
	public String toString() {
		return "("+this.getKey()+":"+this.getValue()+")";
	}

}
