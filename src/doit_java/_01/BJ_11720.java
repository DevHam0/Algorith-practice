package doit_java._01;

// 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.

import java.util.Scanner;

public class BJ_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }
        System.out.println("sum = " + sum);
    }
}
