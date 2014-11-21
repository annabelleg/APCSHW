public class WordSearch{
    public static void main(String[]args){
	WordGrid a = new WordGrid(8,8);
	System.out.println(a);
	System.out.println(a.addWordHorizontal("mello", 5,2));
	System.out.println(a);
	System.out.println(a.addWordVertical("jello", 1,6));
	System.out.println(a);
	System.out.println(a.addWordDiagonalDown("hello", 0,0));
	System.out.println(a);
	System.out.println(a.addWordDiagonalUp("yellow", 6,0));
	System.out.println(a);
	/*	a.clear();
		System.out.println(a);*/

	//	System.out.println(a.getCols());
	//	System.out.println(a.getRows());
    }
}
