package org.example;

//Overloading
class Operation{
    public int add(int a, int b){
        return a+b;
    }

    //Overloading: ubah int menjadi double
    public double add(double a, double b){
        return a+b;
    }

    //Overloading: parameter menjadi 3 int
    public int add(int a, int b, int c){
        return a+b+c;
    }
}

//Overriding
class MultiplyOverride extends Operation{
    @Override
    public int add(int a, int b){
        return a*b; //Melakukan override operasi diganti menjadi perkalian
    }
}

public class PolyMorphism {
    public static void main(String[] args) {
        Operation op = new Operation();
        Operation MulOv = new MultiplyOverride();
        int result1 = op.add(5,10);
        double result2 = op.add(2.5, 3.5);
        int result3 = op.add(5, 10, 15);
        int result4 = MulOv.add(2,3);

        System.out.println("Operation (5,10): " + result1);
        System.out.println("Operation (2.5,3.5): " + result2);
        System.out.println("Operation (5,10,15): " + result3);
        System.out.println("Operation (2,3): " + result4);

        try{
            int a = 10;
            int b = 0;
            int result = a/b;
        }catch(ArithmeticException e){
            System.out.println("Caught ArithmethicException " + e.getMessage());
        }

        try{
            int[] arr = new int[5];
            int index = arr[10];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Caught ArrayIndexOutOfBoundsException " + e.getMessage());
        }

        try{
            String str = null;
            str.length();
        }catch(NullPointerException e){
            System.out.println("Caught NullPointerException " + e.getMessage());
        }

        try{
            String str = "Hello";
            char ch = str.charAt(10);
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Caught StringIndexOutOfBoundsException " + e.getMessage());
        }

        try{
            Thread t = new Thread();
            t.start();
            t.start(); //Mencoba memanggil thread saat yang pertama belum selesai
        }catch(IllegalThreadStateException e){
            System.out.println("Caught IllegalThreadStateException " + e.getMessage());
        }
    }
}
