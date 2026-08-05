class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverse(matrix);
    }

    private void transposeMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    private void reverse(int[][] matrix) {
        for (int[] matRow : matrix) {
            revereRow(matRow);
        }
    }

    private void revereRow(int[] row) {
        int l = 0;
        int r = row.length - 1;
        while (l < r) {
            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }
}
