package DoIt.chap06;

public class QuickSortV {
    static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = a[left];
    }

    // 퀵 정렬(배열을 나누는 과정을 출력)
    static void quickSort(int[] a, int left, int right) {
        int pl = left;              // 왼쪽 커서
        int pr = right;             // 오른쪽 커서
        int x = a[(pl + pr) / 2];   // 피벗(가운데 요소)

        System.out.printf("a[%d]~a[%d]: {" , left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }
}
