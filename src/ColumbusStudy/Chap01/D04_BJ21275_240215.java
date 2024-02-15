package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D04_BJ21275_240215 {
    /*
     폰 호석만은 진법 변환의 달인이다. 어떤 진법의 수가 주어져도 모든 다른 진법으로의 변환이 가능한 폰 호석만은 새로운 문제를 내기로 했다. 폰 호석만이 내는 문제는 다음과 같이 진행된다.
    먼저 폰 호석만은 수 3개 X, A, B를 결정한다(0 ≤ X < 263, 2 ≤ A ≤ 36, 2 ≤ B ≤ 36, A ≠ B). 이 때 X는 10진법이다. 그 다음에 X를 A진법으로 표현한 수와 B진법으로 표현한 수를 종이에 써 놓는다.
    그 다음에 종이에 써져 있는 두 개의 수를 여러분에게 보여주게 된다. 주어진 두 개의 수를 통해 원래 숫자인 X, A, B를 계산해주자. 만약 조건을 만족하는 (X, A, B)로 가능한 조합이 여러 개라면 "Multiple"을 출력하고, 가능한 조합이 없다면 "Impossible"를 출력한다.
      */
    /*
    첫번째 줄에 X를 A진법으로 표현한 값과 X를 B진법으로 표현한 값이 공백으로 구분되어 주어진다. 각 자리수는 0 이상 z 이하이다. a부터 z 는 10부터 35 를 의미한다.
단, 0을 제외한 각 수는 0 으로 시작하지 않으며, 길이는 최대 70 이다.
     */
/*
만약 문제의 조건에 맞는 X, A, B가 유일하게 존재한다면, X를 십진법으로 표현한 수와 A와 B를 공백으로 나누어 출력하라. 만약 만족하는 경우가 2가지 이상이라면 "Multiple"을, 없다면 "Impossible"을 출력하라.
 */
    static String xA, xB, x, max;
    static long a, b;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        xA = s[0];
        xB = s[1];
        max = String.valueOf(Math.pow(2, 63));

        arr = new int[200];

        for (int i=0; i<9; i++) {
            arr[i+'1']=i+1;
        }
        for (int i=0; i<26; i++) {
            arr['a'+i]=i+10;
        }
        solve();

        if (count == 0) {
            System.out.println("Impossible");
        } else if (count == 1) {
            String toInteger = x.substring(0, x.length() - 2);
            System.out.println(toInteger+" "+a+" "+b);
        } else {
            System.out.println("Multiple");
        }
    }

    public static void solve() {
        for (int i=1; i<=36; i++) {
            for (int j=1; j<=36;j++) {
                if (i==j) {
                    continue;
                }
                if (check(i, xA) && check(j, xB)) {
                    if (find(i, xA).equals(find(j, xB))) {
                        if (find(i, xA).compareTo(max)>=1) {
                            continue;
                        }
                        count++;
                        x=find(i, xA);
                        a=i;
                        b=j;
                    }
                }
            }
        }
    }

    public static String find(int a, String s) {
        int temp = 0;
        double result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            int t = arr[s.charAt(i)];
            result += Math.pow(a, temp) * t;
            temp++;
        }
        return String.valueOf(result);
    }

    public static boolean check(int a, String s) {
        for (int i=0; i<s.length(); i++) {
            if (a <= arr[s.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
