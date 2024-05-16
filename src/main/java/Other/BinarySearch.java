package Other;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] parts = {8, 3, 7, 9, 2};
        int[] targets = {5, 7, 9};

        Arrays.sort(parts);

        for(int target : targets) {
            if(BinarySearch(parts, target, 0, parts.length - 1))
                System.out.print("yes ");

            else System.out.print("no ");
        }

    }

    private static boolean BinarySearch(int[] parts, int target, int start, int end){
        while(start <= end) {
            int mid = (start + end) / 2;

            if(parts[mid] == target) return true;

            else if(parts[mid] > target) end = mid - 1;

            else start = mid + 1;
        }

        return false;
    }
}
