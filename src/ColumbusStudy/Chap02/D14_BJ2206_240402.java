package ColumbusStudy.Chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오
 */
//첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.
// (1, 1)과 (N, M)은 항상 0이라고 가정하자.
//첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
public class D14_BJ2206_240402 {
    static int n, m;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    //현재 위치, 벽을 부순적이 있는지, 지나간 타일의 수를 저장하는 클래스
    static class Point {
        int x, y, cnt;
        boolean destroyed;

        public Point(int x, int y, boolean destroyed, int cnt) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i=0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j=0; j<m; j++) {
                board[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        //시작점을 큐에 넣는다.
        queue.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            //도착하면 지나간 타일 수를 반환
            if (point.x == n - 1 && point.y == m - 1) {
                return point.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int newX = point.x + dx[d];
                int newY = point.y + dy[d];

                //배열을 벗어난 경우는 넘어간다.
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                //벽을 부순적 있는지 확인
                if (point.destroyed) {
                    //벽을 부순적이 있을때 해당 지점이 벽이 아니고, 방문한적이 없다면 큐에 정보를 넣는다.
                    if (board[newX][newY] == 0 && !visited[newX][newY][1]) {
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    }
                } else {
                    //해당 위치가 벽인지 확인
                    if (board[newX][newY] == 1) {
                        //벽이라면 벽을 부수고 큐에 값을 넣는다.
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    } else if (!visited[newX][newY][0]) {
                        //벽이 아니고 방문한 적이 없다면 큐에 값을 넣는다.
                        visited[newX][newY][0] = true;
                        queue.offer(new Point(newX, newY, false, point.cnt + 1));

                    }
                }
            }
        }
        return -1;
    }
}
