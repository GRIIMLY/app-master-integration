package com.holding.dto;

public class IdentificacionRequestDto {

    private String numero;
    private String tipo;

    /**
     * Obtiene el valor de la propiedad numero.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
