/**
 * NetworkParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.LINQ2Entities;

public class NetworkParameters  extends org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityObject  implements java.io.Serializable {
    private java.lang.String networkId;

    private org.datacontract.schemas._2004._07.LINQ2Entities.Networks networks;

    private org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfNetworkshovVakal networksReference;

    private java.lang.String propertyName;

    private java.lang.Float propertyValue;

    private java.lang.String id;

    public NetworkParameters() {
    }

    public NetworkParameters(
           org.apache.axis.types.Id _id,
           org.apache.axis.types.IDRef ref,
           org.datacontract.schemas._2004._07.System_Data.EntityKey entityKey,
           java.lang.String networkId,
           org.datacontract.schemas._2004._07.LINQ2Entities.Networks networks,
           org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfNetworkshovVakal networksReference,
           java.lang.String propertyName,
           java.lang.Float propertyValue,
           java.lang.String id) {
        super(
            _id,
            ref,
            entityKey);
        this.networkId = networkId;
        this.networks = networks;
        this.networksReference = networksReference;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.id = id;
    }


    /**
     * Gets the networkId value for this NetworkParameters.
     * 
     * @return networkId
     */
    public java.lang.String getNetworkId() {
        return networkId;
    }


    /**
     * Sets the networkId value for this NetworkParameters.
     * 
     * @param networkId
     */
    public void setNetworkId(java.lang.String networkId) {
        this.networkId = networkId;
    }


    /**
     * Gets the networks value for this NetworkParameters.
     * 
     * @return networks
     */
    public org.datacontract.schemas._2004._07.LINQ2Entities.Networks getNetworks() {
        return networks;
    }


    /**
     * Sets the networks value for this NetworkParameters.
     * 
     * @param networks
     */
    public void setNetworks(org.datacontract.schemas._2004._07.LINQ2Entities.Networks networks) {
        this.networks = networks;
    }


    /**
     * Gets the networksReference value for this NetworkParameters.
     * 
     * @return networksReference
     */
    public org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfNetworkshovVakal getNetworksReference() {
        return networksReference;
    }


    /**
     * Sets the networksReference value for this NetworkParameters.
     * 
     * @param networksReference
     */
    public void setNetworksReference(org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfNetworkshovVakal networksReference) {
        this.networksReference = networksReference;
    }


    /**
     * Gets the propertyName value for this NetworkParameters.
     * 
     * @return propertyName
     */
    public java.lang.String getPropertyName() {
        return propertyName;
    }


    /**
     * Sets the propertyName value for this NetworkParameters.
     * 
     * @param propertyName
     */
    public void setPropertyName(java.lang.String propertyName) {
        this.propertyName = propertyName;
    }


    /**
     * Gets the propertyValue value for this NetworkParameters.
     * 
     * @return propertyValue
     */
    public java.lang.Float getPropertyValue() {
        return propertyValue;
    }


    /**
     * Sets the propertyValue value for this NetworkParameters.
     * 
     * @param propertyValue
     */
    public void setPropertyValue(java.lang.Float propertyValue) {
        this.propertyValue = propertyValue;
    }


    /**
     * Gets the id value for this NetworkParameters.
     * 
     * @return id
     */
/*    public java.lang.String getId() {
        return id;
    }
*/

    /**
     * Sets the id value for this NetworkParameters.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NetworkParameters)) return false;
        NetworkParameters other = (NetworkParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.networkId==null && other.getNetworkId()==null) || 
             (this.networkId!=null &&
              this.networkId.equals(other.getNetworkId()))) &&
            ((this.networks==null && other.getNetworks()==null) || 
             (this.networks!=null &&
              this.networks.equals(other.getNetworks()))) &&
            ((this.networksReference==null && other.getNetworksReference()==null) || 
             (this.networksReference!=null &&
              this.networksReference.equals(other.getNetworksReference()))) &&
            ((this.propertyName==null && other.getPropertyName()==null) || 
             (this.propertyName!=null &&
              this.propertyName.equals(other.getPropertyName()))) &&
            ((this.propertyValue==null && other.getPropertyValue()==null) || 
             (this.propertyValue!=null &&
              this.propertyValue.equals(other.getPropertyValue()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getNetworkId() != null) {
            _hashCode += getNetworkId().hashCode();
        }
        if (getNetworks() != null) {
            _hashCode += getNetworks().hashCode();
        }
        if (getNetworksReference() != null) {
            _hashCode += getNetworksReference().hashCode();
        }
        if (getPropertyName() != null) {
            _hashCode += getPropertyName().hashCode();
        }
        if (getPropertyValue() != null) {
            _hashCode += getPropertyValue().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NetworkParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "NetworkParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("networkId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "NetworkId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("networks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Networks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Networks"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("networksReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "NetworksReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", "EntityReferenceOfNetworkshovVakal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "PropertyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "PropertyValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
