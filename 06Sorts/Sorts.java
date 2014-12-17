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
    
    public static boolean isSorted(int[]c){
	for (int i = 1; i < c.length ; i++){
	    if (c[i] < c[i-1]) return false;
	}
	return true;
    }
    public static void main(String[]args){
	int[] a = {5,6,3,8,0,-1,7,2,24,0,9};
	int[] b = {5,6,3,8,0,-1,7,2,24,0,9};
	int[] c = {5,6,3,8,0,-1,7,2,24,0,9};

	Sorts.bubble(a);
	Sorts.insertion(b);
	Sorts.selection(c);

	if (isSorted(a))
	    System.out.println("bubble is true");
	if (isSorted(b)) 
	    System.out.println("insertion is true");
	if (isSorted(c)) 
	    System.out.println("selection is true");
    }
}
