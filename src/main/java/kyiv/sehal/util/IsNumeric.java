package kyiv.sehal.util;

public class IsNumeric {
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str.replace(',','.'));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
