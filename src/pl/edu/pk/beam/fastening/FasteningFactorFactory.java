package pl.edu.pk.beam.fastening;

import java.math.BigDecimal;

import pl.edu.pk.buckling.R;

public abstract class FasteningFactorFactory {
    private static final Fastening[] fasteningsArray = {
	    new Fastening("zamocowanie na przegubach z g�ry i z do�u", new BigDecimal(1), R.drawable.fs1),
	    new Fastening("zamocowanie sztywne od do�u, g�ra swobodna", new BigDecimal(2), R.drawable.fs2),
	    new Fastening("zamocowanie sztywne od do�u i na przegubie od g�ry", new BigDecimal(0.699), R.drawable.fs3),
	    new Fastening("zamocowanie sztywne od do�u, g�ra przesuwna", new BigDecimal(0.5), R.drawable.fs4),
	    new Fastening("d� swobodny zamocowanie przesuwne od g�ry", new BigDecimal(1), R.drawable.fs5),
	    new Fastening("d� swobodny, g�ra na przegubie", new BigDecimal(2), R.drawable.fs6)};

    public static BigDecimal getAlpha(int fasteningId) {
	return fasteningsArray[fasteningId].getAlpha();
    }

    public static String getDescriptionForId(int fasteningId) {
	return fasteningsArray[fasteningId].getDescription();
    }
    
    public static CharSequence[] getAllDescriptions(){
	CharSequence[] descriptionsArray = new CharSequence[fasteningsArray.length];
	for(int i=0; i<fasteningsArray.length; i++){
	    descriptionsArray[i] = fasteningsArray[i].getDescription();
	}
	return descriptionsArray;
    }
    
    public static int getImageIdForId(int fasteningId) {
	return fasteningsArray[fasteningId].getImageId();
    }

}
