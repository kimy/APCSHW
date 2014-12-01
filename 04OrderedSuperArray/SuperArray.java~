public class SuperArray{

    private Object[] Objects;
    private int Size;

    public SuperArray(){
	this(10);

    }

    public SuperArray(int size){
	Size = size;
	Objects = new Object[size];
    }

    public String toString() {
	String s = "[ ";
	for (int i = 0; i < Objects.length; ++i) {
	    s += this.Objects[i] + ", ";
	}
	s += "]";
	return s;
    }


    public int size(){
	return Size;
    }


    public void resize(int newSize){
	Object[] a = new Object[newSize];
	for (int i=0;i<Size;i++){
	    a[i] = Objects[i];
	}

	Object[]sArray =new Object[newSize];
	for (int i=0;i<Size;i++){
	    sArray[i]=a[i];
	}
	setArray(sArray);
	setLength(newSize);
    }


    public void setArray(Object[] a){
	this.Objects = a;
    }


    public void setLength(int size){
	this.Size = size;
    }

    public Object set(int index, Object o){
	if(index < this.size()){
	    Object a = Objects[index];
	    Objects[index] = o;
	    return a;
	}else{
	    throw new IndexOutOfBoundsException();
	}

    }

    public Object get(int index){
	if (index < Size && index >= 0){
	    return Objects[index];
	}else{
	    throw new IndexOutOfBoundsException();
	}

    }

    public void add(Object e){
	setLength(Size + 1);
	resize(Size);
	Objects[Size - 1] = e;
    }


    public void add(int index, Object e){
	if (index>=size()){
	    add(e);
	    resize(Size*2);
	}else{
	    resize(Size*2);    
	    for (int i=index;i<=Size-index;i++){
		Objects[i+1]=Objects[i];
	    }
	    Objects[index] = e;
	}
    }

    public Object remove(int index){
	if( index < 0  || index >= size() ){
	    throw new IndexOutofBoundsExcpetion();
	}else{
	    Object a = Objects[index];
	    for(int i = 0; i < Size  - 1; i ++){
		Objects[i] = Objects[i + 1];
	    }
	    Objects[Size - 1] = null;
	    Size = this.Size - 1;
	    resize(Size);
	    return a;
	}

    }


   

}