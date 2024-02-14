package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D03_BJ1157_240214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String result = getAlphabetCount(word);
        // 결과 출력
        System.out.println(result);
    }

    static String getAlphabetCount(String word) {
        char[] arr = word.toLowerCase().toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alpArr = alphabet.toCharArray();
        int[] num = new int[alphabet.length()];
        // int배열 알파벳 0으로 초기화
        for (int i=0; i<alphabet.length(); i++) {
            num[i] = 0;
        }

        // 입력한 문자를 하나씩 체크
        for (int i=0; i<arr.length; i++) {
            // alphabet에 포함되어있는지 확인하고 숫자증가하는 로직
            for (int j=0; j<alphabet.length(); j++) {
                // 해당 알파벳이 있는 int배열의 숫자를 늘려주기
                if (Character.compare(arr[i], alpArr[j]) == 0) {
                    num[j] += 1;
                }
            }
        }

        // int 배열에서 제일 큰 숫자를 가진 인덱스 가져오기
        int max = 0; // 가장 큰 수 넣기위한 인덱스
        int index = 0; // 해당 인덱스
        for (int i=0; i<num.length; i++) {
            if(max < num[i]) {
                max = num[i];
                index = i;
            }
        }

        // 여러개있는지 확인하는 로직
        for (int i=0; i<num.length; i++) {
            if(i == index) {
                continue;
            }
            if(num[i] == max) {
                return "?";
            }
        }

        // 해당하는 문자를 출력해주는 로직
        String result = (alpArr[index] + "").toUpperCase();
        return result;
    }
}