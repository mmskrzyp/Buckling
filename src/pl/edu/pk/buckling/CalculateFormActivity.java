package pl.edu.pk.buckling;

import java.math.BigDecimal;

import pl.edu.pk.beam.Beam;
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
	
	Button btCalculate = (Button) findViewById(R.id.btCalculate);
	btCalculate.setOnClickListener(new OnClickListener() {

	    public void onClick(View v) {
		Intent intent = new Intent(getBaseContext(),
			CalculationResultActivity.class);
		intent.putExtra(RESULT, calulateFromForm());
		startActivity(intent);
	    }
	});
    }
    
    private BigDecimal calulateFromForm(){
	Beam beam = new Beam(); //na podstawie formularza
	// Beam beam = new Beam(mass, length, ...);
	BigDecimal result = beam.getCriticalPower();
	return result;
    }
    
    public static final String RESULT = "result";
}
