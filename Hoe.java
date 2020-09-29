package Tools;

import Player.Handable;
import Player.Item;

public class Hoe implements Handable, Item {
    private int toughness = 100;
    public  void minusToughness (int num) {
        this.toughness -= num;
    }
    @Override
    public String getName() {
        return "Hoe";
    }
    public int getToughness() {
        return this.toughness;
    }
}
