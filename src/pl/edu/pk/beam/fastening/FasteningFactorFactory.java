package pl.edu.pk.beam.fastening;

import java.math.BigDecimal;
import pl.edu.pk.buckling.R;

public abstract class FasteningFactorFactory {
    private static final Fastening[] fasteningsArray = {
	    new Fastening("pierwsze zamocowanie", new BigDecimal(1)),
	    new Fastening("drugie zamocowanie", new BigDecimal(2)),
	    new Fastening("trzecie zamocowanie", new BigDecimal(Math.sqrt(2) / 2)),
	    new Fastening("czwarte zamocowanie", new BigDecimal(Math.sqrt(2) / 2)),
	    new Fastening("pi¹te zamocowanie", new BigDecimal(1 / 2)) };

    public static BigDecimal getAlpha(int fasteningId) {
	return fasteningsArray[fasteningId].getAlpha();
    }

    public static String getDescriptionForId(int fasteningId) {
	return fasteningsArray[fasteningId].getDescription();
    }

}
