package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class D08_BJ18258_240220 {
    /*
     *  정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 여섯 가지이다.
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    /*
    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고,
    100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
     */
    //출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> queue = new ArrayList<>();

    }

    static void push(ArrayList queue, int num) {
        queue.add(num);
    }

    static void pop(ArrayList queue, int num) {
        for (int i=0; i<queue.size(); i++) {
            queue[i] = queue[i+1];

        }
    }
}
