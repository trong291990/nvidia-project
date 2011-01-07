package men.org;

public class DoBlah {
	public static void main(String[] args) {
		Blah b1=new Blah();
		Blah b2=new Blah();
		
		b1.setFoo(200);
		System.out.println(b1.getFoo());
		
		b2.setFoo(500);
		System.out.println(b1.getFoo());
	}
}
