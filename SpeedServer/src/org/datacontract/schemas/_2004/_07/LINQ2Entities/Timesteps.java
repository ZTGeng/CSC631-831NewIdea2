/**
 * Timesteps.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.LINQ2Entities;

public class Timesteps  extends org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityObject  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries;

    private java.lang.String timeseriesId;

    private org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfTimeserieshovVakal timeseriesReference;

    private java.lang.Double valX;

    private java.lang.Double valY;

    private java.lang.String id;

    public Timesteps() {
    }

    public Timesteps(
           org.apache.axis.types.Id _id,
           org.apache.axis.types.IDRef ref,
           org.datacontract.schemas._2004._07.System_Data.EntityKey entityKey,
           org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries,
           java.lang.String timeseriesId,
           org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfTimeserieshovVakal timeseriesReference,
           java.lang.Double valX,
           java.lang.Double valY,
           java.lang.String id) {
        super(
            _id,
            ref,
            entityKey);
        this.timeseries = timeseries;
        this.timeseriesId = timeseriesId;
        this.timeseriesReference = timeseriesReference;
        this.valX = valX;
        this.valY = valY;
        this.id = id;
    }


    /**
     * Gets the timeseries value for this Timesteps.
     * 
     * @return timeseries
     */
    public org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries getTimeseries() {
        return timeseries;
    }


    /**
     * Sets the timeseries value for this Timesteps.
     * 
     * @param timeseries
     */
    public void setTimeseries(org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries) {
        this.timeseries = timeseries;
    }


    /**
     * Gets the timeseriesId value for this Timesteps.
     * 
     * @return timeseriesId
     */
    public java.lang.String getTimeseriesId() {
        return timeseriesId;
    }


    /**
     * Sets the timeseriesId value for this Timesteps.
     * 
     * @param timeseriesId
     */
    public void setTimeseriesId(java.lang.String timeseriesId) {
        this.timeseriesId = timeseriesId;
    }


    /**
     * Gets the timeseriesReference value for this Timesteps.
     * 
     * @return timeseriesReference
     */
    public org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfTimeserieshovVakal getTimeseriesReference() {
        return timeseriesReference;
    }


    /**
     * Sets the timeseriesReference value for this Timesteps.
     * 
     * @param timeseriesReference
     */
    public void setTimeseriesReference(org.datacontract.schemas._2004._07.System_Data_Objects_DataClasses.EntityReferenceOfTimeserieshovVakal timeseriesReference) {
        this.timeseriesReference = timeseriesReference;
    }


    /**
     * Gets the valX value for this Timesteps.
     * 
     * @return valX
     */
    public java.lang.Double getValX() {
        return valX;
    }


    /**
     * Sets the valX value for this Timesteps.
     * 
     * @param valX
     */
    public void setValX(java.lang.Double valX) {
        this.valX = valX;
    }


    /**
     * Gets the valY value for this Timesteps.
     * 
     * @return valY
     */
    public java.lang.Double getValY() {
        return valY;
    }


    /**
     * Sets the valY value for this Timesteps.
     * 
     * @param valY
     */
    public void setValY(java.lang.Double valY) {
        this.valY = valY;
    }


    /**
     * Gets the id value for this Timesteps.
     * 
     * @return id
     */
/*    public java.lang.String getId() {
        return id;
    }
*/

    /**
     * Sets the id value for this Timesteps.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Timesteps)) return false;
        Timesteps other = (Timesteps) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.timeseries==null && other.getTimeseries()==null) || 
             (this.timeseries!=null &&
              this.timeseries.equals(other.getTimeseries()))) &&
            ((this.timeseriesId==null && other.getTimeseriesId()==null) || 
             (this.timeseriesId!=null &&
              this.timeseriesId.equals(other.getTimeseriesId()))) &&
            ((this.timeseriesReference==null && other.getTimeseriesReference()==null) || 
             (this.timeseriesReference!=null &&
              this.timeseriesReference.equals(other.getTimeseriesReference()))) &&
            ((this.valX==null && other.getValX()==null) || 
             (this.valX!=null &&
              this.valX.equals(other.getValX()))) &&
            ((this.valY==null && other.getValY()==null) || 
             (this.valY!=null &&
              this.valY.equals(other.getValY()))) &&
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
        if (getTimeseries() != null) {
            _hashCode += getTimeseries().hashCode();
        }
        if (getTimeseriesId() != null) {
            _hashCode += getTimeseriesId().hashCode();
        }
        if (getTimeseriesReference() != null) {
            _hashCode += getTimeseriesReference().hashCode();
        }
        if (getValX() != null) {
            _hashCode += getValX().hashCode();
        }
        if (getValY() != null) {
            _hashCode += getValY().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Timesteps.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Timesteps"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeseries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Timeseries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Timeseries"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeseriesId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "TimeseriesId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeseriesReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "TimeseriesReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", "EntityReferenceOfTimeserieshovVakal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "ValX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "ValY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
