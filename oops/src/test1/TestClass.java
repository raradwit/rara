package test1;

import test2.ModifierExample;

/**
 * Created by BiplavShrestha on 8/27/2015.
 */
public class TestClass {

    public static void main(String args[]){
        ModifierExample me = new ModifierExample();
        ModifierExample.SubClass sb = me.subClassObject();
        sb.num1 = 10;
        sb.num2= 22;
    }
}
