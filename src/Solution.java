public class Solution {
    public int solution(int[] A, int K, int L) {

        if ((K + L) > A.length)
            return -1;

        int[] B = A.clone();

        int case1 = getMaxApples(A, K, L);
        int case2 = getMaxApples(B, L, K);

        return case1 > case2 ? case1 : case2;
    }

    private int getMaxApples(int[] row, int T1, int T2) {
        int max = -1;
        int iMax = 0;

        // find the T1 trees that are the max sum of apples in the row
        for (int i = 0; i < row.length - T1 + 1; i++) {
            int tempSum = 0;
            for (int j = i; j < i + T1; j++) {
                tempSum += row[j];
            }

            // if this T1 trees are the max then save the sum and the position
            if (tempSum > max) {
                max = tempSum;
                iMax = i;
            }
        }

        // Set to minus one the trees that have been chosen by the first person
        for (int j = iMax; j < iMax + T1; j++) {
            row[j] = -1;
        }

        // find the T2 trees that are the max sum of apples in the row
        int max2 = -1;
        for (int i = 0; i < row.length - T2 + 1; i++) {
            int tempSum = 0;
            for (int j = i; j < i + T2; j++) {
                tempSum += row[j];

                // if one of T2 trees has been set minus one, it means that have been already chosen
                if (row[j] == -1) {
                    continue;
                }
            }

            // if this T2 trees are the max then save the sum
            if (tempSum > max2) {
                max2 = tempSum;
            }
        }

        return max + max2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 10, 18, 15 }, 2, 2));
    }
}
