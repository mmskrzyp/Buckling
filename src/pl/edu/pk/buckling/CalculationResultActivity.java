package pl.edu.pk.buckling;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CalculationResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculation_result_layout);
	
	Bundle bundle = getIntent().getExtras();
	BigDecimal result = (BigDecimal) bundle.get(CalculateFormActivity.RESULT);
	TextView tvResult = (TextView) findViewById(R.id.tvResult);
	tvResult.setText(result.toString());
    }

}
