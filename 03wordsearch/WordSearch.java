import java.util.*;
import java.io.*;

public class WordSearch{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid a = new WordGrid(15,15);
	System.out.println(chooseWords(a));
    }
    public static ArrayList<String> scan() throws FileNotFoundException {
	File f = new File("wordbank.txt");
	Scanner scnr = new Scanner(f);
	ArrayList<String> words = new ArrayList<String>();
	while (scnr.hasNext()){
	    words.add(scnr.next());
	}
	return words;
    }
    public static WordGrid chooseWords(WordGrid w) throws FileNotFoundException{
        WordSearch.scan();
	Random rand = new Random();
        for (int i = 20; i > 0; i--){
	    WordGrid.fit(scan().get(rand.nextInt(scan().size())), w);
	}
	return w;
    }
}
