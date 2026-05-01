class Solution {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    void sort(int[] nums, int start, int end){
        if(start == end) return;
        int mid = (start + end)/2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
    void merge(int[] nums, int start, int mid, int end){
        int l1 = mid - start + 1;
        int l2 = end - mid;

        int[] left = new int[l1];
        int[] right = new int[l2];

        for(int i = 0; i < l1; i++)  left[i] = nums[start + i];
        for(int i = 0; i < l2; i++) right[i] = nums[mid + i + 1];

        int x = 0, y = 0;

        while(x < l1 && y < l2){
            if(left[x] < right[y]){
                nums[start] = left[x];
                x++;
            } else {
                nums[start] = right[y];
                y++;
            }
            start++;
        }

        while(x < l1){
            nums[start] = left[x];
            start++;
            x++;
        }

        while(y < l2){
            nums[start++] = right[y++];
        }
    }
}