package Armors;

public class Boots extends Armor {
    String name;
    String Material;
    //设定属性
    public Boots() {
        this.Material = "Golden";
        this.name = "Golden Boots";
        this.point = 5;
    }
    //根据材质设定名字及点数
    public void setMaterial(String material) {
        this.name =  material + "Boots";
        if (material.equals("Gold")) {
            this.Material = "Gold";
            this.point = 5;
        }
        else if (material.equals("Diamond")) {
            this.Material = "Diamond";
            this.point = 10;
        }
    }
    //设定耐久值
    private int toughness = 100;
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
