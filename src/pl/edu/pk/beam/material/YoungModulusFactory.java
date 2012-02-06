package pl.edu.pk.beam.material;

import java.math.BigDecimal;

public abstract class YoungModulusFactory {
    private static final Material[] materialsArray = {
	    new Material("Guma", new BigDecimal(0.01)),
	    new Material("Polietylen (LDPE)", new BigDecimal(0.2)),
	    new Material("Polipropylen (PP)", new BigDecimal(1.5)),
	    new Material("Poli(tereftalan etylenu) (PET)", new BigDecimal(2.0)),
	    new Material("Polistyren (PS)", new BigDecimal(3.0)),
	    new Material("Nylon", new BigDecimal(2.0)),
	    new Material("Drewno dêbowe (wzd³u¿ w³ókien)", new BigDecimal(11.0)),
	    new Material("Beton", new BigDecimal(27.0)),
	    new Material("Magnez (Mg)", new BigDecimal(45.0)),
	    new Material("Stop glinu (aluminium) (Al)", new BigDecimal(69.0)),
	    new Material("Szk³o (SiO2,Na2CO3, CaCO3)", new BigDecimal(72.0)),
	    new Material("Mosi¹dz (Cu, Zn) i Br¹z (Cu, Sn)", new BigDecimal(103.0)),
	    new Material("Tytan (Ti)", new BigDecimal(105.0)),
	    new Material("Kompozyt z w³ókna wêglowego", new BigDecimal(150.0)),
	    new Material("¯elazo kute i stal", new BigDecimal(190.0)),
	    new Material("Wolfram (W)", new BigDecimal(400.0)),
	    new Material("Wêglik krzemu (SiC)", new BigDecimal(450.0)),
	    new Material("Wêglik tytanu (TiC)", new BigDecimal(450.0)),
	    new Material("MiedŸ", new BigDecimal(100.0)),
	    new Material("Cynk", new BigDecimal(84.0)),
	    new Material("O³ów", new BigDecimal(16.0)),
	    new Material("Cyna", new BigDecimal(47.0)),
	    new Material("Nanorurka", new BigDecimal(1000.0)),
	    new Material("Diament (C)", new BigDecimal(1050.0)) };

    public static BigDecimal getYoungModule(int materialId) {
	return materialsArray[materialId].getYoungModule();
    }

    public static String getNameForId(int materialId) {
	return materialsArray[materialId].getName();
    }
}
