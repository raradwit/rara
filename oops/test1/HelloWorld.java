package test1;

class HelloWorld
{  

	int a;

	int b;

	public static void test(){
		System.out.println("This is just a test");
	}

	public int add(int a, int b){
		return a+b;

	}

	public void multiply(){
		System.out.println(a*b);

	}


	public static void main(String args[])
	{
		System.out.println("HelloWorld");

		HelloWorld hw = new HelloWorld();

		test();
		TestClass tc = new TestClass();
		tc.test();
		TestClass tc1 = new TestClass("bbc","223");
		System.out.printf("tc object name = %s, tc object rollNo=%s, tc1 object name = %s, tc1 object rollNo = %s",tc.name,tc.rollNo, tc1.name,tc1.rollNo);
		int a = hw.add(4,5);

		System.out.println(a);

		HelloWorld hw1 = new HelloWorld();
		int b = hw1.add(6,7);

		System.out.println(b);

		hw.a = 5;
		hw.b = 10;

		hw1.a= 6;
		hw1.b = 6;
		hw.multiply();
		hw1.multiply();

		test();

		ModifierExample mod = new ModifierExample(3,4);

		mod.num4 = 8;

		System.out.println(mod.num4);
	}


}