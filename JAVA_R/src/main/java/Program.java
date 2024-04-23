class Calculator{

    public int add(int num1,int num2){
        return num1+num2;
    }
    public void someBehaviour()
    {
        System.out.println("This just prints out a string");
    }

    //Method-Overloading
    public void someBehaviour(String input){
        System.out.println("This is the input from user : "+input);
    }
}

public class Program {

//    int nantar = 3;
    public static void main(String a[]){
//        System.out.println(nantar);
        int someNumber = 45;
        long longNumber = 234l;
        double doubleNumber = 44.234;
        float floatNumber = 44.234f;
        boolean booleanValue = true;
        char character = 35;

        int b = 4;
        byte c = (byte)b;

        String s = b==4?"True":"False";

        System.out.println("Value of Byte C :: "+c);
        System.out.println("Character is "+character);

        int[] array = {1,2,3,4};

        Calculator calc = new Calculator();
        Calculator calc2 = new Calculator();

        System.out.println("Calculator "+calc.hashCode());

        calc2.toString();

        int result = calc.add(3,4);
        int r2 = calc.add(4,6);


        calc2.add(6,7);
        calc.add(9,1);

        System.out.println("Result after addition is "+result);
        calc.someBehaviour();
        calc.someBehaviour("IT IS WHAT IT IS");


        int arr[] = {1,2,3,4};

        for(int i : arr){
            System.out.println("Integer value "+i);
        }

//        int k=3,j=3;
//        System.out.println("K : "+k+" J "+ j);

    }

    public void ternaryOperation(){

        int a = 34;
        int b = a>30?15:a;
        System.out.println("Number is "+b);
    }
}
