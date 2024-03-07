package ColumbusStudy.Chap01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D22_BJ2141_240307 {
    /*
    수직선과 같은 일직선상에 N개의 마을이 위치해 있다. i번째 마을은 X[i]에 위치해 있으며, A[i]명의 사람이 살고 있다.
이 마을들을 위해서 우체국을 하나 세우려고 하는데, 그 위치를 어느 곳으로 할지를 현재 고민 중이다. 고민 끝에 나라에서는 각 사람들까지의 거리의 합이 최소가 되는 위치에 우체국을 세우기로 결정하였다. 우체국을 세울 위치를 구하는 프로그램을 작성하시오.
각 마을까지의 거리의 합이 아니라, 각 사람까지의 거리의 합임에 유의한다
     */
    // 첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 X[1], A[1], X[2], A[2], …, X[N], A[N]이 주어진다. 범위는 |X[i]| ≤ 1,000,000,000, 1 ≤ A[i] ≤ 1,000,000,000 이며 모든 입력은 정수이다.
    // 첫째 줄에 우체국의 위치를 출력한다. 가능한 경우가 여러 가지인 경우에는 더 작은 위치를 출력하도록 한다.
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] towns = new int[n];
        int[] people = new int[n];

        for (int i=0 ; i<n; i++) {
            towns[i] = Integer.parseInt(br.readLine());
            people[i] = Integer.parseInt(br.readLine());
        }
    }*/

    static class House implements Comparable<House> {
        long pos, val;
        public House(long pos, long val) {
            this.pos = pos;
            this.val = val;
        }
        // 마을위치기준 오른차순 정렬
        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 마을 정보 저장 리스트
        List<House> houseList = new ArrayList<>();
        long sum = 0;
        // 마을 정보를 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long pos = Long.parseLong(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            houseList.add(new House(pos, val));
            sum += val; // 총인원 구하기
        }
        Collections.sort(houseList);    // 마을 위치 기준 오른차순 정렬
        long result = 0;
        // 가장 먼저 중간값보다 크거나 같은 마을 탐색
        for (int i=0; i<n; i++) {
            result += houseList.get(i).val;
            if ((sum + 1)/2 <= result) { // (sum+1)/2 중간값
                bw.write(String.valueOf(houseList.get(i).pos));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
