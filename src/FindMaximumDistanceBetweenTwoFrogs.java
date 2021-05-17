/*
 *https://stackoverflow.com/questions/63132225/maximum-distance-two-frogs-can-create-by-starting-at-any-index-in-a-list-in-on
 */
public class FindMaximumDistanceBetweenTwoFrogs {

    public static void main(String[] args) {
        /*int[] arr = {2, 6, 8, 5};
        int[] arr = {1,5,5,2,6};*/

        int[] arr = {1, 1};
        // save the current height as the start of the array
        int currentHeight = arr[0];
        int max = 0;
        int prevPeak = 0;
        int i = 0;
        boolean goingUp = false;
        int currentPeakStart = 0;

        while (i < arr.length - 1) {
            if ((!goingUp && currentHeight >= arr[i + 1]) || (goingUp && currentHeight <= arr[i + 1])) {
                // if the current height == next height then
                // don't save the currentPeakStart as this peak started in a previous node.
                if (goingUp && currentHeight < arr[i + 1]) {
                    currentPeakStart = i + 1;
                }
                currentHeight = arr[i + 1];
                i++;
            }
            // if we are going down and the next node is higher than the current then we have reached a
            // valley in the histogram. we now need to make our way up to the next peak.
            else if (!goingUp) {
                goingUp = true;
            }
            // if we are going up and the next node is now lower, this indicates we have reached the next peak.
            else if (goingUp) {
                // distance between the current peak and previous peak.
                int distance = i - prevPeak;
                // save max
                max = Math.max(max, distance);

                // if the start of the peak is not the current location, then override the prev peak as the start of the peak.
                // this is the corner case for when you have multiple adjacent matching heights as the peak;
                // [5, 5]. We don't want to save the second 5's location as the prev peak,
                // we want the first location as the prevPeak.
                if (i != currentPeakStart) {
                    prevPeak = currentPeakStart;
                } else {
                    prevPeak = i;
                }

                // reached peak so that means the next step is to walk down the slope.
                goingUp = false;
            }
        }

        // final calculation as the last location in the histogram is the final peak.
        int d = i - prevPeak;
        max = Math.max(max, d);

        System.out.println(max + 1);
    }
}
