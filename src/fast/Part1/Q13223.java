package fast.Part1;

import java.util.Scanner;

    /*
     *  1. ':' 문자를 기준으로 시간, 분, 초를 쪼갠다.
     *  2. 두 시간, 분, 초의 차이를 계산한다.
     *  3. 구해진 시간을 HH:MM:SS 형태로 출력한다.
     */
public class Q13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] currentTime = sc.nextLine().split(":");
        String[] saltTime = sc.nextLine().split(":");

        int cHour = Integer.parseInt(currentTime[0]);
        int sHour = Integer.parseInt(saltTime[0]);
        int cMin = Integer.parseInt(currentTime[1]);
        int sMin = Integer.parseInt(saltTime[1]);
        int cSec = Integer.parseInt(currentTime[2]);
        int sSec = Integer.parseInt(saltTime[2]);
        int diffHour = sHour - cHour;
        int diffMin = sMin - cMin;
        int diffSec = sSec - cSec;

        if (diffSec < 0 ) {
            diffMin -= 1;
        }
        if (diffMin < 0) {
            diffHour -= 1;
        }
        if (diffHour < 0) {
            diffHour = 24 + diffHour;
        }

        System.out.println(diffHour + ":" + diffMin + ":" + Math.abs(diffSec));
    }
}
