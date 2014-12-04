public class SuperArray{

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
	String[] a = new String[newSize];
	for (int i=0;i<Size;i++){
	    a[i] = Objects[i];
	}

	String[]sArray =new String[newSize];
	for (int i=0;i<Size;i++){
	    sArray[i]=a[i];
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

    public String set(int index, Object o){
	if(index < this.size()){
	    String a = superArray[index];
	    superArray[index] = o;
	    return a;
	}else{
	    throw new IndexOutOfBoundsException();
	}

    }

    public String get(int index){
	if (index < Size && index >= 0){
	    return superArray[index];
	}else{
	    throw new IndexOutOfBoundsException();
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

}
