package pl.edu.pk.beam.fastening;

import java.math.BigDecimal;
import pl.edu.pk.buckling.R;

public class Fastening {
    private BigDecimal alpha;
    private String description;
    
    public Fastening(String description, BigDecimal alpha){
	setDescription(description);
	setAlpha(alpha);
    }

    public BigDecimal getAlpha() {
	return alpha;
    }

    public void setAlpha(BigDecimal alpha) {
	this.alpha = alpha;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
