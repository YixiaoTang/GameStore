package yixiao.gamestore.games.comments;

import android.support.annotation.LayoutRes;

import com.saber.stickyheader.stickyData.HeaderData;

public class CommentHeader implements HeaderData {
    public static final int HEADER_TYPE_1 = 1;

    private int headerType;
    @LayoutRes
    private final int layoutResource;

    public CommentHeader(int headerType, @LayoutRes int layoutResource) {
        this.layoutResource = layoutResource;
        this.headerType = headerType;
    }

    @Override
    public int getHeaderLayout() {
        return layoutResource;
    }

    @Override
    public int getHeaderType() {
        return headerType;
    }
}
