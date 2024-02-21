package algorithms;

//https://hongjw1938.tistory.com/193
/*
문제를 즉각 해결할 수 있을 때까지 재귀적으로 둘 이상의 하위 문제(Sub-problem)들로 나누고(Divide)
문제를 해결한 다음(Conquer) 그 결과를 이용해 다시 전체 문제를 해결하며 합치는 방법
 */
public class DivideNConquer {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        mergeSort(arr, 0, arr.length-1);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start == end) return;

        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        int[] temp = new int[end-start+1];
        int idx = 0;
        int left = start;
        int right = mid+1;
        while (left <= mid && right <= end) {
            temp[idx++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }
        while(right <= end) {
            temp[idx++] = arr[right++];
        }
        for (int i=start; i <= end; i++) {
            arr[i] = temp[i-start];
        }
    }
}
