
package co.com.datacredito.services.schema.serviciolocalizacion.v1;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Conf" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Params" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
    "solicitud",
    "conf"
})
@XmlRootElement(name = "CustomConsultarDatosLocalizacion")
public class CustomConsultarDatosLocalizacion {

    @XmlElement(name = "Solicitud", required = true)
    protected CustomConsultarDatosLocalizacion.Solicitud solicitud;
    @XmlElement(name = "Conf")
    protected CustomConsultarDatosLocalizacion.Conf conf;

    /**
     * Gets the value of the solicitud property.
     * 
     * @return
     *     possible object is
     *     {@link CustomConsultarDatosLocalizacion.Solicitud }
     *     
     */
    public CustomConsultarDatosLocalizacion.Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Sets the value of the solicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomConsultarDatosLocalizacion.Solicitud }
     *     
     */
    public void setSolicitud(CustomConsultarDatosLocalizacion.Solicitud value) {
        this.solicitud = value;
    }

    /**
     * Gets the value of the conf property.
     * 
     * @return
     *     possible object is
     *     {@link CustomConsultarDatosLocalizacion.Conf }
     *     
     */
    public CustomConsultarDatosLocalizacion.Conf getConf() {
        return conf;
    }

    /**
     * Sets the value of the conf property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomConsultarDatosLocalizacion.Conf }
     *     
     */
    public void setConf(CustomConsultarDatosLocalizacion.Conf value) {
        this.conf = value;
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
     *         &lt;element name="Params" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "params"
    })
    public static class Conf {

        @XmlElement(name = "Params")
        protected CustomConsultarDatosLocalizacion.Conf.Params params;

        /**
         * Gets the value of the params property.
         * 
         * @return
         *     possible object is
         *     {@link CustomConsultarDatosLocalizacion.Conf.Params }
         *     
         */
        public CustomConsultarDatosLocalizacion.Conf.Params getParams() {
            return params;
        }

        /**
         * Sets the value of the params property.
         * 
         * @param value
         *     allowed object is
         *     {@link CustomConsultarDatosLocalizacion.Conf.Params }
         *     
         */
        public void setParams(CustomConsultarDatosLocalizacion.Conf.Params value) {
            this.params = value;
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
         *         &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "param"
        })
        public static class Params {

            @XmlElement(name = "Param")
            protected List<CustomConsultarDatosLocalizacion.Conf.Params.Param> param;

            /**
             * Gets the value of the param property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the param property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParam().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CustomConsultarDatosLocalizacion.Conf.Params.Param }
             * 
             * 
             */
            public List<CustomConsultarDatosLocalizacion.Conf.Params.Param> getParam() {
                if (param == null) {
                    param = new ArrayList<CustomConsultarDatosLocalizacion.Conf.Params.Param>();
                }
                return this.param;
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
             *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "name",
                "value"
            })
            public static class Param {

                @XmlElement(name = "Name", required = true)
                protected String name;
                @XmlElement(name = "Value", required = true)
                protected String value;

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
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

            }

        }

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
        protected CustomConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion solicitudDatosLocalizacion;

        /**
         * Gets the value of the solicitudDatosLocalizacion property.
         * 
         * @return
         *     possible object is
         *     {@link CustomConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion }
         *     
         */
        public CustomConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion getSolicitudDatosLocalizacion() {
            return solicitudDatosLocalizacion;
        }

        /**
         * Sets the value of the solicitudDatosLocalizacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link CustomConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion }
         *     
         */
        public void setSolicitudDatosLocalizacion(CustomConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion value) {
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
            "primerApellido"
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

        }

    }

}
