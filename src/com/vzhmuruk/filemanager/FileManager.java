package com.vzhmuruk.filemanager;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    public void creatFile(String path, String name){

        File file = new File(path, name);
        if(file.exists()){
            System.out.println("~~~ File \"" + file.getName() + "\" is already exists! ~~~");
        }else if(file.exists()==false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("~~~ File \"" + file.getName() + "\" has been created successfully! ~~~");
        }
    }

    public void remaneFile(String path, String nameFrom, String nameTo){
        File sourceFile = new File(path, nameFrom);
        File destinationFile = new File(path, nameTo);
        if(sourceFile.isFile()) {
            if (!sourceFile.exists()) {
                sourceFile.renameTo(destinationFile);
                System.out.println("~~~ File \"" + sourceFile.getName() + "\" renamed to\" " + destinationFile.getName() +  "\" ~~~");
            } else {
                System.out.println("~~~ File \"" + destinationFile.getName() + "\" is already exists! ~~~");
            }
        }
    }

    public void deleteFile(String path, String name){
        File f = new File(path, name);
        f.delete();
        System.out.println("~~~ File \"" + f.getName() + "\" deleted successful! ~~~");
    }

    public void fillDir(String path, String fileName, String numFiles){
        Integer num = Integer.parseInt(numFiles);
        for(int i = 0; i <= num; i++){
            File f = new File(path, "[" + i + "]" + fileName);
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createDirectory(String path, String name){
        File directory = new File(path, name);
        if(directory.exists()){
            System.out.println("~~~ Directory \"" + directory.getName() + "\" is already exists! ~~~");
        }else if(!directory.exists()) {
            directory.mkdir();
            System.out.println("~~~ Directory " + directory.getName() + " has been created successfully! \nPath: " + directory.getAbsolutePath() + " ~~~");
        }
    }

    public void copyFile(String path1, String path2, String name) throws IOException{
        File source = new File(path1, name);
        File dest = new File(path2, name);
        FileInputStream is = new FileInputStream(source);
        try {
            FileOutputStream os = new FileOutputStream(dest);
            try {
                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                os.close();
            }
        } finally {
            is.close();
        }

    }
}
