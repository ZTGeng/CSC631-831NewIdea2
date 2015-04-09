/**
 * TimeseriesRemoveRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WCFService_Portal;

public class TimeseriesRemoveRequest  extends org.datacontract.schemas._2004._07.WCFService_Portal.Request  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries;

    private java.lang.String timeseriesIdx;

    private org.datacontract.schemas._2004._07.LINQ2Entities.User user;

    public TimeseriesRemoveRequest() {
    }

    public TimeseriesRemoveRequest(
           org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries,
           java.lang.String timeseriesIdx,
           org.datacontract.schemas._2004._07.LINQ2Entities.User user) {
        this.timeseries = timeseries;
        this.timeseriesIdx = timeseriesIdx;
        this.user = user;
    }


    /**
     * Gets the timeseries value for this TimeseriesRemoveRequest.
     * 
     * @return timeseries
     */
    public org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries getTimeseries() {
        return timeseries;
    }


    /**
     * Sets the timeseries value for this TimeseriesRemoveRequest.
     * 
     * @param timeseries
     */
    public void setTimeseries(org.datacontract.schemas._2004._07.LINQ2Entities.Timeseries timeseries) {
        this.timeseries = timeseries;
    }


    /**
     * Gets the timeseriesIdx value for this TimeseriesRemoveRequest.
     * 
     * @return timeseriesIdx
     */
    public java.lang.String getTimeseriesIdx() {
        return timeseriesIdx;
    }


    /**
     * Sets the timeseriesIdx value for this TimeseriesRemoveRequest.
     * 
     * @param timeseriesIdx
     */
    public void setTimeseriesIdx(java.lang.String timeseriesIdx) {
        this.timeseriesIdx = timeseriesIdx;
    }


    /**
     * Gets the user value for this TimeseriesRemoveRequest.
     * 
     * @return user
     */
    public org.datacontract.schemas._2004._07.LINQ2Entities.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this TimeseriesRemoveRequest.
     * 
     * @param user
     */
    public void setUser(org.datacontract.schemas._2004._07.LINQ2Entities.User user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimeseriesRemoveRequest)) return false;
        TimeseriesRemoveRequest other = (TimeseriesRemoveRequest) obj;
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
            ((this.timeseriesIdx==null && other.getTimeseriesIdx()==null) || 
             (this.timeseriesIdx!=null &&
              this.timeseriesIdx.equals(other.getTimeseriesIdx()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser())));
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
        if (getTimeseriesIdx() != null) {
            _hashCode += getTimeseriesIdx().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeseriesRemoveRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "TimeseriesRemoveRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeseries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "Timeseries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "Timeseries"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeseriesIdx");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "TimeseriesIdx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "User"));
        elemField.setNillable(true);
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
