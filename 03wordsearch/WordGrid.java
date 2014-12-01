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
    public WordGrid(int rows,int cols, int randomSeed, int answers){
	data = new char[rows][cols];
	for (int r = 0; r < rows; r ++){
	    for (int c = 0; c < cols; c ++){
		data[r][c] = '.';
	    }
	}
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
    public int getSeed(){
	return this
    }
    
    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
		data[r][c] = '.';
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
	    if (data[row][col + i] != '.' && data[row][col + i] != chars[i]) return false;  
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
	    if (data[row + i][col] != '.' && data[row + i][col] != chars[i]) return false;  
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
	    if (data[row + i][col + i] != '.' && data[row + i][col + i] != chars[i]) return false;  
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
	    if ( row - i < 0 || data[row - i][col + i] != '.' && data[row - i][col + i] != chars[i]) return false;  
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
    public  void fit(String word){
	int direction = rand.nextInt(8);
	for (int tries = 100; tries > 0; tries--){
	    int x = rand.nextInt(w.getCols());
	    int y = rand.nextInt(w.getRows());
	    if (direction == 0){
		if (w.addWordHorizontal(word,x,y)) break;
		direction = rand.nextInt(8);
	    }else if (direction == 1){
		if (w.addWordHorizontal(WordGrid.reverse(word),x,y)) break;
	        direction = rand.nextInt(8);
	    }else if (direction == 2){
		if (w.addWordVertical(word,x,y)) break;
		direction = rand.nextInt(8);
	    }else if (direction == 3){
		if (w.addWordVertical(WordGrid.reverse(word),x,y)) break;
	        direction = rand.nextInt(8);
	    }else if (direction == 4){
	        if (w.addWordDiagonalDown(word,x,y)) break;
	        direction = rand.nextInt(8);
	    }else if (direction == 5){
		if (w.addWordDiagonalDown(WordGrid.reverse(word),x,y)) break;
		direction = rand.nextInt(8);
	    }else if (direction == 6){
	        if (w.addWordDiagonalUp(word,x,y)) break;
	        direction = rand.nextInt(8);
	    }else{
	        if (w.addWordDiagonalUp(WordGrid.reverse(word),x,y)) break;
		direction = rand.nextInt(8);
	    }	
	}
    }
    public void loadWordsFromFile(String filename, boolean fillRandomLetters) throws FileNotFoundException {
	File f = new File(filename);
	Scanner scnr = new Scanner(f);
	ArrayList<String> words = new ArrayList<String>();
	while (scnr.hasNext()){
	    words.add(scnr.next());
	}
	this.chooseWords();
	if (fillRandomLetters){
	    this.fillIn();
	}
    }
    public void chooseWords() throws FileNotFoundException{
        ArrayList<String> words = WordSearch.scan();
        for (int i = words.size(); i > 0; i--){
	    fit(scan().get(rand.nextInt(scan().size())));
	}
	return w;
    }
    public void fillIn(){
	for (int i = 0 ; i < data.length ; i++){
	    for (int x = 0; x < data[i].length ; x++){
		if (data[i][x]!='.'){
		    data[i][x] = pickRandLetter;
		}
	    }
	}
    }
    public char pickRandLetter(){
	int num = rand.nextInt(26);
	if (num == 0) return 'a';
	if (num == 1) return 'b';
	if (num == 2) return 'c';
	if (num == 3) return 'd';
	if (num == 4) return 'e';
	if (num == 5) return 'f';
	if (num == 6) return 'g';
	if (num == 7) return 'h';
	if (num == 8) return 'i';
	if (num == 9) return 'j';
	if (num == 10) return 'k';
	if (num == 11) return 'l';
	if (num == 12) return 'm';
	if (num == 13) return 'n';
	if (num == 14) return 'o';
	if (num == 15) return 'p';
	if (num == 16) return 'q';
	if (num == 17) return 'r';
	if (num == 18) return 's';
	if (num == 19) return 't';
	if (num == 20) return 'u';
	if (num == 21) return 'v';
	if (num == 22) return 'w';
	if (num == 23) return 'x';
	if (num == 24) return 'y';
	if (num == 25) return 'z';
    }
}

