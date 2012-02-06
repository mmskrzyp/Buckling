package pl.edu.pk.beam.material;

import java.math.BigDecimal;

public class Material {
    private BigDecimal youngModule;
    private String name;
    
    public Material(String name, BigDecimal youngModule) {
	setName(name);
	setYoungModule(youngModule);
    }

    public BigDecimal getYoungModule() {
	return youngModule;
    }

    public void setYoungModule(BigDecimal youngModule) {
	this.youngModule = youngModule;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
