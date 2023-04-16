package com.javafeatures;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "product")
public class Product implements Serializable {

    @XmlAttribute(name = "id")
    private int productId;
    @XmlAttribute(name = "name")
    private String name;

}
