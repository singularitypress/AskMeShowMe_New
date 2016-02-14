package co.jaypandya.askmeshowme_new;

/**
 * Created by Jay on 2/13/2016.
 */
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ShowMe extends Activity {

    private static final String TAG = "Ask Me, Show Me";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        Intent myIntent = getIntent();
        Bundle b = myIntent.getExtras();
        String choice = b.getString("choice");
// 	   Intent intent = getIntent();
// 	   String choice = intent.getStringExtra("choice");

        Log.i(TAG,"selection: " + choice);
        TextView textView = (TextView) findViewById(R.id.showmeText);
        textView.append(" : " + choice); //.setText("Enter whatever you Like!");

//	   //if(choice.equals("January")) {
//		   String showmetv = this.getString(R.string.title_show_me);
//		   this.setTitle(showmetv + " " + choice);
//		   //R.string.title_show_me + choice
//		 String show = getResources().getString(R.string.title_show_me);
//		 //TextView tv = getResources().getResourceName(R.id.showmeText);
//		 show += choice;
//		 TextView tv = new TextView(this);
//		 tv.setText(show);

        //tv.setText("");

        //.getTextArray(showmetv.getText());
        //showmetv.setText("You selected: " + choice);
        //this.getText(showmeText);
//	     courses = getResources().getStringArray(R.array.cours);
//	   } else {
//	     courses = getResources().getStringArray(R.array.courses);
        //}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
