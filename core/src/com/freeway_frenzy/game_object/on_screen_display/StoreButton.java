package com.freeway_frenzy.game_object.on_screen_display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.game_object.StoreMenu.Store;
import com.freeway_frenzy.game_object.base_classes.OnScreenItem;

public class StoreButton extends OnScreenItem {

    private boolean storeVisible = false;
    private Store store;

    public StoreButton(Store store){
        super(128, 128, new Texture("store.png"), 256, 256, true);
        this.store = store;
    }

    @Override
    public void onClick() {
        this.storeVisible = !this.storeVisible;
    }

    @Override
    public void draw(ShapeRenderer shape){
        super.draw(shape);
        if(storeVisible){
            store.draw(shape);
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
        if(storeVisible){
            store.draw(batch);
        }
    }

    public boolean storeVisible() { return this.storeVisible; }

    public boolean storeVisible(boolean b) {
        this.storeVisible = b;
        return b;
    }
}
