package yixiao.gamestore.common;

import android.arch.persistence.room.Entity;
import java.io.Serializable;


@Entity
public class Game implements Serializable {

    private String name;
    private String image;
    private String price;
    private int gameId;
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getGameId() {
        return gameId;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
