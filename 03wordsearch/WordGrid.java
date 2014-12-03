
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid{

    private char[][] data;
    private ArrayList<String> wordlist;
    private ArrayList<String> wordsInPuzzle;
    private long seed;
    private Random r;

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

    public void loadWordsFromFile(String fileName, boolean fileRandomLetter)throws FileNotFoundException{
	Scanner in = new Scanner(new File(fileName));
	while(in.hasNext()){
	    wordlist.add(in.nextLine());
	}
	in.close();
	clear();
	addWordsToGrid(wordlist);
	fill();
	setSeed(seed);
	
    }


    public void addWordsToGrid(ArrayList<String> words){
	int tries = 200;
	wordlist = words;
	wordsInPuzzle.clear();
	clear();
	String word;
	int yRand = r.nextInt(data.length);
	int xRand = r.nextInt(data[0].length);
	int directionRand = r.nextInt(3) - 1;

	for(int i =0; i < wordlist.size(); i--){
	    word = findBiggestWord(words);
	    int index = getIndex(word, words);
	    words.remove(index);
	    if(add(word, yRand, xRand, directionRand, directionRand)){
		wordsInPuzzle.add(word);	    }
	    
	}
    }

    public int getIndex(String s, ArrayList<String> words){
	int index = 0;
	for(int i = 0; i < words.size(); i++){
	    String word = words.get(i);
	    if(word.equals(s)){
		index = i;
		break;
	    }else{
		index = 0;
	    }
	}
	    return index;
    }

    public String findBiggestWord(ArrayList<String> words){
	String biggest = words.get(0);
	for(int i = 1; i < words.size(); i++){
	    String word = words.get(i);
	    if(word.length() >= biggest.length()){
		biggest = word;
	    }
	}
	return biggest;
    }

    public void setSeed(long seed){
	r = new Random(seed);

    }

    public void fill(){
	Random r = new Random();
	String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for(int i=0; i<data.length; i++){
	    for(int a=0; a<data[i].length; a++){
		if(("" + data[i][a]).equals(" ")){
		    int x = r.nextInt(26);
		    data[i][a] = s.charAt(x);
		}		
	    }
	}
    }

    public boolean add(String word, int row, int col, int dx, int dy){
	if(wordFits(word, row, col, dx, dy)){
	    for(int i=0; i<word.length(); i++){
		data[row][col] = word.charAt(i);
		row = row + 1; 
		col = col + 1;
	    }
	    return true;
	}else{
	    return false;
	}	
    }    

    private boolean wordFits(String word, int row, int col, int dx, int dy){
	int x = col + (dx * word.length());
	int y = row + (dy * word.length());
	if(row < 0 || col < 0){
	    return false;
	}else{
	    if(x >= data.length || y >= data[0].length){
		return false;
	    }else{
		if(x < 0 || y < 0){
		    return false;
		}else{
		    return true;
		}
	    }
	}

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
