package fast.Part1;

import java.util.Scanner;

    // 문제: 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로,
    // 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
    // 입력: WrongAnswer
    // 출력: wRONGaNSWER
public class Q2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ASCII CODE
//        char x = 65;
//        System.out.println('Z' - 'A');      // 25
//        System.out.println(x);              // A
//        System.out.println((int)x);         // 65
//        System.out.println((char)65);       // A
//        System.out.println(x + 25);         // 90
//        System.out.println((char)(x + 25)); // Z
//        String str = sc.nextLine();
//        ASCII Code를 이용한 대소문자 변환
//        for (int i = 0; i < str.length(); i++) {
//            // 대문자니?
//            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
//                // int dist = str.charAt(i) - 'A';
//                // int lower_ascii = 'A' + dist;
//                System.out.println((char) ('a' + str.charAt(i) - 'A'));
//            }
//            else System.out.println((char)('A' + str.charAt(i) - 'a'));
//        }


        //풀이
        String str = sc.next();
        char[] ans = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z'){
                ans[i] = (char)('a' + ch - 'A');
            }else{
                ans[i] = (char)('A' + ch - 'a');
            }
            System.out.println(ans);
        }


    }
}
