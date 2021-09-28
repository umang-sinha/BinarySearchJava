public class FirstOneInBinarySortedInfiniteArray {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 };
        System.out.println(findFirstOneInBinarySortedInfiniteArray(arr));
    }

    //takes an infinitely long sorted array containing only 0's and 1's and returns index of the first 1.
    public static int findFirstOneInBinarySortedInfiniteArray(int[] arr){
        int start = 0;
        int end = 1;
        int res = -1;
        while(1 > arr[end]){
            start = end;
            end = end * 2;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == 1){
                res = mid;
                end = mid - 1;
            }
            else if(arr[mid] < 1){
                start = mid + 1;
            }
        }
        return res;
    }
}
