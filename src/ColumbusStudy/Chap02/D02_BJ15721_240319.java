package ColumbusStudy.Chap02;

/*
중앙대학교 소프트웨어학부에 새로 입학한 19학번 새내기 일구는 새내기 새로 배움터에 가서 술게임을 여러 가지 배웠다. 그 중 가장 재미있었던 게임은 바로 번데기 게임이었다.
번데기 게임의 규칙은 다음과 같다. ‘뻔 – 데기 – 뻔 – 데기 – 뻔 – 뻔 – 데기 – 데기’ 를 1회차 문장이라고 하자. 2회차 문장은 ‘뻔 – 데기 – 뻔 - 데기 – 뻔 – 뻔 – 뻔 – 데기 – 데기 – 데기’가 된다.
즉 n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’이 된다. 하이픈 사이를 지날 때마다 순서는 다음 사람으로 넘어간다. 원을 돌아 다시 일구 차례가 와도 게임은 계속 진행된다.
일구와 동기들, 그리고 선배들을 포함한 사람 A명이 다음과 같이 원으로 앉아 있다고 가정하자.
일구가 0번째이고, 반 시계 방향으로 번데기 게임을 진행한다. T번째 ‘뻔’ 또는 ‘데기’를 외치는 사람은 위 원에서 몇 번 사람인지를 구하여라. (새내기는 10000번째가 되는 순간 시체방에 가기 때문에 T는 10000이하의 임의의 자연수이다.)
 */
//첫째 줄에 게임을 진행하는 사람 A명이 주어진다. A는 2,000보다 작거나 같은 자연수이다.
//둘째 줄에는 구하고자 하는 번째 T가 주어진다. (T ≤ 10000)
//셋째 줄에는 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1로 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//첫째 줄에 구하고자 하는 사람이 원탁에서 몇 번째에 있는지 정수로 출력한다.
public class D02_BJ15721_240319 {
    static int A, T, BD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        BD = Integer.parseInt(br.readLine());

        System.out.println(play());
    }

    static int play() {
        int b = 0, d = 0;
        int n = 2;
        while(true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    b++;
                    if (b == T && BD == 0) return (b + d - 1) % A;
                }
                else {
                    d++;
                    if (d == T && BD == 1) return (b + d - 1) % A;
                }
            }

            for (int i = 0; i < n; i++) {
                b++;
                if (b == T && BD == 0) return (b + d - 1) % A;
            }

            for (int i = 0; i < n; i++) {
                d++;
                if (d == T && BD == 1) return (b + d - 1) % A;
            }
            n++;
        }
    }
}
