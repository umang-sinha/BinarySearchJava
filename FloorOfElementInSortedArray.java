public class FloorOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(findFloorOfElementInSortedArray(arr, 0));
    }

    //takes a sorted array as input and returns the floor of x. If floor doesn't exist, returns -1
    //Here floor means the greatest element in the array which is smaller than x
    public static int findFloorOfElementInSortedArray(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                res = arr[mid];
                return res;
            }
            else if(arr[mid] < x){
                res = arr[mid];
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return res;
    }
}
