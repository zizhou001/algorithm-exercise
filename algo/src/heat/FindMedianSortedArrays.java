package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-14 9:22
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays s = new FindMedianSortedArrays();
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;

        int i = 0;  //nums1指针
        int j = 0;  //nums2指针
        int k = 0;  //合并后数组指针
        int targetIdx = 0;
        int cur = 0;
        boolean isOdd = false;
        if (len % 2 == 0) {
            targetIdx = len / 2 - 1;
            isOdd = true;
        } else targetIdx = len / 2;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) cur = nums1[i++];
            else cur = nums2[j++];
            if (k == targetIdx) {
                if (isOdd) {
                    if (i >= len1) {
                        return (double)(cur + nums2[j]) / 2;
                    } else if (j >= len2) {
                        return (double)(cur + nums1[i]) / 2;
                    } else {
                        return (double)(cur + Math.min(nums1[i], nums2[j])) / 2;
                    }
                } else return cur;
            }
            ++k;
        }
        while (i < len1) {
            cur = nums1[i++];
            if (k == targetIdx) {
                if (isOdd) {
                    return (double) (cur + nums1[i]) / 2;
                } else return cur;
            }
            ++k;
        }
        while (j < len2) {
            cur = nums2[j++];
            if (k == targetIdx) {
                if (isOdd) {
                    return (double) (cur + nums2[j]) / 2;
                } else return cur;
            }
            ++k;
        }
        return cur;
    }
}
