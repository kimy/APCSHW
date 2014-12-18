import java.util.*;
import java.io.*;

public class Driver{

    private Random rand = new Random();

    public static void main(String[] args){

    int[]a = new int[100000];
    int[]b = new int[100000];
    int[]c = new int[100000];

    for(int i = 0; i < 100000; i++){
	a[i] = i;
	b[i] = i;
	c[i] = i;
    }

    long start;
    long end;
    long time;

    System.out.println("Bubble Sort:");
    start = System.currentTimeMillis();
    Sorts.bubble(a);
    end = System.currentTimeMillis();
    time = end - start;
    System.out.println(time + "");

    System.out.println("Insertion Sort:");
    start = System.currentTimeMillis();
    Sorts.insertion(b);
    end = System.currentTimeMillis();
    time = end - start;
    System.out.println(time + "");

    System.out.println("Selection Sort:");
    start = System.currentTimeMillis();
    Sorts.selection(c);
    end = System.currentTimeMillis();
    time = end - start;
    System.out.println(time + "");

    }    

}
