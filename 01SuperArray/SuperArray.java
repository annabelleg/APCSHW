public class SuperArray{
    private Object[] dataset;
    private int numEls;

    public SuperArray(){
	this(10);
    }
    public SuperArray(int x){
	dataset = new Object[x];
	numEls = x;
    }
    public String toString(){
	String stuff = "[ ";
	for (int i = 0;i<dataset.length;i++){
	    stuff += dataset[i] + " ";
	}
	return stuff + "]";
    }
    public void add(Object e){
	for (int i = 0; i < dataset.length ; i++){
	    if (dataset[i]==null){
	        dataset[i] = e;
		break;
	    }
	}
    }
    public void add(int index, Object e){
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
	Object[] newArray = new Object[newCapacity];
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
    public Object get(int index){
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException();
	}else{
	    return dataset[index];
	}
    }
    public void set(int index, Object e){
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException();
	}else{
	    dataset[index] = e;
	}
    }
    public static void main(String[]args){
	/*	SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(5);
	//	System.out.println(a.toString());
	//	System.out.println(b.toString());
	a.add(5);
	b.add("seven");
	a.add("hello");
	b.add(78);
	System.out.println(a.toString());
	System.out.println(b.toString());
	a.resize(3);
	b.resize(10);
	System.out.println(a.toString());
	System.out.println(b.toString());
	a.clear();
	System.out.println(a.toString());
	System.out.println(b.toString());
	//	System.out.println(a.get(3));
	System.out.println(b.get(0));
	b.set(6,"buggabo");
	System.out.println(b.toString());*/
	//Example of ways to add Integer objects:
	Integer x = new Integer(5);
	SuperArray L = new SuperArray();
	L.add(x);
	L.add(new Integer(99));
	System.out.println(L.toString());
	L.add("seven");
	L.add(7, "eight");
	System.out.println(L.toString());
    }
}
