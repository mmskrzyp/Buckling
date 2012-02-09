package pl.edu.pk.buckling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	//TextView menuItem1 = (TextView) findViewById(R.id.tvMainMenuItem1);
	TextView menuItem2 = (TextView) findViewById(R.id.tvMainMenuItem2);
	// TODO dalsze pozycje menu

	menuItem2.setClickable(true);
	menuItem2.setOnClickListener(new OnClickListener() {

	    public void onClick(View v) {
		startActivity(new Intent(getApplicationContext(),
			CalculateFormActivity.class));
	    }
	});
    }
}