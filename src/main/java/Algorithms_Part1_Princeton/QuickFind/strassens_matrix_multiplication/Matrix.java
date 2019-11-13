package Algorithms_Part1_Princeton.QuickFind.strassens_matrix_multiplication;

public class Matrix {

    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1RowLength = m1.length;
            int m1ColLength = m1[0].length;
            int m2RowLength = m2.length;
            int m2ColLength = m2[0].length;
            if (m1ColLength != m2RowLength)
                throw new IllegalStateException("Matrix multiplication is not possible for this combination");
            double[][] resultantMatrix = new double[m1RowLength][m2ColLength];
            for (int i = 0; i < m1RowLength; i++) { // rows from m1
                for (int j = 0; j < m2ColLength; j++) { // columns from m2
                    for (int k = 0; k < m1ColLength; k++) // columns from m1
                        resultantMatrix[i][j] += m1[i][k] * m2[k][j];
                }
         }
        return resultantMatrix;
    }

    public static String toString(double[][] m) {
        String result = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result += String.format("%11.2f", m[i][j]);
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        // for the first set of data
        double[][] multiDimentionalArray = new double[][] {
                {3, -1, 2},
                {2, 0, 1},
                {1, 2, 1}
        };
        double[][] secondMultiDimentionalArray = new double[][] {
                {2, -1, 1},
                {0, -2, 3},
                {3, 0, 1}
        };
        System.out.println(toString(multiplyByMatrix(multiDimentionalArray,secondMultiDimentionalArray)));

        // for the second set of data
        double[][] firstArray = new double[][] {
                {1, 2, 0},
                {-1, 3, 1},
                {2, -2, 1}
        };
        double[][] secondArray = new double[][] {
                {2},
                {-1},
                {1}
        };

        System.out.println(toString(multiplyByMatrix(firstArray,secondArray)));


    }

}
