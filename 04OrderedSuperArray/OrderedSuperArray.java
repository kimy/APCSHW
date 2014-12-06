public class OrderedSuperArray extends SuperArray{


    public OrderedSuperArray(){
	super(10);
    }

    public OrderedSuperArray(int size){
	super(size);

    }

    public void add(String o){
        int index = size();
        while( index >0 && get(index-1).compareTo(o) > 0 ){
            index--;
        }
        super.add(index, o);
    }


    public void add(int index, String s){
	add(s);
    }

    public String set(int index, String s){
	add(s);
	return remove(index);
    }

    /*
    //binary search
    public int find(String s){
    int mid = (size()/2);
    int change = (size()/2);

    for(int i = 0; i < 

    }
    */

}
