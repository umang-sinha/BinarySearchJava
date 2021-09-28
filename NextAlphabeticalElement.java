public class NextAlphabeticalElement {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h'};
        System.out.println(findNextAlphabet(arr, 'c'));
    }

    //takes a sorted array of char as input and returns the smallest char greater than x present in the array. Returns '#' when not present
    public static char findNextAlphabet(char[] arr, char x){
        int start = 0;
        int end = arr.length - 1;
        char res = '#';
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                start = mid + 1;
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
