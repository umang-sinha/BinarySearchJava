public class MinimumDifferenceElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19, 23};
        System.out.println(findMinimumDifferenceElement(arr, 11));
    }

    //takes a sorted array as input and returns the element that gives the minimum absolute difference with x
    public static int findMinimumDifferenceElement(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){ //if x is present in the array, the minimum absolute difference will be zero
                return arr[mid];
            }
            else if(arr[mid] < x){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        //if x is not present in the array then the minimum absolute difference will be either one of the elements at index position 'start' or 'end' at the end of the binary seach while loop
        if(Math.abs(arr[start] - x) >= Math.abs(arr[end] - x)){
            return arr[end];
        }
        else{
            return arr[start];
        }
    }
}
