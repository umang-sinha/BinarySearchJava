public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println(searchInInfiniteSortedArray(arr, 13));
    }

    //takes an infinitely long sorted array as input and returns the position of element x in it. If absent, returns -1 
    public static int searchInInfiniteSortedArray(int[] arr, int x){
        int start = 0;
        int end = 1;
        while(x > arr[end]){
            start = end;
            end = end * 2;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
