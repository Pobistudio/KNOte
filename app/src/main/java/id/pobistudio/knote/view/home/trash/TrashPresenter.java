package id.pobistudio.knote.view.home.trash;
import id.pobistudio.knote.helper.base_view.Presenter;

/**
 * Created by kukuh on 16/02/18.
 */

public class TrashPresenter implements Presenter<TrashView> {

    private TrashView view;

    @Override
    public void onAttach(TrashView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
