public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        ArrayList<Long> row, prev = null;
        for(int i=0;i<n;i++){
            row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add((long)1);
                }
                else{
                    row.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev= row;
            ans.add(row);
        }
        return ans;
	}
}


// Pascle Traingle problem
//       1
//     1  1
//   1   2  1
// 1   3   3  1
