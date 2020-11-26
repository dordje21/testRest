package com.test.test.task1;

import java.io.File;
import java.util.ArrayDeque;

public class FileFilter implements Runnable {
    private FilePrinter filePrinter = new FilePrinter();
    private String rootPath;
    private String mask;
    private int depth;

    public FileFilter(String rootPath, String mask, int depth) {
        this.rootPath = rootPath;
        this.mask = mask;
        this.depth = depth;
    }

    public FilePrinter getFilePrinter() {
        return filePrinter;
    }

    public void setFilePrinter(FilePrinter filePrinter) {
        this.filePrinter = filePrinter;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public void run() {
        ArrayDeque<File> stack = new ArrayDeque<File>();
        stack.push(new File(rootPath));


        for (int i = 0; i <= depth; i++) {
            File file = stack.pop();
            File[] files = file.listFiles();

            try {
                for (File f : files) {
                    if (f.isHidden()) {
                        continue;
                    }
                    if (f.isFile() && f.getName().equals(mask)) {
                        filePrinter.setF(f);
                        Thread thread = new Thread(filePrinter);
                        thread.start();
                        System.out.println("Searching files - " + Thread.currentThread().getName());
                    }
                    stack.push(f);
                    continue;
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
    }
}