
package co.com.datacredito.services.schema.serviciolocalizacion.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServicioLocalizacionException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServicioLocalizacionException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Business" type="{http://www.datacredito.com.co/services/schema/ServicioLocalizacion/v1}Business" minOccurs="0"/>
 *         &lt;element name="Runtime" type="{http://www.datacredito.com.co/services/schema/ServicioLocalizacion/v1}Runtime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicioLocalizacionException", propOrder = {
    "business",
    "runtime"
})
public class ServicioLocalizacionException {

    @XmlElement(name = "Business")
    protected Business business;
    @XmlElement(name = "Runtime")
    protected Runtime runtime;

    /**
     * Gets the value of the business property.
     * 
     * @return
     *     possible object is
     *     {@link Business }
     *     
     */
    public Business getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     * 
     * @param value
     *     allowed object is
     *     {@link Business }
     *     
     */
    public void setBusiness(Business value) {
        this.business = value;
    }

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link Runtime }
     *     
     */
    public Runtime getRuntime() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Runtime }
     *     
     */
    public void setRuntime(Runtime value) {
        this.runtime = value;
    }

}
