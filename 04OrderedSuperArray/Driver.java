import java.util.*;
import java.io.*;

public class Driver{

    public static void main(String[] args){

	SuperArray L = new SuperArray(2000);
	SuperArray M = new SuperArray(2000);
	//SuperArray N = new SuperArray(2000);
  
	for(int i = 0; i < 2000; i++){
	    L.add("" + i);
	    M.add("" + i);
	    //N.add("" + i);
	}

	//test insertionSort();
	long startTime = System.currentTimeMillis();
	L.insertionSort();
	long endTime = System.currentTimeMillis();
	System.out.println("insertionSort(): " + (endTime - startTime));
	System.out.println(L);

	//test selectionSort();
	startTime = System.currentTimeMillis();
	M.selectionSort();
	endTime = System.currentTimeMillis();
	System.out.println("selectionSort(): " + (endTime - startTime));
	System.out.println(M);

    }


}
