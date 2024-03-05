package ColumbusStudy.Chap01;

import java.io.*;

public class D20_BJ1343_240305 {
    /*
    민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
     */
    // 첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.
    // 첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.

    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int count = 0;

        // 보드의 각 글자 탐색
        for (int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == 'X')        // 'X'일때 연속된 개수 더하기
                count++;
            else {                  // '.'일때 지금까지 연속된 'X'의 개수에 따라 덮어쓰기 진행
                if (!check(count))  // 폴리오미노로 덮어쓰기 불가능시 종료
                    break;
                answer.append(".");
                count = 0;          // 연속된 개수 0으로 초기화
            }
        }
        // 마지막 글자가 'X'로 끝날때 남은 연속된 개수 폴리오미노로 덮기
        if (!answer.equals("-1") && str.charAt(str.length()-1) == 'X')
            check(count);
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 폴리오미노 덮기 진행하는 함수
    static boolean check(int count) {
        String A = "AAAA", B = "BB";    // 폴리오미노 정보
        if (count % 4 == 0) {           // 4의 배수로 떨어질때 "AAAA"만 사용
            for (int j=0; j<count; j++)
                answer.append(A);
            answer.append(B);
        } else if (count % 4 == 2) {    // "AAAA를 최대한 사용한 뒤 남은 칸 "BB"로 덮기
            for (int j=0; j<count / 4; j++)
                answer.append(A);
            answer.append(B);
        } else if (count == 2)          // 연속된 개수가 2개일때 "BB" 한번 사용
            answer.append(B);
        else {                          // 폴리오미노로 덮을 수 없을떄
            answer = new StringBuilder("-1");
            return false;
        }
        return true;
    }
}
