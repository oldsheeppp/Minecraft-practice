import Armors.*;
import Foods.Meet;
import Foods.Shit;
import Foods.Vegetable;
import Items.*;
import Tools.Axe;
import Tools.Hoe;
import Tools.Pickaxe;
import Tools.Sword;
import Player.Player;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个玩家的名字");
        String a = input.nextLine();
        Player aa = new Player(a);                        //用aa来记载第一个玩家的变量名
        System.out.println("请问是否要穿盔甲？（Y / N）");
        Helmet helmet = new Helmet();                     //创建各个物品的实例，使后面能顺利运行
        Chestplate chestplate = new Chestplate();
        Legging legging = new Legging();
        Boots boots = new Boots();
        Axe axe = new Axe();
        Pickaxe pickaxe = new Pickaxe();
        Hoe hoe = new Hoe();
        String one = input.nextLine();
        switch (one) {                                                      //选择盔甲阶段
            case "Y" :
                System.out.println("请问头盔要什么材料的？（1：金的 2：钻石的）");
                String one1 = input.nextLine();
                switch (one1) {
                    case "1" :
                        helmet.setMaterial("Gold");
                        break;
                    case "2" :
                        helmet.setMaterial("Diamond");
                        break;
                }
                aa.wearArmor(helmet);
                System.out.println("请问胸甲要什么材料的？（1：金的 2：钻石的）");
                String one2 = input.nextLine();
                switch (one2) {
                    case "1" :
                        chestplate.setMaterial("Gold");
                        break;
                    case "2" :
                        chestplate.setMaterial("Diamond");
                        break;
                }
                aa.wearArmor(chestplate);
                System.out.println("请问护腿要什么材料的？（1：金的 2：钻石的）");
                String one3 = input.nextLine();
                switch (one3) {
                    case "1" :
                        legging.setMaterial("Gold");
                        break;
                    case "2" :
                        legging.setMaterial("Diamond");
                        break;
                }
                aa.wearArmor(legging);
                System.out.println("请问靴子要什么材料的？（1：金的 2：钻石的）");
                String one4 = input.nextLine();
                switch (one4) {
                    case "1" :
                        boots.setMaterial("Gold");
                        break;
                    case "2" :
                        boots.setMaterial("Diamond");
                        break;
                }
                aa.wearArmor(boots);
                System.out.println("穿完了，真强啊");break;
            case "N" :
                System.out.println("这么有自信啊");break;
        }
        System.out.println("请问是否要把剑？（Y / N）)");
        String two = input.nextLine();
        Sword sword = new Sword();
        switch (two) {                                                //选剑阶段
            case "Y" :
                System.out.println("请问剑要什么材料的？（1：铁的 2：金的 3：钻石的）");
                String two1 = input.nextLine();
                switch (two1) {
                    case "1":
                        sword.setMaterial("Iron");
                        break;
                    case "2":
                        sword.setMaterial("Gold");
                        break;
                    case "3":
                        sword.setMaterial("Diamond");
                        break;
                }
                aa.getWeapon(sword);break;
            case "N" :
                System.out.println("有种啊小子");
        }
        System.out.println("请选择要创建第二个玩家吗？(Y / N)");
        String three = input.nextLine();
        boolean haveOther = true;
        String b = "null";
        switch (three) {
            case "Y" :
                System.out.println("请输入名字");
                 b = input.nextLine();
                haveOther = true;
                break;
            case "N" :
                System.out.println("自个玩吧");
                haveOther = false;
                break;
        }
        Player bb = new Player(b);
        int i = 0;
        do {
            System.out.println("下面请选择要干的事\n1: 自残 2：获取工具并装备或切回剑 3：攻击第二名玩家（没创建时请别攻击）\n" +    //具体事情的选择
                    "4：砍树（没斧头就别砍了） 5：挖矿（没稿子就别挖了） 6：锄地拿东西（没锄头就别搞了）\n" +
                    "7：吃 8：修装备 9：查看状态 10：查看背包 11:退出程序");
            String four = input.nextLine();
            switch (four) {
                case "1":
                    aa.attackSelf();
                    break;
                case "2":
                    System.out.println("要哪个？1：斧头 2：稿子 3：锄头 4:剑");
                    String five = input.nextLine();
                    switch (five) {
                        case "1":
                            aa.mainHand = axe;
                            break;
                        case "2":
                            aa.mainHand = pickaxe;
                            break;
                        case "3":
                            aa.mainHand = hoe;
                            break;
                        case "4":
                            System.out.println("不给换剑，就这么喜欢打打杀杀吗？");
                            break;
                    }break;
                case "3":
                    if(!haveOther) {
                        aa.attackSelf();
                        System.out.println("傻了吧，没其他人还想打，自残吧");
                    }
                    else {
                        aa.attack(bb);
                        System.out.printf("你是真的恶毒啊%s还有%d点血", bb.getName(), bb.getHealth());
                    }break;
                case "4":
                    if (aa.mainHand instanceof Axe) {
                        aa.doSomeThings(aa.mainHand);
                    }
                    else {
                        aa.attackSelf();
                        System.out.println("说了没斧头就别选，自残吧");
                    }break;
                case "5":
                    if (aa.mainHand instanceof Pickaxe) {
                        aa.doSomeThings(aa.mainHand);
                    }
                    else {
                        aa.attackSelf();
                        System.out.println("说了没稿子就别选，自残吧");
                    }break;
                case "6":
                    if (aa.mainHand instanceof Hoe) {
                        aa.doSomeThings(aa.mainHand);
                    }
                    else {
                        aa.attackSelf();
                        System.out.println("说了没锄头就别选，自残吧");
                    }break;
                case "7":
                    System.out.println("吃啥？1：肉 2：蔬菜 3：屎");
                    String six = input.nextLine();
                    switch (six) {
                        case "1":
                            Meet meet = new Meet();
                            aa.eat(meet);break;
                        case "2":
                            Vegetable vegetable = new Vegetable();
                            aa.eat(vegetable);break;
                        case "3":
                            Shit shit = new Shit();
                            aa.eat(shit);break;
                    }break;
                case "8":
                    Anvil anvil = new Anvil();
                    anvil.setOwner(aa);
                    System.out.println("修啥？1：头盔 2：胸甲 3：护腿 4：靴子");
                    String seven = input.nextLine();
                    System.out.println("用哪个材料？1：铁锭 2：金锭 3：钻石");
                    String eight = input.nextLine();
                    Iron iron = new Iron();
                    Gold gold = new Gold();
                    Diamond diamond = new Diamond();
                    switch (eight) {
                        case "1":
                            switch (seven) {
                                case "1":
                                    anvil.fixArmor(iron, helmet);break;
                                case "2":
                                    anvil.fixArmor(iron, chestplate);break;
                                case "3":
                                    anvil.fixArmor(iron, legging);break;
                                case "4":
                                    anvil.fixArmor(iron, boots);break;
                            }break;
                        case "2":
                            switch (seven) {
                                case "1":
                                    anvil.fixArmor(gold, helmet);break;
                                case "2":
                                    anvil.fixArmor(gold, chestplate);break;
                                case "3":
                                    anvil.fixArmor(gold, legging);break;
                                case "4":
                                    anvil.fixArmor(gold, boots);break;
                            }break;
                        case "3":
                            switch (seven) {
                                case "1":
                                    anvil.fixArmor(diamond, helmet);break;
                                case "2":
                                    anvil.fixArmor(diamond, chestplate);break;
                                case "3":
                                    anvil.fixArmor(diamond, legging);break;
                                case "4":
                                    anvil.fixArmor(diamond, boots);break;
                            }break;
                    }break;
                case "9":
                    aa.getState(aa);break;
                case "10":
                    aa.getThingsNum(aa);break;
                case "11":
                    i = 1;
                    break;
            }
        } while (i != 1 && aa.getHealth() > 0);
        System.out.println("已选择退出游戏或玩家血量为0");
    }
}


