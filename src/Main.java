public class Main {

    public static void main(String[] args) {
        int[] tab1 = {3, 2, -2, 5, -3};
        int[] tab2 = {1, 1, 7, 2, -1, 2, -1, -7};
        int[] tab3 = {1, 2, 3, -4};
        int[] tab4 = {1, 1};

        findHighestAbsolutePair(tab1);
        findHighestAbsolutePair(tab2);
        findHighestAbsolutePair(tab3);
        findHighestAbsolutePair(tab4);
    }

    private static void findHighestAbsolutePair(int[] array) {
        if (array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int maxVal = 0;
        // Find maximum absolute value to size our arrays
        for (int num : array) {
            maxVal = Math.max(maxVal, Math.abs(num));
        }

        boolean[] positive = new boolean[maxVal + 1];
        boolean[] negative = new boolean[maxVal + 1];

        // Populate the arrays
        for (int num : array) {
            if (num >= 0) {
                positive[num] = true;
            } else {
                negative[-num] = true;
            }
        }

        // Find the highest absolute pair
        for (int i = maxVal; i > 0; i--) {
            if (positive[i] && negative[i]) {
                System.out.println("The returned result is a pair of " + i + " and |-" + i + "|");
                return;
            }
        }

        // If no pair found
        System.out.println("No pair found in the array.");
    }
}
