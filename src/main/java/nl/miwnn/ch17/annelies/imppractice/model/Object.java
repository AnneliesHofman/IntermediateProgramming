package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Annelies Hofman
 * An object is a piece of furniture in the catalogue
 */

@Entity
public class Object {

    @Id @GeneratedValue
    private Long objectId;
    //@Column(unique = true)
    private String objectName;

    private String lightImage;
    private String hueImage;
    private String shadeImage;
    private String staticImage;

    //Relations
    @ManyToOne
    private Color color;

    //Getters
    public Long getObjectId() {
        return objectId;
    }
    public String getObjectName() {
        return objectName;
    }

    public String getLightImage() {
        return lightImage;
    }
    public String getHueImage() {
        return hueImage;
    }
    public String getShadeImage() {
        return shadeImage;
    }
    public String getStaticImage() {
        return staticImage;
    }

    public Color getColor() {
        return color;
    }

    //Setters
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setLightImage(String lightImage) {
        this.lightImage = lightImage;
    }
    public void setHueImage(String hueImage) {
        this.hueImage = hueImage;
    }
    public void setShadeImage(String shadeImage) {
        this.shadeImage = shadeImage;
    }
    public void setStaticImage(String staticImage) {
        this.staticImage = staticImage;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
