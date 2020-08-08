package com.hackerrank.github.util;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


public class TxtWriter {


    public static final String FILE_EXT = ".txt";

    public static BufferedWriter bw = null;
    public static FileWriter fw = null;
   // public static String fileName = null;
    public static String fullRequestFilePath = null;
    public static String fullArchiveRequestFilePath = null;

    public static void setUp(String fileName) throws Exception {
        fileName = fileName;
        fullRequestFilePath =  fileName + FILE_EXT;

        String folderPath= fileName.substring(0,fileName.lastIndexOf("/")+1);
        createDirectory(folderPath);
        prepareWrite();


        Path path = Paths.get(fullRequestFilePath);
      //  Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxrwxrwx"));



    }

    public static void createDirectory(String folderPath) throws Exception {
        try {
            //creating request directory
            Path path = Paths.get(folderPath);
            if(Files.notExists(path)) {
                Files.createDirectories(path);
            }

        }
        catch (Exception e)
        {

            throw new Exception("Error occurred while creating directory");
        }
    }

    public static void prepareWrite() throws Exception {
        try {
            fw = new FileWriter(fullRequestFilePath);
            bw = new BufferedWriter(fw);
        }
        catch (Exception e)
        {

            throw new Exception("Error occurred while preparing for writing");
        }
    }

    public static void writeFile(List<String> lines) throws Exception {
        try {

            for(String line : lines) {
                writeLine(line);
            }

        }
        catch (IOException e) {

            throw e;
        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            }
            catch (IOException e) {

            }
            finally {

            }

        }
    }

    public static void writeLine(String line) throws Exception {
        try {
            bw.write(line);
        }
        catch (IOException e) {

            throw new Exception("Error occurred while writing in file");
        }
    }

    public static void copyFile(String sourcePath, String destinationPath) throws Exception {
        Path sourceFile = Paths.get(sourcePath);
        Path destinationFile = Paths.get(destinationPath);

        Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);

    }

    public static void clear() {
        bw = null;
        fw = null;
        fullArchiveRequestFilePath = null;
        fullRequestFilePath = null;
       // fileName = null;
    }


    public static String readUrlFromFile(String name) throws IOException {

        StringBuffer sb= new StringBuffer();
        String fileName =  name+".txt";
        File file = new File(fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
            //process the line
          //  System.out.println(line);
        }
        System.out.println(sb);
        return sb.toString();
    }


    public static void createUrlFile(String fileName,String url) {
        try {
            //txtWriter = new TxtWriter();


            setUp(fileName);

            //prepare data as list
            List<String> stringList = prepareFileData(url);

            //write lines
            writeFile(stringList);

            //save byte array in VO
            try {
               // String filePath = TxtWriter.REQUEST_FOLDER + fileName + TxtWriter.FILE_EXT;
            }
            catch(Exception e) {

            }

            TxtWriter.clear();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<String> prepareFileData(String url) {
        List<String> stringList = new ArrayList<>(1);

        StringBuilder row = new StringBuilder();
        row.append(url);
        stringList.add(row.toString());

        return stringList;
    }


}
