import java.util.ArrayList;
import java.util.Arrays;

public class recursionBasics {

    public static void main(String[] args) {
//        int[] arr = {29, 30, 34, 35, 36, 37, 44, 54, 54, 54, 54, 69, 78, 88};
//        String str = "HelloSonam";
//       printingStart(1,6);
//       printingEnding(6);
//        System.out.println(sum(5));
//        System.out.println(factorial(5));
//        System.out.println(sumOfDigits(1234));
//        System.out.println(digitsProduct(0));
//        System.out.println(countDigits(0, 184329345));
//            even(1, 7);
//        System.out.println(fiboNumber(9));
//        printArr(arr,0);
//        System.out.println(findFirstIndex(arr,0,54));
//        System.out.println(findLastIndex(arr,arr.length -1 , 54));
//        System.out.println(findAllIndex(arr,0,54,new ArrayList<Integer>()));
//        System.out.println(sortedArray(arr,0));
//        System.out.println(arrSum(arr,arr.length -1));
//        System.out.println(maxVal(arr,arr[0],0));
//        System.out.println(linearSearch(arr,54,0));
//        printDigitsRev(34889);
//        System.out.println(countZeroes(8907008));
//        System.out.println(reverse(123, 0));
//        System.out.println(palindrome(1221));
//        printDigits(123);
//       fiboSeq(0, 1, 8); // count = n
//        System.out.println(validFibo(0,1,8,83));
//        System.out.println(removeA(str,new StringBuilder(),0));
//        System.out.println(removeChar(str, new StringBuilder(),0, 'e'));
//        skipCharacter("","sidhanttaneja");
//        skipApple("","bcdapplejapplejoik");

//        int[] arr = {5,8,10,3,1};
//        System.out.println(Arrays.toString(arr));
//        sortArr(arr,arr.length);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(gcd(62, 8));

//        int[] arr = {2,4,5,23,1,3,45,1};
//        int[] arr2 = {1,2,3,4,5,5,56,2390,3200};
//        System.out.println(rotatedBinarySearch(arr2, 2390, 0, arr2.length - 1));


    }

    // Rotated Binary search :

