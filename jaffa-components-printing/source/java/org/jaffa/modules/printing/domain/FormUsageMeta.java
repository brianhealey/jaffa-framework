// .//GEN-BEGIN:1_be
/******************************************************
 * Code Generated From JAFFA Framework Default Pattern
 * 
 * The JAFFA Project can be found at http://jaffa.sourceforge.net
 * and is available under the Lesser GNU Public License
 ******************************************************/ 
package org.jaffa.modules.printing.domain;

import org.jaffa.metadata.*;
import java.util.*;

// .//GEN-END:1_be
// Add additional imports//GEN-FIRST:imports




// .//GEN-LAST:imports
// .//GEN-BEGIN:2_be
/** This class has the meta information for the FormUsage persistent class.
 */
public class FormUsageMeta {
    
    // domain-object class name
    private static String m_name = "org.jaffa.modules.printing.domain.FormUsage";

    // token to be used for getting the label for the domain-object
    private static String m_labelToken = "[label.Jaffa.Printing.FormUsage]";



    // Field constants
    /** A constant to identity the FormName field.*/
    public static final String FORM_NAME = "FormName";
    /** A constant to identity the EventName field.*/
    public static final String EVENT_NAME = "EventName";
    /** A constant to identity the FormAlternate field.*/
    public static final String FORM_ALTERNATE = "FormAlternate";
    /** A constant to identity the Copies field.*/
    public static final String COPIES = "Copies";
    /** A constant to identity the CreatedOn field.*/
    public static final String CREATED_ON = "CreatedOn";
    /** A constant to identity the CreatedBy field.*/
    public static final String CREATED_BY = "CreatedBy";
    /** A constant to identity the LastChangedOn field.*/
    public static final String LAST_CHANGED_ON = "LastChangedOn";
    /** A constant to identity the LastChangedBy field.*/
    public static final String LAST_CHANGED_BY = "LastChangedBy";


    // Meta Data Definitions

    /** A constant which holds the meta information for the FormName field.*/
    public static final FieldMetaData META_FORM_NAME = new StringFieldMetaData(FORM_NAME, "[label.Jaffa.Printing.FormGroup.FormName]", Boolean.TRUE, null, new Integer(20), FieldMetaData.UPPER_CASE);

    /** A constant which holds the meta information for the EventName field.*/
    public static final FieldMetaData META_EVENT_NAME = new StringFieldMetaData(EVENT_NAME, "[label.Jaffa.Printing.FormEvent.EventName]", Boolean.TRUE, null, new Integer(20), FieldMetaData.UPPER_CASE);

    /** A constant which holds the meta information for the FormAlternate field.*/
    public static final FieldMetaData META_FORM_ALTERNATE = new StringFieldMetaData(FORM_ALTERNATE, "[label.Jaffa.Printing.FormDefinition.FormAlternate]", Boolean.FALSE, null, new Integer(20), FieldMetaData.UPPER_CASE);

    /** A constant which holds the meta information for the Copies field.*/
    public static final FieldMetaData META_COPIES = new IntegerFieldMetaData(COPIES, "[label.Jaffa.Printing.FormUsage.Copies]", Boolean.FALSE, null, null, null, new Integer(8));

    /** A constant which holds the meta information for the CreatedOn field.*/
    public static final FieldMetaData META_CREATED_ON = new DateTimeFieldMetaData(CREATED_ON, "[label.Jaffa.Common.CreatedOn]", Boolean.FALSE, null, null, null);

    /** A constant which holds the meta information for the CreatedBy field.*/
    public static final FieldMetaData META_CREATED_BY = new StringFieldMetaData(CREATED_BY, "[label.Jaffa.Common.CreatedBy]", Boolean.FALSE, null, new Integer(20), FieldMetaData.UPPER_CASE);

    /** A constant which holds the meta information for the LastChangedOn field.*/
    public static final FieldMetaData META_LAST_CHANGED_ON = new DateTimeFieldMetaData(LAST_CHANGED_ON, "[label.Jaffa.Common.LastChangedOn]", Boolean.FALSE, null, null, null);

    /** A constant which holds the meta information for the LastChangedBy field.*/
    public static final FieldMetaData META_LAST_CHANGED_BY = new StringFieldMetaData(LAST_CHANGED_BY, "[label.Jaffa.Common.LastChangedBy]", Boolean.FALSE, null, new Integer(20), FieldMetaData.UPPER_CASE);



    // Map of FieldConstants + MetaDataDefinitions
    private static Map m_fieldMap = new HashMap();
    static {
        m_fieldMap.put(FORM_NAME, META_FORM_NAME);
        m_fieldMap.put(EVENT_NAME, META_EVENT_NAME);
        m_fieldMap.put(FORM_ALTERNATE, META_FORM_ALTERNATE);
        m_fieldMap.put(COPIES, META_COPIES);
        m_fieldMap.put(CREATED_ON, META_CREATED_ON);
        m_fieldMap.put(CREATED_BY, META_CREATED_BY);
        m_fieldMap.put(LAST_CHANGED_ON, META_LAST_CHANGED_ON);
        m_fieldMap.put(LAST_CHANGED_BY, META_LAST_CHANGED_BY);
    }
    
    // List of MetaDataDefinitions for key fields
    private static List m_keyFields = new LinkedList();
    static {
        m_keyFields.add(META_FORM_NAME);
        m_keyFields.add(META_EVENT_NAME);
    }
    
    // List of MetaDataDefinitions for mandatory fields
    private static List m_mandatoryFields = new LinkedList();
    static {
        m_mandatoryFields.add(META_FORM_NAME);
        m_mandatoryFields.add(META_EVENT_NAME);
    }
    
    
    
    
    
    /** Returns the name of the persistent class.
     * @return the name of the persistent class.
     */
    public static String getName() {
        return m_name;
    }
    
    /** Getter for property labelToken.
     * @return Value of property labelToken.
     */
    public static String getLabelToken() {
        return m_labelToken;
    }
    
    /** This returns an array of all the fields of the persistent class.
     * @return an array of all the fields of the persistent class.
     */
    public static String[] getAttributes() {
        return DomainMetaDataHelper.getAttributes(m_fieldMap);
    }
    
    /** This returns an array of meta information for all the fields of the persistent class.
     * @return an array of meta information for all the fields of the persistent class.
     */
    public static FieldMetaData[] getFieldMetaData() {
        return DomainMetaDataHelper.getFieldMetaData(m_fieldMap);
    }
    
    /** This returns meta information for the input field.
     * @param fieldName the field name.
     * @return meta information for the input field.
     */
    public static FieldMetaData getFieldMetaData(String fieldName) {
        return DomainMetaDataHelper.getFieldMetaData(m_fieldMap, fieldName);
    }

    /** This returns an array of meta information for all the key fields of the persistent class.
     * @return an array of meta information for all the key fields of the persistent class.
     */
    public static FieldMetaData[] getKeyFields() {
        return (FieldMetaData[]) m_keyFields.toArray(new FieldMetaData[0]);
    }
    
    /** This returns an array of meta information for all the mandatory fields of the persistent class.
     * @return an array of meta information for all the mandatory fields of the persistent class.
     */
    public static FieldMetaData[] getMandatoryFields() {
        return (FieldMetaData[]) m_mandatoryFields.toArray(new FieldMetaData[0]);
    }
    
// .//GEN-END:2_be
// All the custom code goes here//GEN-FIRST:custom






// .//GEN-LAST:custom
}
