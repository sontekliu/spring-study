package com.javaliu.modules.shortlink;

public class Base62 {
    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    /**
     * 将数值转换为字符串
     * @param num
     * @return
     */
    public static String toBase62(long num){
        StringBuilder str = new StringBuilder();
        int baseLength = BASE.length();
        do {
           int i = (int)(num % baseLength);
           str.append(BASE.charAt(i));
           num /= baseLength;
        }while (num > 0);
        return str.reverse().toString();
    }

    /**
     * 将字符串转换为ID
     * @param input
     * @return
     */
    public static long toBase10(String input){
        int baseLength = BASE.length();
        long result = 0;
        String temp = new StringBuilder(input).reverse().toString();
        for (int i = 0; i < temp.length(); i++){
            int charIndex = BASE.indexOf(temp.charAt(i));
            result += charIndex * Math.pow(baseLength, i);
        }
        return result;
    }

    public static void main(String[] args) {
        // long number = System.currentTimeMillis();
        long number = 9999998;
        String shortKey = toBase62(number);// 6laZD
        System.out.println(shortKey);
        long result = toBase10(shortKey);
        System.out.println(result);

        System.out.println(Math.pow(62,1));
    }
}
