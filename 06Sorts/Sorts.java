public class Sorts{
    public static void bubble(int[]c){
	for (int i = 0 ; i < c.length-1 ; i++){
	    if (c[i] > c[i+1]){
		int temp = c[i];
		c[i] = c[i+1];
		c[i+1] = temp;
	    }
	}
    }
    public static boolean isSorted(int[]c){
	for (int i = 1; i < c.length ; i++){
	    if (c[i] < c[i-1]) return false;
	}
	return true;
    }
    public static void main(String[]args){
	int[] a = {5,6,3,8,0,-1,7,2};
	Sorts.bubble(a);
	//System.out.println(a);'
	if (isSorted(a)) 
	    System.out.println("true");
    }
}
