package Programmers.greedy;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>{
    int attitude;
    int review;
    int sum;

    public Employee(int attitude, int review){
        this.attitude = attitude;
        this.review = review;
        this.sum = this.attitude + this.review;
    }

    @Override
    public int compareTo(Employee e) {
        if(this.review != e.review)
            return Integer.compare(this.review, e.review);

        else return Integer.compare(this.attitude, e.attitude);
    }
}

public class PerformanceReview {
    public static int solution(int[][] scores){
        int answer = 1;
        int threshold = 0;

        ArrayList<Employee> employee_score = new ArrayList<>();
        Employee WanHo = new Employee(scores[0][0], scores[0][1]);
        int wanho_sum = WanHo.attitude + WanHo.review;

        for(int i = 1; i < scores.length; i++){
            employee_score.add(new Employee(scores[i][0], scores[i][1]));
        }

        Collections.sort(employee_score);

        for(Employee employee : employee_score){
            if(WanHo.attitude < employee.attitude && WanHo.review < employee.review)
                return -1;

            if (threshold <= employee.review){
                if(wanho_sum < employee.sum)
                    answer++;
                threshold = employee.review;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        System.out.println(solution(scores));
    }
}
