package nl.miwnn.ch17.annelies.imppractice.model;

/**
 * @author Annelies Hofman
 * The values that make up a color, which can used to give color to an object
 */
public class Color {

    String light;
    String hue;
    String shade;

    public Color(String light, String hue, String shade) {
        this.light = light;
        this.hue = hue;
        this.shade = shade;
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
