// KMP Algorithm 
// Input : txt = "abcabcdab" and pat = "abc"
// Output : true
// Explanation: pat is present in the txt

// Approach: KMP Algorithm
// KMP is most popular algorithm in string matching is the optimal algorithm
// In this algorithm we maintain the lps array to find the pattern

// Time Complexity - O(N+M)
// Space Complexity - O(M)

// Problem Link : https://www.codingninjas.com/codestudio/problems/1112621?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
// Code:

public class Solution {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        
        int[] lps = new int[p.length()];
        for(int i = 1;i<p.length();i++){
            int j = lps[i-1];
            while(j>0 && p.charAt(i) != p.charAt(j)){
                j = lps[j-1];
            }
            
            if(p.charAt(i)==p.charAt(j))    j++;
            if(i<p.length())    lps[i]=j;
        }
        
        int m = p.length();
        int n = s.length();
        int i=0;
        int j=0;
        while(i<n){
            if(p.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            
            if(j==m){
                return true;
            }
            else if(i<n && p.charAt(j) != s.charAt(i)){
                if(j==0){
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return false;
    }
}
