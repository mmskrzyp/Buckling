package pl.edu.pk.beam;

import java.math.BigDecimal;

import pl.edu.pk.beam.fastening.FasteningFactorFactory;
import pl.edu.pk.beam.material.YoungModulusFactory;

public class Beam {
    private BigDecimal momentOfInteria;
    private BigDecimal lenght;
    
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
		.multiply(momentOfInteria)
		.multiply(BigDecimal.valueOf(Math.PI * Math.PI))
		.divide(lenghtReduced.multiply(lenghtReduced));
    }

}
