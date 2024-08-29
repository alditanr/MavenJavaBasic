package org.example;
import java.util.Scanner;

public class ShapeDrawer {

    Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("Selamat datang di ASCII drawing");
        System.out.println("Pilih bentuk yang mau digambar:");
        System.out.println("1. Segitiga Siku-Siku");
        System.out.println("2. Segitiga Sama Kaki");
        System.out.println("3. Persegi");
        System.out.println("4. Persegi Panjang");
        System.out.println("5. Keluar");
    }

    public void drawShape(int choice){
        switch (choice){
            case 1:
                System.out.println("Masukkan panjang segitiga siku-siku: ");
                int height = scanner.nextInt();
                drawTriangleSS(height);
                break;
            case 2:
                System.out.println("Masukkan panjang segitiga sama kaki: ");
                int height2 = scanner.nextInt();
                drawTriangleSK(height2);
                break;
            case 3:
                System.out.println("Masukkan sisi persegi: ");
                int height3 = scanner.nextInt();
                drawPersegi(height3);
                break;
            case 4:
                System.out.println("Masukkan lebar persegi panjang: ");
                int height4 = scanner.nextInt();
                System.out.println("Masukkan panjang persegi panjang: ");
                int height5 = scanner.nextInt();
                drawPersegiPanjang(height4, height5);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public void drawTriangleSS(int height){
        //nested loop
        //outer loop
        for (int i=1; i<=height; i++){ // row atau baris
            //inner loop
            for (int j=1; j<=i; j++){ // column atau kolom
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public void drawTriangleSK(int height){
        //print whitespace agar segitiga berada di tengah
        for (int i=1; i<=height; i++){
            //inner loop
            for (int j=height-i; j>0; j--){
                System.out.print(" ");
            }
            for (int k=1; k<=(2*i-1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawPersegi(int height){
        for (int i=1; i<=height; i++){
            for (int j=1; j<=height-1; j++){
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }

    public void drawPersegiPanjang(int height1, int height2){
        for (int i=1; i<=height1; i++){
            for (int j=1; j<=height2-1; j++){
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }

    public void run(){
        //Loop untuk terus menampilkan menu
        while(true){
            displayMenu();
            System.out.println("Masukkan pilihan anda: ");
            int choice = scanner.nextInt();
            drawShape(choice);
            System.out.println();
        }
    }
    public static void main(String[] args){
        //Runner
        ShapeDrawer drawer = new ShapeDrawer();
        drawer.run();
    }
}
