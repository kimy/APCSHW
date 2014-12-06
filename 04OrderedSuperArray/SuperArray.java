public class SuperArray{
    
    private String[] superArray;
    private int Size;
    
    public SuperArray(){
        this(10);
    }
    
    public SuperArray(int size){
        Size = 0;
        superArray = new String[size];
    }
    
    public String toString() {
        String s = "[ ";
        for (int i = 0; i < superArray.length; ++i) {
            s += superArray[i] + ", ";
        }
        s += "]";
        return s;
    }
    
    
    public int size(){
        return Size;
    }
    
    public void resize(int newCapacity){
	String[]a = new String[newCapacity];
	for (int i = 0;i < superArray.length; i++){
	    a[i] = superArray[i];
	}
	superArray = a;
    }
    
    
    public void setArray(String[] a){
        superArray = a;
    }
    
    
    public void setLength(int size){
        Size = size;
    }
    
    public String set(int index, String o){
        if(outOfRange(index)){
            throw new IndexOutOfBoundsException();
        }else{
            String a = superArray[index];
            superArray[index] = o;
            return a;
        }
    }
    
    public String get(int index){
        if(outOfRange(index)){
            throw new IndexOutOfBoundsException();
        }else{
            return superArray[index];
        }
    }
    /*  
	public void add(String e){
        setLength(Size + 1);
        resize(Size);
        superArray[Size - 1] = e;
	}
    */

    public void add(String e){
	if (size()*2 > superArray.length){
	    resize(superArray.length * 2);
	}
	superArray[size()] = e;
	Size += 1;
    }
    
    public void add(int index, String e){
        if (index>=size()){
            add(e);
            resize(Size*2);
        }else{
            resize(Size*2);
            for (int i=index;i<=Size-index;i++){
                superArray[i+1]= superArray[i];
            }
            superArray[index] = e;
        }
    }
    
    public String remove(int index){
        if(!( index < 0  || index >= size()) ){
            String a = superArray[index];
            for(int i =0; i < Size - 1; i++){
                superArray[i] = superArray[i + 1];
            }
            superArray[Size - 1] = null;
            Size = Size - 1;
            resize(Size);
            return a;	 
        }else{
            return null;
        }
    }
    
    private boolean outOfRange(int index){
        if(index < 0 || index >= size()){
            return true;
        }else{
            return false;
        }
    }

    public int find(String target){

	for(int i = 0; i < size(); i++){
	    if(get(i).equals(target)){
		return i;
	    }
	}
	return -1;
    }


    //Sorts 
    public void insertionSort(){
	String s;
	s = "";

	for (int i = 0; i < size() - 1; i++){
	    if (superArray[i + 1].compareTo(superArray[i]) < 0){
		s = superArray[i+1];
		int a = i;
		
		for (a = i; (a >= 0) && (s.compareTo(superArray[a]) < 0); a--){
		    superArray[a + 1] = superArray[a];
		}
		
		superArray[a + 1] = s;
	    }
	}
    }

    public void selectionSort(){

	for (int i = 0; i < size(); i++){
	    String minElement = get(i);
	    int index =i;

	    for (int a = i+1; a < size(); a++){
		if (get(a).compareTo(minElement) < 0){
		    minElement = get(a);
		    index = a;
		}
	    }
	    set(index,set(i, minElement));
	}

    }

    //from Mr. K 
    public void badInsertionSort(SuperArray L){
        OrderedSuperArray c = new OrderedSuperArray();
        while( L.size() > 0){ 
            c.add(L.remove(0));
        }
        while(c.size() > 0){
            L.add(c.remove(0));
        }
    }



}
