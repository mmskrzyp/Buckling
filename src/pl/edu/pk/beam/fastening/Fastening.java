package pl.edu.pk.beam.fastening;

import java.math.BigDecimal;

public class Fastening {
    private BigDecimal alpha;
    private String description;
    private int imageId;
    
    public Fastening(String description, BigDecimal alpha, int imageId){
	setDescription(description);
	setAlpha(alpha);
	setImageId(imageId);
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

    public int getImageId() {
	return imageId;
    }

    public void setImageId(int imageId) {
	this.imageId = imageId;
    }

}
