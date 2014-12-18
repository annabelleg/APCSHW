import java.util.ArrayList;
import java.util.Arrays;
public class Sorts{

    public static void bubble(int[]c) {
        boolean swapped = true;                                         
        while (swapped) {
            swapped = false;
            for (int i= 1; i < c.length; i ++) {
                if (c[i-1] > c[i]) {
                    int temp = c[i];
                    c[i] = c[i-1];
                    c[i-1] = temp;
                    swapped = true;
                }
            }                           
        }
    }

    public static void insertion(int[] c){
	int blah;
	int i;  
	for (int j = 1; j < c.length; j++){
	    blah = c[j];
	    for(i = j - 1; (i >= 0) && (c[i] > blah); i--){
		c[i + 1] = c[i];
	    }
	    c[i + 1] = blah;
	}
    }


    public static void selection(int[] c){
	int i, j, first, temp;  
	for (i = c.length - 1; i > 0; i--){
	    first = 0;
	    for(j = 1; j <= i; j ++){
		if (c[j] > c[first])         
		    first = j;
	    }
	    temp = c[first];
	    c[first] = c[i];
	    c[i] = temp; 
	}           
    }

    public static void radix(int[] c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
	int m = 0;
	int biggest = c[0];
	for (int i = 0; i < c.length ; i++){
	    if (c[i]>biggest){
		biggest = c[i];
		m = c[i].length;
	}
	while (!c.equals(Arrays.Sort(c))){
	    for (int i = 0; i < c.length ; i++){
		for (int tens = 10;i < 10^(; tens*=10){
		    if (c[i]%tens);
		}
	    }
	}		 
    }
    
    public static String name(){
	return "Gary,Annabelle";
    }
    public static int period(){
	return 7;
    }
    public static void main(String[]args){

    }
}
