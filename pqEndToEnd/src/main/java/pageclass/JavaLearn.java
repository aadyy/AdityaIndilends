package pageclass;

public class JavaLearn {
	
	public static void main(String[] args) {
		Aditya a1=new Aditya();
		a1.age=28;
		System.out.println(a1.age);
		Aditya a2=new Aditya();
		a2.age=29;
		System.out.println(a2.age);
		Aditya a3=new Aditya(30);
		System.out.println(a3.age);
		
		int[] sam= {1,2,3};
		System.out.println(sam[2]);
		String str="strawberries";
		System.out.println(str.toString());
		}
	
}

	class Aditya{
	int age;
	String name;
	public Aditya() {
		System.out.println("Insided default constructor");
	}
	public Aditya(int age){
		this();
		this.age=age;
	}
	public void walk() {
	System.out.println("I am walking");
	}
}


