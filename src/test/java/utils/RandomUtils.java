package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomGender());
    }


    public static String getRandomString(int len){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(characters.charAt(secureRandom.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public static String getRandomEmail(){

        return getRandomString(6) + "@mail.com";
    }

    public static int getRandomInt(int min, long max){
        return ThreadLocalRandom.current().nextInt(min, (int) (max + 1));
    }

    public static String getRandomPhoneNumber(){
        return String.format("%s%s%s%s%s",
                getRandomInt(1, 9),
                getRandomInt(111, 999),
                getRandomInt(111, 999),
                getRandomInt(11, 99),
                getRandomInt(11, 99));
    }

    public static String getRandomGender(){
        String[] gender = {"Male", "Female", "Other"};
        return getRandomItemFromStringArray(gender);
    }

    private static String getRandomItemFromStringArray(String[] values){
        int i = getRandomInt(0, values.length - 1);
        return values[i];
    }
}
