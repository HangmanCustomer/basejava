package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
//        String filePath = "C:\\JavaDev\\basejava\\.gitignore";
//        File file = new File(filePath);
//
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Err", e);
//        }
//        try(FileInputStream fis = new FileInputStream(filePath)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException("Err", e);
//        }
        String dirPath = "C:\\JavaDev\\basejava\\src\\ru\\javawebinar\\basejava";
//        File dir = new File(dirPath);
//        List<String> dirList = Arrays.asList(Objects.requireNonNull(dir.list()));
//        dirList.forEach(System.out::println);
        listDirectory(dirPath);
    }
    private static void listDirectory(String dirPath) {
        File file = new File(dirPath);
        String[] dirList = file.list();
        if (dirList != null) {
            System.out.println(file.getName());
            for (String fileName : dirList) {
                File innerFile = new File(dirPath + File.separator + fileName);
                if (innerFile.isFile()) {
                    System.out.println(fileName);
                } else {
                    listDirectory(dirPath + File.separator + fileName);
                }
            }
        }
    }
}
