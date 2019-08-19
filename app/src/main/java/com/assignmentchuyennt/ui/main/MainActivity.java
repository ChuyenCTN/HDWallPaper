package com.assignmentchuyennt.ui.main;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.aboutus.AboutUsActivity;
import com.assignmentchuyennt.ui.aboutus.AboutUsFragment;
import com.assignmentchuyennt.ui.category.CategoryFragment;
import com.assignmentchuyennt.ui.imagedetail.ImageDetailActivity;
import com.assignmentchuyennt.ui.latest.LatestFragment;
import com.assignmentchuyennt.ui.myfavorites.MyFavoritesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment;
    Toolbar toolbar;
    private ImageView imgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        imgSearch = (ImageView) findViewById(R.id.img_search);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setTitle(getResources().getString(R.string.title_Latest));
        fragment = new CategoryFragment();
        showFragment(fragment);
        imgSearch.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Resources resources = getResources();
        if (id == R.id.nav_home) {
            imgSearch.setVisibility(View.GONE);
            fragment = new LatestFragment();
            toolbar.setTitle(resources.getString(R.string.title_Latest));
        } else if (id == R.id.nav_category) {
            fragment = new CategoryFragment();
            imgSearch.setVisibility(View.VISIBLE);
            toolbar.setTitle(resources.getString(R.string.title_Category));
        } else if (id == R.id.nav_gifs) {
            imgSearch.setVisibility(View.GONE);
            startActivity(new Intent(getApplicationContext(), ImageDetailActivity.class));
        } else if (id == R.id.nav_favorites) {
            imgSearch.setVisibility(View.GONE);
            fragment = new MyFavoritesFragment();
            toolbar.setTitle(resources.getString(R.string.title_MyFavorites));

        } else if (id == R.id.nav_rateApp) {

        } else if (id == R.id.nav_moreApp) {

        } else if (id == R.id.nav_aboutUs) {
            imgSearch.setVisibility(View.GONE);
            startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
            toolbar.setTitle(resources.getString(R.string.title_AboutUs));
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_privacyPolicy) {

        }

        if (fragment != null) {
            showFragment(fragment);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main, fragment);
        fragmentTransaction.commit();
    }
}
