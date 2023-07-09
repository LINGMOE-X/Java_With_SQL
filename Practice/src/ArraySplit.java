import java.util.Arrays;
import java.util.Scanner;
import java.util.Spliterator;

public class ArraySplit {
    public static void main(String[] args) {
        //自我拓展

        String[] understand = {"1、一般", "2、理解", "3、透彻"};

        Spliterator<String> spliterator = Arrays.stream(understand).spliterator();

        spliterator.forEachRemaining(System.out::println);
        System.out.println("==============================");
        System.out.println("选择一个代表自己的学习成果");
        String[] strList = new String[understand.length];
        for (int i = 0; i < understand.length; i++) {
            strList[i] = understand[i].split("\\s+")[0];
            System.out.println(understand[i]);
            String L1 = understand[i];
            String L2 = understand[i];
            String L3 = understand[i];
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (String ignored : strList) {
            System.out.println("后方测试");
        }
        switch (input) {
            case "1" -> System.out.println("你的选择是一般，看来还需要提高质量啊！");
            case "2" -> System.out.println("你的选择是理解，但我感觉你能做的远不止这些。");
            case "3" -> System.out.println("你的选择是透彻，但请不要过度自傲！");
            default ->
                    System.out.println("你没有给出上述的自我评价，看来你对自己没有信心，\n送你一句话：请不要逃避现实。");
        }
       /*
        switch () {
            case "":
                System.out.println("还需要提高质量啊！");
            case "理解":
                System.out.println("能做的远不止这些。");
            case "透彻":
                System.out.println("不要过度自傲！");
            default:
                System.out.println("请不要逃避现实。");
        }

        */
    }
}
