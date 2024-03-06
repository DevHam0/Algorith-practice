package ColumbusStudy.Chap01;

import java.io.*;
import java.util.StringTokenizer;

public class D21_BJ1541_240306 {
    /*
    세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
     */
    /*
    첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
     */
    // 첫째 줄에 정답을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        System.out.println(solution(input));

    }

    // 최솟값을 만들기 위해서는 큰 수를 빼줘야한다. => 덧셈으로 이루어진 부분을 먼저
    // (뺄셈이 덧셈보다 뒤에있는 경우 먼저 더하나 빼고 더하나 같음)
    static int solution(String str) {
        int sum = Integer.MAX_VALUE;
        String[] tokenArrByMinus = str.split("-");
        for (String token : tokenArrByMinus) {
            String[] tokenArrByPlus = token.split("\\+"); // + 문자가 메타문자
            int temp = 0;
            for (String t : tokenArrByPlus) {
                temp += Integer.parseInt(t);
            }

            if (sum == Integer.MAX_VALUE) sum = temp; // tokenArrByMinus의
            else sum -= temp;
        }
        return sum;
    }

    static int solution2(String str) {
        int sum = Integer.MAX_VALUE;
        StringTokenizer stMinus = new StringTokenizer(str, "-");
        while (stMinus.hasMoreTokens()) { // 남아있는 토큰이 있으면 true를 리턴
            String token = stMinus.nextToken(); // 객체에서 다음 토큰을 반환
            StringTokenizer stPlus = new StringTokenizer(token, "+");
            int temp = 0;
            while (stPlus.hasMoreTokens()) {
                temp += Integer.parseInt(stPlus.nextToken());
            }

            if (sum == Integer.MAX_VALUE) sum = temp;
            else sum -= temp;
        }
        return sum;
    }
}
