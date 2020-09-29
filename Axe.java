package Tools;

import Player.Handable;
import Player.Item;

public class Axe implements Handable, Item{
    private int toughness = 100;
    @Override
    public void minusToughness (int num) {
        this.toughness -= num;
    }
    public String getName() {
        return "Axe";
    }
    public int getToughness() {
        return this.toughness;
    }
}
