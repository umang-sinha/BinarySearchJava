public class LastOccurrence{
    public static void main(String[] args) {
        int[] arr = { 12, 13, 13, 14, 14, 15, 17, 19, 23, 24, 24, 24 };
        int x = 24;
        System.out.println(findLastOccurrence(arr, x));
    }

    
    /*
     * performs a binary search for element x on the array and returns the index of
     * the last occurrence of x. Returns -1 if not found
     */
    public static int findLastOccurrence(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2; // defining mid this way rather than doing (start+end)/2 helps prevent overflows
            if(arr[mid] == x){
                res = mid;
                start = mid + 1;
            } else if(arr[mid] < x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}