package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

/**
 * Created by URAN on 30.07.2016.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop {

    @XmlElementWrapper(name = "goods")
    @XmlElement(name = "names")
    public String[] names;

    @XmlElement(name = "count")
    public int count;

    @XmlElement(name = "profit")
    public double profit;

    @XmlElement(name = "secretData")
    public String[] secretData;

    @Override
    public String toString() {
        return "Shop{" +
                "names=" + Arrays.toString(names) +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }
}
