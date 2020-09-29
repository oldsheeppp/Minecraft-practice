package Armors;

import Player.Player;

public class Chestplate extends Armor {
    String name;
    String Material;
    //设定属性
    public Chestplate() {
        this.name = "Golden Chestplate";
        this.point = 5;
    }
    //根据材质设定名字及点数
    public void setMaterial(String material) {
        if (material.equals("Gold")) {
            point = 10;
            this.name = "Golden" + name;
            this.Material = "Gold";
        } else if (material.equals("Diamond")) {
            point = 15;
            this.name = "Diamond" + name;
            this.Material = "Diamond";
        }
    }
    //设定耐久值并给与玩家防御值
    private int toughness = 200;
    @Override
    public void addToughness(int num) {
        this.toughness += num;
    }
    public void minusToughness(int num) {
        this.toughness -= num;
    }
    public int getPoint() {
        return this.point;
    }
    public String getName() {
        return this.name;
    }
    public String getMaterial() {
        return this.Material;
    }
    public int getToughness() {
        return this.toughness;
    }
}

