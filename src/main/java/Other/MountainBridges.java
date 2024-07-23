package Other;

import java.util.*;

public class MountainBridges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        // 높이별로 인덱스를 그룹화
        Map<Integer, List<Integer>> heightMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            heightMap.putIfAbsent(heights[i], new ArrayList<>());
            heightMap.get(heights[i]).add(i);
        }

        int totalBridges = 0;

        // 각 높이에 대해 슬라이딩 윈도우로 가능한 다리 수 찾기
        for (Map.Entry<Integer, List<Integer>> entry : heightMap.entrySet()) {
            List<Integer> positions = entry.getValue();
            if (positions.size() < 2) continue; // 동일 높이의 산이 2개 미만이면 다리 불가

            for (int i = 0; i < positions.size(); i++) {
                int left = positions.get(i);
                int right = i + 1;
                while (right < positions.size()) {
                    int rightPos = positions.get(right);
                    boolean canBuild = true;
                    // 중간 산들의 높이가 현재 높이보다 낮은지 확인
                    for (int k = left + 1; k < rightPos; k++) {
                        if (heights[k] >= heights[left]) {
                            canBuild = false;
                            break;
                        }
                    }
                    if (canBuild) {
                        totalBridges++;
                    }
                    right++;
                }
            }
        }

        // 결과 출력
        System.out.println(totalBridges);

        scanner.close();
    }
}
