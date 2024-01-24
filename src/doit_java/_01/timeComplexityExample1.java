package doit_java._01;

public class timeComplexityExample1 {
    public static void main(String[] args) {
        // 1~100 사이 값 랜덤 선택
        int findNumber = (int)(Math.random() * 100);
        for (int i = 0; i < 100; i++) {
            if (i == findNumber) {
                System.out.println(i);
                break;
            }
        }
    }
}

// 연산 횟수가 N인 경우
/*
public class 시간복잡도_판별원리1 {
    public static void main(String[] args) {
        int N = 100000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            System.out.println("연산 횟수:" + cnt++);
        }
    }
}
*/

// 연산 횟수가 3N인 경우
/*
public class 시간복잡도_판별원리2 {
    public static void main(String[] args) {
        int N = 100000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            System.out.println("연산 횟수:" + cnt++);
        }
        for (int i = 0; i < N; i++) {
            System.out.println("연산 횟수:" + cnt++);
        }
        for (int i = 0; i < N; i++) {
            System.out.println("연산 횟수:" + cnt++);
        }
    }
}
*/

// 연산 횟수가 N^2인 경우
/*public class 시간복잡도_판별원리3 {
    public static void main(String[] args) {
        int N = 100000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println("연산 횟수:" + cnt++);
            }
        }
    }
}*/


