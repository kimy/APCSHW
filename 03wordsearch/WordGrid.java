import java.util.*;

public class WordGrid{

    private char[][] data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int row, int col){
	data = new char[row][col];
	clear();
    }

    /**Set all values in the WordGrid to spaces ' '*/
    public void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int a = 0; a < data[i].length; a++){
		//data[i][a] = '-'; //for debugging
		data[i][a] =' ';
	    }
	}	

    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String s = ""; 
	for(int i = 0; i < data.length; i++){
	    for(int a = 0; a < data[i].length; a++){
		s += data[i][a];
	    }
	    s += "\n";
	}
	return s;
    }
    

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */	    
    public boolean addWordHorizontal(String word,int row, int col){
	int givenSpace = data[row].length - col;
	if(givenSpace < word.length()){
	    return false;
	}else{
	    for(int i=0; i<word.length(); i++){
		if(!(data[row][col+i] == ' ') && !(data[row][col+i] == word.charAt(i))){
			return false;
		}
	    }
	    for(int i=0; i<word.length(); i++){
		data[row][col+i] = word.charAt(i);
		return true;
	    }
	    return true;    
	}
    }


    /**Attempts to add a given word to the specified position of the WordGrid vertically.
     * The word is added from top to bottom, must fit on the WordGrid, and must
     * have a corresponding letter to match any letters that it overlaps.
     *@param word any text to be added to the word grid
     *@param row the vertical location of where you want the word to start
     *@param col the horizontal location of where you want the word to start
     *@return true when the word is added successfully; false when the word doesn't fit 
     *or there are overlapping letters that do not match
     */
    public boolean addWordVertical(String word, int row, int col){
	int givenSpace = data.length - row;
	if(givenSpace < word.length()){
	    return false;
	}else{
	    for(int i=0; i<word.length(); i++){
		if(!(data[row+i][col] == ' ') && !(data[row+i][col] == word.charAt(i))){
		    return false;
		}
	    }
	    for(int i=0; i<word.length(); i++){
		data[row+i][col] = word.charAt(i);
		return true;
	    }
	    return true;
	}

    }

    /**Attempts to add a given word to the specified position of the WordGrid diagonally. 
     *The word is added from top left to bottom right, must fit on the WordGrid, and must 
     *have a corresponding letter to match any letters that it overlaps.
     *@param word any text to be added to the word grid
     *@param row the vertical location of where you want the word to start
     *@param col the horizontal location of where you want the word to start
     *@return true when the word is added successfully; false when the word doesn't fit 
     *or there are overlapping letters that do not match
     */
    public boolean addWordDiagonal(String word, int row, int col){
	int horizontalSpace = data[row].length - col;
	int verticalSpace = data.length -row;
	if(horizontalSpace < word.length() && verticalSpace < word.length()){
	    return false;
	}else{
	    for(int i=0; i<word.length(); i++){
		if(!(data[row+i][col+i] == ' ') && !(data[row+i][col+i] == word.charAt(i))){
		    return false;
		}
	    }
	    for(int i=0; i<word.length(); i++){
		data[row+i][col+i] = word.charAt(i);
		return true;
	    }
	    return true;
	}
    }
      	
}
