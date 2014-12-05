public class SuperArray{
    private String[] dataset;
    private int numEls;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int x){
	dataset = new String[x];
	numEls = x;
    }
    public String toString(){
	String stuff = "[ ";
	for (int i = 0; i<dataset.length; i++){
	    stuff += dataset[i] + " ";
	}
	return stuff + "]";
    }

    public void add(){
	this.resize(this.size() + 1);
    }

    public void add(String e){
	for (int i = 0; i < dataset.length ; i++){
	    if (dataset[i].equals(null)){
	        this.set(i,e);
		break;
	    }
	}
    }

    public void add(int index, String e){
	if (index < 0 || index > this.size()){
	    throw new IndexOutOfBoundsException("Index out of bounds.");
	}
	this.resize(this.size() + 1);
	this.set(index, e);
    }

    public int size(){
	return numEls;
    }

    public void resize(int newCapacity){
	String[] newArray = new String[newCapacity];
	numEls = newCapacity;
	if (newCapacity > dataset.length){    
	    for (int i = 0; i < dataset.length ; i++){
		newArray[i] = dataset[i];
	    }
	}else{
	    for (int i = 0; i < newCapacity ; i++){
		newArray[i] = dataset[i];
	    }
	}
        dataset = newArray;
    }

    public void clear(){
	for (int i = 0; i < dataset.length ; i++){
	    dataset[i] = null;
	}
    }

    public String get(int index){
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException("Index is out of range.");
	}else{
	    return dataset[index];
	}
    }

    public String set(int index, String o){
	String replaced = dataset[index];
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException();
	}else{
	    dataset[index] = o;
	}
	return replaced;
    }

    public String remove(int index){
	String item = null;
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException();
	}else{
	    item = dataset[index];
	    for (int i = index; i < this.size()-1; i++){
		dataset[i] = dataset[i+1];
	    }
	    this.resize(this.size()-1);
	}
	return item;
    }
    public  void insertionSort(){
	for(int i = 1; i < size(); i++){
	    String value = get(i);
	    int j = i - 1;
	    while(j >= 0 && get(j).compareTo(value) < 1){
		set(j + 1, get(j));
		j--;
	    }
	    set(j + 1, value);
	}
    }
    public void selectionSort(){
	for (int i = 0; i < size(); i++){
	    String temp = get(i);
	    for (int x = 1; x <   size(); x++){
		String smallest = get(0);
		if (smallest.compareTo(get(x)) > 0){
		    smallest = get(x);
		}
		set(i, smallest);
		set(x, temp);
	    }
	}
    }

    
    public static void main(String[]args){
	SuperArray s = new SuperArray(500000);
	for (int i = 0; i < 500000 ; i++){
	    s.set(i, ""+i);
	}
	s.insertionSort();
	System.out.println("Sorted!");

    }
}
