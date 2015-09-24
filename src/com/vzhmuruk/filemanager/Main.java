package com.vzhmuruk.filemanager;

import java.io.*;

public class Main {

    public static final String CREATE_FILE = "create file";
    public static final String CREATE_DIR = "create dir";
    public static final String RENAME_FILE = "rename file";
    public static final String DELETE_FILE = "delete file";
    public static final String FILL_DIR = "fill dir";
    public static final String DONE = "done";


    public static void main(String[] args) throws IOException {

        String dirName;
        String path;
        String fileName;
        String fileNameDest;
        String numFiles;

        BufferedReader bufferedReader;
        do {
            start:


            System.out.println("Enter command. For show all commands enter \'help\'");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            start:
            switch (bufferedReader.readLine()) {
                case CREATE_FILE:
                    FileManager fileManager = new FileManager();
                    System.out.println("Enter path:");
                    path = bufferedReader.readLine();
                    System.out.println("Enter File name:");
                    fileName = bufferedReader.readLine();
                    fileManager.creatFile(path, fileName);
                    break start;
                case CREATE_DIR:
                    FileManager fileManager1 = new FileManager();
                    System.out.println("Enter path:");
                    path = bufferedReader.readLine();
                    System.out.println("Enter Directory name:");
                    dirName = bufferedReader.readLine();
                    fileManager1.createDirectory(path, dirName);
                    break start;
                case RENAME_FILE:
                    FileManager fileManager2 = new FileManager();
                    System.out.println("Enter path:");
                    path = bufferedReader.readLine();
                    System.out.println("Enter File name:");
                    fileName = bufferedReader.readLine();
                    System.out.println("Enter rename File name:");
                    fileNameDest = bufferedReader.readLine();
                    fileManager2.remaneFile(path, fileName, fileNameDest);
                    break start;
                case DELETE_FILE:
                    FileManager fileManager3 = new FileManager();
                    System.out.println("Enter path:");
                    path = bufferedReader.readLine();
                    System.out.println("Enter File name:");
                    fileName = bufferedReader.readLine();
                    fileManager3.deleteFile(path, fileName);
                    break start;
                case FILL_DIR:
                    FileManager fileManager4 = new FileManager();
                    System.out.println("Enter path:");
                    path = bufferedReader.readLine();
                    System.out.println("Enter File name:");
                    fileName = bufferedReader.readLine();
                    System.out.println("Enter num of Files for creating:");
                    numFiles = bufferedReader.readLine();
                    System.currentTimeMillis();
                    fileManager4.fillDir(path, fileName, numFiles);

            }
        }while(!bufferedReader.readLine().equalsIgnoreCase("done"));

int a = 010;




    }
}
