package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D09_BJ10866_240221 {
    /*
    정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 여덟 가지이다.
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    /*
    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
     */
    // 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수
        ArrayList<Integer> deque = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String command = br.readLine(); // 명령어 받기
            if (command.contains("push_front")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                deque = push_front(deque, num);
            } else if(command.contains("push_back")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                deque = push_back(deque, num);
            } else if(command.contains("pop_front")) {
                deque = pop_front(deque);
            } else if(command.contains("pop_back")) {
                deque = pop_back(deque);
            }else if (command.contains("size")) {
                System.out.println(deque.size());
            } else if (command.contains("empty")) {
                if (deque.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.contains("front")) {
                front(deque);
            } else if (command.contains("back")) {
                back(deque);
            }
        }
    }

    static ArrayList<Integer> push_front(ArrayList<Integer> deque, int num) {
        if (deque.size() == 0) {
            deque.add(num);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(num);
            for (int i=0; i<deque.size(); i++) {
                temp.add(deque.get(i));
            }
            deque = temp; // 만든 temp를 deque로 변경해주기
        }
        return deque;
    }

    static ArrayList<Integer> push_back(ArrayList<Integer> deque, int num) {
        deque.add(num);
        return deque;
    }

    static ArrayList<Integer> pop_front(ArrayList<Integer> deque) {
        if (deque.size() == 0) {
            System.out.println(-1);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<deque.size(); i++) {
                if (i == 0) {
                    System.out.println(deque.get(i));
                } else {
                    temp.add(deque.get(i));
                }
            }
            deque = temp;
        }
        return deque;
    }

    static ArrayList<Integer> pop_back(ArrayList<Integer> deque) {
        if (deque.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(deque.get(deque.size() - 1));
            deque.remove(deque.size()-1);
        }
        return deque;
    }

    static void front (ArrayList<Integer> deque) {
        if (deque.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(deque.get(0));
        }
    }

    static void back (ArrayList<Integer> deque) {
        if (deque.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(deque.get(deque.size() - 1));
        }
    }
}
