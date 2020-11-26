package com.test.test.task2.controller;

import com.test.test.task2.fileUser.FileFilter;
import com.test.test.task2.fileUser.FilePrinter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Component
@RestController
public class ClientController {
    //example http://localhost:8080/search/com.myTest?mask=RestService.class&depth=5
    //RestService.class, path = C:\com.myTest\target\classes\task2\RestService.class

    @GetMapping(value = "/search/{rootPath}")
    public String fileFilter(@PathVariable String rootPath,
                             @RequestParam(value = "mask", required = false) String mask,
                             @RequestParam(value = "depth", required = false) int depth) throws InterruptedException {
        String rootPathS = "/" + rootPath;
        StringBuilder sb = new StringBuilder();


        FileFilter search = new FileFilter(rootPathS, mask, depth);
        Thread thread1 = new Thread(search);
        thread1.start();
        thread1.join();

        if (FilePrinter.getF() != null) {
            for (File f : search.getFilePrinter().getMyArrayList()) {
                sb.append(f.getName() + ", path = " + f.getAbsolutePath());
                sb.append("\n");
            } if(search.getFilePrinter().getMyArrayList().size() == 1){
                sb.append("we found " + search.getFilePrinter().getMyArrayList().size() + " file");
            } else if (search.getFilePrinter().getMyArrayList().size() > 1){
                sb.append("we found " + search.getFilePrinter().getMyArrayList().size() + " files");
            }

        } else if (FilePrinter.getF() == null || FilePrinter.getF().getName() != mask) {
            sb.append("there is no such file or folder");
        }
        search.getFilePrinter().getMyArrayList().clear();
        search.getFilePrinter().setF(null);
        return sb.toString();
    }
}