    public static int rotatedBinarySearch(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = start + (end - start ) / 2;
        if(arr[mid] == target) return mid;
        if(arr[start] < arr[mid]){
            if(target > arr[start] && target < arr[mid]) return rotatedBinarySearch(arr, target, start, mid - 1);
            return rotatedBinarySearch(arr, target, mid + 1, end);
        }
        else{
            if(target > arr[mid] && target < arr[end]) return rotatedBinarySearch(arr, target, mid + 1, end);
            else{
                return rotatedBinarySearch(arr, target, start, mid - 1);
            }
        }
    }


    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        else {
            return gcd(b, a % b);
        }
    }

    public static void sortArr(int[] arr, int n){
        if(n <= 1) return;

        sortArr(arr, n - 1);

        int lastElement = arr[n - 1];
        int i = n - 2;

        while(i >= 0 && arr[i] > lastElement){
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = lastElement;
    }
    public static void skipApple(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        if(up.startsWith("apple")){
            skipApple(p,up.substring(5));
        }
        else{
            skipApple(p + up.charAt(0), up.substring(1));
        }
    }
    public static void skipCharacter(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            skipCharacter(p, up.substring(1));
        } else {
            skipCharacter(p + ch, up.substring(1));
        }
    }
    public static String removeChar(String str, StringBuilder builder, int index, char ch){
        if(index == str.length()) return builder.toString();

        if(str.charAt(index) != ch) builder.append(str.charAt(index));

        return removeChar(str,builder,index + 1, ch);

    }
    public static String removeA(String str, StringBuilder builder, int index){
        if(index == str.length()) return builder.toString();

        if(str.charAt(index) != 'a') builder.append(str.charAt(index));

        return removeA(str,builder,index + 1);
    }
    public static boolean validFibo(int a, int b, int count, int target){
        if(a == target) return true;
        if(a > target) return false;
        return validFibo(b, a + b, count - 1, target);
    }
    public static void fiboSeq(int a, int b, int count){
        // here a = current number to print
        // here b = the next number
        // here count = number of times to print the sequence(n)

        if(count == 0) return;

        System.out.println(a + " ");    // we print the current number
        fiboSeq(b, a + b, count -1);
        // visualization :
        // fibonacci(current) = fib(n - 1) + fib(n - 2)
        // so this is why we do "a + b" think about it like this
        // if a = 2 and b = 3 so what should be the fibonacci number 5 right?
        // and to proceed b becomes the new a(current) in this case b = 3 so now for the next call a = 3
        // and b becomes a + b which is the fibonacci number 5
        // so now print 3 and do 5 + 3 to get b for the next step
    }
    public static void printDigits(int n){
        if(n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }
    public static boolean palindrome(int n){
        return (n == reverse(n, 0));
    }
    public static int reverse(int n, int rev){
        if(n == 0) return rev;
        rev = (rev * 10)+ n % 10;
        return reverse(n/10 , rev);
    }
    public static int countZeroesHelper(int n, int count){
        if(n == 0) return count;

        if(n % 10 == 0) return countZeroesHelper(n / 10, count + 1);
        return countZeroesHelper(n / 10, count);
    }
    public static int countZeroes(int n){
        if(n == 0) return 1;
        return countZeroesHelper(n, 0);
    }
    public static void printDigitsRev(int n){
        if(n == 0) return;
        System.out.println(n % 10);
        printDigitsRev(n / 10);
    }
    public static int linearSearch(int[] arr, int target, int index){
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;
        return linearSearch(arr,target,index + 1);
    }
    public static int maxVal(int[] arr,int max, int index){
        if(index == arr.length) return max;
        if(arr[index] > max) max = arr[index];
        return maxVal(arr,max,index + 1);
    }
    public static int arrSum(int[] arr, int index){
        if(index == 0) return arr[index];
        return arr[index] + arrSum(arr,index - 1);
    }
    public static boolean sortedArray(int[] arr, int index){
        if(index == arr.length - 1) return true;
        if(arr[index] > arr[index + 1]) return false;
        return sortedArray(arr,index + 1);
    }
    public static ArrayList<Integer> findAllIndex(int[] arr, int index, int target, ArrayList<Integer> list){
        if(index == arr.length) return list;
        if(arr[index] == target) list.add(index);

        return findAllIndex(arr,index + 1,target,list);
    }
    public static int findLastIndex(int[] arr,int index,int target){
        if(index == 0) return -1;
        if(arr[index] == target) return index;

        return findLastIndex(arr,index - 1,target);
    }
    public static int findFirstIndex(int[] arr,int index,int target){
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;

        return findFirstIndex(arr,index + 1,target);
    }
    public static void printArr(int[] arr,int index){
        if(index == arr.length -1) return;

        System.out.println(arr[index]);
        printArr(arr,index + 1);
    }


    public static int fiboNumber(int n){
        if(n <= 1) return n;
        return fiboNumber(n - 1) + fiboNumber(n - 2);
    }

    public static void even(int index, int n){
        if(index > n) return;

        if(index % 2 == 0){
            System.out.println(index);
        }
        even(index + 1, n);
    }
    public static int countDigits(int count, int n){
        if(n == 0) return count;
        return countDigits(count + 1, n / 10);
    }
    public static int digitsProduct(int n){
        if(n < 10) return n;
        return (n % 10) * digitsProduct(n / 10);
    }
    public static int sumOfDigits(int n){
        if(n <= 1) return n;

        return (n % 10) + sumOfDigits(n / 10);
    }
    public static int factorial(int n){
        if(n <= 1) return n;
        return n * factorial(n - 1);
    }
    public static int sum(int n){
        if(n <= 1) return n;
        return n + sum(n - 1);
    }
    public static int printingEnding(int n){
        System.out.println(n);
        if(n <= 1) return 1;
        return printingEnding(n - 1);
    }
    public static int printingStart(int i ,int n){
        if(i > n) return i;
        System.out.println(i);
        return printingStart(i + 1, n);
    }

}
