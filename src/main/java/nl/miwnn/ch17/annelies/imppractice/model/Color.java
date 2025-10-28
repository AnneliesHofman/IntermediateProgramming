package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Annelies Hofman
 * The values that make up a color, which can used to give color to an object
 */

@Entity
public class Color {

    @Id @GeneratedValue
    Integer colorId;

    String light;
    String hue;
    String shade;

    public Integer getColorId() {
        return colorId;
    }

    public String getHue() {
        return hue;
    }

    public String getLight() {
        return light;
    }

    public String getShade() {
        return shade;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public void setHue(String hue) {
        this.hue = hue;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }
}
