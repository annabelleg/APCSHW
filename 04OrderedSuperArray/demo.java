import java.util.Arrays;
public class demo{
    public static void main(String[]args){
	SuperArray a = new SuperArray(500000);
	String[] b = new String[500000];
	for (int i = 0; i < 500000; i++){
	    a.set(i, ""+i);
	    b[i] = ""+i;
	}
	if (args.length == 0){
	    System.out.println("Please enter a type of sort");
	}else if (args[0]=="select"){
	    a.selectionSort();
	}else if (args[0]=="insert"){
	    a.insertionSort();
	}else if (args[0]=="array"){
	    Arrays.sort(b);

	}
    }
}
