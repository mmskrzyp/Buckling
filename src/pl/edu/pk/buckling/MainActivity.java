package pl.edu.pk.buckling;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	TextView menuItem1 = (TextView) findViewById(R.id.tvMainMenuItem1);
	menuItem1.setOnClickListener(new OnClickListener() {	    
	    public void onClick(View v) {
		String http = getString(R.string.wiki_buckling);
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(http));
		startActivity(browserIntent);
	    }
	});
	
	TextView menuItem2 = (TextView) findViewById(R.id.tvMainMenuItem2);
	//menuItem2.setClickable(true);
	menuItem2.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		startActivity(new Intent(getApplicationContext(),
			CalculateFormActivity.class));
	    }
	});
    }
}