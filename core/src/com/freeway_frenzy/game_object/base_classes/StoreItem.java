package com.freeway_frenzy.game_object.base_classes;

public class StoreItem {
    private Destroyer destroyer;
    private int cost;
    private int quantity;
    public StoreItem(Destroyer destroyer, int quantity){
        this.destroyer = destroyer;
        this.quantity = quantity;
        this.cost = destroyer.getPurchasedCost();
    }

    public Destroyer getDestroyer() {
        return this.destroyer;
    }
    public Destroyer buyDestroyer(){
        if(this.quantity > 0){
            --this.quantity;
            this.cost *= 3;
            return this.destroyer.clone();
        }
        return null;
    }

    public int getCost() { return this.cost; }
    public int getQuantity() { return this.quantity; }
}
