public class demo{
    public static void main(String[]args){
	SuperArray a = new SuperArray(500000);
	for (int i = 0; i < 500000; i++){
	    a.set(i, ""+i);
	}
	if (args[0]=="select"){
	    selectionSort(a);
	}else if (args[0]=="insert"){
	    insertionSort(a);
	}else if (args[0]=="array"){
	    Arrays.sort();
	}else{
	    System.out.println("Please enter a type of sort.");
	}
    }
