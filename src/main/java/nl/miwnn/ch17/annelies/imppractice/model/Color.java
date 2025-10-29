package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * @author Annelies Hofman
 * The values that make up a color, which can used to give color to an object
 */

@Entity
public class Color {

    @Id @GeneratedValue
    Long colorId;

    String light;
    String hue;
    String shade;

    @OneToMany(mappedBy = "color")
    private List<PaintCan> paintCans;

    public int getNumberOfPaintCans() {
        return paintCans.size();
    }

    public Long getColorId() {
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

    public void setColorId(Long colorId) {
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
