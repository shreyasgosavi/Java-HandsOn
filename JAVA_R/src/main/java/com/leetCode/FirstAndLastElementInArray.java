package com.leetCode;

public class FirstAndLastElementInArray {


    public static int firstLastOccurence(int[] nums, int target, int start, int end, int flag, int occurence) {

        if (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                return firstLastOccurence(nums, target, mid + 1, end, flag, occurence);
            } else if (nums[mid] > target) {
                return firstLastOccurence(nums, target, start, mid - 1, flag, occurence);
            } else {
                occurence = mid;
                //First Occurence
                if (flag == 0) {
                    return firstLastOccurence(nums, target, start, mid - 1, flag, occurence);
                } else {
                    return firstLastOccurence(nums, target, mid + 1, end, flag, occurence);
                }
            }

        } else {
            return occurence;
        }


    }

    public static int[] searchRange(int[] nums, int target) {

        int[] index = {-1, -1};

        if(nums.length >0) {
            int[] soln = findElementInAnArray(nums, 0, nums.length-1, target);

            if (soln[0] == -1) {
                return index;
            } else {

                int firstOcc = firstLastOccurence(nums, target, soln[1], soln[2], 0, -1);
                int secondOcc = firstLastOccurence(nums, target, soln[1], soln[2], 1, -1);

                if (firstOcc == -1) {
                    index[0] = soln[0];
                } else {
                    index[0] = firstOcc;
                }

                if (secondOcc == -1) {
                    index[0] = soln[0];
                } else {
                    index[1] = secondOcc;
                }


            }
        }
        return index;
    }

    public static int[] findElementInAnArray(int[] nums, int start, int end, int target) {

        if ( (start <= end) && (end < nums.length)) {
            int mid = (start + end) / 2;

            if (target > nums[mid]) {
                return findElementInAnArray(nums, mid + 1, end, target);
            } else if (target < nums[mid]) {
                return findElementInAnArray(nums, start, mid - 1, target);
            } else {
                int[] finalVal = {mid, start, end};
                return finalVal;
            }
        } else {
            int[] finalVal = {-1, start, end};
            return finalVal;
        }
    }

    public static void main(String[] args) {
        int[] i = {5,7,7,8,8,10};

        String s= "ssdsd";


        int[] soln = searchRange(i, 8);
        System.out.println(soln);
    }
}
