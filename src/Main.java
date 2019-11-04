import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        try {
            File data = new File("/Users/wooycik/Documents/Projects/DaftCode2019/src/dane.csv");
            FileReader fileReader= new FileReader(data);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList <Ship> list = new ArrayList<>();
            String firstLine = bufferedReader.readLine();
            String[] array = firstLine.split(";");
            String nextLine;

            for (String s : array) {
                Pattern pattern = Pattern.compile("(\\d+): (.*) \\((.*)\\)");
                Matcher matcher = pattern.matcher(s);
                if(matcher.matches()) {
                    list.add(
                            new Ship(
                                    Integer.parseInt(matcher.group(1)),
                                    matcher.group(2),
                                    matcher.group(3)
                            )
                    );
                }
            }

            while((nextLine = bufferedReader.readLine()) != null){
                String[] tmp = nextLine.split(";");
                for(int i=0; i<tmp.length; i++) {
                    Pattern pattern = Pattern.compile("(\\w{2})-(\\w{2})-(.+)\\/(\\d{4})\\/(\\w\\d)@(.*)\\.(\\w{2})\\/(\\d*)");
                    Matcher matcher = pattern.matcher(tmp[i]);
                    if (matcher.matches()) {
                        list.get(i).containers.add(
                                new ShipContainter(
                                        matcher.group(1),
                                        matcher.group(2),
                                        matcher.group(3),
                                        Integer.parseInt(matcher.group(4)),
                                        matcher.group(5),
                                        matcher.group(6),
                                        matcher.group(7),
                                        Integer.parseInt(matcher.group(8))/100
                                )
                        );
                    }
                }
            }

            System.out.println("There will be " + containersToJapan(list) + " containers transported to Japan");
            averageAmountPerShipType(list);
            System.out.println("Average weight of X1 containers is " + averageWeightOfX1(list));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static int containersToJapan(ArrayList<Ship> list){
        int i = 0;
        for(Ship s : list){
            for(ShipContainter sc : s.containers){
                if(sc.destinationCountry.equals("JP"))
                    i++;
            }
        }
        return i;
    }

    public static void averageAmountPerShipType(ArrayList<Ship> list){
        ArrayList<String> listOfTypes = new ArrayList<>();
        int maxAverage = 0;
        String maxType = "";
        for(int i=0; i<list.size(); i++){
            if(!listOfTypes.contains(list.get(i).type)){
                listOfTypes.add(list.get(i).type);
                int sum = 0;
                int amount = 0;
                for(int j=i; j<list.size(); j++){
                    if(list.get(j).type.equals(list.get(i).type)){
                        sum += list.get(j).containers.size();
                        amount++;
                    }
                }
                int average = sum/amount;
                if(average >= maxAverage){
                    maxAverage = average;
                    maxType = list.get(i).type;
                }
            }
        }
        System.out.println("The biggest average amount of containers is transported by class " + maxType + " (" + maxAverage + ").");
    }

    public static long averageWeightOfX1(ArrayList<Ship> list){
        int sum = 0;
        int amount = 0;
        for(Ship s : list){
            for(ShipContainter sc : s.containers){
                if(sc.contentType.equals("X1")){
                    sum += sc.weight;
                    amount++;
                }
            }
        }
        double average = sum/amount;
        return Math.round(average);
    }
}

