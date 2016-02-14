package co.jaypandya.askmeshowme_new;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "AskMeShowMe";
    private String selection = "";
    private Menu myMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("Jay Pandya 062791132 - ", TAG);

        View promptButton = findViewById(R.id.prompt_button);
        promptButton.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.monthsRadioGroup);
        int checkedRadioButton = radioGroup.getCheckedRadioButtonId();

        switch (checkedRadioButton) {
            case R.id.januaryButton :
                selection = "January";
                break;
            case R.id.juneButton :
                selection = "June";
                break;
            case R.id.julyButton :
                selection = "July";
                break;
        }

        switch(v.getId()) {
            //case R.id.play_button:
            //	Intent k = new Intent(this, Video.class);
            //	startActivity(k);
            //	break;
            case R.id.prompt_button:
                Intent j = new Intent(this, ShowMe.class);
                j.putExtra("choice", selection);
                startActivity(j);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        Log.i(TAG,"AskMeShowMe onCreateOptionsMenu from XML file");

        getMenuInflater().inflate(R.menu.menu_main, menu);

        this.myMenu = menu;

        //when user clicks: More
        addRegularMenuItems(menu);
        //add5SecondaryMenuItems(menu);
        this.addSubMenu(menu);

        return true;
    }

    private void addRegularMenuItems(Menu menu) {
        //Secondary items are shown just like everything else
        int base=Menu.FIRST; // value is 1

        MenuItem item1 = menu.add(base,base,base,"Browser...");
        menu.add(base,base+1,base+1,"DialPad...");
        menu.add(base,base+2,base+2,"About...");

        item1.setIcon(R.drawable.ic_launcher);
    }

    private void addSubMenu(Menu menu) {
        //click on picture menu
        //Secondary items are shown just like everything else
        int base=Menu.FIRST + 100;
        SubMenu sm = menu.addSubMenu(base,base+1,Menu.NONE,"submenu");
        MenuItem item1 = sm.add(base,base+2,base+2,"item 1....");

        sm.add(base,base+3,base+3, "item 2....");
        sm.add(base,base+4,base+4, "item 3....");

        Log.i(TAG,"AskMeShowMe addSubMenu support with android picture icon");
        item1.setIcon(R.drawable.skateboarding_android_1);
        sm.setIcon(R.drawable.skateboarding_android_2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.xml_menu_1:
//    		startActivity(new Intent(this, Video.class));
                break;
            case R.id.xml_menu_2:
//    		startActivity(new Intent(this, About.class));
                break;
            case R.id.xml_menu_3:
//    		startActivity(new Intent(this, Prefs.class));
                break;
        }

        if (item.getItemId() == 1)	{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            this.startActivity(intent);
        } else if (item.getItemId() == 2)	{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:4164669992"));
            this.startActivity(intent);
        }	else if (item.getItemId() == 3)	{
//    		Intent intent = new Intent(this, About.class);
//    		this.startActivity(intent);

            this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY,true);
        }

        return super.onOptionsItemSelected(item);
    }
}
