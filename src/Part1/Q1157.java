package Part1;

import java.util.Scanner;

/**
 * 문자열에서 가장 많이 등장한 알파벳 (대소문자 구분하지 않음)
 *
 * 1. 각 알파벳의 개수를 구한다.
 * 2. 그 중 최댓값을 구한다.
 */
public class Q1157 {

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        String str = sc.next();
        int[] count = getAlphabetCount(str);
        char[] arr = str.toCharArray();
        for (char ar : arr) {

        }
    }
}
