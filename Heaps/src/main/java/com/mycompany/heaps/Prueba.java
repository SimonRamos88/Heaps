
package com.mycompany.heaps;

import java.util.Scanner;
public class Prueba {
    
    public static void main(String[] args){
    Scanner scanner;
    scanner = new Scanner(System.in);
    int i,n,num;
    Heaps pQueue = new Heaps();
    i=0;
    System.out.println();
    System.out.print("Enter a non-negative integer ");
    System.out.print(" or a -1 to stop: ");
    num = scanner.nextInt();
    while(num > -1) {
        pQueue.insert(num);
        i++;
        System.out.print("Enter a non-negative integer");
        System.out.print("or a -1 to stop: ");
        num =scanner.nextInt();
    }
    n=i;
    System.out.println();
    System.out.print("Array = ");
    pQueue.getArray().stringTo();
    System.out.print("Priority Queue = ");
    for(i=0; i<n; i++) {
        //num = pQueue.extractMax();
        //System.out.print(num + " ");
    }
    System.out.println();
    System.out.println();
    System.out.println("Change priority:");
    System.out.print("Enter an index where changing priority or -1 to exit:");
    int num1 = scanner.nextInt();
    System.out.print("Enter new priority:");
    int num2 = scanner.nextInt();
    while(num1 > -1 && num2 > -1) {
        pQueue.changePriority(num1,num2);
        i++;
        System.out.print("Enter an index where changing priority or -1 to exit:");
        num1 = scanner.nextInt();
        System.out.print("Enter new priority:");
        num2 = scanner.nextInt();
    }
    System.out.println();
    System.out.print("Priority Queue = ");
    for(i=0; i<n; i++) {
        num = pQueue.extractMax();
        System.out.print(num + " ");
    }
    
    System.out.println();
}

    
}
