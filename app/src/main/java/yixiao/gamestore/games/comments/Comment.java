package yixiao.gamestore.games.comments;

import com.saber.stickyheader.stickyData.StickyMainData;

public class Comment implements StickyMainData {
    private String name;
    private String avatar;
    private String comment;
    private int gameId;

    public String getName() {
        return name;
    }

    public int getGameId() {
        return gameId;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

