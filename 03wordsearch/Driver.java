import java.util.*;
import java.io.*;

public class Driver{

    public static void main(String[] args)throws FileNotFoundException{

	Random r = new Random();

	/*set params 
	 */
	int rows = 0;
	int cols = 0;
	long seed = 0;
	int answer = 0;
	boolean answers = true;
	
	rows = Integer.valueOf(args[0]);
	cols = Integer.valueOf(args[1]);
	if(args.length > 2){
	    seed = Long.valueOf(args[2]);
	}
	if(args.length > 3){
	    answer = Integer.valueOf(args[3]);
	    if(answer == 0){
		answers = false;
	    }else{
		answers = true;
	    }
	}else{
	    answers = true;
	}
	
	WordGrid grid = new WordGrid(rows, cols, seed);
	if(answers){
	    System.out.println("YOU WANTED THE ANSWERS");
	}
	grid.loadWordsFromFile("word.txt", answers);
	System.out.println(grid.toString());
	ArrayList<String> wordbox = grid.getWordsInPuzzle();
	System.out.println("Get These Words");
	System.out.println(wordbox);

    }
   
}
