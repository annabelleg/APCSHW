import java.until.*;

public class ArrayListWork{
    
    public void collapseDuplicates(ArrayList<Integer> L){
    for (int i = 0; i < L.length -1 ; i++){
        if (L[i] = L[i+1]) L.remove(i+1);
      }
    }

    public static void main(String[]args){
    ArrayList<Integer> L = new ArrayList<Integer>(9,1,9,3,3,4);
    L.toArray();
    L.collapseDuplicates();
    L.toArray();
    }
}
