package de.orat.smartvote;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ConstraintLayout content;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        content = (ConstraintLayout) findViewById(R.id.cl);
        title = (TextView) findViewById(R.id.txt_title);
        description = (TextView) findViewById(R.id.txt_desc);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // damit die icons in der Originalfarbe angezeigt werden
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            return true;
        } else if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_positive_confirmation) {
            content.setBackgroundColor(Color.GREEN);
            title.setText(getString(R.string.positive_confirmation));
            description.setText(getString(R.string.descr_positive_confirmation));
        } else if (id == R.id.nav_leight_concerns) {
            content.setBackgroundColor(Color.YELLOW);
            title.setText(getString(R.string.leight_concerns));
            description.setText(getString(R.string.descr_leight_concerns));
        } else if (id == R.id.nav_abstention) {
            content.setBackgroundColor(Color.LTGRAY);
            title.setText(getString(R.string.abstention));
            description.setText(getString(R.string.descr_abstention));
        } else if (id == R.id.nav_stand_aside) {
            content.setBackgroundColor(Color.BLUE);
            title.setText(getString(R.string.stand_aside));
            description.setText(getString(R.string.descr_stand_aside));
        } else if (id == R.id.nav_massive_conerns) {
            content.setBackgroundColor(Color.rgb(255,140,0));
            title.setText(getString(R.string.massive_concerns));
            description.setText(getString(R.string.descr_massive_concerns));
        } else if (id == R.id.nav_blocks) {
            content.setBackgroundColor(Color.RED);
            title.setText(getString(R.string.block));
            description.setText(getString(R.string.descr_block));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
