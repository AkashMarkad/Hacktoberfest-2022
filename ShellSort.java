class ShellSort {

    public static void main(String args[]) {
        int arr[] = {12,43,52,84,53,58,92,68,8};
        ShellSort ob = new ShellSort();
        ob.sort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    int sort(int arr[]) {
        int n = arr.length;
  
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return 0;
    }
}