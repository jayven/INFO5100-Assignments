public class AssignmentFour {
    //Q4
    public int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int m = 0; m < A.length; m++) {
            for (int n = 0; n < A[m].length; n++) {
                if (A[m][n] == 0)
                    continue;
                for (int i = 0; i < B[0].length; i++) {
                    if (B[n][i] == 0)
                        continue;
                    ;
                    C[m][i] += A[m][n] * B[n][i];
                }
            }
        }
        return C;
    }

    //Q5
    public int[] String(String S) {
        int N = S.length();
        int low = 0;
        int high = N;
        int[] A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I')
                A[i] = low++;
            else
                A[i] = high--;
        }
        A[N] = low;
        return A;
    }

}
