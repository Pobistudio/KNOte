package id.pobistudio.knote.view.home.reminder;


import id.pobistudio.knote.helper.base_view.Presenter;

/**
 * Created by kukuh on 16/02/18.
 */

public class ReminderPresenter implements Presenter<ReminderView> {

    private ReminderView view;

    @Override
    public void onAttach(ReminderView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
