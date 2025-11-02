package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Annelies Hofman
 * Automated color categories
 */

@Entity
public class ColorCategory {

    @Id @GeneratedValue
    private Long colCatId;

    private String colCatName;

    private int hueMinValue;
    private int hueMaxValue;
    private int saturationMinValue;
    private int saturationMaxValue;
    private int lightnessMinValue;
    private int lightnessMaxValue;



// methods for extracting separate HSL values from Color

    public int getHSLHue(Color color) {
        return Integer.parseInt(color.getHue().substring(0, color.getHue().indexOf(",")));
    }
    public int getHSLSaturation(Color color) {
        return Integer.parseInt(color.getHue().substring((color.getHue().indexOf(" ")+1), color.getHue().indexOf("%")));
    }
    public int getHSLLightness(Color color) {
        return Integer.parseInt(color.getHue().substring((color.getHue().lastIndexOf(" ")+1), color.getHue().lastIndexOf("%")));
    }


 // getters & setters


    public Long getColCatId() {
        return colCatId;
    }
    public String getColCatName() {
        return colCatName;
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

