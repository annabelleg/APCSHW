import java.util.*;
import java.io.*;

public class WordSearch{
    public static void main(String[]args){
	WordGrid a = new WordGrid(15,15);
	/*System.out.println(a);
	System.out.println(a.addWordHorizontal("mello", 5,2));
	System.out.println(a);
	System.out.println(a.addWordVertical("jello", 1,6));
	System.out.println(a);
	System.out.println(a.addWordDiagonalDown("hello", 0,0));
	System.out.println(a);
	System.out.println(a.addWordDiagonalUp("yellow", 6,0));
	System.out.println(a);
		a.clear();
		System.out.println(a);

	//	System.out.println(a.getCols());
	//	System.out.println(a.getRows());
	//	String a = "hello world";
	WordGrid.fit("rubberduck",a);
	WordGrid.fit("hello",a);
	System.out.println(a);
	WordGrid.fit("world",a);
	System.out.println(a);
	WordGrid.fit("peanut",a);
	WordGrid.fit("love",a);
	WordGrid.fit("annabelle",a);
	WordGrid.fit("ruby",a);
	System.out.println(a);
	WordGrid.fit("queen",a);
	WordGrid.fit("candle",a);
	WordGrid.fit("candelabra",a);
	WordGrid.fit("tenletters",a);
	System.out.println(a);
	WordGrid.fit("birthday",a);
	WordGrid.fit("cow",a);
	WordGrid.fit("hi",a);*/
	
	//	System.out.println(a);
	System.out.println(scan());
    }
    public static ArrayList scan() throws FileNotFoundException {
	File f = new File("wordbank.txt");
	System.out.println(f.exists());
	System.out.println(f.canRead());
	Scanner scnr = new Scanner(f);
	ArrayList<String> words = new ArrayList<String>();
	while (scnr.hasNext()){
	    words.add(scnr.next());
	}
	return words;
    }
}
