package yixiao.gamestore.games.comments;
import android.util.Log;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;
public class CommentsModel implements CommentsContract.Model{
    private CommentsContract.Presenter presenter;


    @Override
    public void fetchData(int gameId) {

    }

    @Override
    public void setPresenter(CommentsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
