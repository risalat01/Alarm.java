class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, left = 0, right = m - 1, bottom = n - 1;
        List<Integer> answers = new ArrayList<>();

        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (int j = left; j <= right; j++) {
                    answers.add(matrix[top][j]);
                }
                top++;
                direction = 1;

            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    answers.add(matrix[i][right]);
                }
                right--;
                direction = 2;

            } else if (direction == 2) {
                for (int j = right; j >= left; j--) {
                    answers.add(matrix[bottom][j]);
                }
                bottom--;
                direction = 3;

            } else {
                for (int i = bottom; i >= top; i--) {
                    answers.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }

        return answers;
    }
}