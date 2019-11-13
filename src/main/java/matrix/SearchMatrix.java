package matrix;

public class SearchMatrix {

    public void search(int[][] matrix, int n, int value) {
        int i = 0, j = n-1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == value) {
                System.out.print(value+" is found at :" +i+","+j+"\n");
                return;
            }
            if (matrix[i][j] > value) j--;
            else i++;
        }
        System.out.print(value +" is not found \n");
    }

    public static void main(String[] args) {
        int[][] testMatrix = {{1,2,3,4},
                              {5,6,7,8},
                              {9,10,11,12},
                              {13,14,15,16}
                             };
        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.search(testMatrix,4,9);
        searchMatrix.search(testMatrix,4,19);
    }
}
