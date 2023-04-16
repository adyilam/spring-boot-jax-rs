package com.javafeatures;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "products")
public class Products {

    @XmlElement(name = "products")
    private ArrayList<Product> products;

}
