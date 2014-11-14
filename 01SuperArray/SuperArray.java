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

    public void add(){
	this.resize(this.size() + 1);
    }

    public void add(Object e){
	for (int i = 0; i < dataset.length ; i++){
	    if (dataset[i]==null){
	        this.set(i,e);
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
	    throw new IndexOutOfBoundsException("Index is out of range.");
	}else{
	    return dataset[index];
	}
    }

    public Object set(int index, Object o){
	Object replaced = dataset[index];
	if ( index < 0  || index >= size() ){
	    throw new IndexOutOfBoundsException();
	}else{
	    dataset[index] = o;
	}
	return replaced;
    }

    public Object remove(int index){
	Object item = null;
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

    public static void main(String[]args){
	/*SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(5);
	//	System.out.println(a.toString());
	//	System.out.println(b.toString());
	a.add(5);
	b.add("seven");
	a.add("hello");
	b.add(78);
	System.out.println(a);
	System.out.println(b);
	a.resize(3);
	b.resize(10);
	System.out.println(a);
	System.out.println(b);
	a.clear();
	System.out.println(a);
	System.out.println(b);
	//	System.out.println(a.get(3));
	System.out.println(b.get(0));
	b.set(6,"buggabo");
	System.out.println(b);*/


	Integer x = new Integer(5);
	SuperArray L = new SuperArray(7);
	L.add(x);
	L.add(new Integer(99));
	System.out.println(L);
	L.add("seven");
	L.add(7, "eight");
	//	L.add(10, "ten");
	System.out.println(L);
	L.add();
	L.set(3, "MOOP");

       	System.out.println(L);
	System.out.println(L.get(5));
	System.out.println(L.get(3));
	SuperArray M = new SuperArray(2);
	L.set(5, M);
	System.out.println(L);

	L.remove(5);
	System.out.println(L);
	L.clear();

	/*	System.out.println(L.toString());
	SuperArray c = new SuperArray(5);
	System.out.println(c);
	System.out.println(c.size());
	c.add("Test");
	System.out.println(c);
       	System.out.println(c.size());
       	c.add("Blah");
	System.out.println(c);
       	System.out.println(c.size());
	c.resize(3);
	System.out.println(c);
	c.add("Blah");
	System.out.println(c);
	c.add("Blah");
	c.add("Blah");
	System.out.println(c);	
        a.add(2, "insertion");
	System.out.println(c);	
	c.remove(2);
	System.out.println(c);*/

    }
}
