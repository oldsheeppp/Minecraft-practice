package Armors;

import Player.Item;
public abstract class Armor implements Item {
    int toughness;
    int point;
    String Material;
    public abstract void addToughness(int num);
    public abstract void minusToughness(int num);
    public abstract int getPoint();
    public abstract String getName();
    public abstract String getMaterial();
}
