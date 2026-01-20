class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;

        for(int i=0;i<row;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}