package com.ledx.etandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navGraficar) {
            switchFragment(R.id.containerMain,GraficarFragment.newInstance("Graficas","Fragmented videos"),"TAG-Videos");
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.navConsola) {
            switchFragment(R.id.containerMain,ConsolaFragment.newInstance("Consola","Fragmented fotos"),"TAG-Fotos");
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.navImagenes) {
            switchFragment(R.id.containerMain,ImagenesFragment.newInstance("Consola","Fragmented fotos"),"TAG-Fotos");
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.navReportes) {
            switchFragment(R.id.containerMain,ReporteFragment.newInstance("Consola","Fragmented fotos"),"TAG-Fotos");
            drawer.closeDrawer(GravityCompat.START);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchFragment(int idContainer, Fragment fragment, String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragment != null){
            FragmentTransaction transaction = null;
            while (fragmentManager.popBackStackImmediate());
            transaction = fragmentManager.beginTransaction().replace(idContainer,fragment,tag);
            if(!(fragment instanceof HomeFragment))
                transaction.addToBackStack(tag);
            transaction.commit();

        }
    }
}
