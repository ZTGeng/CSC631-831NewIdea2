/**
 * NetworkSearchRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WCFService_Portal;

public class NetworkSearchRequest  extends org.datacontract.schemas._2004._07.WCFService_Portal.Request  implements java.io.Serializable {
    private java.lang.Boolean DESC;

    private java.lang.Boolean LOAD;

    private java.lang.Boolean loadPropertiesOnly;

    private java.lang.String orderBy;

    private java.lang.Integer page;

    private java.lang.Integer pageSize;

    private java.lang.Boolean paramSearch;

    private java.lang.Object[] searchParameters;

    private java.lang.Boolean textSearch;

    private java.lang.Integer textSearchMode;

    private org.datacontract.schemas._2004._07.LINQ2Entities.User user;

    private java.lang.String whereClause;

    public NetworkSearchRequest() {
    }

    public NetworkSearchRequest(
           java.lang.Boolean DESC,
           java.lang.Boolean LOAD,
           java.lang.Boolean loadPropertiesOnly,
           java.lang.String orderBy,
           java.lang.Integer page,
           java.lang.Integer pageSize,
           java.lang.Boolean paramSearch,
           java.lang.Object[] searchParameters,
           java.lang.Boolean textSearch,
           java.lang.Integer textSearchMode,
           org.datacontract.schemas._2004._07.LINQ2Entities.User user,
           java.lang.String whereClause) {
        this.DESC = DESC;
        this.LOAD = LOAD;
        this.loadPropertiesOnly = loadPropertiesOnly;
        this.orderBy = orderBy;
        this.page = page;
        this.pageSize = pageSize;
        this.paramSearch = paramSearch;
        this.searchParameters = searchParameters;
        this.textSearch = textSearch;
        this.textSearchMode = textSearchMode;
        this.user = user;
        this.whereClause = whereClause;
    }


    /**
     * Gets the DESC value for this NetworkSearchRequest.
     * 
     * @return DESC
     */
    public java.lang.Boolean getDESC() {
        return DESC;
    }


    /**
     * Sets the DESC value for this NetworkSearchRequest.
     * 
     * @param DESC
     */
    public void setDESC(java.lang.Boolean DESC) {
        this.DESC = DESC;
    }


    /**
     * Gets the LOAD value for this NetworkSearchRequest.
     * 
     * @return LOAD
     */
    public java.lang.Boolean getLOAD() {
        return LOAD;
    }


    /**
     * Sets the LOAD value for this NetworkSearchRequest.
     * 
     * @param LOAD
     */
    public void setLOAD(java.lang.Boolean LOAD) {
        this.LOAD = LOAD;
    }


    /**
     * Gets the loadPropertiesOnly value for this NetworkSearchRequest.
     * 
     * @return loadPropertiesOnly
     */
    public java.lang.Boolean getLoadPropertiesOnly() {
        return loadPropertiesOnly;
    }


    /**
     * Sets the loadPropertiesOnly value for this NetworkSearchRequest.
     * 
     * @param loadPropertiesOnly
     */
    public void setLoadPropertiesOnly(java.lang.Boolean loadPropertiesOnly) {
        this.loadPropertiesOnly = loadPropertiesOnly;
    }


    /**
     * Gets the orderBy value for this NetworkSearchRequest.
     * 
     * @return orderBy
     */
    public java.lang.String getOrderBy() {
        return orderBy;
    }


    /**
     * Sets the orderBy value for this NetworkSearchRequest.
     * 
     * @param orderBy
     */
    public void setOrderBy(java.lang.String orderBy) {
        this.orderBy = orderBy;
    }


    /**
     * Gets the page value for this NetworkSearchRequest.
     * 
     * @return page
     */
    public java.lang.Integer getPage() {
        return page;
    }


    /**
     * Sets the page value for this NetworkSearchRequest.
     * 
     * @param page
     */
    public void setPage(java.lang.Integer page) {
        this.page = page;
    }


    /**
     * Gets the pageSize value for this NetworkSearchRequest.
     * 
     * @return pageSize
     */
    public java.lang.Integer getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this NetworkSearchRequest.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the paramSearch value for this NetworkSearchRequest.
     * 
     * @return paramSearch
     */
    public java.lang.Boolean getParamSearch() {
        return paramSearch;
    }


    /**
     * Sets the paramSearch value for this NetworkSearchRequest.
     * 
     * @param paramSearch
     */
    public void setParamSearch(java.lang.Boolean paramSearch) {
        this.paramSearch = paramSearch;
    }


    /**
     * Gets the searchParameters value for this NetworkSearchRequest.
     * 
     * @return searchParameters
     */
    public java.lang.Object[] getSearchParameters() {
        return searchParameters;
    }


    /**
     * Sets the searchParameters value for this NetworkSearchRequest.
     * 
     * @param searchParameters
     */
    public void setSearchParameters(java.lang.Object[] searchParameters) {
        this.searchParameters = searchParameters;
    }


    /**
     * Gets the textSearch value for this NetworkSearchRequest.
     * 
     * @return textSearch
     */
    public java.lang.Boolean getTextSearch() {
        return textSearch;
    }


    /**
     * Sets the textSearch value for this NetworkSearchRequest.
     * 
     * @param textSearch
     */
    public void setTextSearch(java.lang.Boolean textSearch) {
        this.textSearch = textSearch;
    }


    /**
     * Gets the textSearchMode value for this NetworkSearchRequest.
     * 
     * @return textSearchMode
     */
    public java.lang.Integer getTextSearchMode() {
        return textSearchMode;
    }


    /**
     * Sets the textSearchMode value for this NetworkSearchRequest.
     * 
     * @param textSearchMode
     */
    public void setTextSearchMode(java.lang.Integer textSearchMode) {
        this.textSearchMode = textSearchMode;
    }


    /**
     * Gets the user value for this NetworkSearchRequest.
     * 
     * @return user
     */
    public org.datacontract.schemas._2004._07.LINQ2Entities.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this NetworkSearchRequest.
     * 
     * @param user
     */
    public void setUser(org.datacontract.schemas._2004._07.LINQ2Entities.User user) {
        this.user = user;
    }


    /**
     * Gets the whereClause value for this NetworkSearchRequest.
     * 
     * @return whereClause
     */
    public java.lang.String getWhereClause() {
        return whereClause;
    }


    /**
     * Sets the whereClause value for this NetworkSearchRequest.
     * 
     * @param whereClause
     */
    public void setWhereClause(java.lang.String whereClause) {
        this.whereClause = whereClause;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NetworkSearchRequest)) return false;
        NetworkSearchRequest other = (NetworkSearchRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.DESC==null && other.getDESC()==null) || 
             (this.DESC!=null &&
              this.DESC.equals(other.getDESC()))) &&
            ((this.LOAD==null && other.getLOAD()==null) || 
             (this.LOAD!=null &&
              this.LOAD.equals(other.getLOAD()))) &&
            ((this.loadPropertiesOnly==null && other.getLoadPropertiesOnly()==null) || 
             (this.loadPropertiesOnly!=null &&
              this.loadPropertiesOnly.equals(other.getLoadPropertiesOnly()))) &&
            ((this.orderBy==null && other.getOrderBy()==null) || 
             (this.orderBy!=null &&
              this.orderBy.equals(other.getOrderBy()))) &&
            ((this.page==null && other.getPage()==null) || 
             (this.page!=null &&
              this.page.equals(other.getPage()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.paramSearch==null && other.getParamSearch()==null) || 
             (this.paramSearch!=null &&
              this.paramSearch.equals(other.getParamSearch()))) &&
            ((this.searchParameters==null && other.getSearchParameters()==null) || 
             (this.searchParameters!=null &&
              java.util.Arrays.equals(this.searchParameters, other.getSearchParameters()))) &&
            ((this.textSearch==null && other.getTextSearch()==null) || 
             (this.textSearch!=null &&
              this.textSearch.equals(other.getTextSearch()))) &&
            ((this.textSearchMode==null && other.getTextSearchMode()==null) || 
             (this.textSearchMode!=null &&
              this.textSearchMode.equals(other.getTextSearchMode()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.whereClause==null && other.getWhereClause()==null) || 
             (this.whereClause!=null &&
              this.whereClause.equals(other.getWhereClause())));
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
        if (getDESC() != null) {
            _hashCode += getDESC().hashCode();
        }
        if (getLOAD() != null) {
            _hashCode += getLOAD().hashCode();
        }
        if (getLoadPropertiesOnly() != null) {
            _hashCode += getLoadPropertiesOnly().hashCode();
        }
        if (getOrderBy() != null) {
            _hashCode += getOrderBy().hashCode();
        }
        if (getPage() != null) {
            _hashCode += getPage().hashCode();
        }
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getParamSearch() != null) {
            _hashCode += getParamSearch().hashCode();
        }
        if (getSearchParameters() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchParameters());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchParameters(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTextSearch() != null) {
            _hashCode += getTextSearch().hashCode();
        }
        if (getTextSearchMode() != null) {
            _hashCode += getTextSearchMode().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getWhereClause() != null) {
            _hashCode += getWhereClause().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NetworkSearchRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "NetworkSearchRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "DESC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOAD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "LOAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loadPropertiesOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "LoadPropertiesOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "OrderBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("page");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "Page"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "PageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paramSearch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "ParamSearch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchParameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "SearchParameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "anyType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textSearch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "TextSearch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textSearchMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "TextSearchMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/LINQ2Entities", "User"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whereClause");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WCFService.Portal", "WhereClause"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
