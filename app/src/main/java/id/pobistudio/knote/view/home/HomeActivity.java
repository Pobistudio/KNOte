package id.pobistudio.knote.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.pobistudio.knote.R;
import id.pobistudio.knote.view.add_note.AddNoteActivity;
import id.pobistudio.knote.view.home.notes.NotesFragment;
import id.pobistudio.knote.view.home.reminder.ReminderFragment;
import id.pobistudio.knote.view.home.trash.TrashFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity
        implements HomeView, NavigationView.OnNavigationItemSelectedListener {

    private HomePresenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onAttachView();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onAttachView() {
        presenter = new HomePresenter();
        presenter.onAttach(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initDrawer();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        transactionFragment(new NotesFragment(), null);
        setTitle(R.string.menu_notes);
        showFAb(true);
        navigationView.getMenu().findItem(R.id.nav_notes).setChecked(true);
    }

    @Override
    public void transactionFragment(Fragment fragment, Bundle bundle) {
        if (fragment!=null) {
            if(bundle!=null){
                fragment.setArguments(bundle);
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            try {
                transaction.replace(R.id.content_frame, fragment).commitAllowingStateLoss();
            } catch (IllegalStateException e) {
                Log.e("ISE", e.getMessage());
            }
        }
    }

    @Override
    public void showFAb(boolean status) {
        if (status){
            fab.setVisibility(View.VISIBLE);
        }else {
            fab.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fab)
    @Override
    public void callAddNote() {
        startActivity(new Intent(this,AddNoteActivity.class));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        int id = item.getItemId();
        Fragment navFragment = null;
        if (id == R.id.nav_notes) {
            navFragment = new NotesFragment();
            setTitle(R.string.menu_notes);
            showFAb(true);
        } else if (id == R.id.nav_reminder) {
            navFragment = new ReminderFragment();
            setTitle(R.string.menu_reminder);
            showFAb(false);
        } else if (id == R.id.nav_trash) {
            navFragment = new TrashFragment();
            setTitle(R.string.menu_trash);
            showFAb(false);
        }
        transactionFragment(navFragment, null);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
