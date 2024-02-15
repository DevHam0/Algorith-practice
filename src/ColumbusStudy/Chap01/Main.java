package ColumbusStudy.Chap01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    //첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    // 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] inputArr = word.split(" ");

        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        int gcd = getGCD(a, b); // 최대공약수
        System.out.println(gcd);
        int lcm = getLCM(a, b, gcd); // 최소공배수
        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 최대공약수 구하는 로직
    static int getGCD(int a, int b) {
        int r = 1; // 나머지 값을 초기화
        // 유클리드 호제법을 사용한다.
        while(r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int getLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
