import java.util.*;
import java.io.*;

public class Sorts{

    public static String name(){
	return "Kim,Yubin";
    }

    public static int period(){
	return 6;
    }

    public static void radix(int[] a){


    }

    public static void bubble(int[] a){
	boolean swapped = true;
	for (int i = a.length-1; i>=0; i--){
	    if (swapped){
		swapped = false;
		for (int j = 0; j < i; j++){
		    if (a[j] >a[j + 1]){
			int temp;
			temp = a[j + 1];
			a[j + 1] = a[j];
			a[j] = temp;
			swapped=true;
		    }
		}
	    }
	}
    }


  public static void insertion(int[] a){
	int s;
	s = 0;

	for (int i = 0; i < a.length - 1; i++){
	    if (a[i + 1] < a[i]){
		s = a[i+1];
		int j = i;
		
		for (j = i; (j >= 0) && (s < a[j]); j--){
		    a[j + 1] = a[j];
		}
		
		a[j + 1] = s;
	    }
	}
    }

    public static void selection(int[] a){

	for (int i = 0; i < a.length; i++){
	    int minElement = a[i];
	    int index = i;

	    for (int j = i + 1; j < a.length; j++){
		if (a[j] < minElement){
		    minElement = a[j];
		    index = j;
		}
	    }
	    int temp;
	    temp = a[index];
	    a[index] = a[i];
	    a[i] = temp;
	}

    }









}
