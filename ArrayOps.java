public class ArrayOps {
    public static void main(String[] args) {
        
    }
    
    public static int findMissingInt (int [] array) {
        int n = array.length + 1;
        // #feedback - you can iterate only once and calcualte both sums.
        int expectedSum = 0;
        for (int i = 0; i < n; i++) {
            expectedSum += i;
        }
        
        int actualSum = 0;
        for (int i = 0; i < array.length; i++) {
            // #feedback - this assignment to the variable num is not needed, you can do - "actualSum += array[i]"
            int num = array[i];
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int secondMax = array[1];

        if (secondMax > max) {
            int temp = max;
            max = secondMax;
            secondMax = temp;
        }

        for (int i = 2; i < array.length; i++) {
            int num = array[i];
            if (num > max) {
                secondMax = max;
                max = num;
            
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        // #feedback - both arrays don't have to be the same length.
        if (array1.length != array2.length) {
            return false;
        }

        // #feedback - there is no need to assume the range. You can just iterate on the arrays and keep a boolean variable to indicate if there is a number missing.
        int[] countArray = new int[1001]; // Assuming integers in the range 0 to 1000

        // Count the occurrences in array1
        for (int i = 0; i < array1.length; i++) {
            int num = array1[i];
            countArray[num]++;
        }

        // Decrease according to the occurrences in array2
        for (int i = 0; i < array2.length; i++) {
            int num = array2[i];
            countArray[num]--;
        }

        // #feedback - the number of times a number is in one array doesn't have to be the same for the other. Only that the number exists in the other array.
        // Check if all counts are zero
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(int [] array) {
        boolean increasing = true;
        boolean decreasing = true;

        // Check for increasing order
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                increasing = false;
                break;
            }
        }

        // Check for decreasing order
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
                break;
            }
        }

        return (increasing || decreasing);
    }

}
