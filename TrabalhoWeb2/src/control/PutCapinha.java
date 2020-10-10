
package control;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import model.Capinha;


/**
 * <p>Classe Java de putCapinha complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="putCapinha">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://control/}capinha" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putCapinha", propOrder = {
    "arg0"
})
public class PutCapinha {

    protected Capinha arg0;

    /**
     * Obt�m o valor da propriedade arg0.
     * 
     * @return
     *     possible object is
     *     {@link Capinha }
     *     
     */
    public Capinha getArg0() {
        return arg0;
    }

    /**
     * Define o valor da propriedade arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link Capinha }
     *     
     */
    public void setArg0(Capinha value) {
        this.arg0 = value;
    }

}
