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
    private Long colorId;
    //@Column(unique = true)
    private String colorName;

    private String light;
    private String hue;
    private String shade;

    //Relations
    @OneToMany(mappedBy = "color")
    private List<Object> objects;
    @ManyToMany
    private Set<ColorGroup> colorGroups;
    @OneToMany(mappedBy = "color")
    private List<PaintCan> paintCans;

    //Constructors
    public Color(String light, String hue, String shade) {
        this.light = light;
        this.hue = hue;
        this.shade = shade;
    }
    public Color () {
    }

    //Methodes

    //Getters
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

    public List<Object> getObjects() {
        return objects;
    }
    public Set<ColorGroup> getColorGroups() {
        return colorGroups;
    }

    //Setters
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

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
    public void setColorGroups(Set<ColorGroup> colorGroups) {
        this.colorGroups = colorGroups;
    }

    //PaintCan getter & setter
    public List<PaintCan> getPaintCans() {
        return paintCans;
    }
    public void setPaintCans(List<PaintCan> paintCans) {
        this.paintCans = paintCans;
    }
}
