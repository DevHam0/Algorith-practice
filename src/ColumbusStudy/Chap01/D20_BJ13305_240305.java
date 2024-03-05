package ColumbusStudy.Chap01;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class D20_BJ13305_240305 {
    /*
    어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다. 편의상 일직선을 수평 방향으로 두자. 제일 왼쪽의 도시에서
    제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다. 인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다.
    도로 길이의 단위는 km를 사용한다.
처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다. 기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다.
도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다. 각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다. 가격의 단위는 원을 사용한다.
예를 들어, 이 나라에 다음 그림처럼 4개의 도시가 있다고 하자. 원 안에 있는 숫자는 그 도시에 있는 주유소의 리터당 가격이다.
도로 위에 있는 숫자는 도로의 길이를 표시한 것이다.
제일 왼쪽 도시에서 6리터의 기름을 넣고, 더 이상의 주유 없이 제일 오른쪽 도시까지 이동하면 총 비용은 30원이다.
만약 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 3리터의 기름을 넣고(3×2 = 6원)
다음 도시에서 1리터의 기름을 넣어(1×4 = 4원) 제일 오른쪽 도시로 이동하면, 총 비용은 20원이다.
또 다른 방법으로 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 4리터의 기름을 넣고(4×2 = 8원)
제일 오른쪽 도시까지 이동하면, 총 비용은 18원이다.
각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는
최소의 비용을 계산하는 프로그램을 작성하시오.
     */
    // 표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다.
    // 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다.
    // 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다.
    // 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다.
    // 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다.

    // 표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 개수

        BigInteger[] road = new BigInteger[n - 1];  // 각 도시를 연결하는 도로의 길이
        BigInteger[] oil = new BigInteger[n];       // 각 도시에 있는 주유소의 기름 가격

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n - 1; i++) {
            road[i] = new BigInteger(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            oil[i] = new BigInteger(st.nextToken());
        }

        // 처음 주유소는 무조건 이동
        BigInteger result = oil[0].multiply(road[0]);
        BigInteger minPrize = oil[0];

        // 마지막 -1 번째 주유소까지만 이용 가능
        for (int i=1; i< oil.length-1; i++) {
            // 지금까지 거친 주유소 중 최저가 vs 현재주유소
            if (oil[i].compareTo(minPrize) < 0) {
                result = result.add(oil[i].multiply(road[i]));
                minPrize = oil[i];
            } else {
                result = result.add(minPrize.multiply(road[i]));
            }
        }
        System.out.println(result);



    }
}
