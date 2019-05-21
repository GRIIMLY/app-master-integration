
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
 *         &lt;element name="Solicitud">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SolicitudDatosLocalizacion">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TipoIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Identificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="PrimerApellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Issuedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "solicitud"
})
@XmlRootElement(name = "ConsultarDatosLocalizacion")
public class ConsultarDatosLocalizacion {

    @XmlElement(name = "Solicitud", required = true)
    protected ConsultarDatosLocalizacion.Solicitud solicitud;

    /**
     * Gets the value of the solicitud property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarDatosLocalizacion.Solicitud }
     *     
     */
    public ConsultarDatosLocalizacion.Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Sets the value of the solicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarDatosLocalizacion.Solicitud }
     *     
     */
    public void setSolicitud(ConsultarDatosLocalizacion.Solicitud value) {
        this.solicitud = value;
    }


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
     *         &lt;element name="SolicitudDatosLocalizacion">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TipoIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Identificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="PrimerApellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Issuedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "solicitudDatosLocalizacion"
    })
    public static class Solicitud {

        @XmlElement(name = "SolicitudDatosLocalizacion", required = true)
        protected ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion solicitudDatosLocalizacion;

        /**
         * Gets the value of the solicitudDatosLocalizacion property.
         * 
         * @return
         *     possible object is
         *     {@link ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion }
         *     
         */
        public ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion getSolicitudDatosLocalizacion() {
            return solicitudDatosLocalizacion;
        }

        /**
         * Sets the value of the solicitudDatosLocalizacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion }
         *     
         */
        public void setSolicitudDatosLocalizacion(ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion value) {
            this.solicitudDatosLocalizacion = value;
        }


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
         *         &lt;element name="TipoIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Identificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="PrimerApellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Issuedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "tipoIdentificacion",
            "identificacion",
            "usuario",
            "clave",
            "primerApellido",
            "name",
            "fullName",
            "issuedate"
        })
        public static class SolicitudDatosLocalizacion {

            @XmlElement(name = "TipoIdentificacion", required = true)
            protected String tipoIdentificacion;
            @XmlElement(name = "Identificacion", required = true)
            protected String identificacion;
            @XmlElement(name = "Usuario", required = true)
            protected String usuario;
            @XmlElement(name = "Clave", required = true)
            protected String clave;
            @XmlElement(name = "PrimerApellido", required = true)
            protected String primerApellido;
            @XmlElement(name = "Name")
            protected String name;
            @XmlElement(name = "FullName")
            protected String fullName;
            @XmlElement(name = "Issuedate")
            protected String issuedate;

            /**
             * Gets the value of the tipoIdentificacion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTipoIdentificacion() {
                return tipoIdentificacion;
            }

            /**
             * Sets the value of the tipoIdentificacion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTipoIdentificacion(String value) {
                this.tipoIdentificacion = value;
            }

            /**
             * Gets the value of the identificacion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentificacion() {
                return identificacion;
            }

            /**
             * Sets the value of the identificacion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentificacion(String value) {
                this.identificacion = value;
            }

            /**
             * Gets the value of the usuario property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUsuario() {
                return usuario;
            }

            /**
             * Sets the value of the usuario property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUsuario(String value) {
                this.usuario = value;
            }

            /**
             * Gets the value of the clave property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClave() {
                return clave;
            }

            /**
             * Sets the value of the clave property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClave(String value) {
                this.clave = value;
            }

            /**
             * Gets the value of the primerApellido property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrimerApellido() {
                return primerApellido;
            }

            /**
             * Sets the value of the primerApellido property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrimerApellido(String value) {
                this.primerApellido = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the fullName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFullName() {
                return fullName;
            }

            /**
             * Sets the value of the fullName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFullName(String value) {
                this.fullName = value;
            }

            /**
             * Gets the value of the issuedate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIssuedate() {
                return issuedate;
            }

            /**
             * Sets the value of the issuedate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIssuedate(String value) {
                this.issuedate = value;
            }

        }

    }

}
