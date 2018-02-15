package com.freeway_frenzy.game_object.base_classes;

public class StoreItem {
    private Destroyer destroyer;
    private int cost;
    public StoreItem(Destroyer destroyer, int cost){
        this.destroyer = destroyer;
        this.cost = cost;
    }

    public Destroyer getDestroyer() { return this.destroyer; }
    public int getCost() { return this.cost; }
}
