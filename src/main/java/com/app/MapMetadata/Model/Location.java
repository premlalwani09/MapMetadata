package com.app.MapMetadata.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "locations")
public class Location {

    @Id
    public String id;
    public double latitude;
    public double longitude;

}
