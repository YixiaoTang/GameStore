package yixiao.gamestore.Common;

public class Game {
    private String name;
    private String image;
    private int price;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
