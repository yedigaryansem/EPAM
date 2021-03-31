package HelperMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperMethods {
    public static float reformatStringToFloat(String price){

        // convert String to char[] array
        char[] chars = price.toCharArray();

        // iterate over char[] array using enhanced for loop
        int i;
        for (i = 0; i < price.length(); i++) {
            if (chars[i] == ','){
                chars[i] = '.';
            }
        }

        String reformattedPrice = new String(chars);

        return Float.parseFloat(reformattedPrice);
    }

    public static String takeFromStringOnlyFloat(String totalPriceText){

        String regex="([0-9]+[,.][0-9]+)";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(totalPriceText);

        while(matcher.find()){

            return matcher.group();
        }

        return "";
    }
}