package Test;

public class tastDemo6 {
    public static void main(String[] args) {
        // 1、定义一个数组存储需要加密的数据
        int[] arr = new int[]{1, 9, 8, 3};

        // 2、遍历数组中的每个数据，按照规则进行修改
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + 5) % 10;
        }

        // 3、把数组中的元素进行反转操作。
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            // 交换 i 和 j位置处的值，即可反转
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        // 4、遍历数组中的每个元素输出即可
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
