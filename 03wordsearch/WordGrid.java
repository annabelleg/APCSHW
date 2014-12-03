import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    private static Random rand;
    private ArrayList<String> words;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param rows is the starting height of the WordGrid
     *@param cols is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	for (int r = 0; r < rows; r ++){
	    for (int c = 0; c < cols; c ++){
		data[r][c] = '_';
	    }
	}
	rand = new Random();
	words = new ArrayList<String>();
    }

    public WordGrid(){
	this(15,15);
    }

    public int getRows(){
	return data.length;
    }

    public int getCols(){
	int cols = 0;
	for (int i = 0; i < data.length; i++){
	    cols = data[i].length;
	}
	return cols;
    }

    public void setRowsAndCols(int r, int c){
	data = new char[r][c];
    }

    public void setSeed(long seed){
	rand = new Random(seed);
    }
    
    /**Set all values in the WordGrid to blanks '_'*/
    private void clear(){
	for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
		data[r][c] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
		result+= data[r][c] + " ";
	    }
	    if (r != data.length-1){
		result += "\n";
	    }
	}
        return result + "\n";
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if (row >= this.getRows() || col >= this.getCols()) return false;
	char[] chars = word.toCharArray();
	if (this.getCols() - col < chars.length) return false;
	for (int i = 0; i < chars.length; i++){
	    if (data[row][col + i] != '_' && data[row][col + i] != chars[i]) return false;  
	}
	for (int w = 0; w < chars.length; w++){
	    data[row][col + w] = chars[w];
	
	}
	return true;
    }

    public boolean addWordVertical(String word,int row, int col){
	if (row >= this.getRows() || col >= this.getCols()) return false;
	char[] chars = word.toCharArray();
	if (this.getRows() - row < chars.length) return false;
	for (int i = 0; i < chars.length; i++){
	    if (data[row + i][col] != '_' && data[row + i][col] != chars[i]) return false;  
	}
	for (int w = 0; w < chars.length; w++){
	    data[row + w][col] = chars[w];
	}
   
	return true;
    }

    public boolean addWordDiagonalDown(String word, int row, int col){
	if (row >= this.getRows() || col >= this.getCols()) return false;
	char[] chars = word.toCharArray();
	if (this.getRows() - row < chars.length || this.getCols() - col < chars.length) return false;
	for (int i = 0; i < chars.length; i++){
	    if (data[row + i][col + i] != '_' && data[row + i][col + i] != chars[i]) return false;  
	}
	for (int w = 0; w < chars.length; w++){
	    data[row + w][col + w] = chars[w];
	}
	return true;
    }

    public boolean addWordDiagonalUp(String word, int row, int col){
	if (row >= this.getRows()|| row < 0 || col >= this.getCols() || col < 0) return false;
	char[] chars = word.toCharArray();
	if (this.getRows() - row > chars.length || this.getCols() - col < chars.length) return false;
	for (int i = 0; i < chars.length; i++){
	    if ( row - i < 0 || data[row - i][col + i] != '_' && data[row - i][col + i] != chars[i]) return false;  
	}
	for (int w = 0; w < chars.length; w++){
	    data[row - w][col + w] = chars[w];
	}
	
	return true;
    }

    public static String reverse(String a){
	String result = new StringBuilder(a).reverse().toString();
	return result;
    }

    public boolean fit(String word){
	int direction = rand.nextInt(8);
	for (int tries = 100; tries > 0; tries--){
	    int x = rand.nextInt(getCols());
	    int y = rand.nextInt(getRows());
	    if (direction == 0){
		if (addWordHorizontal(word,x,y)) return true;
		direction = rand.nextInt(8);
	    }else if (direction == 1){
		if (addWordHorizontal(WordGrid.reverse(word),x,y)) return true;
	        direction = rand.nextInt(8);
	    }else if (direction == 2){
		if (addWordVertical(word,x,y)) return true;
		direction = rand.nextInt(8);
	    }else if (direction == 3){
		if (addWordVertical(WordGrid.reverse(word),x,y)) return true;
	        direction = rand.nextInt(8);
	    }else if (direction == 4){
	        if (addWordDiagonalDown(word,x,y)) return true;
	        direction = rand.nextInt(8);
	    }else if (direction == 5){
		if (addWordDiagonalDown(WordGrid.reverse(word),x,y)) return true;
		direction = rand.nextInt(8);
	    }else if (direction == 6){
	        if (addWordDiagonalUp(word,x,y)) return true;
	        direction = rand.nextInt(8);
	    }else{
	        if (addWordDiagonalUp(WordGrid.reverse(word),x,y)) return true;
		direction = rand.nextInt(8);
	    }	
	}
	return false;
    }

    public void loadWordsFromFile(String filename, boolean fillRandomLetters) throws FileNotFoundException {
	chooseWords(filename);
	if (fillRandomLetters){
	    fillIn();
	}
    }

    public void chooseWords(String f) throws FileNotFoundException{
        ArrayList<String> allWords = scan(f);
        for (int i = allWords.size(); i > 0; i--){
	    String w = allWords.get(rand.nextInt(i));
	    if(fit(w)){
		words.add(w);
		allWords.remove(w);
	    }
	}
    }

    public static ArrayList<String> scan(String f) throws FileNotFoundException {
	File fname = new File(f);
	Scanner scnr = new Scanner(fname);
	ArrayList<String> allWords = new ArrayList<String>();
	while (scnr.hasNext()){
	    allWords.add(scnr.next());
	}
	return allWords;
    }

    public void fillIn(){
	for (int i = 0 ; i < data.length ; i++){
	    for (int x = 0; x < data[i].length ; x++){
		if (data[i][x]=='_'){
		    data[i][x] = pickRandLetter();
		}
	    }
	}
    }

    public char pickRandLetter(){
	char letter = (char)(rand.nextInt(26) + 97);
	return letter;
        
    }

    public String wordsInPuzzle(){
	String result = "";
       	for (int i = 0; i < words.size(); i++){
	    if (i % 3 == 0){
		result += "\n";
	    }
	    result += words.get(i) + addSpaces(words.get(i));
	}
	result += "\n";
	return result;
    }

    public String addSpaces(String word){
	int spaces = 20 - word.length();
	String space = " ";
	for (int i = 0; i < spaces; i++){
	    space += " ";
	}
	return space;
    }
}

