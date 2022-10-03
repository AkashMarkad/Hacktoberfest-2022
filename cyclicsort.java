// used in 1 to N problem
import java.util.*;
public class cyclicsort{
    public static void main(String args[]){
        int[] arr = {1,5,4,3,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int i=0;
        while (i<arr.length) {
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp  = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }
    }
}