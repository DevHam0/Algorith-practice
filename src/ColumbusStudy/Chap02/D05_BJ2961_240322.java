package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.
지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.
시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다. 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.
재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.
 */
//첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다. 다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다.
// 모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.
//첫째 줄에 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 출력한다.
public class D05_BJ2961_240322 {

    /*
    DFS, 완전 탐색을 사용
    - 신맛과 쓴맛을 저장한 배열을 하나씩 방문하며 넣을지 안 넣을지 확인한다
    - 모든 음식을 넣을지 안 넣을지 확인하였을 때, 쓴맛과 신맛의 차이가 answer보다 작다면 answer를 업데이트
    - 완전 탐색 후 answer를 출력
     */

    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken()); // 신맛
            B[i] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        DFS(0, 1, 0, 0); // (트리 깊이, 신맛, 쓴맛, 선택한 음식 개수)
        System.out.println(answer);
    }

    private static void DFS(int level, int s, int b, int selectedCount) { // 완탐
        if (level == N) {   //모든 조합 찾음
            if (selectedCount != 0 && Math.abs(s-b) < answer) // 1개 이상 선택하고 쓴맛과 신맛의 차이가 지금까지 찾은 값보다 작다면
                answer = Math.abs(s-b); // 가장 작은 값으로 변경
            return;
        }
        DFS(level+1, s*S[level], b+B[level], selectedCount+1); //선택
        DFS(level+1, s, b, selectedCount); //비선택
    }
}
