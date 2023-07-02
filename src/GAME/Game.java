package GAME;

import java.util.Scanner;
public class Game {
    Plaver computer;//电脑玩家
    Plaver person;//人类玩家
    int count;
    private static Scanner input = new Scanner(System.in);

    public void initial() {
        String newGame = "y";
        do {
            System.out.println("\n******欢迎进入游戏****\n");
            // Scanner input = new Scanner(System.in);
            computer = new computer();
            person = new Person(input);
            count = 0;
            System.out.println("请选择对战角色【1-刘备   2-曹操  3-孙权】；");
            String choice = input.next();
            if (choice.equals("1")) {
                computer.setName("刘备");
            } else if (choice.equals("2")) {
                computer.setName("曹操");
            } else if (choice.equals("3")) {
                computer.setName("孙权");
            } else {
                System.out.println("你输入有误，系统自动设置电脑玩家名称为---刘鑫");
                computer.setName("电脑战神");
            }
            System.out.print("请输入您的姓名；");
            String pName = input.next();
            person.setName(pName);
            System.out.println("对战双方；" + computer.getName() + "vs" + person.getName());
            System.out.println("开始游戏。。");
            System.out.println("--------第一次---------");
            String answer = "y";
            do {
                int pFist = person.showFist();
                if (pFist == 1) {

                    System.out.println(person.getName() + "出拳；石头");
                } else if (pFist == 2) {
                    System.out.println(person.getName() + "出拳；剪刀");
                } else if (pFist == 3) {
                    System.out.println(person.getName() + "出拳；布");
                }

                int cFist = computer.showFist();
                if (cFist == 1) {
                    System.out.println(computer.getName() + "出拳；石头");
                } else if (cFist == 2) {
                    System.out.println(computer.getName() + "出拳；剪刀");
                } else if (cFist == 3) {
                    System.out.println(computer.getName() + "出拳；布");
                }
                judge(pFist, cFist);
                System.out.println("是否进入下一局（y/n）?");
                answer = input.next();
                System.out.println("----第" + (count + 1) + "次---");
            } while (!answer.equals("n"));
            System.out.println("\n<<<显示对战结果>>>");
            showResult();
            System.out.println("重新开始游戏（y/n）？");
            newGame = input.next();
            System.out.println("---------");
        } while (!newGame.equals("n"));
        System.out.println(person.getName() + "即将退出游戏，欢迎下次再来");
        input.close();
    }

    public void judge(int p, int c) {
        if (p == c) {
            System.out.println("平局！");
        } else if ((p == 1 && c == 2) || (p == 2 && c == 3) || (p == 3 && c == 1)) {
            System.out.println(person.getName() + "赢了");
            person.setscore(person.getScore() + 1);
        } else if ((p == 1 && c == 3) || (p == 2 && c == 1) || (p == 3 && c == 2)) {
            System.out.println(person.getName() + "输了");
            computer.setscore((computer.getScore() + 1));
        }
        count++;
    }

    public void showResult() {
        System.out.println("************");
        System.out.println("对战双方：" + computer.getName() + "vs" + person.getName());
        System.out.println("双方对战次数：" + count);
        System.out.println(person.getName() + "得分:" + person.getScore());
        System.out.println(computer.getName() + "得分:" + person.getScore());
        if (person.getScore() > computer.getScore()) {
            System.out.println(person.getName() + "取得了最终胜利！");
        } else if (person.getScore() < computer.getScore()) {
            System.out.println(computer.getName() + "取得了最终胜利！");
        } else {
            System.out.println("双方战成平手，下次一决胜负");
        }
        System.out.println("********");
    }

}
