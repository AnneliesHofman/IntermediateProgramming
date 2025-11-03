package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

/**
 * @author Annelies Hofman
 * Automated color categories
 */

@Entity
public class ColorCategory {

    @Id @GeneratedValue
    private Long colCatId;

    private String colCatName;
    @ManyToMany
    private Set<Color> catColors;

    private int hueMinValue;
    private int hueMaxValue;
    private int saturationMinValue;
    private int saturationMaxValue;
    private int lightnessMinValue;
    private int lightnessMaxValue;

    // methodes
//    // first attempt, add colors to category
//    public void calcColorsInHueCat(ColorCategory colCat, Color color) {
//        if (calcHueFit(colCat, color)) {
//            colCat.getCatColors().add(color);
//        }
//    }
//
//
//    // methods to compare color's HSL to category's min and max values
//    public boolean calcHueFit(ColorCategory colCat, Color color) {
//        int colHue = separateHue(color);
//        return ((colHue > colCat.hueMinValue) && (colHue < colCat.hueMaxValue));
//    }
//    public boolean calcSatFit(ColorCategory colCat, Color color) {
//        int colSat = separateSaturation(color);
//        return ((colSat > colCat.saturationMinValue) && (colSat < colCat.saturationMaxValue));
//    }
//    public boolean calcLightFit(ColorCategory colCat, Color color) {
//        int colLight = separateLightness(color);
//        return ((colLight > colCat.lightnessMinValue) && (colLight < colCat.lightnessMaxValue));
//    }
//
//    // methods for extracting separate Hue Saturation and Lightness values from Color
//    // (based on color gradient's medium color (hue)
//    public int separateHue(Color color) {
//        return Integer.parseInt(color.getHue().substring(0,
//                color.getHue().indexOf(",")));
//    }
//    public int separateSaturation(Color color) {
//        return Integer.parseInt(color.getHue().substring((color.getHue().indexOf(" ")+1),
//                color.getHue().indexOf("%")));
//    }
//    public int separateLightness(Color color) {
//        return Integer.parseInt(color.getHue().substring((color.getHue().lastIndexOf(" ")+1),
//                color.getHue().lastIndexOf("%")));
//    }

 // getters & setters
    public Long getColCatId() {
        return colCatId;
    }
    public String getColCatName() {
        return colCatName;
    }
    public Set<Color> getCatColors() {
        return catColors;
    }

    public int getHueMinValue() {
        return hueMinValue;
    }
    public int getHueMaxValue() {
        return hueMaxValue;
    }

    public int getSaturationMinValue() {
        return saturationMinValue;
    }
    public int getSaturationMaxValue() {
        return saturationMaxValue;
    }

    public int getLightnessMinValue() {
        return lightnessMinValue;
    }
    public int getLightnessMaxValue() {
        return lightnessMaxValue;
    }

    public void setColCatId(Long colCatId) {
        this.colCatId = colCatId;
    }
    public void setColCatName(String colCatName) {
        this.colCatName = colCatName;
    }
    public void setCatColors(Set<Color> catColors) {
        this.catColors = catColors;
    }

    public void setHueMinValue(int hueMinValue) {
        this.hueMinValue = hueMinValue;
    }
    public void setHueMaxValue(int hueMaxValue) {
        this.hueMaxValue = hueMaxValue;
    }

    public void setSaturationMinValue(int saturationMinValue) {
        this.saturationMinValue = saturationMinValue;
    }
    public void setSaturationMaxValue(int saturationMaxValue) {
        this.saturationMaxValue = saturationMaxValue;
    }

    public void setLightnessMinValue(int lightnessMinValue) {
        this.lightnessMinValue = lightnessMinValue;
    }
    public void setLightnessMaxValue(int lightnessMaxValue) {
        this.lightnessMaxValue = lightnessMaxValue;
    }
}

