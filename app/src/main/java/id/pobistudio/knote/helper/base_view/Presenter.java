package id.pobistudio.knote.helper.base_view;

/**
 * Created by KUKUH on 15-Feb-18.
 */

public interface Presenter  <T extends View> {
    void onAttach(T view);
    void onDetach();
}
