package Utilities;
import java.util.ArrayList;
public class DataProvider {


            public static ArrayList<String> getOptionsMandatories(){
            ArrayList<String> options = new ArrayList<String>();
            options.add("Price (Lowest)");
            options.add("Price (Highest)");
            options.add("Duration (Shortest)");
            options.add("Duration (Longest)");
            options.add("Departure (Earliest)");
            options.add("Departure (Latest)");
            options.add("Arrival (Earliest)");
            options.add("Arrival (Latest)");
            return options;

        }


    }

