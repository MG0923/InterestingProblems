/*There are 10 players standing in a row and 1 player on a field.
 * Each player can move up(^), down(v), right(>), left(<)
 * Need to find out total number of moves possible in a given input*/
public class TotalMovesPossibleInASampleString {
    public static void main(String[] args) {
       /* String sample = "><^v";
        String sample = "<>>><";
        String sample = "1234";*/
        String sample = "<<^<v>>";
        int length = sample.length();
        int[] arr = new int[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (sample.charAt(i) == '>') {
                if (i != length - 1) {
                    if (arr[i + 1] == 1) {
                        count++;
                        arr[i] = 1;
                        arr[i + 1] = 0;
                    }
                } else if (i == length - 1) {
                    count++;
                    arr[i] = 1;
                }
            } else if (sample.charAt(i) == '<') {
                if (i != 0) {
                    if (arr[i - 1] == 1) {
                        count++;
                        arr[i] = 1;
                        arr[i - 1] = 0;
                    }
                } else if (i == 0) {
                    count++;
                    arr[i] = 1;
                }
            } else if (sample.charAt(i) == 'v' || sample.charAt(i) == '^') {
                count++;
                arr[i] = 1;
            }
        }
        System.out.println(count);
    }
}
