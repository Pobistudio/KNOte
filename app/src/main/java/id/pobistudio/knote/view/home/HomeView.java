package id.pobistudio.knote.view.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import id.pobistudio.knote.helper.base_view.View;

/**
 * Created by KUKUH on 15-Feb-18.
 */

public interface HomeView extends View {

    void initDrawer();
    void transactionFragment(Fragment fragment, Bundle bundle);
    void showFAb(boolean status);
    void callAddNote();
}
