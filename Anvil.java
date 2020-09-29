package Items;

import Armors.Armor;
import Player.Player;

public class Anvil {
    public Anvil() {
    }
    Player owner;
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    private String name;
    private int toughness = 100;
    public void fixArmor(Material m, Armor armor) {
        //检测铁砧有无耐久
        if (this.toughness > 0) {
            //检测铁砧有无主人
            if (owner instanceof Player) {
                //检测材料是否匹配
                if (m.getName().equals(armor.getMaterial())) {
                    //检测材料还有没有
                    if (owner.getMaterialNum(m.getName()) > 0) {
                        //修复装备中
                        System.out.println("duang duang duang");
                        System.out.println("正在修复装备中");
                        armor.addToughness(5);
                        this.toughness -= 5;
                        owner.setExp(-5);
                        if (m.getName().equals("Iron")) {
                            owner.setIrons(-1);
                        }
                        else if (m.getName().equals("Gold")) {
                            owner.setGolds(-1);
                        }
                        else {
                            owner.setDiamonds(-1);
                        }
                    }
                    else {
                        System.out.println("材料不够啦");
                    }
                }
                else {
                    System.out.println("你给的材料不对啊");
                }
            }
            else {
                System.out.println("铁砧没主人，没法修复");
            }
        }
        else {
            System.out.println("铁砧没耐久啦，别修啦");
        }
    }
}



