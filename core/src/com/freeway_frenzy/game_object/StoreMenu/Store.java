package com.freeway_frenzy.game_object.StoreMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.destroyer.WeirdBaseExample;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private ArrayList<Destroyer> destroyers;




    public Store(){
        destroyers = new ArrayList<Destroyer>(){{
            add(new WeirdBaseExample(0,0,300));
            add(new WeirdBaseExample(0,0,500));
            add(new WeirdBaseExample(0,0,800));
            add(new WeirdBaseExample(0,0,700));
            add(new WeirdBaseExample(0,0,600));
            add(new WeirdBaseExample(0,0,800));
            add(new WeirdBaseExample(0,0,700));
            add(new WeirdBaseExample(0,0,900));
        }};


    }
    public void draw(ShapeRenderer shape){
        shape.setColor(Color.ROYAL);
        shape.rect(0,0, 1920, 256);
    }
    public void draw(SpriteBatch batch) {
        int max = destroyers.size() > 5 ? 5 : destroyers.size();
        for(int i = 0; i < max; i++) {
            batch.draw(destroyers.get(i).getImage(), 256 * (i + 1), 0, 256, 256);
        }
    }
    public Texture getDestroyerAtPosition(float x, float y){
        if(y > 256 || x > 1536 || x < 256 || MathUtils.round(x / 256 - 1) >= destroyers.size())
            return null;
        return destroyers.get(MathUtils.round(x  / 256 - 1)).getImage();
    }

    public Destroyer getDestroyerByTexture(Texture t, float x, float y){
        Destroyer temp = null;
        for(Destroyer d : destroyers){
            if(t.getTextureData().equals(d.getImage().getTextureData())) {
                temp = d;
            }
        }
        if (temp != null)  {
            destroyers.remove(temp);
            System.out.println(temp);
            temp.setSelect(true);
        }
        return temp;
    }


}
