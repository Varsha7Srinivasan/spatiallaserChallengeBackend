package com.example.entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name= "dallas_rent")
public class RentalProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="mls")
    private BigDecimal mls;

    @Column(name="rent")
    private BigDecimal rent;

    @Column(name="lat")
    private BigDecimal lat;

    @Column(name="long")
    private BigDecimal lon;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    @Column(name="geometry")
    private Point geometry;

}
