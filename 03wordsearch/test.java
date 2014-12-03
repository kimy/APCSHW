public class test{

    publc static void main (String[]args){
    WordGrid w = WordGrid(100, 100, 2);
    w.loadWordstoFile("word.txt", false);
    System.out.prinln(w.wordsInPuzzle);
    w.toString();

    }
}