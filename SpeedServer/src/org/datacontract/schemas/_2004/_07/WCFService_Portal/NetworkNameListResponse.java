/**
 * NetworkNameListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WCFService_Portal;

public class NetworkNameListResponse  extends org.datacontract.schemas._2004._07.WCFService_Portal.Response  implements java.io.Serializable {
    private java.lang.Integer curPage;

    private java.lang.String message;

    private org.datacontract.schemas._2004._07.WCFService_Portal.NetworkNameID[] networkNameIDList;

    private java.lang.String orderBy;

    private java.lang.Integer pageAvailable;

    public NetworkNameListResponse() {
    }

    public NetworkNameListResponse(
           java.lang.String _message,
           java.lang.Integer curPage,
           java.lang.String message,
           org.datacontract.schemas._2004._07.WCFService_Portal.NetworkNameID[] networkNameIDList,
           java.lang.String orderBy,
           java.lang.Integer pageAvailable) {
        super(
            _message);
        this.curPage = curPage;
        this.message = message;
        this.networkNameIDList = networkNameIDList;
        this.orderBy = orderBy;
        this.pageAvailable = pageAvailable;
    }


    /**
     * Gets the curPage value for this NetworkNameListResponse.
     * 
     * @return curPage
     */
    public java.lang.Integer getCurPage() {
        return curPage;
    }


    /**
     * Sets the curPage value for this NetworkNameListResponse.
     * 
     * @param curPage
     */
    public void setCurPage(java.lang.Integer curPage) {
        this.curPage = curPage;
    }


    /**
     * Gets the message value for this NetworkNameListResponse.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this NetworkNameListResponse.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the networkNameIDList value for this NetworkNameListResponse.
     * 
     * @return networkNameIDList
     */
    public org.datacontract.schemas._2004._07.WCFService_Portal.NetworkNameID[] getNetworkNameIDList() {
        return networkNameIDList;
    }


    /**
     * Sets the networkNameIDList value for this NetworkNameListResponse.
     * 
     * @param networkNameIDList
     */
    public void setNetworkNameIDList(org.datacontract.schemas._2004._07.WCFService_Portal.NetworkNameID[] networkNameIDList) {
        this.networkNameIDList = networkNameIDList;
    }


    /**
     * Gets the orderBy value for this NetworkNameListResponse.
     * 
     * @return orderBy
     */
    public java.lang.String getOrderBy() {
        return orderBy;
    }


    /**
     * Sets the orderBy value for this NetworkNameListResponse.
     * 
     * @param orderBy
     */
    public void setOrderBy(java.lang.String orderBy) {
        this.orderBy = orderBy;
    }


    /**
     * Gets the pageAvailable value for this NetworkNameListResponse.
     * 
     * @return pageAvailable
     */
    public java.lang.Integer getPageAvailable() {
        return pageAvailable;
    }


    /**
     * Sets the pageAvailable value for this NetworkNameListResponse.
     * 
     * @param pageAvailable
     */
    public void setPageAvailable(java.lang.Integer pageAvailable) {
        this.pageAvailable = pageAvailable;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NetworkNameListResponse)) return false;
        NetworkNameListResponse other = (NetworkNameListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.curPage==null && other.getCurPage()==null) || 
             (this.curPage!=null &&
              this.curPage.equals(other.getCurPage()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.networkNameIDList==null && other.getNetworkNameIDList()==null) || 
             (this.networkNameIDList!=null &&
              java.util.Arrays.equals(this.networkNameIDList, other.getNetworkNameIDList()))) &&
            ((this.orderBy==null && other.getOrderBy()==null) || 
             (this.orderBy!=null &&
              this.orderBy.equals(other.getOrderBy()))) &&
            ((this.pageAvailable==null && other.getPageAvailable()==null) || 
             (this.pageAvailable!=null &&
              this.pageAvailable.equals(other.getPageAvailable())));
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
        if (getCurPage() != null) {
            _hashCode += getCurPage().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getNetworkNameIDList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNetworkNameIDList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNetworkNameIDList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrderBy() != null) {
            _hashCode += getOrderBy().hashCode();
        }
        if (getPageAvailable() != null) {
            _hashCode += getPageAvailable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NetworkNameListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "NetworkNameListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "CurPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("networkNameIDList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "NetworkNameIDList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "NetworkNameID"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "NetworkNameID"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "OrderBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageAvailable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "PageAvailable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
