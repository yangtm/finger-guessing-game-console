package GAME;

import java.util.Scanner;
public class Person extends Plaver {
    Scanner input;
    public Person(Scanner scanner){
        this.input = scanner;
    }
    public int showFist(){
        System.out.print("请出拳（1-石头 2-剪刀 3-布）；");
        // Scanner input = new Scanner(System.in);
        String i=input.next();
            int fist;
            if(i.equals("1")){
                fist=1;
            }else if(i.equals("2")){
                fist=2;
            } else if (i.equals("3")) {
                fist=3;
            }else {
                System.out.println("你输入有误！系统将自动出拳");
                fist=(int)(Math.random()*10)%3+1;
            }
            return fist;
    }
}
