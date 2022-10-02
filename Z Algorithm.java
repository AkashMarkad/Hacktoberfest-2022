// Z Algorithm (Search Pattern)
// Z Algorithm is the famous string pattern searching problem 
// Input : str= "ababa" and pat="ab"
// Output : 2
// Two time ab occurs in the str

// Approach 1 : Brute force to search pattern

// Using String Method equals and substring , we can easily find out or search pattern in String 


// code :

public class Solution {
  
  public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        int ans = 0;
        for(int i=0;i<n-m+1;i++){
            if(p.equals(s.substring(i,i+m)))
                ans++;
        }
        return ans;
  }
}

// Approach 1: Z Algorithm
// Initially we appenad the pat and string in between $
// craete a function to find the Z Array
// We can found that the pattern prsent in which index and same prefix is occurs then we add the how much length pattern is occurs at that perticular index
// now using the z array we calculate is the same length as pattern present in the array is present increase the count
// Return the count

// Time Complexity - O(n+n*pat.length()) where n= pat+str+"$"
// Space Complexity - O(n)

// Code:

public class Solution {
    
    public static void getZArray(String s, int z[]){
        int L=0,R=0,n=s.length(),K;
        for(int i=1;i<n;i++){
            if(i>R){
                L=R=i;
                while(R<n && s.charAt(R-L)==s.charAt(R)) R++;
                z[i] = R-L;
                R--;
            }
            else{
                K=i-L;
                if(z[K]<R-i+1){
                    z[i]=z[K];
                }
                else{
                    L=i;
                    while(R<n && s.charAt(R-L)==s.charAt(R)) R++;
                    z[i]=R-L;
                    R--;
                }
            }
        }
    }

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        int ans=0;
        String concat = p+"$"+s;
        int z[] = new int[concat.length()];
        getZArray(concat,z);
        for(int i=0;i<z.length;i++){
            if(z[i]==p.length()){
                ans++;
            }
        }
        return ans;

	}

}
