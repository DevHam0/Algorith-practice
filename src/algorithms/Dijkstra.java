package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    // 우선순위 큐에서 정렬기준을 잡기위해 Comparable을 구현한다.
    static class Node implements Comparable<Node> {
        int index;  // 노드 번호
        int distance;   // 이동할 노드까지의 거리

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 최단거리를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    // INF 값 초기화
    static final int INF = 9999999;
    // 그래프를 표현할 2차원 List
    static List<List<Node>> graph = new ArrayList<>();
    // 최단거리테이블을 표현할 배열
    static int[] result;
    // 방문처리를 위한 배열이지만 다른 방법으로 방문처리를 진행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int startIndex = Integer.parseInt(br.readLine());

        // 그래프 생성
        for (int i=0; i < Integer.parseInt(info[0]) + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 최단거리테이블 생성
        result = new int[Integer.parseInt(info[0]) + 1];
        // 최단거리테이블 INF로 초기화
        Arrays.fill(result, INF);

        // 방문처리를 위한 배열 생성
        // visited = new boolean[Integer.parseInt(info[0])+1];

        // 주어진 입력값에 따라 그래프 초기화
        for (int i=0; i<Integer.parseInt(info[1]); i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(new Node(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
        }

        // 문제에서 주어진 입력값을 바탕으로 다익스트라 알고리즘 수행
        dijkstra(startIndex);

        // 문제에서 제시한 조건에 맞게 출력
        for (int i=1; i<result.length; i++) {
            if (result[i] == INF) {
                bw.write("INF");
                bw.newLine();
            } else {
                bw.write(String.valueOf(result[i]));
                bw.newLine();
            }
        }
        bw.flush();
    }

    // 다익스트라 알고리즘
    static void dijkstra(int index) {
        // 최단거리가 갱신된 노드들을 담을 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 최단거리테이블의 시작지점노드 값 0으로 갱신
        result[index] = 0;
        // 우선순위 큐에 시작노드 넣기
        pq.offer(new Node(index, 0));

        // 우선순위 큐에 노드가 존재하면 계속 반복
        while (!pq.isEmpty()) {
            // 큐에서 노드 꺼내기
            Node node = pq.poll();
            // 꺼낸 노드의 인덱스 및 최단거리 비용 확인
            int nodeIndex = node.index;
            int distance = node.distance;

            // 앞에서 주석처리했던 방문처리 배열을 사용해서 아래와 같이 방문처리가능
//            if (visited[nodeIndex]) {
//                continue;
//            } else {
//                visited[nodeIndex] = true;
//            }

            // 큐에서 꺼낸 거리와 최단거리테이블의 값을 비교해서 방문처리를 한다.
            // 큐는 최단거리를 기준으로 오름차순 정렬
            // 만약 현재 꺼낸 노드의 거리가 최단거리테이블의 값보다 크다면 해당 노드는 이전에 방문한 노드
            // 그래서 해당 노드와 연결된 노드를 탐색하지 않고 큐에서 다음노드를 꺼낸다.
            if (distance > result[nodeIndex]) {
                continue;
            }

            // 큐에서 꺼낸 노드에서 이동가능한 노드들을 탐색
            for (Node linkedNode : graph.get(nodeIndex)) {
                // 해당노드를 거쳐서 다음 노드로 이동할 때의 값이 다음 이동노드의 최단거리테이블 값보다 작을때
                if (distance + linkedNode.distance < result[linkedNode.index]) {
                    // if문의 조건을 만족했다면 최단거리테이블의 값을 갱신한다.
                    result[linkedNode.index] = distance + linkedNode.distance;
                    // 갱신된 노드를 우선순위 큐에 넣어준다.
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
            }
        }
    }

    // 우선순위 큐에서 정렬기준을 잡기위해 Comparable을 구현
    static class Node2 implements Comparable<Node> {
        int index;  // 노드번호
        int distance;   // 이동할 노드까지의 거리

        Node2(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 최단거리를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
