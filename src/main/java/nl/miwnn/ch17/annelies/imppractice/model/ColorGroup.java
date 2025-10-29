package nl.miwnn.ch17.annelies.imppractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Annelies Hofman
 * A way of grouping colors
 */

@Entity
public class ColorGroup {

    @Id @GeneratedValue
    private Long colorGroupId;

    private String colorGroupName;


    public Long getColorGroupId() {
        return colorGroupId;
    }

    public void setColorGroupId(Long colorGroupId) {
        this.colorGroupId = colorGroupId;
    }

    public String getColorGroupName() {
        return colorGroupName;
    }

    public void setColorGroupName(String colorGroupName) {
        this.colorGroupName = colorGroupName;
    }
}
