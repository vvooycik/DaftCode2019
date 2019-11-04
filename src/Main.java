import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        try {
            File data = new File("dane.csv");
            FileReader fileReader= new FileReader(data);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList list = new ArrayList<Ship>();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
