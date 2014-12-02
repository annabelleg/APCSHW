public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int x){
	super(10);
    }
    public void add(String s){
	if (this.size() == 0){
	    super.add(s);
	}else{
	    for (int i = 0; i < this.size(); i++){
		if (s.compareTo(this.get(i)) < 1){
		    super.add(i, s);
		}
	    }
	    super.add(s);
	}
    }
    /*  public String set(int index, String s){
	String temp = this.get(index);
	super.set(index,s);
	
	}*/
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(1);
	a.add("Hello");
	a.add("Yolo");
	System.out.println(a);
    }
}
