package DoIt.chap10;
// 체인법에 의한 해시의 사용 예

import java.util.Scanner;

public class ChainHashTester {
    static Scanner stdIn = new Scanner(System.in);

    // 데이터(회원번호 + 이름)
    static class Data {
        static final int NO = 1;        // 번호 이름받기
        static final int NAME = 2;      // 이름 입력받기

        private Integer no;             // 회원번호(키값)
        private String name;            // 이름

        // 키값
        Integer keyCode() {
            return no;
        }

        // 문자열 출력을 반환
        public String toString() {
            return name;
        }

        // 데이터를 입력
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호: ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름: ");
                name = stdIn.next();
            }
        }
    }

    // 메뉴 열거형
    enum Menu {
        ADD("추가"),
        REMOVE("삭제"),
        SEARCH("검색"),
        DUMP("출력"),
        TERMINATE("종료");

        private final String message;       // 출력할 문자열

        static Menu MenuAt(int idx) {       // 서수가 idx인 열거를 반환
            for (Menu m: Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {               // 생성자
            message = string;
        }

        String getMessage() {               // 출력할 문자열을 반환
            return message;
        }
    }
}
