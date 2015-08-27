package test2;

public class ModifierExample{

    public class SubClass{
        public int num1;
        public int num2;

        public void operate(){
            System.out.println(this.num1 + this.num2);
        }

    }

    public SubClass subClassObject(){
        return new SubClass();
    }

    public static void main(String args[]){
    System.out.println("Hello World");

    }
}