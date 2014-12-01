import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
	int rows;
	int cols;
	boolean fillrandletters = true;
	if (args[0]!=null && args[1]!=null){
	    rows = Integer.parseInt(args[0]);
	    cols = Integer.parseInt(args[1]);
	}else{
	    System.out.println("Please specify how large you want your grid to be! Like this:\n      java Driver rows cols");
	}
	if (args[3]=="1") fillrandletters = false;
	WordGrid w = new WordGrid(rows, cols);
	if (this.getSeed()!=null){ 
	    w.setSeed(Integer.parseInt(args[2]));  
	}
	w.loadWordsFromFile("wordbank.txt", fillrandletters );
	System.out.println( "Find these words:\n"+ w.wordsInPuzzle() );
	System.out.println( w );
    }
}
