package org.m2i.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("V")
@XmlType(name="V")
public class Versment extends Operation {
	

}
