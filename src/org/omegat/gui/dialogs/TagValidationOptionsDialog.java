/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
**************************************************************************/

package org.omegat.gui.dialogs;

import java.awt.event.ActionEvent;     // HP
import java.awt.event.KeyEvent;        // HP
import java.awt.Frame;
import javax.swing.AbstractAction;     // HP
import javax.swing.Action;             // HP
import javax.swing.JComponent;         // HP
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.KeyStroke;          // HP

import org.omegat.util.OStrings;
import org.omegat.util.Preferences;

/**
 *
 * @author  Maxym Mykhalchuk
 */
public class TagValidationOptionsDialog extends JDialog
{
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    
    /** Creates new form WorkflowOptionsDialog */
    public TagValidationOptionsDialog(Frame parent)
    {
        super(parent, true);
        
        // HP
        //  Handle escape key to close the window
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(escape, "ESCAPE");                                                  // NOI18N
        getRootPane().getActionMap().put("ESCAPE", escapeAction);               // NOI18N
        // END HP

        initComponents();

        getRootPane().setDefaultButton(okButton);

        // initializing options
        noCheckRadio.setSelected(Preferences.isPreference(Preferences.DONT_CHECK_PRINTF_TAGS));
        simpleCheckRadio.setSelected(Preferences.isPreference(Preferences.CHECK_SIMPLE_PRINTF_TAGS));
        fullCheckRadio.setSelected(Preferences.isPreference(Preferences.CHECK_ALL_PRINTF_TAGS));

        invalidate();
        pack();
    }
    
    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus()
    {
        return returnStatus;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        ourButtonGroup = new javax.swing.ButtonGroup();
        descriptionTextArea = new javax.swing.JTextArea();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        noCheckRadio = new javax.swing.JRadioButton();
        simpleCheckRadio = new javax.swing.JRadioButton();
        fullCheckRadio = new javax.swing.JRadioButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle(OStrings.getString("GUI_TITLE_Workflow_Options"));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                closeDialog(evt);
            }
        });

        descriptionTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setFont(new JLabel().getFont());
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setText(OStrings.getString("GUI_TAGVALIDATION_DESCRIPTION"));
        descriptionTextArea.setWrapStyleWord(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(descriptionTextArea, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK"));
        okButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                okButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 4, 4);
        getContentPane().add(okButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL"));
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 4, 4);
        getContentPane().add(cancelButton, gridBagConstraints);

        ourButtonGroup.add(noCheckRadio);
        noCheckRadio.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(noCheckRadio, OStrings.getString("TV_OPTION_NO_CHECK"));
        noCheckRadio.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(0, 0, 0, 0)));
        noCheckRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        noCheckRadio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                radiosActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 4, 4);
        getContentPane().add(noCheckRadio, gridBagConstraints);

        ourButtonGroup.add(simpleCheckRadio);
        org.openide.awt.Mnemonics.setLocalizedText(simpleCheckRadio, OStrings.getString("TV_OPTION_SIMPLE_CHECK"));
        simpleCheckRadio.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(0, 0, 0, 0)));
        simpleCheckRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        simpleCheckRadio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                radiosActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 4, 4);
        getContentPane().add(simpleCheckRadio, gridBagConstraints);
        
        ourButtonGroup.add(fullCheckRadio);
        org.openide.awt.Mnemonics.setLocalizedText(fullCheckRadio, OStrings.getString("TV_OPTION_FULL_CHECK"));
        fullCheckRadio.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(0, 0, 0, 0)));
        fullCheckRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        fullCheckRadio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                radiosActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 4, 4);
        getContentPane().add(fullCheckRadio, gridBagConstraints);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }
    // </editor-fold>//GEN-END:initComponents

    private void radiosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radiosActionPerformed
    {//GEN-HEADEREND:event_radiosActionPerformed
        
    }//GEN-LAST:event_radiosActionPerformed
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okButtonActionPerformed
    {
        Preferences.setPreference(Preferences.DONT_CHECK_PRINTF_TAGS, noCheckRadio.isSelected());
        Preferences.setPreference(Preferences.CHECK_SIMPLE_PRINTF_TAGS, simpleCheckRadio.isSelected());
        Preferences.setPreference(Preferences.CHECK_ALL_PRINTF_TAGS, fullCheckRadio.isSelected());

        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt)//GEN-FIRST:event_closeDialog
    {
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus)
    {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JRadioButton noCheckRadio;
    private javax.swing.JRadioButton simpleCheckRadio;
    private javax.swing.JRadioButton fullCheckRadio;
    private javax.swing.JButton okButton;
    private javax.swing.ButtonGroup ourButtonGroup;
    // End of variables declaration//GEN-END:variables
    
    private int returnStatus = RET_CANCEL;
}
