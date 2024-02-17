package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D06_BJ2004_240217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 수학
        long count5 = five_power_n(n) - five_power_n(n - m) - five_power_n(m);
        long count2 = two_power_n(n) - two_power_n(n - m) - two_power_n(m);

        System.out.println(Math.min(count5, count2));
    }

    // 5의 승수를 구하는 함수
    static long five_power_n (long num) {
        int count = 0;

        while (num >= 5) {
            count += num/5;
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long two_power_n(long num) {
     int count = 0;

     while (num >= 2) {
         count += num/2;
         num /= 2;
     }
     return count;
    }
}
