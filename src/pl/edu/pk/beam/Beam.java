package pl.edu.pk.beam;

import java.math.BigDecimal;

import pl.edu.pk.beam.fastening.FasteningFactorFactory;
import pl.edu.pk.beam.material.YoungModulusFactory;
import pl.edu.pk.buckling.R;

public class Beam {
    private BigDecimal lenght;
    private BigDecimal mass;
    // TODO pozosta³e wymiary potrzebne do liczenia momentu bezwladnosci

    private final int materialId = 0; // jeden z gotowych materia³ów
    private BigDecimal youngModule; // rêcznie wpisany modu³ Younga

    private int fasteningId; // jedno z gotowych zamocowañ
    private BigDecimal fasteningFactor; // rêcznie wpisana alpha dla zamocowania

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
