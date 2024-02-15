package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D04_BJ1929_240215 {
    // M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    // 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
    // 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] input = word.split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        String result = "";
        for (int i=M; i<=N; i++) {
            if (i >= 2) {
                if (getPrimeNumber(i)) {
                    if(result.length() != 0) {
                        result = result + "\n" + i;
                    }else {
                        result = i + "";
                    }
                }
            }
        }

        System.out.print(result);
    }

    static boolean getPrimeNumber(int num) {
        // 루트 num은 항상 num/2 보다 커서 이것을 사용하면 O(루트(N))의 시간이 걸리게된다.
        for (int i=2; i*i <= num ; i++) {
            if (num % i == 0 ) return false;
        }
        return true;
    }

}
