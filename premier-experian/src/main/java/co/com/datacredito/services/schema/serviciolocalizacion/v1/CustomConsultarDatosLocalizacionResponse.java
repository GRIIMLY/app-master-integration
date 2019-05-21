
package co.com.datacredito.services.schema.serviciolocalizacion.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomConsultarDatosLocalizacionReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customConsultarDatosLocalizacionReturn"
})
@XmlRootElement(name = "CustomConsultarDatosLocalizacionResponse")
public class CustomConsultarDatosLocalizacionResponse {

    @XmlElement(name = "CustomConsultarDatosLocalizacionReturn", required = true)
    protected String customConsultarDatosLocalizacionReturn;

    /**
     * Gets the value of the customConsultarDatosLocalizacionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomConsultarDatosLocalizacionReturn() {
        return customConsultarDatosLocalizacionReturn;
    }

    /**
     * Sets the value of the customConsultarDatosLocalizacionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomConsultarDatosLocalizacionReturn(String value) {
        this.customConsultarDatosLocalizacionReturn = value;
    }

}
