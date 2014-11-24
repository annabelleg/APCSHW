import java.util.*;

public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param rows is the starting height of the WordGrid
     *@param cols is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
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
    //vertical + diagonal should be implemented as well.
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
 public static void fit(String word, WordGrid w){
	Random rand = new Random();
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
}

