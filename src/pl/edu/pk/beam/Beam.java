package pl.edu.pk.beam;

import java.math.BigDecimal;

import pl.edu.pk.beam.fastening.FasteningFactorFactory;
import pl.edu.pk.beam.material.YoungModulusFactory;
import pl.edu.pk.buckling.R;

public class Beam {
    private BigDecimal lenght;
    private BigDecimal mass;
    // TODO pozosta�e wymiary potrzebne do liczenia momentu bezwladnosci

    private final int materialId = 0; // jeden z gotowych materia��w
    private BigDecimal youngModule; // r�cznie wpisany modu� Younga

    private int fasteningId; // jedno z gotowych zamocowa�
    private BigDecimal fasteningFactor; // r�cznie wpisana alpha dla zamocowania

    public Beam(/* tutaj wszystkie wymagane pola ^ */) {
	// TODO inicjalizacja obiektu
    }

    public BigDecimal getCriticalPower() {
	BigDecimal lenghtReduced = lenght.multiply(FasteningFactorFactory
		.getAlpha(fasteningId));

	return YoungModulusFactory.getYoungModule(materialId)
		.multiply(getMomentOfInteria())
		.multiply(BigDecimal.valueOf(Math.PI * Math.PI))
		.divide(lenghtReduced.multiply(lenghtReduced));
    }

    private BigDecimal getMomentOfInteria() {
	// TODO
	return null;
    }

}
