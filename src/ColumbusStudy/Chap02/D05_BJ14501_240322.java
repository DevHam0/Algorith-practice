package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
N = 7인 경우에 다음과 같은 상담 일정표를 보자.

1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 */
//첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
//
//둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
//첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
public class D05_BJ14501_240322 {
    //DFS를 이용
    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담하는데 걸리는 일수
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 돈
        }

        result = 0;
        // 0일부터 시작
        dfs(0, 0);

        System.out.println(result);
    }

    // 백트래킹(DFS)코드
    /*
    DFS 를 사용하여 해결한다.
    탈출 조건: 날짜(idx)가 N 이상이면 result 중 최댓값을 구하며 끝낸다.
    만약 상담을 끝낸 날이 N 이하라면. 즉, idx + schedule[idx][0] <= N 라면 dfs에 상담이 끝난 날짜와 합친 상담비를 넣는다.
    만약 상담을 끝낸 날이 N 을 넘어간다면. 즉, 상담을 퇴사날까지 끝마칠 수 없다면 dfs에 상담이 끝난 날짜만 넘겨준다. -> 합친 상담비는 그대로고 넘겨준 날짜는 탈출 조건에서 사용한다.
    dfs(idx + 1, pay) 를 dfs 끝에 넣어주어 이어서 상담하지 않고 날짜를 띄워서 새로운 날짜를 탐색할 수 있도록 해준다. -> 마지막 날짜까지 모두 탐색해볼 수 있다.
     */
    static void dfs(int idx, int pay) {
        if (idx >= N) {
            result = Math.max(pay, result);
            return;
        }

        if (idx + schedule[idx][0] <= N) { //상담을 끝마칠 수 있다면 -> 상담이 끝난 날짜와 상담비 넣음
            dfs(idx + schedule[idx][0], pay + schedule[idx][1]);
        } else { // 상담을 끝마칠 수 없다면 -> 상담이 끝난 날짜만 넘겨준다(탈출 조건으로 써먹음)
            dfs(idx + schedule[idx][0], pay);
        }

        // 이어서 상담하지 않고 날짜를 띄워서 새로운 날짜를 입력 (0일부터 마지막 날짜까지 다 훑을 수 있음)
        dfs(idx + 1, pay);
    }

    // DP코드
    /*
    날짜의 끝 부터 첫 날 까지 거꾸로 DP 배열을 구해나간다.
    배열 DP[i]는 날짜 i 부터 상담을 했을 때 벌 수 있는 돈의 최댓값이다.
    예를 들어 DP[5] 라면 5일 부터 일 한 값 중 최댓값이다.
    그러므로 DP[1] 을 구해주면 된다.
    i + T[i] > N + 1 라면 i 날짜에는 일을 할 수 없다.
    따라서 DP[i] 의 값은 DP[i + 1] 이 된다.
    i의 날짜에 i의 일을 하지 못한다면 i + 1 의 날짜부터 일해서 번 돈의 최댓값과 i 의 날짜부터 일해서 번 돈의 최댓값이 같기 때문이다.
    i + T[i] <= N + 1 라면 i 날짜에 일을 할 수 있다.
    일을 하지 않았을 때의 값 DP[i + 1]
    i 날짜의 일을 하면 i 날짜의 페이인 P[i] 와 i 날짜 이후에 번 돈의 최댓값인 DP[i+T[i]] 의 합인 값 P[i] + DP[i+T[i]]
    위의 DP[i + 1] 과 P[i] + DP[i+T[i]] 값 중 더 큰 값을 DP[i]에 넣어준다.
    DP를 사용할 때 뒤에서부터 시작하는 것도 좋은 방법이다.
     */
    private void dp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); // 상담하는데 걸리는 일 수
            P[i] = Integer.parseInt(st.nextToken()); // 돈
        }

        for (int i=N; i>0;i--) {
            int next = i + T[i]; // 다음 날짜

            if (next > N + 1) { // 일할 수 있는 날짜를 넘기는 경우
                // 일을 하지 못하므로 바로 다음 DP값(더 앞쪽의 날짜)로 설정
                DP[i] = DP[i + 1];
            } else {    // 일할 수 있는 날짜인 경우
                // 1. 일하지 않았을 떄(DP[i + 1])
                // 2. 일 했을때 총 벌수 있는 금액(P[i] + DP[next])
                // 위 두 경우 중 더 큰 값을 DP에 넣어준다.
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]);
            }
        }

        System.out.println(DP[1]);
    }
}
