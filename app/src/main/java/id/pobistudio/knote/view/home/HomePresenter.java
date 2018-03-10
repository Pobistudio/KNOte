package id.pobistudio.knote.view.home;

import id.pobistudio.knote.helper.base_view.Presenter;

/**
 * Created by KUKUH on 15-Feb-18.
 */

public class HomePresenter implements Presenter<HomeView> {

    private HomeView view;

    @Override
    public void onAttach(HomeView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
