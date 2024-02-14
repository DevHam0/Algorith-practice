package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class D02_BJ20154_240213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] inputArr = input.toCharArray();
        int[] result = dic(inputArr);
    }

    static int[] dic(char[] inputArr) {
        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "32123333113133122212112221";
        int[] alpNum = new int[alp.length()];
        int[] numNum = new int[num.length()];
        char[] alpArr = alp.toCharArray();
        char[] numArr = num.toCharArray();

        int[] iArr = new int[inputArr.length];

        for (int i=0; i<iArr.length; i++) {
            for (int j=0; j<alpArr.length; j++) {

                iArr[i] = numArr[j];
            }
        }
        return iArr;
    }
}
