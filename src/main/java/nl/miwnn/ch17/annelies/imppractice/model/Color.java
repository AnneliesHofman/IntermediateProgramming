package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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

    //@Column(unique = true)
    String colorName;

    @ManyToMany
    private Set<ColorGroup> colorGroups;


    @OneToMany(mappedBy = "color")
    private List<PaintCan> paintCans;



    public int getNumberOfPaintCans() {
        return paintCans.size();
    }


    // getters
    public Long getColorId() {
        return colorId;
    }

    public String getColorName() {
        return colorName;
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

    public List<PaintCan> getPaintCans() {
        return paintCans;
    }

    public Set<ColorGroup> getColorGroups() {
        return colorGroups;
    }



    // setters
    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public void setColorGroups(Set<ColorGroup> colorGroups) {
        this.colorGroups = colorGroups;
    }

    public void setPaintCans(List<PaintCan> paintCans) {
        this.paintCans = paintCans;
    }
}
