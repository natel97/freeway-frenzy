package com.freeway_frenzy.game_object.on_screen_display;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.StoreMenu.Store;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;
import com.freeway_frenzy.game_object.base_classes.OnScreenItem;

public class UpgradeBTN extends OnScreenItem {
    private Destroyer destroyer;
    private GlobalVars globalVars;
    public UpgradeBTN(int x, int y, Destroyer destroyer, GlobalVars globalVars){
        super(x, y, new Texture("upgrade_btn.png"), 64, 256, true);
        this.destroyer = destroyer;
        this.globalVars = globalVars;
    }
    @Override
    public void onClick() {
        if(globalVars.money > destroyer.getUpgradeCost()){
            globalVars.money -= destroyer.getUpgradeCost();
            destroyer.upgrade();
        }
    }

    public Texture getTexture() {
        return this.texture;
    }
    public void updateDestroyer(Destroyer d){
        this.destroyer = d;
    }
}
