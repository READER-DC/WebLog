package kyiv.sehal.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountRow {
    String file;
    String [] titleLine;
    public static ArrayList<String> title = new ArrayList<>();
    public CountRow(String file){
        this.file = file;
    }
    public int countRow() throws FileNotFoundException {
        File in = new File(file);
        Scanner sc = new Scanner(in);
        if(sc.hasNextLine()) {
            String line = sc.nextLine();
            titleLine = line.split(";");
        } else {
            System.out.println("can't read line");
            return 1;
        }
        sc.close();
        Collections.addAll(title, titleLine);

        return titleLine.length;
    }

}
