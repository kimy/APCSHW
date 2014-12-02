public class Driver{
    public static void main(String[]args){
	SuperArray a=new SuperArray();
	a.resize(11);
	a.add("hi");
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(10,8008);
     
	System.out.println(a.remove(5));
	System.out.println(a.get(2));

	System.out.println(a.size());
	System.out.println(a.toString());
    }
}
