// .//GEN-BEGIN:_1_be
/******************************************************
 * Code Generated From JAFFA Framework Default Pattern
 * 
 * The JAFFA Project can be found at http://jaffa.sourceforge.net
 * and is available under the Lesser GNU Public License
 ******************************************************/
 package org.jaffa.modules.printing.components.formdefinitionviewer.ui;

import org.apache.log4j.Logger;
import java.util.EventObject;
import org.jaffa.presentation.portlet.component.Component;
import org.jaffa.presentation.portlet.FormKey;
import org.jaffa.exceptions.ApplicationExceptions;
import org.jaffa.exceptions.FrameworkException;
import org.jaffa.exceptions.DomainObjectNotFoundException;
import org.jaffa.datatypes.exceptions.MandatoryFieldException;
import org.jaffa.middleware.Factory;
import org.jaffa.components.finder.OrderByField;
import org.jaffa.components.maint.*;
import org.jaffa.components.dto.HeaderDto;

import org.jaffa.modules.printing.components.formdefinitionviewer.IFormDefinitionViewer;
import org.jaffa.modules.printing.components.formdefinitionviewer.dto.FormDefinitionViewerInDto;
import org.jaffa.modules.printing.components.formdefinitionviewer.dto.FormDefinitionViewerOutDto;
import org.jaffa.modules.printing.domain.FormDefinition;
import org.jaffa.modules.printing.domain.FormDefinitionMeta;



import org.jaffa.modules.printing.components.formdefinitionmaintenance.ui.FormDefinitionMaintenanceComponent;
// .//GEN-END:_1_be
// Add additional imports//GEN-FIRST:_imports
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jaffa.util.SplitString;
// .//GEN-LAST:_imports
// .//GEN-BEGIN:_2_be
/** The controller for the FormDefinitionViewer.
 */
public class FormDefinitionViewerComponent extends Component {
    
    private static Logger log = Logger.getLogger(FormDefinitionViewerComponent.class);
    private HeaderDto m_headerDto = null;

    private java.lang.Long m_formId;
    private FormDefinitionViewerOutDto m_outputDto = null;
    private IFormDefinitionViewer m_tx = null;

    private FormDefinitionMaintenanceComponent m_updateComponent = null;
    private IUpdateListener m_updateListener = null;
    // .//GEN-END:_2_be
    // .//GEN-BEGIN:_quit_1_be
    /** This should be invoked when done with the component.
     */    
    public void quit() {
        // .//GEN-END:_quit_1_be
        // Add custom code before processing the method//GEN-FIRST:_quit_1


        // .//GEN-LAST:_quit_1
        // .//GEN-BEGIN:_quit_2_be
        if (m_tx != null) {
            m_tx.destroy();
            m_tx = null;
        }
        if (m_updateComponent != null) {
            m_updateComponent.quit();
            m_updateComponent = null;
        }
        m_updateListener = null;

        m_outputDto = null;
        super.quit();
    }
    // .//GEN-END:_quit_2_be
    // .//GEN-BEGIN:formId_1_be
    /** Getter for property formId.
     * @return Value of property formId.
     */
    public java.lang.Long getFormId() {
        return m_formId;
    }
    
    /** Setter for property formId.
     * @param formId New value of property formId.
     */
    public void setFormId(java.lang.Long formId) {
        m_formId = formId;
    }
    // .//GEN-END:formId_1_be
    // .//GEN-BEGIN:_FormDefinitionViewerOutDto_1_be
    /** Getter for property outputDto.
     * @return Value of property outputDto.
     */    
    public FormDefinitionViewerOutDto getFormDefinitionViewerOutDto() {
        return m_outputDto;
    }
    
