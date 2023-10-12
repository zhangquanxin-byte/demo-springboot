package zhaohang;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param times string字符串ArrayList
     * @return string字符串ArrayList
     */
    public static ArrayList<String> timeSort(ArrayList<String> times) {
        times.sort((o1, o2) -> {
            //比较秒数
            int cpSecond = o1.substring(6, 8).compareTo(o2.substring(6, 8));
            if (cpSecond != 0) {
                return cpSecond;
            }

            //比较分钟
            int cpMinute = o1.substring(3, 5).compareTo(o2.substring(3, 5));
            if (cpMinute != 0) {
                return cpMinute;
            }

            //比较小时
            int cpHour = o1.substring(0, 2).compareTo(o2.substring(0, 2));
            if (cpHour != 0) {
                return cpHour;
            }
            return 0;
        });


        return times;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param N int整型 字符串的长度
     * @return int整型
     */
    public static int validNum(int N) {
        //总计数
        int totalNum = N;

        //考虑c出现的次数, N长度的字符串中c出现的次数必然小于等于N/2，否则必然有两个c相邻
        int cNum = N % 2 == 0 ? N % 2 : N % 2 + 1;
        for (int i = 2; i <= cNum; i++) {
            for (int j = 0; j < N; j++) {
                int[] ints = new int[cNum];
                ints[0] = j;
                totalNum += sum(N, i, 1, ints);
            }
        }

        return totalNum;
    }

    public static int sum(int N, int cNum, int chooseC, int[] cLocation) {
        if (chooseC + 1 == cLocation.length) {
            if (cNum == 0) {
                return N;
            }

            int cc = N - cLocation[chooseC - 1] - 1;
            return cc > 0 ? cc : 0;
        }

        if (cLocation[chooseC]+2 >=N){
            return 0;
        }
        cLocation[chooseC+1] = cLocation[chooseC]+2;
        return sum(N, cNum, chooseC+1, cLocation);

    }


    public static void main(String[] args) {
       /* ArrayList<String> times = new ArrayList<>();
        times.add("12:30:10");
        times.add("12:15:10");
        times.add("11:20:14");
        times.add("09:20:14");
        times.add("11:14:14");
        times.add("11:20:00");
        timeSort(times);
        System.out.println("times = " + times);*/

        int total = validNum(3);
        System.out.println("total = " + total);
    }


}
