package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N보다 작거나 같은 자연수 중에서, 집합 K의 원소로만 구성된 가장 큰 수를 출력하는 프로그램을 작성하시오. K의 모든 원소는 1부터 9까지의 자연수로만 구성된다.
예를 들어 N=657이고, K={1, 5, 7}일 때 답은 577이다.
 */
/*
첫째 줄에 N, K의 원소의 개수가 공백을 기준으로 구분되어 자연수로 주어진다. (10 ≤ N ≤ 100,000,000, 1 ≤ K의 원소의 개수 ≤ 3) 둘째 줄에 K의 원소들이 공백을 기준으로 구분되어 주어진다. 각 원소는 1부터 9까지의 자연수다.
단, 항상 K의 원소로만 구성된 N보다 작거나 같은 자연수를 만들 수 있는 경우만 입력으로 주어진다.
 */
//첫째 줄에 N보다 작거나 같은 자연수 중에서, K의 원소로만 구성된 가장 큰 수를 출력한다.
public class D04_BJ18511_240321 {

    private static int[] num;
    private static int n;
    private static int k;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //k의 원소
        st = new StringTokenizer(br.readLine(), " ");
        num = new int[k];

        for (int i=0; i<k; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
        System.out.println(ans);
    }

    //N보다 작거나 같은수 구하기
    static void dfs(int now) {
        if(now>n) return;

        if (ans<now) ans=now;

        for (int i = k-1; i > -1; i--) {
            dfs(now*10+num[i]);
        }
    }
}
