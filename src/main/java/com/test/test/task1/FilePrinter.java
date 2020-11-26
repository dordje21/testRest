package com.test.test.task1;

import java.io.File;

public class FilePrinter implements Runnable {

    private static File f;

    public static File getF() {
        return f;
    }

    public void setF(File f) {
        FilePrinter.f = f;
    }

    @Override
    public void run() {
        System.out.println("File <" + f.getName() + "> is on path: " + f.getPath() + " " + Thread.currentThread().getName());
    }

}
