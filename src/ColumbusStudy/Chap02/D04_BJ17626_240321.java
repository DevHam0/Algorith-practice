package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
라그랑주는 1770년에 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다고 증명하였다. 어떤 자연수는 복수의 방법으로 표현된다.
예를 들면, 26은 52과 12의 합이다; 또한 42 + 32 + 12으로 표현할 수도 있다. 역사적으로 암산의 명수들에게 공통적으로 주어지는
문제가 바로 자연수를 넷 혹은 그 이하의 제곱수 합으로 나타내라는 것이었다. 1900년대 초반에 한 암산가가 15663 = 1252 + 62 + 12 + 12라는
해를 구하는데 8초가 걸렸다는 보고가 있다. 좀 더 어려운 문제에 대해서는 56초가 걸렸다: 11339 = 1052 + 152 + 82 + 52.
자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현하는 컴퓨터 프로그램을 작성하시오.
 */
//입력은 표준입력을 사용한다. 입력은 자연수 n을 포함하는 한 줄로 구성된다. 여기서, 1 ≤ n ≤ 50,000이다.
//출력은 표준출력을 사용한다. 합이 n과 같게 되는 제곱수들의 최소 개수를 한 줄에 출력한다.
public class D04_BJ17626_240321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        //dp
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<= n; i++) {
            // 현재 구할 값의 개수는 전 값의 +1이니 전 값을 그대로 우선 가져온다.
            dp[i] = dp[i - 1];
            for (int j = 1; j * j <= i; j++) {
                //현재 들어가있는 값과, i - j * j의 값과 비교해서 작은 값을 다시 저장
                dp[i] = Math.min(dp[i], dp[i - (j * j)]);
            }
            //최솟값이 저장되었을테니 +1을해서 마무리 해준다.
            dp[i]++;
        }
        System.out.println(dp[n]);
    }
}
