package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Annelies Hofman
 * TODO
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

    @ManyToOne
    private Color color;




    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getLightImage() {
        return lightImage;
    }

    public void setLightImage(String lightImage) {
        this.lightImage = lightImage;
    }

    public String getHueImage() {
        return hueImage;
    }

    public void setHueImage(String hueImage) {
        this.hueImage = hueImage;
    }

    public String getShadeImage() {
        return shadeImage;
    }

    public void setShadeImage(String shadeImage) {
        this.shadeImage = shadeImage;
    }

    public String getStaticImage() {
        return staticImage;
    }

    public void setStaticImage(String staticImage) {
        this.staticImage = staticImage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
