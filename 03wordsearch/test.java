public class test{

    public static void main(String [] args){
	WordGrid  a = new WordGrid(7, 7);
	System.out.print(a.toString());
	System.out.println(a.addWordHorizontal("YUBIN", 3, 4));
	System.out.println("should be false");
	System.out.println(a.addWordHorizontal("YURA", 2, 3));
	System.out.println("should be true");

    }


}