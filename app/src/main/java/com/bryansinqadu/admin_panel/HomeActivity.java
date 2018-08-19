package com.bryansinqadu.admin_panel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;
    private long backPressedTime;
    private Toast backToast;
    private Toolbar toolbar;
    private FirebaseAuth firebaseAuth;
    CardView booking,users,staff,slots,settings,calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        cardView();
        navMenu();
    }

    public void cardView(){
        booking = (CardView) findViewById(R.id.cardBookings);
        users = (CardView) findViewById(R.id.cardUsers);
        staff = (CardView) findViewById(R.id.cardStaff);
        slots = (CardView) findViewById(R.id.cardSlots);
        settings = (CardView) findViewById(R.id.cardSettings);
        calendar = (CardView) findViewById(R.id.cardCalendar);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,BookingsActivity.class));
            }
        });
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,UsersActivity.class));
            }
        });
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,StaffActivity.class));
            }
        });
        slots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,SlotsActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CalendarActivity.class));
            }
        });
    }

    public void navMenu(){


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(HomeActivity.this,nDrawerLayout,R.string.open,R.string.close);
        navigationView = findViewById(R.id.navMenu);
        navigationView.setNavigationItemSelectedListener(this);



        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();


    }

    public void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navHome:
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
                break;
            case R.id.navBooking:
                startActivity(new Intent(HomeActivity.this,BookingsActivity.class));
                break;
            case R.id.navDepartments:
                startActivity(new Intent(HomeActivity.this,DepartmentsActivity.class));
                break;

            case R.id.navSlots:
                startActivity(new Intent(HomeActivity.this,SlotsActivity.class));
                break;

            case R.id.navStaff:
                startActivity(new Intent(HomeActivity.this,StaffActivity.class));
                break;
            case R.id.navMap:
                startActivity(new Intent(HomeActivity.this,MapsActivity.class));
                break;

            case R.id.navGallery:
                startActivity(new Intent(HomeActivity.this,GalleryActivity.class));
                break;

            case R.id.navCalendar:
                startActivity(new Intent(HomeActivity.this,CalendarActivity.class));
                break;

            case R.id.navChat:
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
                break;

            case R.id.navSettings:
                startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
                break;
            case R.id.navHelp:
                startActivity(new Intent(HomeActivity.this,HelpActivity.class));
                break;
            case R.id.navLogout:
                Logout();
                break;

            case R.id.navExit:
                finish();
                System.exit(0);
                break;
        }

        nDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }
      return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (nDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            nDrawerLayout.closeDrawer(GravityCompat.START);
        } else if(backPressedTime + 2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
