package g2e.navigatioindrawer.Activity;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import g2e.navigatioindrawer.Adapter.DrawerItemCustomAdapter;
import g2e.navigatioindrawer.R;
import g2e.navigatioindrawer.fragment.Home_Fragment;
import g2e.navigatioindrawer.utility.ObjectDrawerItem;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    FrameLayout mViewContainer;
    ListView mDrawerMenu;
    private MenuItem mMenuBellItem;
    private ActionBarDrawerToggle mDrawerToggle;
    Context context;
    Dialog dialog1;
    EditText _USERNAME,_passwordText;
    String lusername, lemail, lmobile, lid;
    public static final String LOGIN_URL = "http://trywis.com/app/trywis_user_login.php";
    public static final String KEY_KEYVAL="keyval";
    public static final String KEY_USERNAME="uname";
    public static final String KEY_PASSWORD="upass";

    String ehome, enotification, edashboard, eaboutus, elogout;
    String khome, knotification, kdashboard, kaboutus, klogout;
    TextView textName, textPhone;
    public static String name, phone, id, loginspinner;

    ImageView profileimage;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Bitmap bitmap;

    public static final String UPLOAD_URL = "http://thememoirs.in/kaffeecup/feader/feader_profile.php";
    public static final String UPLOAD_KEY = "image";
    public static final String UPLOAD_ID = "feed_reg_id";

    String Result, Image, Message, Imagepro, Response, status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mViewContainer = (FrameLayout) findViewById(R.id.fragment_container);
        mDrawerMenu = (ListView) findViewById(R.id.left_drawer);

        setupToolBar();





        SharedPreferences prefuserdata = getSharedPreferences("registerUser", 0);
        id = prefuserdata.getString("id", "0");

        name = prefuserdata.getString("name", "0");

        phone = prefuserdata.getString("phone", "0");



        Log.e("testing", "register name home==" + name);
        Log.e("testing", "register id home==" + id);
        Log.e("testing", "register id phone==" + phone);
        Log.e("testing", "register id spinner==" + loginspinner);


        profileimage = (ImageView) findViewById(R.id.imageViewprofile);
        textName = (TextView) findViewById(R.id.drawer_title_name);
        textPhone = (TextView) findViewById(R.id.drawer_title_phone);

        textName.setText("  " + name);
        textPhone.setText("  " + phone);

        setupDrawer();
        context = this;


        Home_Fragment fragment4 = new Home_Fragment();


        android.support.v4.app.FragmentTransaction fragmentTransaction4 =
                getSupportFragmentManager().beginTransaction();

        fragmentTransaction4.replace(R.id.fragment_container, fragment4);

        fragmentTransaction4.commit();


    }


    private void setupToolBar() {
        //set the Toolbar as ActionBar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    private void setupDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // List the Drawer Items
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[1];




        drawerItem[0] = new ObjectDrawerItem(R.drawable.home, "HOME","13");


        // Declare a new instance of our Custom drawer Adapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(MainActivity.this,
                R.layout.listview_drawer_item_row, drawerItem);

        // Set the Adapter and the Listener on the ListView
        mDrawerMenu.setAdapter(adapter);
        mDrawerMenu.setOnItemClickListener(this);


    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), 0, spanString.length(), 0); //fix the color to white
            item.setTitle(spanString);
        }
        return true;
    }*/
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.post:
              *//*  int colorBlue = getResources().getColor(R.color.red);
                MenuItem settingsMenuItem = item.findItem(R.id.post);
                SpannableString s = new SpannableString(settingsMenuItem.getTitle());
                s.setSpan(new ForegroundColorSpan(colorBlue), 0, s.length(), 0);
                settingsMenuItem.setTitle(s);*//*

              //String posttext = getResources().getString(R.string.post);

                //posttext.
                Intent intent1 = new Intent(MainActivity.this,Activity_Post_Requirement.class);
                startActivity(intent1);



                return true;

            default:
                mDrawerToggle.onOptionsItemSelected(item);
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // L.t(this,"Drawer Item clicked :" + position);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        switch (position) {
            case 0:
                Home_Fragment fragment1 = new Home_Fragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction1 =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, fragment1);
                fragmentTransaction1.commit();
                //L.t(view.getContext(), "0th location Clicked");
                break;







        }
    }


    private void ShowLogoutAlert(String data) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Logout from Trywis?");
        alertDialog.setMessage(data);
        //  alertDialog.setBackgroundResource(R.color.dialog_color);
        // alertDialog.setIcon(R.drawable.exit);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences prefuserdata = context.getSharedPreferences("registerUser", 0);
                SharedPreferences.Editor prefeditor = prefuserdata.edit();
                prefeditor.putString("name", "");
                prefeditor.putString("phone", "");
                prefeditor.putString("spinnername", "");
                prefeditor.putString("id", "");

                prefeditor.clear();
                prefeditor.commit();


                //Toast.makeText(HomPage.this,"Deleted",Toast.LENGTH_LONG ).show();

                Intent i7 = new Intent(context,MainActivity.class);

                context.startActivity(i7);

                ((Activity) context).finish();
                ((MainActivity) context).finish();

            }

        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }





}
