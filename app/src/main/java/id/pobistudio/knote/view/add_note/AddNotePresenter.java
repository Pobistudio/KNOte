package id.pobistudio.knote.view.add_note;

import id.pobistudio.knote.helper.base_view.Presenter;

/**
 * Created by kukuh on 16/02/18.
 */

public class AddNotePresenter implements Presenter<AddNoteView> {

    private AddNoteView view;

    @Override
    public void onAttach(AddNoteView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
