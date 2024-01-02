package pt;

import java.util.Scanner;

public class Q25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = N / 4;
        String resultStr = "long ".repeat(result) + "int";
        System.out.println(resultStr);
    }
}
