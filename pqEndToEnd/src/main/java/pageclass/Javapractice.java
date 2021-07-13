package pageclass;

public class Javapractice {
	
	
	
	public static void main(String[] args) {
		
		
		String str="aditya";
		char[] arr=str.toCharArray();
		for ( int i= arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	
		for ( int i= str.length()-1; i >= 0; i--) {
			System.out.println(i);
		}
		
		
	}

}
