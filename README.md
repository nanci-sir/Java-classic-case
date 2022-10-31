# Java-classic-case
# 1.评委打分

案例 需求 :  在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。选手的最后得分为：去掉最 高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。

```java
package Test;
import java.util.Scanner;
public class tastDemo5 {
    public static void main(String[] args) {
/**
 需求：在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
 选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。
 */

                // 1、定义一个动态初始化的数组，用于后期录入6个评委的分数
                int[] scores = new int[6];

                // 2、录入6个评委的分数
                Scanner sc = new Scanner(System.in);
                for (int i = 0; i < scores.length; i++) {
                    System.out.println("请您输入第" + (i + 1) +"个评委的打分：");
                    int score = sc.nextInt();
                    // 3、把这个分数存入到数组的对应位置处
                    scores[i] = score;
                }

                // 3、遍历数组中的每个数据，找出最大值 最小值 总分
                // int max = scores[0] , min = scores[0] , sum = 0;
                int max = scores[0] ;
                int min = scores[0] ;
                int sum = 0;
                for (int i = 0; i < scores.length; i++) {
                    if(scores[i] > max){
                        // 替换最大值变量存储的数据
                        max = scores[i];
                    }

                    if(scores[i] < min){
                        // 替换最小值变量存储的数据
                        min = scores[i];
                    }

                    // 统计总分
                    sum += scores[i];
                }
                System.out.println("最高分是：" + max);
                System.out.println("最低分是：" + min);
                // 4、统计平均分即可
                double result = (sum - max - min) * 1.0 / (scores.length - 2);
                System.out.println("选手最终得分是：" + result);
            }
        }
```

.如何实现评委打分案例？

 ① 定义一个动态初始化的数组用于存储分数数据。 ② 定义三个变量用于保存最大值、最小值和总和。 ③ 遍历数组中的每个元素，依次进行统计。 ④ 遍历结束后按照规则计算出结果即可。

# 2.数字加密

 需求： 某系统的数字密码，比如1983，采用加密方式进行传输，规则如下：先得到每位数，然后每位数都加上 5 , 再对10求余，最后将所有数字反转，得到一串新数

```java
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
```

案例中是如何完成数组元素的反转的？ 
定义2个变量分别占数组的首尾位置。 
一个变量往前走，一个变量往后走，同步交换双方位置处的值

# 3.抢红包 

需求： 一个大V直播抽奖，奖品是现金红包，分别有{2, 588 , 888, 1000, 10000}五个奖金。请使用代码模拟抽奖， 打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不一定是下面的顺序

```java
package Test;
import java.util.Random;
import java.util.Scanner;
public class tastDemo7 {
    public static void main(String[] args) {
/**
 需求：一个大V直播抽奖，奖品是现金红包，分别有{2, 588 , 888, 1000, 10000}五个奖金。
 请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不一定是下面的顺序）
 */
                // 1、定义一个数组存储可以抽奖的金额 总数
                int[] money = {2, 588, 888, 1000, 10000};

                // 2、定义一个数组用于存储已经被抽中的奖金金额。
                int[] lockMoney = new int[money.length];

                // 3、开始模拟抽奖逻辑
                Scanner sc = new Scanner(System.in);
                Random r = new Random();
                for (int i = 0; i < money.length; i++) {
                    // 分别代表抽奖一次。
                    System.out.println("您要开始打开红包吗，您可以输入任意内容进行抽奖：");
                    sc.next(); // 目的是为了让程序在这里等一下，直到用户按了数据和回车就下来抽奖一次！

                    while (true) {
                        // 4、开始抽奖了，随机一个索引取提取金额
                        int index = r.nextInt(money.length);
                        int currentMoney = money[index];

                        boolean flag = true; // 代表默认没有被抽过

                        // 5、判断这个红包金额之前是否有人抽中过！
                        for (int j = 0; j < lockMoney.length; j++) {
                            if(lockMoney[j] == currentMoney){
                                // 说明这个金额已经被抽过了！
                                flag = false; // 表示已经被抽走了
                                break;
                            }
                        }

                        if(flag){
                            System.out.println("您当前很幸运，抽中了：" + currentMoney);
                            // 必须把这个金额放到被抽中的数组中去
                            lockMoney[i] = currentMoney;
                            break; // 当次抽象已经结束！
                        }
                    }
                }
            }
        }
```

本次案例中是如何保证每次抽奖的金额不是之前抽过的？ 
定义一个数组用于记录已经抽到的金额。 
每次抽奖都随机一个索引，取出索引对应的奖金金额，判断该金额之前是否 在已抽奖金额的数组中

# 4.双色球系统

业务分析、随机生成一组中奖号码



