package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
오늘부터 인구 이동이 시작되는 날이다.
인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
 */
//첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
//둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
//인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.
//인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class D14_BJ16234_240402 {

    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    static ArrayList<Pair> unionXY = new ArrayList<>();
    static boolean visit[][];
    static int map[][];
    static int n, l, r, cnt;
    static boolean isMove = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(cnt);
    }

    static void move() {
        while(true) {
            isMove = false;
            visit = new boolean[n][n]; //새로 BFS 시작할때마다 방문 초기화

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visit[i][j]) {
                        bfs(i, j);  //방문하지 않은상태면 BFS 시작
                    }
                }
            }

            if (!isMove) break; //국경이동이 없으면 종료
            else cnt++; //국경이동이 있었다면 일수 추가
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visit[x][y] = true;
        unionXY.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            x = p.x;
            y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visit[nx][ny] && l <= Math.abs(map[x][y] - map[nx][ny]) && Math.abs(map[x][y] - map[nx][ny]) <= r) {
                        isMove = true;
                        visit[nx][ny] = true;
                        unionXY.add(new Pair(nx, ny));
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        //BFS가 끝나면 인구이동 결과 맵에 집어넣기
        int sum = 0;
        for (int i=0; i<unionXY.size(); i++) {
            Pair p = unionXY.get(i);
            sum += map[p.x][p.y];
        }

        for (int i=0; i<unionXY.size(); i++) {
            Pair p = unionXY.get(i);
            map[p.x][p.y] = sum / unionXY.size();
        }
        unionXY.removeAll(unionXY);
    }
}
