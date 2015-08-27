class TestClass{

	class SubClass{
		public void subText(){
			System.out.println("example of subclass");
		}
	}

	String name;
	String rollNo;

	public TestClass(){
		this.name="abc";
		this.rollNo="132";

	}

	public TestClass(String name, String rollNo){
		this.name=name;
		this.rollNo = rollNo;
	}
	

	public void test(){
		SubClass subClass = new SubClass();
		subClass.subText();	
		System.out.println("Refrenced from TestClass");
	}

}