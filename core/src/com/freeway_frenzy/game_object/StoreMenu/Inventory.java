package com.freeway_frenzy.game_object.StoreMenu;


import com.freeway_frenzy.game_object.base_classes.Destroyer;

import java.util.List;

public class Inventory {
    private List<Destroyer> items;
    private int money;

    public int getMoney() { return this.money; }
    public void purchase(int amnt, Destroyer item) {
        this.money -= amnt;
        items.add(item);
    }
}
