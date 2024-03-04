package ColumbusStudy.Chap01;

import java.io.*;

public class D19_BJ14916_240304 {
    /*
    춘향이는 편의점 카운터에서 일한다.
손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.
     */
    // 첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
    // 거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = countCoin(N);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 코인갯수 구하는 함수
    static int countCoin(int N) {
        int answer = -1;
        for (int i=N/5; i>=0;i--) {
            if ((N - (5 * i))% 2 == 0) {    // 5원을 i개쓰고 2원으로 거슬러 줄수일을때
                answer = i + (N - (5 * i))/2; // 동전의 개수 저장
                break; // 가장 먼저 거슬러줄 때가 최소 개수
            }
        }
        return answer;
    }
}
