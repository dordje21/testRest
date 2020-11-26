package com.test.test.task2.fileUser;

import java.io.File;
import java.util.ArrayList;

public class FilePrinter implements Runnable {
    private static File f;
    private static ArrayList<File> myArrayList = new ArrayList<>();

    public ArrayList<File> getMyArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(ArrayList<File> myArrayList) {
        FilePrinter.myArrayList = myArrayList;
    }

    public static File getF() {
        return f;
    }

    public void setF(File f) {
        FilePrinter.f = f;
    }

    @Override
    synchronized public void run() {
        myArrayList.add(f);
    }
}
