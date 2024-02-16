package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D05_BJ1676_240216 {
        // N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
//첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
//첫째 줄에 구한 0의 개수를 출력한다.
        /*public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
            int fact = getFactorial(input);
            int zeros = getZeroNum(fact);
            System.out.print(zeros);
        }

        // 팩토리얼 구하는 함수
        static int getFactorial(int num) {
            int fact = 1;

            for (int i=1; i<=num; i++) {
                fact *= i;
            }
            return fact;
        }

        static int getZeroNum(int fact) {
            int num = fact;
            int zero = 0;
            while (num % 10 != 0) {
                if (num % 10 != 0) {
                    break;
                } else if (num % 10 == 0) {
                    zero++;
                }
                num = num % 10;
            }
            return zero;
        }*/

    // 소인수분해를 이용
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int num = Integer.parseInt(br.readLine());
            int count = 0;

            while (num >= 5) {
                count += num / 5;
                num /= 5;
            }
            System.out.println(count);
        }
}
