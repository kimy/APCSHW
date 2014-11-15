import java.util.*;
public class ArrayListMethods{

    public static void RemoveDuplicates(ArrayList<Integer> L){
	for(int i = 0; i < L.size(); i++){
	    if(L.get(i).equals(L.get(i+1))){
		L.remove(i);
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	Random r = new Random;
	for(int i = 0; i< L.size(); i++){
	    int a = r.nextInt(L.size() - 1);
	    L.add(L.remove(a));
	}
    }


}