```java
package Test;
import java.util.Random;
import java.util.Scanner;
public class tastDemo8 {
    public static void main(String[] args) {
/**
 需求：双色球模拟
 */
                // 1、随机6个红球号码（1-33，不能重复），随机一个蓝球号码（1-16），可以采用数组装起来作为中奖号码
                int[] luckNumbers = createLuckNumber();
                // printArray(luckNumbers);

                // 2、录入用户选中的号码
                int[] userNumbers = userInputNumbers();

                // 3、判断中奖情况
                judge(luckNumbers, userNumbers);

            }

            public static void judge(int[] luckNumbers, int[] userNumbers ){
                // 判断是否中奖了。
                // luckNumbers = [12, 23, 8, 16, 15, 32,   9]
                // userNumbers = [23, 13, 18, 6, 8, 33,   10]
                // 1、定义2个变量分别存储红球命中的个数，以及蓝球命中的个数。
                int redHitNumbers = 0;
                int blueHitNumbers = 0;

                // 2、判断红球命中了几个，开始统计
                for (int i = 0; i < userNumbers.length - 1; i++) {
                    for (int j = 0; j < luckNumbers.length - 1; j++) {
                        // 每次找到了相等了，意味着当前号码命中了
                        if(userNumbers[i] == luckNumbers[j]){
                            redHitNumbers ++ ;
                            break;
                        }
                    }
                }

                // 蓝球号码是否命中了
                blueHitNumbers = luckNumbers[6] == userNumbers[6] ? 1 : 0;

                System.out.println("中奖号码是："  );
                printArray(luckNumbers);
                System.out.println("您投注号码是："  );
                printArray(userNumbers);
                System.out.println("您命中了几个红球：" + redHitNumbers);
                System.out.println("您是否命中蓝球：" + ( blueHitNumbers == 1 ? "是": "否" ) );

                // 判断中奖情况了
                if(blueHitNumbers == 1 && redHitNumbers < 3){
                    System.out.println("恭喜您，中了5元小奖！");
                }else if(blueHitNumbers == 1 && redHitNumbers == 3
                        || blueHitNumbers == 0 && redHitNumbers == 4){
                    System.out.println("恭喜您，中了10元小奖！");
                }else if(blueHitNumbers == 1 && redHitNumbers == 4
                        || blueHitNumbers == 0 && redHitNumbers == 5){
                    System.out.println("恭喜您，中了200元！");
                }else if(blueHitNumbers == 1 && redHitNumbers == 5){
                    System.out.println("恭喜您，中了3000元大奖！");
                }else if(blueHitNumbers == 0 && redHitNumbers == 6){
                    System.out.println("恭喜您，中了500万超级大奖！");
                }else if(blueHitNumbers == 1 && redHitNumbers == 6){
                    System.out.println("恭喜您，中了1000万巨奖！可以开始享受人生，诗和远方！！");
                }else {
                    System.out.println("感谢您为福利事业做出的突出贡献！！");
                }
            }

            public static int[] userInputNumbers(){
                // a、动态初始化一个数组，长度为7
                int[] numbers = new int[7];
                Scanner sc = new Scanner(System.in);
                for (int i = 0; i < numbers.length - 1; i++) {
                    System.out.println("请您输入第"+(i + 1)+"个红球号码（1-33、不重复）：");
                    int data = sc.nextInt();
                    numbers[i] = data;
                }

                // b、录入一个蓝球号码
                System.out.println("请您输入一个蓝球号码（1-16）：");
                int data = sc.nextInt();
                numbers[numbers.length - 1] = data;

                return numbers;
            }

            public static void printArray(int[] arr){
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

            public static int[] createLuckNumber(){
                // a、定义一个动态初始化的数组，存储7个数字
                int[] numbers = new int[7];  // [12, 23, 0, 0, 0, 0, | 0]
                //                                   i
                // b、遍历数组，为每个位置生成对应的号码。(注意：遍历前6个位置，生成6个不重复的红球号码，范围是1-33)
                Random r = new Random();
                for (int i = 0; i < numbers.length - 1; i++) {
                    // 为当前位置找出一个不重复的1-33之间的数字
                    while (true) {
                        int data = r.nextInt(33) + 1; // 1-33 ====>  (0-32) + 1

                        // c、注意：必须判断当前随机的这个号码之前是否出现过，出现过要重新随机一个，直到不重复为止，才可以存入数组中去。
                        // 定义一个flag变量，默认认为data是没有重复的
                        boolean flag = true;
                        for (int j = 0; j < i; j++) {
                            if(numbers[j] == data) {
                                // data当前这个数据之前出现过，不能用
                                flag = false;
                                break;
                            }
                        }

                        if(flag) {
                            // data这个数据之前没有出现过，可以使用了
                            numbers[i] = data;
                            break;
                        }
                    }
                }
                // d、为第7个位置生成一个1-16的号码作为蓝球号码
                numbers[numbers.length - 1] = r.nextInt(16) + 1;
                return numbers;
            }
        }
```

本次案例中是如何去统计红球的命中数量的？ 
遍历用户的每个选号，然后遍历中奖号码的数组。 
看当前选号是否在中奖号码中存在，存在则命中数量加1
