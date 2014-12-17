public class Sorts{
    public static void bubble(int[]c) {
        boolean swapOccurred = true;                                         
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
    static boolean isSorted(int[]c){
	for (int i = 1; i < c.length ; i++){
	    if (c[i] < c[i-1]) return false;
	}
	return true;
    }
    /*  public  void insertionSort(){
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
	}*/
    public static void main(String[]args){
	int[] a = {5,6,3,8,0,-1,7,2};
	Sorts.bubble(a);
	//System.out.println(a);'
	if (isSorted(a)) 
	    System.out.println("true");
    }
}
