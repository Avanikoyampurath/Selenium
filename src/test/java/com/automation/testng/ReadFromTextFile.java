package com.automation.testng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFromTextFile {
    public static void main(String[] args) throws Exception {

        /*
        FileReader fr=new FileReader("src/test/resources/data/data.txt");
        BufferedReader br=new BufferedReader(fr);
        String line;

        while ((line= br.readLine())!=null){
            System.out.println(line);
        }

         */


        //Using Scanner
        Scanner scanner=new Scanner(new FileInputStream("src/test/resources/data/data.txt"));
        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }
    }
}
