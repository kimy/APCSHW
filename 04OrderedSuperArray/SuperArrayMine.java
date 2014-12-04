public class SuperArrayMine{
    
    private String[] superArray;
    private int Size;
    
    public SuperArray(){
        this(10);
    }
    
    public SuperArray(int size){
        Size = size;
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
    
    
    public void resize(int newSize){
        String[] temporary = new String[newSize];
        for (int i=0;i<Size;i++){
            temporary[i] = superArray[i];
        }
        
        String[]sArray =new String[newSize];
        for (int i=0;i<Size;i++){
            sArray[i]=temporary[i];
        }
        setArray(sArray);
        setLength(newSize);
    }
    
    
    public void setArray(String[] a){
        superArray = a;
    }
    
    
    public void setLength(int size){
        Size = size;
    }
    
    public String set(int index, String o){
        if(outOfRange(index)){
            throw new IndexOutOfBoundsException;
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
    
    public void add(String e){
        setLength(Size + 1);
        resize(Size);
        superArray[Size - 1] = e;
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
    public void insertionSort(){
	String s;
	s = "";

	for (int i = 0; i < size() - 1; i++){
	    if (superArray[i+1].compareTo(superArray[i])<0){
		s = superArray[i+1];
		int a = i;
		
		for (int a = i; (a >= 0) && (s.compareTo(superArray[a]) < 0); a--){
		    superArray[a +1 ] = superArray[a];
		}
		
		superArray[a + 1] = s;
	    }
	}
    }
    
}