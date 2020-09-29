package Tools;

import Items.Iron;
import Player.Handable;
import Player.Item;

public class Sword implements Handable, Item {
    String name;
    String Material;
    int point;
    private int toughness = 100;

    public Sword() {
        name = "Iron Sword";
    }

    public Sword(String material) {
        if (material.equals("Iron")) {
            this.Material = "Iron";
            this.name = material + "Sword";
            this.point = 5;
        } else if (material.equals("Gold")) {
            this.Material = "Gold";
            this.name = material + "Sword";
            this.point = 7;
            toughness += 50;

        } else if (material.equals("Diamond")) {
            this.Material = "Diamond";
            this.name = material + "Sword";
            this.point = 10;
            toughness += 100;
        }
    }

    public void setMaterial(String material) {
        if (material.equals("Iron")) {
            this.Material = "Iron";
            this.name = material + "Sword";
            this.point = 5;
        } else if (material.equals("Gold")) {
            this.Material = "Gold";
            this.name = material + "Sword";
            this.point = 7;
            toughness += 50;

        } else if (material.equals("Diamond")) {
            this.Material = "Diamond";
            this.name = material + "Sword";
            this.point = 10;
            toughness += 100;
        }
    }

    public int getPoint() {
        return this.point;
    }

    public void addToughness(int num) {
        this.toughness += num;
        switch (Material) {
            case "Iron":
                if (this.toughness > 0) {
                    addToughness(5);
                }
                if (this.toughness >= 100) {
                    this.toughness = 100;
                    System.out.println("装备耐久已满");
                }
                break;
            case "Gold":
                if (this.toughness > 0) {
                    addToughness(7);
                }
                if (this.toughness >= 150) {
                    this.toughness = 150;
                    System.out.println("装备耐久已满");
                }
                break;
            case "Diamond":
                if (this.toughness > 0) {
                    addToughness(10);
                }
                if (this.toughness >= 200) {
                    this.toughness = 200;
                    System.out.println("装备耐久已满");
                }
                break;
        }
    }
    public void minusToughness (int num){
        this.toughness -= num;
        if (this.toughness <= 0) {
            System.out.println("装备耐久没了，快去修吧");
            this.point = 0;
            if (this.Material.equals("Iron")) {
                minusToughness(5);
            } else if (this.Material.equals("Golden")) {
                minusToughness(7);
            } else if (this.Material.equals("Diamond")) {
                minusToughness(10);
            }
        }
    }
    @Override
    public String getName () {
        return this.name;
    }
    public int getToughness() {
        return this.toughness;
    }
}
