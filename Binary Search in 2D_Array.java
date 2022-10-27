import java.util.Arrays;

public class tutorial {
    //program to search for item in a row-wise, column-wise sorted 2D Array
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,}, {4,5,6}, {7,8,9}};
        int target = 6;
        System.out.println(Arrays.toString(searchSorted2D(matrix, target)));
    }
    static int[] searchSorted2D(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowidx = 0;
        int colidx = cols - 1;

        while(rowidx < rows && colidx >= 0){
            if(matrix[rowidx][colidx] == target){
                return new int[]{rowidx, colidx};
            } else if(matrix[rowidx][colidx] < target){
                rowidx++;
            } else if(matrix[rowidx][colidx] > target){
                colidx--;
            }
        }
        return new int[]{-1, -1};
    }
}
