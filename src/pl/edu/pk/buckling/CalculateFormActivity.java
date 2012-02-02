package pl.edu.pk.buckling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CalculateFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculate_beam_layout);

	// TODO
	Button btCalculate = (Button) findViewById(R.id.btCalculate);
	btCalculate.setOnClickListener(new OnClickListener() {

	    public void onClick(View v) {
		startActivity(new Intent(getBaseContext(),
			CalculationResultActivity.class));
	    }
	});
    }
}
