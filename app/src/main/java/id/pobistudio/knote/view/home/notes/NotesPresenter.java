package id.pobistudio.knote.view.home.notes;

import id.pobistudio.knote.helper.base_view.Presenter;

/**
 * Created by kukuh on 16/02/18.
 */

public class NotesPresenter implements Presenter<NotesView> {

    private NotesView view;

    @Override
    public void onAttach(NotesView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
