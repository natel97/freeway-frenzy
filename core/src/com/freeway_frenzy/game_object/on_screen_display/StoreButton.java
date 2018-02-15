package com.freeway_frenzy.game_object.on_screen_display;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.base_classes.OnScreenItem;

public class StoreButton extends OnScreenItem {

    public StoreButton(){
        super(128, 128, new Texture("store.png"), 256, 256, true);
    }

    @Override
    public void onClick() {

    }
}
