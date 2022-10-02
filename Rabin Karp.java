// Rabin Karp
// Input: a = "abcd", b = "cdabcdab"
// Output: 3
// Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

// Approach 1: Brute Force 
// Check for each length of pattern in substring 
// if found then return the true else return false

// Time Complexity - O(m*n)
// Space Complexity - O(1)

// Code:
// 1)
import java.util.ArrayList;

public class Solution {
    public static void cp(String str, String pat, ArrayList<Integer> ans){
        if(str.length()<pat.length()){
            return;
        }
        int m=str.length();
        int n = pat.length();
        for(int i=0;i<=m-n;i++){
            int j=0;
            for(j=0;j<n;j++){
                if(str.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }
            if(j==n){
                ans.add(i);
            }
        }
    }
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        
        cp(str,pat,ans);
        return ans;
	}
}

// 2)

class Solution {
    
   public int repeatedStringMatch(String a, String b) {

          // Approach 1 : Brute Force 
          int count = b.length()/a.length();
          String str = a;
          int ans = 1;

          for(int i=0;i<=count+1;i++){
              if(str.contains(b))
                  return ans;    

              str += a;
              ans++;

          }
          return -1;
   }
}
  

// Approach 2 : Rabin Karp 

// Optimal Approach
// We find the hashcode of the pattern and the string and if hashcode is match then only we will check is this substring else go for the next index
// return ans

// Time Complexity - O(m*n) but optimal Approach no need check for every substrng 
// Space Complexity - O(1)

// Code:

class Solution {
    public static int d=256;
    public static int q=101;
    public boolean cp(String str,String pat){
        int m= pat.length();
        int n= str.length();
        int p=0;
        int t=0;
        int h=1;
        
        for(int i=0;i<m-1;i++){
            h = (h*d)%q;
        }
        
        for(int i=0;i<m;i++){
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + str.charAt(i))%q;
        }
        
        for(int i=0;i<=n-m;i++){
            if(p==t){
                int j=0;
                for(j=0;j<m;j++){
                    if(str.charAt(i+j)!=pat.charAt(j)){
                        break;
                    }
                }
                if(j==m){
                    return true;
                }
            }
            if(i<n-m){
                t = (d*(t-str.charAt(i)*h) + str.charAt(i+m))%q;
                
                if(t<0){
                    t = (t+q);
                }
            }
        }
        return false;
        
    }
    public int repeatedStringMatch(String a, String b) {
        int ans=1;
        String s = a;
        while(s.length()<b.length()){
            s+=a;
            ans++;
        }
        if(cp(s,b)){
            return ans;
        }
        if(cp(s+a,b)){
            return ans+1;
        }
        return -1;
    }
}
