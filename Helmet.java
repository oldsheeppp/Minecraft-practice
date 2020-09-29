package Armors;

import Player.Player;

public class Helmet extends Armor {
    String name;
    String Material;
    //设定属性
    public Helmet() {
        this.name = "Golden Helmet";
        this.point = 5;
    }
    int point;
    //根据材质设定名字及点数
    public void setMaterial(String material ) {
        if (material.equals("Gold")) {
            point = 7;
            this.name = "Golden" + name;
            this.Material = "Gold";
        }
        else if (material.equals("Diamond")) {
            point = 12;
            this.name = "Diamond" + name;
            this.Material = "Diamond";
        }
    }
    //设定耐久值
    private int toughness = 50;
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
}
