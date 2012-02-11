package pl.edu.pk.buckling;

import java.math.BigDecimal;

import pl.edu.pk.beam.Beam;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateFormActivity extends Activity /*implements OnClickListener*/ {
    public static final String RESULT = "result";
    private Context context = this;

    private EditText etLenght;
    private EditText etRadius;
    private EditText etMass;

    private BigDecimal fasteningFactor;
    private BigDecimal youngModulus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculate_form_layout);

	etLenght = (EditText) findViewById(R.id.etFormStep3Lenght);
	etRadius = (EditText) findViewById(R.id.etFormStep4Radius);
	etMass = (EditText) findViewById(R.id.etFormStep5Mass);

	Button btSelectFastening = (Button) findViewById(R.id.btFormStep1Select);
	/*btSelectFastening.setOnClickListener(new OnClickListener() {

	    public void onClick(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Select fastening");
		// builder.setItems(items, listener)
		AlertDialog alert = builder.create();
	    }
	});*/

	Button btFillFasteningFactor = (Button) findViewById(R.id.btFormStep1FillIn);
	btFillFasteningFactor.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		/*final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.fill_in_fastening_factor_dialog);
		dialog.setTitle("Fill in fastening factor");
		
		Button btOk = (Button) findViewById(R.id.btFillFasteningFactor);
		btOk.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
			fasteningFactor = new BigDecimal(
				((EditText) findViewById(R.id.etFillFasteningFactor))
					.getText().toString());
			dialog.cancel();
		    }
		});*/
		final CharSequence[] items = {"Red", "Green", "Blue"};

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
		    }
		});
		AlertDialog alert = builder.create();
	    }
	});

	Button btSelectMaterial = (Button) findViewById(R.id.btFormStep2Select);
	Button btFillYoungModule = (Button) findViewById(R.id.btFormStep2FillIn);

	Button btCalculate = (Button) findViewById(R.id.btCalculate);
	//btCalculate.setOnClickListener(this);
	btCalculate.setOnClickListener(new OnClickListener() {
	    
	    public void onClick(View v) {
		if (isFormValid()) {
		    Intent intent = new Intent(getBaseContext(),
			    CalculationResultActivity.class);
		    intent.putExtra(RESULT, calulateFromForm());
		    startActivity(intent);
		} else {
		    Toast.makeText(context,
			    "You must fill all fields in order to calculate!",
			    Toast.LENGTH_SHORT).show();
		}
	    }
	});
    }

    private boolean isFormValid() {
	return (etLenght.length() > 0) && (etRadius.length() > 0)
		&& (etMass.length() > 0);
    }

    private BigDecimal calulateFromForm() {
	BigDecimal lenght = new BigDecimal(etLenght.getText().toString());
	BigDecimal radius = new BigDecimal(etRadius.getText().toString());
	BigDecimal mass = new BigDecimal(etMass.getText().toString());

	// TODO zamiennie zaleznie od tego co wybrano jako ostatnie,
	// wpisywanie czy wybieranie
	// Beam beam = new Beam(lenght, radius, mass, youngModulus,
	// fasteningFactor); // TODO
	Beam beam = new Beam(lenght, radius, mass, 0, 0);

	return beam.getCriticalPower();
    }

    /*public void onClick(View v) {
	if (isFormValid()) {
	    Intent intent = new Intent(getBaseContext(),
		    CalculationResultActivity.class);
	    intent.putExtra(RESULT, calulateFromForm());
	    startActivity(intent);
	} else {
	    Toast.makeText(context,
		    "You must fill all fields in order to calculate!",
		    Toast.LENGTH_SHORT).show();
	}
    }*/
}
