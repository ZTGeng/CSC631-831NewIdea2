/**
 * EntityReferenceOfNetwork3DViewCtrlSettinghovVakal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses;

public class EntityReferenceOfNetwork3DViewCtrlSettinghovVakal  extends org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReference  implements java.io.Serializable {
    public EntityReferenceOfNetwork3DViewCtrlSettinghovVakal() {
    }

    public EntityReferenceOfNetwork3DViewCtrlSettinghovVakal(
           org.datacontract.schemas._2004._07.System_Data.EntityKey entityKey) {
        super(
            entityKey);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntityReferenceOfNetwork3DViewCtrlSettinghovVakal)) return false;
        EntityReferenceOfNetwork3DViewCtrlSettinghovVakal other = (EntityReferenceOfNetwork3DViewCtrlSettinghovVakal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityReferenceOfNetwork3DViewCtrlSettinghovVakal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", "EntityReferenceOfNetwork3DViewCtrlSettinghovVakal"));
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
