package com.app.MapMetadata.Model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "metadata")
public class Metadata {

    @Id
    public String id;
    public String type;
    public Double rating;
    public Integer reviews;

}
