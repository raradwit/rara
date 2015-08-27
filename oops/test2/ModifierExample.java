package test2;

public class ModifierExample{
	
	private int num1;
	private int num2;
	public int num3;
	protected int num4;

	public ModifierExample(){

	}

	public ModifierExample(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}

	public void operate(){
		System.out.println(add());
	}

	private int add(){
		return num1 + num2;
	}

	public static void main(String args[]){
		ModifierExample mod = new ModifierExample(3,4);

		mod.num1 = 8;

		System.out.println(mod.num1);

	}
}