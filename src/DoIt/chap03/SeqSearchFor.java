package DoIt.chap03;

public class SeqSearchFor {

    // 요솟수가 n인 배열 a에서 key와 값이 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key) {
        for (int i=0; i < n; i++)
            if (a[i] == key)
                return i;       // 검색 성공(인덱스를 반환)

        return -1;              // 검색 실패(-1을 반환)
    }
}
