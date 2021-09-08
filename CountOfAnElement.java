public class CountOfAnElement{
    public static void main(String[] args) {
        int[] arr = { 12, 13, 13, 14, 14, 15, 17, 19, 23, 24, 24, 24 };
        int x = 4;
        System.out.println(countOfElement(arr, x));
    }

    /*
     * performs a binary search on the array for the element x
     * and finds the first and last occurrence of it. Then uses these
     * indices to find the number of times x occurs in the array.
     * Returns -1 if x is not present in the array.
     */  
    public static int countOfElement(int[] arr, int x){
        if(findFirstOccurrence(arr, x) != -1 && findLastOccurrence(arr, x) != -1){
            return findLastOccurrence(arr, x) - findFirstOccurrence(arr, x) + 1; 
        }
        else{
            return -1;
        }
    }

    /*
     * performs a binary search for element x on the array and returns the index of
     * the first occurrence of x. Returns -1 if not found
     */
    public static int findFirstOccurrence(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int firstOccurrence = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // defining mid this way rather than doing (start+end)/2 helps prevent overflows
            if (arr[mid] == x) {
                firstOccurrence = mid;
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstOccurrence;
    }

    /*
     * performs a binary search for element x on the array and returns the index of
     * the last occurrence of x. Returns -1 if not found
     */
    public static int findLastOccurrence(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int lastOccurrence = -1;
        while(start <= end){
            int mid = start + (end - start)/2; // defining mid this way rather than doing (start+end)/2 helps prevent overflows
            if(arr[mid] == x){
                lastOccurrence = mid;
                start = mid + 1;
            } else if(arr[mid] < x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastOccurrence;
    }
}