package DoIt.chap06;

import DoIt.chap04.IntStack;

public class QuickSort2 {
    static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = a[left];
    }

    // 퀵 정렬(비재귀 버전)
    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();   // 왼쪽 커서
            int pr = right = rstack.pop();  // 오른쪽 커서
            int x = a[(left + right) / 2];  // 피벗(가운데 요소)

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);      // 왼쪽 그룹 범위의
                rstack.push(pr);        // 인덱스를 푸시
            }
            if(pl < right) {
                lstack.push(pl);        // 오른쪽 그룹 범위의
                rstack.push(right);     // 인덱스를 푸시
            }
        }
    }
}
