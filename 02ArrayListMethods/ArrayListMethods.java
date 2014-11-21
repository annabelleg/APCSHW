import java.util.*;

public class ArrayListMethods{
    
    public static void collapseDuplicates(ArrayList<Integer> L){
	int i = 0;
	while ( i < L.size() -1){
	    if (L.get(i) == L.get(i+1)){
		L.remove(i+1);
	    }else{
		i++;
	    }
	}
    }
    
    public static void randomize(ArrayList<Integer> L){
	Random rand = new Random();
	for (int i = 0; i < L.size(); i++){
	    L.add(L.remove(rand.nextInt(L.size())));
	}
    }

    public static void main(String[]args){
	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(1);
	L.add(2);
	L.add(2);
	L.add(3);

	System.out.println(L);
	collapseDuplicates(L);
	System.out.println(L);

	randomize(L);
	System.out.println(L);

	/*	ArrayList<Integer> M = new ArrayList<Integer>();
	M.add(1);
	M.add(2);
	M.add(3);
	M.add(4);
	randomize(M);
	System.out.println(M);*/
    }
}
