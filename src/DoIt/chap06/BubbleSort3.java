package DoIt.chap06;

public class BubbleSort3 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬(버전 3)
    static void bubbleSort(int[] a, int n) {
        int k = 0;                  // a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            int last = n - 1;       // 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            k = last;
        }
    }
}
