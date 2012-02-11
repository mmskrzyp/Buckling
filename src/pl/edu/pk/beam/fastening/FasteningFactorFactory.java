package pl.edu.pk.beam.fastening;

import java.math.BigDecimal;

import pl.edu.pk.buckling.R;

public abstract class FasteningFactorFactory {
    private static final Fastening[] fasteningsArray = {
	    new Fastening("zamocowanie na przegubach z góry i z do³u", new BigDecimal(1), R.drawable.fs1),
	    new Fastening("zamocowanie sztywne od do³u, góra swobodna", new BigDecimal(2), R.drawable.fs2),
	    new Fastening("zamocowanie sztywne od do³u i na przegubie od góry", new BigDecimal(0.699), R.drawable.fs3),
	    new Fastening("zamocowanie sztywne od do³u, góra przesuwna", new BigDecimal(0.5), R.drawable.fs4),
	    new Fastening("dó³ swobodny zamocowanie przesuwne od góry", new BigDecimal(1), R.drawable.fs5),
	    new Fastening("dó³ swobodny, góra na przegubie", new BigDecimal(2), R.drawable.fs6)};

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
