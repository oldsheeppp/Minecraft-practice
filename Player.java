package Player;

import Armors.Armor;
import Blocks.Straw;
import Foods.Meet;
import Foods.Shit;
import Foods.Vegetable;
import Items.Diamond;
import Items.Gold;
import Tools.Axe;
import Tools.Hoe;
import Tools.Pickaxe;
import Tools.Sword;
import Items.Iron;
import Blocks.Woods;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

public class Player {
    public Player() {
        System.out.println("请设置玩家姓名为你设的名字");
    }
    //设置玩家姓名
    private String name;
    public void setName(String a) {
        this.name = a;
    }
    public Player(String name) {
        this.name = name;
    }
    //设置初始防御值，生命值，饥饿值，经验值
    private int defensePoint = 0;
    private int health = 20;
    private int hunger = 20;
    private int attack = 5;
    private int exp = 100;
    //设置方法获取基本属性值
    public int getDefensePoint() {
        return this.defensePoint;
    }
    public int getHealth() {
        return this.health;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getHunger() {
        return this.hunger;
    }
    public int getExp() {
        return this.exp;
    }
    public String getName() { return this.name; }
    //创建接口变量
    public Handable mainHand;
    //设置防御值增加和穿盔甲
    public void addDefensePoint(int give) {
        defensePoint += give;
    }
    public void wearArmor(Armor armor) {
        this.addDefensePoint(armor.getPoint());
        System.out.printf("%s的防御力增加了！\n现在防御力是%d点\n", this.name, this.defensePoint);
    }
    //设置攻击力增加和拿剑
    public void addAttack(int give) {
        attack += give;
    }
    public void getWeapon(Sword sword) {
        this.addAttack(sword.getPoint());
        this.mainHand = sword;
        System.out.printf("%s的攻击力增加了！\n现在攻击力是%d点\n", this.name, this.attack);
    }
    //装备斧子，稿子，锄头
    public void getAxe(Handable things) {
        this.mainHand = things;
        System.out.printf("%s装备了%s\n", this.name, things.getName());
    }
    //设置三个干的事
    public void doSomeThings(Handable things) {
        //耐久大于0才能干
        if (things.getToughness() > 0) {
            if (things.getName().equals("Axe")) {
                setWoods(1);
                things.minusToughness(1);
                System.out.printf("%s获得了一个木头\n", this.name);
            } else if (things.getName().equals("Pickaxe")) {
                setDiamonds(1);
                setIrons(1);
                System.out.printf("%s获得了一个铁锭一个金锭和一个钻石\n", this.name);
            } else if (things.getName().equals("Hoe")) {
                setStraws(1);
                setMeets(1);
                setVegetable(1);
                things.minusToughness(1);
                System.out.printf("%s获得了一个稻草和肉和蔬菜\n", this.name);
            }
        } else
            System.out.println("没耐久啦");
    }
    //设置经验值
    public void setExp(int give) {
        this.exp += give;
        System.out.printf("%s的经验值减少了！\n", this.name);
    }
    //设置攻击的动作
    public void attack(Player player) {
        this.hunger -= 1;
        player.health -= (this.attack - (this.defensePoint / 3));
        System.out.printf("%s打了%s一下，造成了%d点伤害\n", this.name, player.getName(), this.attack);
        if (player.mainHand instanceof Sword) {                   //检测主手有无剑
            (player.mainHand).minusToughness(1);
        }
        setShits(1);
        System.out.printf("%s获得了屎\n", this.name);
    }
    public void attackSelf() {
        this.hunger -= 1;
        this.health -= (this.attack - (this.defensePoint / 3));
        System.out.printf("%s打了%s一下，造成了%d点伤害\n", this.name, this.name, this.attack);
        if (this.mainHand instanceof Sword) {                   //检测主手有无剑
            (this.mainHand).minusToughness(1);
        }
        setShits(1);
        System.out.printf("%s获得了屎\n", this.name);
    }
    //设置吃的动作
    public void eat(Item food) {
        if (food.getName().equals("Meet")) {
            if (haveOrNot(meets)) {
                hunger += 10;
                System.out.printf("%s吃了肉，爽极了！\n", this.name);
                meets.remove(0);
            }
            else {
                System.out.println("肉没了，别吃了");
            }
        } else if (food.getName().equals("Vegetable")) {
            if (haveOrNot(vegetable)) {
                hunger += 5;
                System.out.printf("%s吃了蔬菜，身体健康！\n", this.name);
                vegetable.remove(0);
            }
            else {
                System.out.println("蔬菜没了，别吃了");
            }
        } else if (food.getName().equals("Shit")) {
            if (haveOrNot(shits)) {
                hunger -= 5;
                System.out.printf("%s吃了屎，要暴毙了！\n现在饥饿值为%d\n", this.name, this.hunger);
                shits.remove(0);
            }
            else {
                System.out.println("你是真的牛逼，屎都能吃完");
            }
        }
    }
    //添加各种泛型容器
    ArrayList<Gold> golds = new ArrayList<>();
    public void setGolds(int num) {
        things gold = new things();
        setItem(golds, gold, num, "Gold");
    }
    ArrayList<Iron> irons = new ArrayList<>();
    public void setIrons(int num) {
        things iron = new things();
        setItem(irons, iron, num, "Iron");
    }
    ArrayList<Diamond> diamonds = new ArrayList<>();
    public void setDiamonds(int num) {
        things diamond = new things();
        setItem(diamonds, diamond, num, "Diamond");
    }
    public int getMaterialNum(String a) {                 //获取当前矿物数量，给铁砧类用的
        int size = 0;
        if (a.equals("Iron")) {
            size = irons.size();
        } else if (a.equals("Gold")) {
            size = golds.size();
        } else {
            size = diamonds.size();
        }
        return size;
    }
    ArrayList<Woods> woods = new ArrayList<>();
    public void setWoods(int num) {
        things wood = new things();
        setItem(woods, wood, num, "Wood");
    }
    ArrayList<Meet> meets = new ArrayList<>();
    public void setMeets(int num) {
        things meet = new things();
        setItem(meets, meet, num, "Meet");
    }
    ArrayList<Vegetable> vegetable = new ArrayList<>();
    public void setVegetable(int num) {
        things veg = new things();
        setItem(vegetable, veg, num, "Vegetable");
    }
    ArrayList<Shit> shits = new ArrayList<>();
    public void setShits(int num) {
        things shit = new things();
        setItem(shits, shit, num, "Shit");
    }
    ArrayList<Straw> straws = new ArrayList<>();
    public void setStraws(int num) {
        things straw = new things();
        setItem(straws, straw, num, "Straw");
    }
    //查看状态的方法
    public void getState(Player player) {
        System.out.printf("%s的血量是%d\n攻击力是%d\n防御力是%d\n饥饿值是%d\n经验值是%d\n主手装备为%s\n", this.getName(),
                this.getHealth(), this.getAttack(), this.getDefensePoint(), this.getHunger(), this.getExp(),
                this.haveMainHand());
    }
    //查看背包物品
    public void getThingsNum(Player player) {
        System.out.printf("%s有%d个钻石 %d个铁锭 %d个金锭 %d个稻草 %d个肉 %d个蔬菜 %d坨屎\n", this.name, diamonds.size(),
                irons.size(), golds.size(), straws.size(), meets.size(), vegetable.size(), shits.size());
    }
    public boolean haveOrNot(ArrayList a) {               //查看物品有没有的方法
        boolean have;
        have = a.size() > 0;
        return have;
    }
    public boolean haveMaxOrNot(ArrayList a) {           //查看物品满了没得的方法
        boolean have;
        have = a.size() < 64;
        return have;
    }
    public void setItem(ArrayList a, things b, int d, String e) {                //将物品放入对应泛型容器的方法
        if (d > 0) {
            if (haveMaxOrNot(a)) {
                a.add(b);
            } else {
                System.out.printf("%s满了，别搞了\n", e);
            }
        } else {
            if (haveOrNot(a)) {
                a.remove(0);
                System.out.printf("%s少了一个\n", e);
            } else {
                System.out.printf("%s你一个都没，别搞了\n", e);
            }
        }
    }
    public String haveMainHand() {                    //检测主手装备
        String h;
        if (this.mainHand instanceof Sword)
            h = "sword";
        else if (this.mainHand instanceof Axe)
            h = "axe";
        else if (this.mainHand instanceof Hoe)
            h = "hoe";
        else if (this.mainHand instanceof Pickaxe)
            h = "pickaxe";
        else
            h = "NULL";
        return h;
    }
}






