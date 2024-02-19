package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D07_BJ10828_240219 {
    /*
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다.
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는
경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    /*첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
    주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
    문제에 나와있지 않은 명령이 주어지는 경우는 없다.
    */
    //출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); // 스택 선언
        int n = Integer.parseInt(br.readLine()); // 명령의 수 읽기

        // 명령 실행
        for (int i=0; i<n; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                stack.push(Integer.valueOf(input.split(" ")[1]));
            } else if(input.contains("pop")) {
                pop(stack);
            } else if(input.contains("size")) {
                size(stack);
            } else if(input.contains("empty")) {
                empty(stack);
            } else if(input.contains("top")) {
                top(stack);
            }
            // KMP 사용
        }
    }

    // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
    static void pop(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int num = stack.pop();
            System.out.println(num);
        } else if (stack.isEmpty()) {
            System.out.println(-1);
        }
    }

    // 스택에 들어있는 정수의 개수를 출력한다.
    static void size(Stack<Integer> stack) {
        int size = stack.size();
        System.out.println(size);
    }

    // 스택이 empty인지 확인한다.
    static void empty(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    // 스택에 가장위에있는 정수를 출력
    static void top(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int num = stack.peek();
            System.out.println(num);
        } else {
            System.out.println(-1);
        }

    }
}
