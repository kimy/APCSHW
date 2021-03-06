public class SuperArray{

    private Object[] superArray;
    private int Size;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int size){
	Size = size;
	superArray = new Object[size];
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
	Object[] temporary = new Object[newSize];
	for (int i=0;i<Size;i++){
	    temporary[i] = superArray[i];
	}

	Object[]sArray = new Object[newSize];
	for (int i=0;i<Size;i++){
	    sArray[i]=temporary[i];
	}
	setArray(sArray);
	setLength(newSize);
    }


    public void setArray(Object[] a){
	superArray = a;
    }


    public void setLength(int size){
	Size = size;
    }

    public Object set(int index, Object o){
	if(outOfRange(index)){
	    throw new IndexOutOfBoundsException;
	}else{
	    Object a = superArray[index];
	    superArray[index] = o;
	    return a;
	}
    }

    public Object get(int index){
	if(outOfRange(index)){
	    throw new IndexOutOfBoundsException();
	}else{
	    return superArray[index];
	}
    }

    public void add(Object e){
	setLength(Size + 1);
	resize(Size);
	superArray[Size - 1] = e;
    }


    public void add(int index, Object e){
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

    public Object remove(int index){
	if(!( index < 0  || index >= size()) ){
	    Object a = superArray[index];
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

}
