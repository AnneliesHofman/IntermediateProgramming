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

    protected static final Integer DEFAULT_MIN_VALUE = 0;
    protected static final Integer DEFAULT_HUE_MAX_VALUE = 360;
    protected static final Integer DEFAULT_SAT_LT_MAX_VALUE = 100;
    protected static final String DEFAULT_NAME = null;

    @Id @GeneratedValue
    private Long colCatId;
    private String colCatName;

    private int hueMinValue;
    private int hueMaxValue;
    private int saturationMinValue;
    private int saturationMaxValue;
    private int lightnessMinValue;
    private int lightnessMaxValue;

    //Relations
    @ManyToMany
    private Set<Color> catColors;

    //Constructors
    public ColorCategory(String colCatName,
                         int hueMinValue, int hueMaxValue,
                         int saturationMinValue, int saturationMaxValue,
                         int lightnessMinValue, int lightnessMaxValue) {
        this.colCatName = colCatName;
        this.hueMinValue = hueMinValue;
        this.hueMaxValue = hueMaxValue;
        this.saturationMinValue = saturationMinValue;
        this.saturationMaxValue = saturationMaxValue;
        this.lightnessMinValue = lightnessMinValue;
        this.lightnessMaxValue = lightnessMaxValue;
    }

    public ColorCategory() {
        this.colCatName = DEFAULT_NAME;
        this.hueMinValue = DEFAULT_MIN_VALUE;
        this.hueMaxValue = DEFAULT_HUE_MAX_VALUE;
        this.saturationMinValue = DEFAULT_MIN_VALUE;
        this.saturationMaxValue = DEFAULT_SAT_LT_MAX_VALUE;
        this.lightnessMinValue = DEFAULT_MIN_VALUE;
        this.lightnessMaxValue = DEFAULT_SAT_LT_MAX_VALUE;
    }

    //Getters
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

    public Set<Color> getCatColors() {
        return catColors;
    }

    //Setters
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

    public void setCatColors(Set<Color> catColors) {
        this.catColors = catColors;
    }
}

