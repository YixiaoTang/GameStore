package yixiao.gamestore.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import yixiao.gamestore.R;
import yixiao.gamestore.games.GamesFragment;
import yixiao.gamestore.games.comments.CommentsFragment;


public class ContainerFragment extends Fragment{
    public static final int GAMES_PAGE = 0;
    public static final String GAMES_PAGE_TAG = "games_page";
    public static final int FUNCTIONS_PAGE = 1;
    public static final String FUNCTIONS_PAGE_TAG = "functions_page";
    public static final int BANK_CARD_PAGE = 2;
    public static final String BANK_CARD_PAGE_TAG = "bank_card_page";
    public static final int PROFILE_PAGE = 3;
    public static final String PROFILE_PAGE_TAG = "profile_page";
    private int pageIndex;
    private Fragment initFragment;

    public static ContainerFragment newInstance(int pageIndex) {
        ContainerFragment containerFragment = new ContainerFragment();
        containerFragment.pageIndex = pageIndex;
        containerFragment.initFragment = createInitFragmentByIndex
                (pageIndex);
        return containerFragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (initFragment != null && !initFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().replace(R.id.child_fragment_container, initFragment, getCurrentTag(pageIndex))
                    .commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child_fragment_container, container, false);
    }

    public static String getCurrentTag(int position) {
        switch (position) {
            case GAMES_PAGE:
                return GAMES_PAGE_TAG;
            case FUNCTIONS_PAGE:
                return FUNCTIONS_PAGE_TAG;
            case BANK_CARD_PAGE:
                return BANK_CARD_PAGE_TAG;
            case PROFILE_PAGE:
                return PROFILE_PAGE_TAG;
            default:
                return null;
        }
    }


    public static int getPositionById(int id) {
        switch (id) {
            case R.id.action_games:
                return GAMES_PAGE;
            case R.id.action_functions:
                return FUNCTIONS_PAGE;
            case R.id.action_bank:
                return BANK_CARD_PAGE;
            case R.id.action_profile:
                return PROFILE_PAGE;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    private static Fragment createInitFragmentByIndex(int pageIndex) {
        switch (pageIndex) {
            case GAMES_PAGE:
                return GamesFragment.newInstance();
            case FUNCTIONS_PAGE:
                return null;
            case BANK_CARD_PAGE:
                return null;
            case PROFILE_PAGE:
                return null;
            default:
                throw new IndexOutOfBoundsException();
        }
    }


}
