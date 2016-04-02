/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import core.Config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import java.awt.Component;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;

//panel 1 todo config the file chooser for a folder
//explore those folder in order to get all ths file in a list

//panel 2 select the filter or edit them

//panel 3 display the result
//and some metrics number of sans indice
//

@ActionID(category = "File",
id = "org.gephi.desktop.filters.TestAction")
@ActionRegistration(displayName = "#CTL_TestAction")
@ActionReferences({
    @ActionReference(path = "Menu/Plugins", position = 3333)
})
@Messages("CTL_TestAction=PDF References")
public final class MenuAction implements ActionListener {
    
    Config mConfig=null;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        System.out.println("menuclick1");
        
        mConfig= new Config();
        
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
        PDFrefWizardPanelFile WPFile=new PDFrefWizardPanelFile();
        WPFile.setConfig(mConfig);
        panels.add(WPFile);
        panels.add(new PDFrefWizardPanel2());
        panels.add(new PDFrefWizardPanel3());
        String[] steps = new String[panels.size()];
        for (int i = 0; i < panels.size(); i++) {
            Component c = panels.get(i).getComponent();
            // Default step name to component name of panel.
            steps[i] = c.getName();
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
            }
        }
        WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<WizardDescriptor>(panels));
        // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
        wiz.setTitleFormat(new MessageFormat("{0}"));
        wiz.setTitle("...dialog title...");
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // do something
        }
        
    }
}
