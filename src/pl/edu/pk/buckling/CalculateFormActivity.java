package pl.edu.pk.buckling;

import java.math.BigDecimal;

import pl.edu.pk.beam.Beam;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculateFormActivity extends Activity {
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculate_form_layout);
	
	Button btSelectFastening = (Button) findViewById(R.id.btFormStep1Select);
	btSelectFastening.setOnClickListener(new OnClickListener() {
	    
	    public void onClick(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Select fastening");
		//builder.setItems(items, listener)
		AlertDialog alert = builder.create();
	    }
	});
	
	Button btFillFasteningFactor = (Button) findViewById(R.id.btFormStep1FillIn);
	btFillFasteningFactor.setOnClickListener(new OnClickListener() {	    
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		
	    }
	});
	
	Button btSelectMaterial = (Button) findViewById(R.id.btFormStep2Select);
	Button btFillYoungModule = (Button) findViewById(R.id.btFormStep2FillIn);

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

    private BigDecimal calulateFromForm() {
	BigDecimal lenght = new BigDecimal(
		((EditText) findViewById(R.id.etFormStep3Lenght)).getText()
			.toString());
	BigDecimal radius = new BigDecimal(
		((EditText) findViewById(R.id.etFormStep4Radius)).getText()
			.toString());
	BigDecimal mass = new BigDecimal(
		((EditText) findViewById(R.id.etFormStep5Mass)).getText()
			.toString());

	Beam beam = new Beam(lenght, radius, mass, ); // TODO

	BigDecimal result = beam.getCriticalPower();
	return result;
    }

    public static final String RESULT = "result";
}
