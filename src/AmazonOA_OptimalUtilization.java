import java.util.*;

public class AmazonOA_OptimalUtilization {
    public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<List<Integer>>> res = new HashMap<>();
        int len1 = forwardRouteList.length;
        int len2 = returnRouteList.length;
        if (len1 < 1 || len2 < 1) return ans;

        int left = 0, right = len2 -1, maxVal = -1;
        while(left < len1 && right >= 0){
            int sum = forwardRouteList[left][1] + returnRouteList[right][1];
            if (sum > maxTravelDist){
                right -= 1;
                continue;
            }
            if(sum >= maxVal){
                maxVal = sum;
                res.putIfAbsent(sum, new ArrayList<>());

                int r = right;
                while(r >= 0  && returnRouteList[r][1] == returnRouteList[right][1]){
                    List<Integer> list = new ArrayList<>();
                    list.add(forwardRouteList[left][0]);
                    list.add(returnRouteList[r][0]);
                    res.get(sum).add(list);
                    r -= 1;
                }
            }
            left += 1;
        }
        return res.get(maxVal);

    }
}
