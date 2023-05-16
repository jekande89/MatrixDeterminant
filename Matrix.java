public class MatrixDeterminant {

    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        
        if (n == 1) {
            // Base case: 1x1 matrix
            return matrix[0][0];
        } else if (n == 2) {
            // Base case: 2x2 matrix
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            // Recursive case: n x n matrix
            int det = 0;
            
            for (int j = 0; j < n; j++) {
                // Calculate the determinant of each minor matrix
                int[][] minor = getMinorMatrix(matrix, 0, j);
                int minorDet = determinant(minor);
                
                // Accumulate the determinant using the appropriate sign
                det += (j % 2 == 0) ? matrix[0][j] * minorDet : -matrix[0][j] * minorDet;
            }
            
            return det;
        }
    }
    
    private static int[][] getMinorMatrix(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        int minorRow = 0;
        
        for (int i = 0; i < n; i++) {
            if (i != row) {
                int minorCol = 0;
                
                for (int j = 0; j < n; j++) {
                    if (j != col) {
                        minor[minorRow][minorCol] = matrix[i][j];
                        minorCol++;
                    }
                }
                
                minorRow++;
            }
        }
        
        return minor;
    }
}
