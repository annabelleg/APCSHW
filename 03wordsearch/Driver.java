import java.io.FileNotFoundException;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	int rows = 0;
	int cols = 0;
	//	int getSeed;
	boolean fillrandletters = true;
	if (args.length > 1){
	    if (args[0]!=null && args[1]!=null){
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
	    }else{
		System.out.println("Please specify how large you want your grid to be! Like this:\n      java Driver rows cols [ randomSeed [ answers ] ]\n where a specific randomSeed will return the same puzzle every time and entering 1 for answers will return the solved puzzle.");
	    }
	    WordGrid w = new WordGrid(rows, cols);
	    if (args.length > 2){
		if (args.length == 4) {
		    if (args[3]!=null){
			if (args[3].equals("1")){
			    fillrandletters = false;
			}else{ fillrandletters = true;}
		    }
		}
		if (args[2]!=null){ 
		    w.setSeed(Long.parseLong(args[2]));  
		}
	    }
	    w.loadWordsFromFile("wordbank.txt", fillrandletters );
	    System.out.println( "Find these words:\n"+ w.wordsInPuzzle() );
	    System.out.println( w );
	    
	}else{
	    System.out.println("Please specify how large you want your grid to be! Like this:\n      java Driver rows cols [ randomSeed [ answers ] ]\n where a specific randomSeed will return the same puzzle every time and entering 1 for answers will return the solved puzzle.");
	
	}
    }
}

