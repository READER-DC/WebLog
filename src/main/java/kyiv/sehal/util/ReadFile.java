package kyiv.sehal.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    static String fileName;

    public static String[] line;
    public static ArrayList <String[]> data = new ArrayList<>();
    public Scanner scanner;

    public ReadFile(String fileName) throws FileNotFoundException {
        ReadFile.fileName = fileName;
    }


    public Scanner createReadFile() throws FileNotFoundException {
        File in = new File(fileName);
        scanner = new Scanner(in);
        return scanner;
    }

    public void readFile( Scanner scanner) {
        scanner.nextLine();
        for (;scanner.hasNextLine();){
            line = scanner.nextLine().split(";",50);
            data.add(line);
            line = null;
        }
        System.out.println("Read file successful! " + data.size());
    }
}
