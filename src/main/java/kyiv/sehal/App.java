package kyiv.sehal;

import kyiv.sehal.util.DBConnection;
import kyiv.sehal.util.IsNumeric;
import kyiv.sehal.util.ReadFile;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException{
        System.out.println( "Hello World!" );
        Long t0 = new Date().getTime();
        DBConnection DBconn = new DBConnection();

        String file = "/home/sehal/myDocument/Отчет_Система_управления_полкой_T22_Детали.csv";
//        CountRow countRow = new CountRow(file);


        try {
            ReadFile readFile = new ReadFile(file);
//            countRow.countRow();
            Scanner sc = readFile.createReadFile();
            readFile.readFile(sc);

        }
        catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        Connection connection =  DBconn.connection();
        connection.setAutoCommit(false);
        String sql = "insert into test (Группа, Подгруппа,Подкатегория,Категория,SKU,Код_товара,Код_Магазина,Магазин,Схема_сотрудничества,Формат,В_пути_шт,Текущий_остаток,Min_q,Max_q,Адреска,BZ,Актуальность,Дата_ввода,Дата_вывода,Продано_за_14_дн,Акция,Ост_на_маг_прот,В_пути_прот,BZH) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement smtp = connection.prepareStatement(sql);


        for (String[] i : ReadFile.data) {
            int k = 0;
            for (String j : i){
                k++;
                if ( j.isEmpty()) { j = "0";}
                if ( IsNumeric.isInteger(j) ){
                    smtp.setInt( k, Integer.parseInt(j) );
                } else if ( IsNumeric.isDouble(j) ) {

                    smtp.setDouble( k,Double.parseDouble(j.replace(",",".")) );
                } else {
                    smtp.setString(k,j);
                }
            }
            smtp.executeUpdate();
        }
        connection.commit();
        connection.close();
        Long t1 = new Date().getTime();
        System.out.println(t1-t0);
    }
}
