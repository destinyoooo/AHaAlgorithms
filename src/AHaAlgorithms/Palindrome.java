package AHaAlgorithms;

import java.util.Scanner;

public class Palindrome {
    /**
     * 判断回文
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("###")) {
            String data = sc.next();
            if (isPalin(data)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        sc.close();
    }

    public static boolean isPalin(String data) {
        int len = data.length();
        for (int i = 0; i < len / 2; i++) {
            if (data.charAt(i) != data.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
