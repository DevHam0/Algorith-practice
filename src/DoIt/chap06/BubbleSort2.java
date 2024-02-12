package DoIt.chap06;
public class BubbleSort2 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬(버전 2)
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;                  // 패스에서 교환하는 횟수를 저장
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            if (exchg == 0) break;          // 교환이 이루어지지 않으므로 멈춤
        }
    }
}
