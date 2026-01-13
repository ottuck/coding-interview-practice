// LeetCode 46 Permute
package jav.exhaustive_serch;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), used, nums, result);
        return result;
    }

    private void backtrack(
        List<Integer> path, // 여기에 완성시켜가는 순열을 차례대로 저장하게 된다
        boolean[] used, // 한번 선택한 숫자를 이미 path에 썼는지 기록하는 역할
        int[] nums, 
        List<List<Integer>> result
    ) {
        // base case: nums 길이의 순열 완성할 때
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // 복사해서 저장
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.add(nums[i]);
            backtrack(path, used, nums, result);
            path.remove(path.size() - 1);

            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutation.permute((nums));

        System.out.println(result);
    }
}

/**
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtract(res,new ArrayList<>(),nums);
        return res;
    }
    public static void backtract(List<List<Integer>> res,ArrayList<Integer> temp,int[] arr){
        if(temp.size()==arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int num:arr){
            if(!temp.contains(num)){
                temp.add(num);
                backtract(res,temp,arr);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
 */
