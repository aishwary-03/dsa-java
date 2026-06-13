package com.dsa.patterns.binarysearch;

public class FindInMountainArray {

    interface MountainArray {
         int get(int index);
         int length();
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        int[] mountainArr = {0,1,2,4,2,1};
        int target = 3;
        System.out.println(findInMountainArray.findInMountainArray(target, new MountainArray() {

            @Override
            public int get(int index) {
                return mountainArr[index];
            }

            @Override
            public int length() {
                return mountainArr.length;
            }
        }));
    }

    private int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int low = 0;
        int high = length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int mountainIndex = low;
        low = 0;
        high = mountainIndex;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = mountainIndex;
        high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            if (val < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
