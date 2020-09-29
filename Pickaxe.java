package Tools;

import Player.Handable;
import Player.Item;

public class Pickaxe implements Handable, Item {
    private int toughness = 100;
    public  void minusToughness (int num) {
        this.toughness -= num;
    }
    @Override
    public String getName() {
        return "Pickaxe";
    }
    public int getToughness() {
        return this.toughness;
    }

}
