package com.freeway_frenzy.game_object.base_classes;

public abstract class Buyable {
    private int cost;
    private Destroyer item;

    public Buyable(int cost, Destroyer destroyer){
        this.cost = cost;
        this.item = destroyer;
    }


}
