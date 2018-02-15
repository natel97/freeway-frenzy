package com.freeway_frenzy.game_object.StoreMenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;
import com.freeway_frenzy.game_object.base_classes.StoreItem;
import com.freeway_frenzy.game_object.destroyer.WeirdBaseExample;

import java.util.ArrayList;

public class Store {
    private ArrayList<StoreItem> destroyers;
    private GlobalVars globalVars;
    private BitmapFont font;




    public Store(GlobalVars globalVars){
        font = new BitmapFont();
        font.getData().setScale(4);
        this.globalVars = globalVars;
        destroyers = new ArrayList<StoreItem>(){{
            add(new StoreItem(new WeirdBaseExample(0,0,300, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,500, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,800, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,700, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,600, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,800, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,700, globalVars), 1000));
            add(new StoreItem(new WeirdBaseExample(0,0,900, globalVars), 1000));
        }};


    }
    public void addMoney(int money){
        this.globalVars.money += money;
    }
    public void draw(ShapeRenderer shape){
        shape.setColor(Color.ROYAL);
        shape.rect(0,0, 1920, 256);
    }
    public void draw(SpriteBatch batch) {
        int max = destroyers.size() > 5 ? 5 : destroyers.size();
        for(int i = 0; i < max; i++) {
            batch.setColor(destroyers.get(i).getCost() <= globalVars.money ? Color.WHITE : Color.RED);
            batch.draw(destroyers.get(i).getDestroyer().getImage(), 256 * (i + 1), 0, 256, 256);
        }
        font.draw(batch, "Money: " + globalVars.money, 1500, 128);
    }
    public Texture getDestroyerAtPosition(float x, float y){
        if(y > 256 || x > 1536 || x < 256 || MathUtils.round(x / 256 - 1) >= destroyers.size())
            return null;
        return destroyers.get(MathUtils.round(x  / 256 - 1)).getCost() <= globalVars.money ? destroyers.get(MathUtils.round(x  / 256 - 1)).getDestroyer().getImage() : null;
    }

    public Destroyer getDestroyerByTexture(Texture t){
        StoreItem temp = null;
        for(StoreItem d : destroyers){
            if(t.getTextureData().equals(d.getDestroyer().getImage().getTextureData())) {
                temp = d;
            }
        }
        if (temp != null)  {
            if(temp.getCost() > this.globalVars.money){
                return null;
            }
            this.globalVars.money -= temp.getCost();
            destroyers.remove(temp);
            temp.getDestroyer().setSelect(true);
            return temp.getDestroyer();
        }

        return null;
    }


}
