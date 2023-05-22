package Part1;

import java.util.Scanner;

/*
 문제: 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 */
// 입력1: Mississipi / ?
// 입력2: zZa / Z
// 입력3: z / Z
// 입력4: baaa / A
public class Q1157 {
    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z')
                count[ch - 'A']++;
            else count[ch - 'a']++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] count  = getAlphabetCount(str);

        int maxCount = -1;
        int maxAlphabetIndex = -1;
        for (int i = 0; i < 26; i++){
            if (count[i] > maxCount){
                maxCount = count[i];
                maxAlphabetIndex = i;
            }
        }
        for (int i = 0; i < 26; i++){
            if (count[i] )
        }
        System.out.println((char)('A' + maxAlphabetIndex));

    }
}
