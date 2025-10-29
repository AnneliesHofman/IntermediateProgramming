package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Annelies Hofman
 * A paintcan is a single item that holds paint of a specific color
 */

@Entity
public class PaintCan {

    protected static final int DEFAULT_LITERS = 1;
    @Id
    @GeneratedValue
    private Long objectId;

    Integer liters;

    @ManyToOne
    private Color color;



    public PaintCan(Color color) {
        this.color = color;
        this.liters = DEFAULT_LITERS;
    }

    public PaintCan() {
    }



    public Long getObjectId() {
        return objectId;
    }

    public Integer getLiters() {
        return liters;
    }

    public Color getColor() {
        return color;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public void setLiters(Integer liters) {
        this.liters = liters;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
