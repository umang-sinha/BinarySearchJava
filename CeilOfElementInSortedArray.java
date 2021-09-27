public class CeilOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(findCeilOfElementInSortedArray(arr, 20));
    }

    //takes a sorted array as input and returns the ceiling of x. If ceiling doesn't exist, returns -1
    //Here ceiling means the smallest element in the array which is greater than x
    public static int findCeilOfElementInSortedArray(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                res = arr[mid];
                return res;
            }
            else if(arr[mid] > x){
                res = arr[mid];
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }
}
