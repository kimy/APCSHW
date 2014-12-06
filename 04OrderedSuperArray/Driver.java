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
	long start = System.currentTimeMillis();
	L.insertionSort();
	long end = System.currentTimeMillis();
	System.out.println("insertionSort(): " + (end - start));
	System.out.println(L);

	//test selectionSort();
	start = System.currentTimeMillis();
	M.selectionSort();
	end = System.currentTimeMillis();
	System.out.println("selectionSort(): " + (end - start));
	System.out.println(M);

    }


}
