package com.test.test.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rootPath: example - C:" + "//" + "com.myTest");
        String rootPath = sc.nextLine();
        System.out.println("Enter mask: example - RestService.class");
        String mask = sc.nextLine();
        System.out.println("Enter depth: example - example - 7");
        int depth = sc.nextInt();

        FileFilter search = new FileFilter(rootPath, mask, depth);
        Thread thread1 = new Thread(search);
        thread1.start();

        if(FilePrinter.getF()==null){
            System.out.println("no such files");
        }
    }
}
