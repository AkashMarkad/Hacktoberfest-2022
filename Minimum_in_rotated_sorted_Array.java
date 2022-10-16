import java.util.*;

class TUF{
public static void main(String args[]) {
  int nums[] = {4,5,1,2,3};
  int i;
  int left = 0, right = 4, minVal = Integer.MAX_VALUE;

  while (left <= right) {
    if (nums[left] < nums[right]) {
      minVal = Math.min(minVal, nums[left]);
      break;
    }
    int mid = left + (right - left) / 2;

    if (nums[left] <= nums[mid]) {
      minVal = Math.min(minVal, nums[left]);
      left = mid + 1;
    } else {
      minVal = Math.min(minVal, nums[mid]);
      right = mid - 1;
    }
  }
  System.out.println("Minimum Value is "+minVal);
}
}