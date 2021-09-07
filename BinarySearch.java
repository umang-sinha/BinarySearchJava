public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        int x = 17;
        System.out.println(binarySearch(arr, x));
    }

    //performs a binary search on the array to find the element x and returns the corresponding index. If not found, returns -1 (the input array should be sorted)
    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2; //defining mid this way rather than doing (start+end)/2 helps prevent overflows
            if(arr[mid] == x){
                return mid;
            }
            else if (arr[mid] < x){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}