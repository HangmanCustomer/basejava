package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args){
        String filePath = "C:\\JavaDev\\basejava\\.gitignore";
        File file = new File(filePath);

        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new  RuntimeException("Err", e);
        }

        File dir = new File("C:\\JavaDev\\basejava\\src\\ru\\javawebinar\\basejava");
       // System.out.println(dir.isDirectory());
//        List<String> dirList = Arrays.asList(dir.list());
//        dirList.forEach(System.out::println);
      //  Arrays.asList(dir.list()).forEach(System.out::println);
        try(FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException("Err", e);
        }
    }
}
