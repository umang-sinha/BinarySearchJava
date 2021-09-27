//In a nearly sorted array, the element that should have been at index i can be at any of i , i+1 or i-1 position

public class SearchInNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70};
        System.out.println(searchInNearlySortedArray(arr, 50));
    }

    //takes a nearly sorted array as input and searches for x inside it. If found returns corresponding index else returns -1
    public static int searchInNearlySortedArray(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(mid - 1 >= start && arr[mid - 1] == x){
                return mid - 1;
            }
            else if(mid + 1 <= end && arr[mid + 1] == x){
                return mid + 1;
            }
            else if(arr[mid] >= x){
                end = mid - 2;
            }
            else if(arr[mid] <= x){
                start = mid + 2;
            }
        }
        return -1;
    }
}