    /** Setter for property outputDto.
     * @param outputDto New value of property outputDto.
     */    
    public void setFormDefinitionViewerOutDto(FormDefinitionViewerOutDto outputDto) {
        m_outputDto = outputDto;
    }
    // .//GEN-END:_FormDefinitionViewerOutDto_1_be
    // .//GEN-BEGIN:_display_1_be
    /** This retrieves the details for the FormDefinition.
     * @throws ApplicationExceptions This will be thrown in case any invalid data has been set, or if no data has been set.
     * @throws FrameworkException Indicates some system error.
     * @return The FormKey for the View screen.
     */    
    public FormKey display() throws ApplicationExceptions, FrameworkException {
        ApplicationExceptions appExps = null;
        // .//GEN-END:_display_1_be
        // Add custom code before processing the method//GEN-FIRST:_display_1


        // .//GEN-LAST:_display_1
        // .//GEN-BEGIN:_display_2_be
        if (getFormId() == null) {
            if (appExps == null)
                appExps = new ApplicationExceptions();
            appExps.add(new MandatoryFieldException(FormDefinitionMeta.META_FORM_ID.getLabelToken()) );
        }
        if (appExps != null && appExps.size() > 0)
            throw appExps;

        doInquiry();
        return getViewerFormKey();
    }
    // .//GEN-END:_display_2_be
    // .//GEN-BEGIN:_inquiry_1_be
    private void doInquiry() throws ApplicationExceptions, FrameworkException {
        FormDefinitionViewerInDto inputDto = new FormDefinitionViewerInDto();
        // .//GEN-END:_inquiry_1_be
        // Add custom code before building the input dto//GEN-FIRST:_inquiry_1


        // .//GEN-LAST:_inquiry_1
        // .//GEN-BEGIN:_inquiry_2_be
        inputDto.setFormId(m_formId);

        inputDto.setHeaderDto(createHeaderDto());

        // create the Tx
        if (m_tx == null)
            m_tx = (IFormDefinitionViewer) Factory.createObject(IFormDefinitionViewer.class);

        // .//GEN-END:_inquiry_2_be
        // Add custom code before invoking the Tx//GEN-FIRST:_inquiry_2


        // .//GEN-LAST:_inquiry_2
        // .//GEN-BEGIN:_inquiry_3_be
        // now get the details
        m_outputDto = m_tx.read(inputDto);

        // uncache the widgets
        getUserSession().getWidgetCache(getComponentId()).clear();
        // .//GEN-END:_inquiry_3_be
        // Add custom code after invoking the Tx//GEN-FIRST:_inquiry_3


        // .//GEN-LAST:_inquiry_3
        // .//GEN-BEGIN:_inquiry_4_be
        // throw an exception if the output is null
        if (m_outputDto == null) {
            ApplicationExceptions appExps = new ApplicationExceptions();
            appExps.add(new DomainObjectNotFoundException(FormDefinitionMeta.getLabelToken()));
            throw appExps;
        }
    }
    // .//GEN-END:_inquiry_4_be
    // .//GEN-BEGIN:_createHeaderDto_1_be
    private HeaderDto createHeaderDto() {
        if (m_headerDto == null) {
            m_headerDto = new HeaderDto();
            m_headerDto.setUserId( getUserSession().getUserId() );
            m_headerDto.setVariation( getUserSession().getVariation() );
            // .//GEN-END:_createHeaderDto_1_be
            // Add custom code before processing the action//GEN-FIRST:_createHeaderDto_1


            // .//GEN-LAST:_createHeaderDto_1
            // .//GEN-BEGIN:_createHeaderDto_2_be
        }
        return m_headerDto;
    }
    // .//GEN-END:_createHeaderDto_2_be
    // .//GEN-BEGIN:_getViewerFormKey_1_be
    public FormKey getViewerFormKey() {
        return new FormKey(FormDefinitionViewerForm.NAME, getComponentId());
    }
    // .//GEN-END:_getViewerFormKey_1_be
    // .//GEN-BEGIN:_updateObject_1_be
    /** Calls the Jaffa.Printing.FormDefinitionMaintenance component for updating the FormDefinition object.
     * @throws ApplicationExceptions This will be thrown in case any invalid data has been set.
     * @throws FrameworkException Indicates some system error.
     * @return The FormKey for the Update screen.
     */
    public FormKey updateObject() throws ApplicationExceptions, FrameworkException {
        if (m_updateComponent == null || !m_updateComponent.isActive()) {
            m_updateComponent = (FormDefinitionMaintenanceComponent) run("Jaffa.Printing.FormDefinitionMaintenance");
            m_updateComponent.setReturnToFormKey(getViewerFormKey());
            addListeners(m_updateComponent);
        }
        m_updateComponent.setFormId(getFormId());
        if (m_updateComponent instanceof IMaintComponent)
            ((IMaintComponent) m_updateComponent).setMode(IMaintComponent.MODE_UPDATE);
        // .//GEN-END:_updateObject_1_be
        // Add custom code before invoking the component//GEN-FIRST:_updateObject_2


        // .//GEN-LAST:_updateObject_2
        // .//GEN-BEGIN:_updateObject_2_be
        return m_updateComponent.display();
    }

    private IUpdateListener getUpdateListener() {
        if (m_updateListener == null) {
            m_updateListener = new IUpdateListener() {
                public void updateDone(EventObject source) {
                    try {
                        // .//GEN-END:_updateObject_2_be
                        // Add custom code//GEN-FIRST:_updateObject_1


                        // .//GEN-LAST:_updateObject_1
                        // .//GEN-BEGIN:_updateObject_3_be
                        doInquiry();
                    } catch (Exception e) {
                        log.warn("Error in refreshing the Results screen after the Update", e);
                    }
                }
            };
        }
        return m_updateListener;
    }
    // .//GEN-END:_updateObject_3_be
    // .//GEN-BEGIN:_addListeners_1_be
    private void addListeners(Component comp) {
        if (comp  instanceof IUpdateComponent)
            ((IUpdateComponent) comp).addUpdateListener(getUpdateListener());
    }
    // .//GEN-END:_addListeners_1_be
    // All the custom code goes here//GEN-FIRST:_custom

    public File loadFormTemplate() throws FrameworkException,ApplicationExceptions,IOException{
        String formTemplate=getFormDefinitionViewerOutDto().getFormTemplate();

        if(formTemplate!=null){
            FormDefinitionViewerInDto inputDto=new FormDefinitionViewerInDto();
            inputDto.setFormId(m_formId);
            if(m_tx==null)
                m_tx=(IFormDefinitionViewer)Factory.createObject(IFormDefinitionViewer.class);
            byte[] formTemplateContents=m_tx.loadFormTemplate(inputDto);

//            int i = formTemplate.lastIndexOf(".pdf");
//            String prifix = i>0 ? formTemplate : formTemplate.substring(0,i);
//            File formTemplateFile=File.createTempFile(prifix,"pdf");

            
            SplitString ss = new SplitString(formTemplate, ".", false);
            String suffix = ss.getSuffix() != null ? "." + ss.getSuffix() : null;
            File formTemplateFile=File.createTempFile("jaffa", suffix);            
            
            OutputStream outputStream=null;
            try{
                outputStream=new BufferedOutputStream(new FileOutputStream(formTemplateFile));
                outputStream.write(formTemplateContents);
                outputStream.flush();
            }finally{
                if(outputStream!=null)
                    outputStream.close();
            }
            return formTemplateFile;
        }
        return null;
    }
    
    
    // .//GEN-LAST:_custom
}
