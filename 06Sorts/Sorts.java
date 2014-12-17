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

    public static void insertion(int[]c){
	for(int i = 1; i < c.length; i++){
	    int value = c[i];
	    int j = i - 1;
	    while(j >= 0 && c[j] < value){
		c[j + 1] = c[i];
		j--;
	    }
	    c[j + 1] = value;
	}
    }

    public static void selection(int[]c){
	for (int i = 0; i < c.length; i++){
	    int temp = c[i];
	    for (int x = 1; x < c.length; x++){
		int smallest = c[0];
		if (smallest > c[x]){
		    smallest = c[x];
		}
		c[i] = smallest;
		c[x] = temp;
	    }
	}
    }

    public static boolean isSorted(int[]c){
	for (int i = 1; i < c.length ; i++){
	    if (c[i] > c[i-1]) return false;
	}
	return true;
    }
    public static String toString(int[]c){
	String a = "[ ";
	for (int i = 0; i < c.length ; i++){
	    a+= "" + c[i] + ", ";
	}
	a+= "]";
	return a;
    }
    public static void main(String[]args){
	int[] a = {5,6,3,8,0,-1,7,2,24,0,9};
	int[] b = {6,7,2,4,1,0,8,-7,4,9,16};
	int[] c = {99,5,2,-5,8,0,1,2,7,9,9};
	Sorts.bubble(a);
	Sorts.insertion(b);
	Sorts.selection(c);
	System.out.println(Sorts.toString(a));
	System.out.println(Sorts.toString(b));
	System.out.println(Sorts.toString(c));
	/*	if (isSorted(a))
	    System.out.println("bubble is true");
	if (isSorted(b)) 
	    System.out.println("insertion is true");
	if (isSorted(c)) 
	System.out.println("selection is true");*/
    }
}
