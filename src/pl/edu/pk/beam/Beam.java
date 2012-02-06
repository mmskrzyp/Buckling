package pl.edu.pk.beam;

import java.math.BigDecimal;

import pl.edu.pk.beam.fastening.FasteningFactorFactory;
import pl.edu.pk.beam.material.YoungModulusFactory;

public class Beam {
    private BigDecimal lenght;
    private BigDecimal mass;
    private BigDecimal radius;
    private BigDecimal youngModule; // rêcznie wpisany modu³ Younga
    private BigDecimal fasteningFactor; // rêcznie wpisana alpha dla zamocowania

    public Beam(BigDecimal lenght, BigDecimal radius, BigDecimal mass,
	    BigDecimal youngModule, BigDecimal fasteningFactor) {
	this.lenght = lenght;
	this.radius = radius;
	this.mass = mass;
	this.youngModule = youngModule;
	this.fasteningFactor = fasteningFactor;
    }

    public Beam(BigDecimal lenght, BigDecimal radius, BigDecimal mass,
	    int materialId, BigDecimal fasteningFactor) {
	this(lenght, radius, mass, YoungModulusFactory
		.getYoungModule(materialId), fasteningFactor);
    }

    public Beam(BigDecimal lenght, BigDecimal radius, BigDecimal mass,
	    BigDecimal youngModule, int fasteningId) {
	this(lenght, radius, mass, youngModule, FasteningFactorFactory
		.getAlpha(fasteningId));
    }

    public Beam(BigDecimal lenght, BigDecimal radius, BigDecimal mass,
	    int materialId, int fasteningId) {
	this(lenght, radius, mass, YoungModulusFactory
		.getYoungModule(materialId), FasteningFactorFactory
		.getAlpha(fasteningId));
    }

    public BigDecimal getCriticalPower() {
	BigDecimal lenghtReduced = lenght.multiply(fasteningFactor);

	return youngModule.multiply(getMomentOfInteria())
		.multiply(BigDecimal.valueOf(Math.PI * Math.PI))
		.divide(lenghtReduced.multiply(lenghtReduced));
    }

    private BigDecimal getMomentOfInteria() {
	return mass.multiply(radius).multiply(radius);
    }

}
