package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 桶排序
 */
public class BucketSort {
    public void bucketSort(int[] A) {
        //1. 构造桶
        //1.1 确定桶的个数n
        int n = A.length;
        //1.2 声明并初始化一个List，存放链表；
        List<ArrayList<Integer>> Blist = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            Blist.add(new ArrayList<Integer>(5));
        //2.将数组中的元素放到桶中
        //2.1 确定元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        //2.2 确定每个元素放入桶的编号并放进去
        for (int i : A) {
            //2.2.1 确定桶的编号
            int len = A.length;
            //加1是为了保证index< A.length，防止程序抛出IndexOutofBoundsEx;
            int index = (int) ((i - min) / (max - min + 1.0) * A.length);
            //2.2.2 放入对应的桶中
            Blist.get(index).add(i);
        }
        //3.桶内排序
        for (int i = 0; i < Blist.size(); i++) {
            java.util.Collections.sort(Blist.get(i));
        }
        //4.合并数据
        int j = 0;
        for (ArrayList<Integer> arr : Blist) {
            for (int i : arr) {
                A[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        BucketSort s = new BucketSort();
        int[] arrays = new int[]{5, 3, 6, 2, 1, 24, 4, 8, 7};
        System.out.println("未排序的数组：" + Arrays.toString(arrays));
        s.bucketSort(arrays);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));

    }


    /**
     * 简易桶排序
     * @param args
     */
//        public static void main(String[] args) {
//
//            int[] scores=new int[11];//定义一个空间大小为11的变量 0-10即11个
//            Scanner input = new Scanner(System.in);//控制台等待输入
//            for(int i=0;i<=10;i++){    //初始化scores值为0
//                scores[i]=0;
//            }
//            System.out.println("请输入数字");
//            for(int j=1;j<=5;j++){    //循环输入
//                int t=input.nextInt();
//                scores[t]++;//计数
//            }
//            System.out.println("**************");
//            for(int a=0;a<=10;a++){   //依次判断每个成绩
//                for(int b=1;b<=scores[a];b++){   //依次判断每个成绩的人数
//                    System.out.println(a);
//                }
//            }
//        }
}
