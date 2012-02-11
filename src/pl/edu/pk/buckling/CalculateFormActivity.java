package pl.edu.pk.buckling;

import java.math.BigDecimal;

import pl.edu.pk.beam.Beam;
import pl.edu.pk.beam.fastening.FasteningFactorFactory;
import pl.edu.pk.beam.material.YoungModulusFactory;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CalculateFormActivity extends Activity implements OnClickListener {
    public static final String RESULT = "result";
    private Context context = this;

    private EditText etLenght;
    private EditText etRadius;
    private EditText etMass;
    private ToggleButton tbtSelectFastening;
    private ToggleButton tbtFillFasteningFactor;
    private ToggleButton tbtSelectMaterial;
    private ToggleButton tbtFillYoungModule;

    private BigDecimal fasteningFactor;
    private BigDecimal youngModulus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calculate_form_layout);

	etLenght = (EditText) findViewById(R.id.etFormStep3Lenght);
	etRadius = (EditText) findViewById(R.id.etFormStep4Radius);
	etMass = (EditText) findViewById(R.id.etFormStep5Mass);

	tbtSelectFastening = (ToggleButton) findViewById(R.id.tbtFormStep1Select);
	tbtSelectFastening.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		createSelectFasteningDialog();
	    }
	});

	tbtFillFasteningFactor = (ToggleButton) findViewById(R.id.tbtFormStep1FillIn);
	tbtFillFasteningFactor.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		createFillFasteningFactorDialog();
	    }
	});

	tbtSelectMaterial = (ToggleButton) findViewById(R.id.tbtFormStep2Select);
	tbtSelectMaterial.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		createSelectMaterialDialog();
	    }
	});

	tbtFillYoungModule = (ToggleButton) findViewById(R.id.tbtFormStep2FillIn);
	tbtFillYoungModule.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		createFillYoungModulusDialog();
	    }
	});

	Button btCalculate = (Button) findViewById(R.id.btCalculate);
	btCalculate.setOnClickListener(this);
    }

    private boolean isFormValid(EditText... et) {
	boolean isValid = true;
	for (int i = 0; i < et.length; i++) {
	    isValid = isValid && (et[i].length() > 0);
	}
	return isValid;
    }

    private BigDecimal calulateFromForm() {
	BigDecimal lenght = new BigDecimal(etLenght.getText().toString());
	BigDecimal radius = new BigDecimal(etRadius.getText().toString());
	BigDecimal mass = new BigDecimal(etMass.getText().toString());

	Beam beam = new Beam(lenght, radius, mass, youngModulus,
		fasteningFactor);

	return beam.getCriticalPower();
    }

    private void createSelectFasteningDialog() {
	final CharSequence[] items = FasteningFactorFactory
		.getAllDescriptions();

	AlertDialog.Builder builder = new AlertDialog.Builder(context);
	builder.setTitle(R.string.select_fastening);
	builder.setCancelable(false);
	builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
	    public void onClick(DialogInterface dialog, int item) {
		fasteningFactor = FasteningFactorFactory.getAlpha(item);
		createFasteningImageToast(item);
	    }
	});
	builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
	    public void onClick(DialogInterface dialog, int which) {
		tbtSelectFastening.setChecked(true);
		tbtFillFasteningFactor.setChecked(false);
	    }
	    
	});
	builder.setNeutralButton(R.string.cancel,
		new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int which) {
			tbtSelectFastening.setChecked(!tbtSelectFastening
				.isChecked());
		    }
		});
	AlertDialog dialog = builder.create();
	dialog.setOnCancelListener(new OnCancelListener() {
	    public void onCancel(DialogInterface dialog) {
		tbtSelectFastening.setChecked(false);
	    }
	});
	dialog.show();
    }
    
    private void createFasteningImageToast(int itemId){
	LayoutInflater inflater = getLayoutInflater();
	View layout = inflater.inflate(R.layout.fastening_image_toast,
	                               (ViewGroup) findViewById(R.id.toast_layout_root));
	ImageView image = (ImageView) layout.findViewById(R.id.ivFastening);
	image.setImageResource(FasteningFactorFactory.getImageIdForId(itemId));
	TextView alphaText = (TextView) layout.findViewById(R.id.tvAlpha);
	alphaText.setText("alpha = " + FasteningFactorFactory.getAlpha(itemId).toString());
	
	Toast toast = new Toast(context);
	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	toast.setDuration(Toast.LENGTH_SHORT);
	toast.setView(layout);
	toast.show();
    }

    private void createFillFasteningFactorDialog() {
	final Dialog dialog = new Dialog(context);
	dialog.setContentView(R.layout.fill_in_fastening_factor_dialog);
	dialog.setTitle(R.string.fill_in_fastening_factor);
	dialog.setCancelable(false);

	final EditText etFasteningFactor = (EditText) dialog
		.findViewById(R.id.etFillFasteningFactor);

	Button btOk = (Button) dialog
		.findViewById(R.id.btFillFasteningFactorOk);
	btOk.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		if (isFormValid(etFasteningFactor)) {
		    fasteningFactor = new BigDecimal(etFasteningFactor
			    .getText().toString());
		    tbtSelectFastening.setChecked(false);
		    tbtFillFasteningFactor.setChecked(true);
		    dialog.dismiss();
		} else {
		    Toast.makeText(context, R.string.fastening_factor_can_t_be_empty_,
			    Toast.LENGTH_SHORT).show();
		}
	    }
	});
	Button btCancel = (Button) dialog
		.findViewById(R.id.btFillFasteningFactorCancel);
	btCancel.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		tbtFillFasteningFactor.setChecked(!tbtFillFasteningFactor
			.isChecked());
		dialog.dismiss();
	    }
	});
	dialog.show();
    }

    private void createSelectMaterialDialog() {
	final CharSequence[] items = YoungModulusFactory.getAllNames();

	AlertDialog.Builder builder = new AlertDialog.Builder(context);
	builder.setTitle(R.string.select_material);
	builder.setCancelable(false);
	builder.setItems(items, new DialogInterface.OnClickListener() {
	    public void onClick(DialogInterface dialog, int item) {
		tbtSelectMaterial.setChecked(true);
		tbtFillYoungModule.setChecked(false);
		youngModulus = YoungModulusFactory.getYoungModule(item);
	    }
	});
	builder.setNeutralButton(R.string.cancel,
		new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int which) {
			tbtSelectMaterial.setChecked(!tbtSelectMaterial
				.isChecked());
			dialog.dismiss();
		    }
		});
	AlertDialog dialog = builder.create();
	dialog.setOnCancelListener(new OnCancelListener() {
	    public void onCancel(DialogInterface dialog) {
		tbtSelectMaterial.setChecked(false);
	    }
	});
	dialog.show();
    }

    private void createFillYoungModulusDialog() {
	final Dialog dialog = new Dialog(context);
	dialog.setContentView(R.layout.fill_in_young_modulus_dialog);
	dialog.setTitle(R.string.fill_in_young_modulus);
	dialog.setCancelable(false);

	final EditText etYoungModulus = (EditText) dialog
		.findViewById(R.id.etFillYoungModulus);

	Button btOk = (Button) dialog.findViewById(R.id.btFillYoungModulusOk);
	btOk.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		if (isFormValid(etYoungModulus)) {
		    youngModulus = new BigDecimal(etYoungModulus.getText()
			    .toString());
		    tbtSelectMaterial.setChecked(false);
		    tbtFillYoungModule.setChecked(true);
		    dialog.dismiss();
		} else {
		    Toast.makeText(context, R.string.young_modulus_can_t_be_empty_,
			    Toast.LENGTH_SHORT).show();
		}
	    }
	});
	Button btCancel = (Button) dialog
		.findViewById(R.id.btFillYoungModulusCancel);
	btCancel.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
		tbtFillYoungModule.setChecked(!tbtFillYoungModule
			.isChecked());
		dialog.dismiss();
	    }
	});
	dialog.show();
    }

    public void onClick(View v) {
	if (isFormValid(etLenght, etRadius, etMass)) {
	    Intent intent = new Intent(getBaseContext(),
		    CalculationResultActivity.class);
	    intent.putExtra(RESULT, calulateFromForm());
	    startActivity(intent);
	} else {
	    Toast.makeText(context,
		    R.string.you_must_fill_all_fields_in_order_to_calculate_,
		    Toast.LENGTH_SHORT).show();
	}
    }
}
