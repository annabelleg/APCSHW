import java.util.*;
import java.io.*;

public class WordSearch{
    public static void main(String[]args) throws FileNotFoundException{
	if (args[0]!=null && args[1]!= null){
	    WordGrid a = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    System.out.println(chooseWords(a));
	}else{ System.out.println("Please enter your data like this:\n     java Driver rows cols [ randomSeed [ answers] ]\n where rows and cols are integers from 0-30. randomSeed and answers are optional.");
	}
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
        ArrayList<String> words = WordSearch.scan();
	Random rand = new Random();
        for (int i = words.size(); i > 0; i--){
	    WordGrid.fit(scan().get(rand.nextInt(scan().size())), w);
	}
	return w;
    }
}
