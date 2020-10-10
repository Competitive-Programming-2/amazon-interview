class Solution2 {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int nSet = 0;

        // the min number of the whole array
        int minAbs = Integer.MAX_VALUE;

        // the min number of the selected set
        int minSet = Integer.MAX_VALUE;

        // the min number of the previous set
        int precMinSet = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < minSet) {
                minSet = A[i];

                // Select the min number of the whole array
                if (minAbs > minSet) {
                    minAbs = minSet;
                }

                // if the next number in the array is greater than min set and min abs set, check if a set can be created
                if (i == A.length - 1 || (A[i + 1] > minSet && A[i + 1] > minAbs)) {

                    // if the current min set is less than the previous min set, then increase the number of sets
                    if (precMinSet < minSet) {
                        nSet++;
                        precMinSet = minSet;
                    }
                    minSet = Integer.MAX_VALUE;
                }
            }
        }

        return nSet;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(new int[] { 2, 1, 6, 4, 3, 7 }));
    }
}