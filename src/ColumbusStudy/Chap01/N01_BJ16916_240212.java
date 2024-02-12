package ColumbusStudy.Chap01;

import java.util.Scanner;

public class N01_BJ16916_240212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String P = sc.nextLine();
        boolean check = false;

        for (int i=0; i<S.length(); i++) {
            if (S.toCharArray()[i] == P.toCharArray()[0]) {
                for (int j=0; j<P.length();j++) {
                    if (S.toCharArray()[i+j] != P.toCharArray()[j]) {
                        check = false;
                    } else {
                        check = true;
                    }
                }
            }
        }
        if (check) System.out.println(1);
        else System.out.println(0);
    }
}
