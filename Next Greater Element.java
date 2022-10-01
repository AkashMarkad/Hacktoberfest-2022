// Next Greater Element 

// Given array we need to find the frist greter elemnt on right

// Approach 1: Brute Force
// Use For loop and check entire array for the first greater element on right 

// Time Complexity- O(n*n)
// Space Complexity - O(1)

// Approach 2: Use Stack

// Time Complexity - O(2n)
// Space Compelxity- o(n)

// Code:

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=n-1;i>=0;i--){
            
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }
            
            if(i<n){
                if(!st.isEmpty()){
                    hm.put(nums2[i], st.peek());
                }
                else{
                    hm.put(nums2[i] , -1);
                }
            }
            
            st.push(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++){
            if(hm.containsKey(nums1[i])){
                ans[i] = hm.get(nums1[i]);
            }
        }
        
        return ans;
    }
}
