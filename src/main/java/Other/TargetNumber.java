package Other;
public class TargetNumber {
    static int count = 0;

    public static int solution(int[] numbers, int target) {
        DFS(numbers, 0, 0, target);
        return count;
    }

    public static void DFS(int[] numbers, int level, int sum, int target){
        if(level == numbers.length){
            if(target == sum) count++;
        }

        else{
            DFS(numbers, level + 1, sum + numbers[level], target);
            DFS(numbers, level + 1, sum + (-1) * numbers[level], target);
        }
    }
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(solution(numbers, target));
    }
}
