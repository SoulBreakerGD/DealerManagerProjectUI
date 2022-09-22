package runtime;

import tableModels.DealersTableModel;
import data.Account;
import data.Config;
import data.Dealer;
import data.DealerList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class JFrameUI extends javax.swing.JFrame {

    private static boolean saved = true, savedContinuing = true, savedUncontinuing = true;
    private Config config;
    private Account acc;
    private DealerList dList;
    private ArrayList<Dealer> statusList;
    private DealersTableModel dTableModel;
    public static boolean EditMode = true;
    public static String[] roles;
    
    /**
     * Creates new form JFrame
     */
    public JFrameUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RoleChoosePanel = new javax.swing.JPanel();
        RoleLabelPanel = new javax.swing.JPanel();
        RoleChooseLabel = new javax.swing.JLabel();
        RoleOptionsPanel = new javax.swing.JPanel();
        RoleOptionsBox = new javax.swing.JComboBox<>();
        PanelsContainer = new javax.swing.JPanel();
        DealerPanel = new javax.swing.JPanel();
        LoggedAccountLabel = new javax.swing.JLabel();
        ShowOptions = new javax.swing.JComboBox<>();
        SaveButton = new javax.swing.JButton();
        ShowLabel = new javax.swing.JLabel();
        TablePanel = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LoggedRoleLabel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ConfirmButton = new javax.swing.JButton();
        SelectAll = new javax.swing.JButton();
        DeselectAll = new javax.swing.JButton();
        SortButton = new javax.swing.JButton();
        SortByLabel = new javax.swing.JLabel();
        SortOptions = new javax.swing.JComboBox<>();

        RoleChoosePanel.setLayout(new java.awt.BorderLayout(5, 5));

        RoleChoosePanel.add(RoleLabelPanel, BorderLayout.LINE_START);
        RoleChoosePanel.add(RoleOptionsPanel, BorderLayout.CENTER);

        RoleLabelPanel.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        RoleChooseLabel.setText("jLabel1");
        RoleLabelPanel.add(RoleChooseLabel);

        RoleOptionsPanel.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        RoleOptionsBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOSS", "ACC-1", "ACC-2" }));
        RoleOptionsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleOptionsBoxActionPerformed(evt);
            }
        });
        RoleOptionsPanel.add(RoleOptionsBox);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N

        PanelsContainer.setLayout(new java.awt.CardLayout());

        LoggedAccountLabel.setText("Account: ");

        ShowOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dealer List", "Continuing Dealer List", "Uncontinuing Dealer List" }));
        ShowOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowOptionsActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ShowLabel.setText("Show:");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Phone", "Continuing"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePanel.setViewportView(Table);

        LoggedRoleLabel.setText("Role: ");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        SelectAll.setText("Select All");
        SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAllActionPerformed(evt);
            }
        });

        DeselectAll.setText("Deselect All");
        DeselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeselectAllActionPerformed(evt);
            }
        });

        SortButton.setText("Sort");
        SortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortButtonActionPerformed(evt);
            }
        });

        SortByLabel.setText("Sort by:");

        SortOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Address", "Phone" }));
        SortOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DealerPanelLayout = new javax.swing.GroupLayout(DealerPanel);
        DealerPanel.setLayout(DealerPanelLayout);
        DealerPanelLayout.setHorizontalGroup(
            DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DealerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DealerPanelLayout.createSequentialGroup()
                        .addComponent(LoggedAccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 619, Short.MAX_VALUE)
                        .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeselectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(LoggedRoleLabel)
                    .addGroup(DealerPanelLayout.createSequentialGroup()
                        .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DealerPanelLayout.createSequentialGroup()
                                .addComponent(ShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ShowOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DealerPanelLayout.createSequentialGroup()
                                .addComponent(SortByLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SortOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ConfirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DealerPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGap(122, 122, 122)))
        );
        DealerPanelLayout.setVerticalGroup(
            DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DealerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoggedAccountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoggedRoleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowLabel)
                    .addComponent(ShowOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmButton))
                .addGap(4, 4, 4)
                .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SortByLabel)
                    .addComponent(SortButton)
                    .addComponent(SortOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeselectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap())
            .addGroup(DealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DealerPanelLayout.createSequentialGroup()
                    .addContainerGap(125, Short.MAX_VALUE)
                    .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        PanelsContainer.add(DealerPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelsContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowOptionsActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        switch (ShowOptions.getSelectedItem().toString().trim()) {
            case "Dealer List":
                dTableModel = new DealersTableModel(dList);
                refreshTable();
                break;
            case "Continuing Dealer List":
                if(savedContinuing)
                    dTableModel = new DealersTableModel(dList.getContinuingDealers());
                else
                    dTableModel = new DealersTableModel(dList.getSortedListByID(dList.getContinuingDealers()));
                refreshTable();
                break;
            default:
                if(savedUncontinuing)
                    dTableModel = new DealersTableModel(dList.getUncontinuingDealers());
                else
                    dTableModel = new DealersTableModel(dList.getSortedListByID(dList.getUncontinuingDealers()));
                refreshTable();
                break;
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        dList.writeDealerToFile(dList);
        saved = true;
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        if (!saved) {
            int res = JOptionPane.showConfirmDialog(this, "Data has been changed. Do you want to save now?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                dList.writeDealerToFile(dList);
                saved = true;
                System.exit(0);
            }
            else if (res == JOptionPane.NO_OPTION) System.exit(0);
        }
        else System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
//        AddFrame newFrame = new AddFrame();
//        newFrame.setVisible(true);
//        newFrame.setTitle("Add dealer");
        JPanel addDealerPanel = new JPanel(new BorderLayout(10,10));
        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Dealer ID", SwingConstants.TRAILING));
        labels.add(new JLabel("Name", SwingConstants.TRAILING));
        labels.add(new JLabel("Address", SwingConstants.TRAILING));
        labels.add(new JLabel("Phone", SwingConstants.TRAILING));
        labels.add(new JLabel("Continuing?", SwingConstants.TRAILING));
        addDealerPanel.add(labels, BorderLayout.LINE_START);

        JPanel inputs = new JPanel(new GridLayout(0,1,2,2));
        JFormattedTextField DealerID =  null;
        try {
            MaskFormatter idf = new MaskFormatter("D###");
            idf.setPlaceholderCharacter('_');
            DealerID = new JFormattedTextField(idf);
        }
        catch (Exception e) {
        }
        inputs.add(DealerID);
        JTextField DealerName = new JTextField("");
        inputs.add(DealerName);
        JTextField DealerAddress = new JTextField("");
        inputs.add(DealerAddress);
        JFormattedTextField DealerPhone = null;
        try {
            MaskFormatter idf = new MaskFormatter("#########(**)");
            idf.setPlaceholderCharacter('_');
            DealerPhone = new JFormattedTextField(idf);
        }
        catch (Exception e) {
        }
        inputs.add(DealerPhone);
        JCheckBox DealerCont = new JCheckBox();
        inputs.add(DealerCont);
        addDealerPanel.add(inputs, BorderLayout.CENTER);
        do {
            int res = JOptionPane.showConfirmDialog(this, addDealerPanel, "Add Dealer", JOptionPane.OK_CANCEL_OPTION);
            String tempphone = DealerPhone.getText();
            tempphone = tempphone.replace("(", "");
            tempphone = tempphone.replace(")", "");
            tempphone = tempphone.replace("_", "");
            
            if (res == JOptionPane.CANCEL_OPTION || res == JOptionPane.CLOSED_OPTION) break;
            if (res == JOptionPane.OK_OPTION) {
                if (DealerID.getText().isEmpty() || DealerName.getText().isEmpty() || DealerAddress.getText().isEmpty() || DealerPhone.getText().equals("_________(__)")) {
                    JOptionPane.showMessageDialog(null, "Fields can not be empty.", "Input error", JOptionPane.ERROR_MESSAGE);
                }
                else if (dList.checkExistDealer(DealerID.getText()) != null) JOptionPane.showMessageDialog(null, "Dealer is already in the list", "Error", JOptionPane.ERROR_MESSAGE);
                else if (!DealerID.getText().matches(Dealer.ID_FORMAT)) JOptionPane.showMessageDialog(null, "ID must be Dxxx", "Input error", JOptionPane.ERROR_MESSAGE);
                else if (!tempphone.matches(Dealer.PHONE_FORMAT)) JOptionPane.showMessageDialog(null, "Phone must have 9 or 11 digits", "Input error", JOptionPane.ERROR_MESSAGE);
                else {
                    dList.add(new Dealer(DealerID.getText(), DealerName.getText(), DealerAddress.getText(), tempphone, DealerCont.isSelected()));
                    dTableModel = new DealersTableModel(dList);
                    refreshTable();
                    saved = false;
                    savedContinuing = true;
                    savedUncontinuing = true;
                    break;
                }
            }
        } while (true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void RoleOptionsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleOptionsBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleOptionsBoxActionPerformed

    private void SelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAllActionPerformed
        DealersTableModel model = (DealersTableModel)Table.getModel();
        HashMap<Dealer, Boolean> data = model.getData();
        for (Dealer d : data.keySet()) 
            dList.get(dList.indexOf(d)).setContinuing(Boolean.TRUE);
        model.setData(data);
        Table.setModel(model);
        ((DealersTableModel)Table.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_SelectAllActionPerformed

    private void DeselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeselectAllActionPerformed
        DealersTableModel model = (DealersTableModel)Table.getModel();
        HashMap<Dealer, Boolean> data = model.getData();
        for (Dealer d : data.keySet()) 
            dList.get(dList.indexOf(d)).setContinuing(Boolean.FALSE);
        model.setData(data);
        Table.setModel(model);
        ((DealersTableModel)Table.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_DeselectAllActionPerformed

    private void SortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortButtonActionPerformed
        switch (ShowOptions.getSelectedItem().toString().trim()) {
            case "Dealer List":
                switch(SortOptions.getSelectedItem().toString().trim())
                {
                    case "ID":
                        dTableModel = new DealersTableModel(dList.getSortedListByID(dList));
                        saved = false;
                        refreshTable();
                        break;
                    case "Name":
                        dTableModel = new DealersTableModel(dList.getSortedListByName(dList));
                        saved = false;
                        refreshTable();
                        break;
                    case "Address":
                        dTableModel = new DealersTableModel(dList.getSortedListByAddress(dList));
                        saved = false;
                        refreshTable();
                        break;
                    case "Phone":
                        dTableModel = new DealersTableModel(dList.getSortedListByPhone(dList));
                        saved = false;
                        refreshTable();
                        break;
                }
                break;
            case "Continuing Dealer List":
                switch(SortOptions.getSelectedItem().toString().trim())
                {
                    case "ID":
                        dTableModel = new DealersTableModel(dList.getSortedListByID(dList.getContinuingDealers()));
                        savedContinuing = false;
                        refreshTable();
                        break;
                    case "Name":
                        dTableModel = new DealersTableModel(dList.getSortedListByName(dList.getContinuingDealers()));
                        savedContinuing = false;
                        refreshTable();
                        break;
                    case "Address":
                        dTableModel = new DealersTableModel(dList.getSortedListByAddress(dList.getContinuingDealers()));
                        savedContinuing = false;
                        refreshTable();
                        break;
                    case "Phone":
                        dTableModel = new DealersTableModel(dList.getSortedListByPhone(dList.getContinuingDealers()));
                        savedContinuing = false;
                        refreshTable();
                        break;
                }
                break;
            default:
                switch(SortOptions.getSelectedItem().toString().trim())
                {
                    case "ID":
                        dTableModel = new DealersTableModel(dList.getSortedListByID(dList.getUncontinuingDealers()));
                        savedUncontinuing = false;
                        refreshTable();
                        break;
                    case "Name":
                        dTableModel = new DealersTableModel(dList.getSortedListByName(dList.getUncontinuingDealers()));
                        savedUncontinuing = false;
                        refreshTable();
                        break;
                    case "Address":
                        dTableModel = new DealersTableModel(dList.getSortedListByAddress(dList.getUncontinuingDealers()));
                        savedUncontinuing = false;
                        refreshTable();
                        break;
                    case "Phone":
                        dTableModel = new DealersTableModel(dList.getSortedListByPhone(dList.getUncontinuingDealers()));
                        savedUncontinuing = false;
                        refreshTable();
                        break;
                }
                break;
        }
    }//GEN-LAST:event_SortButtonActionPerformed

    private void SortOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortOptionsActionPerformed
        
    }//GEN-LAST:event_SortOptionsActionPerformed
    
    public void initUI() {
        config = new Config();
        setLocationRelativeTo(null);
        PanelsContainer.setVisible(false);
        this.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                if (!saved) 
                {
                    int res = JOptionPane.showConfirmDialog(null,"You have not saved any changes. Do you want to save now?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (res == JOptionPane.YES_OPTION) 
                    {
                        dList.writeDealerToFile();
                        saved = true;
                        System.exit(0);
                    }
                    else if (res == JOptionPane.NO_OPTION) System.exit(0);
                }   
                else System.exit(0);
            }
        });
        setVisible(true);
        initLogIn();
    }
    
    private void initLogIn(){
        JPanel LogInPanel = new JPanel(new BorderLayout(10,10));
        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("User ID", SwingConstants.TRAILING));
        labels.add(new JLabel("Password", SwingConstants.TRAILING));
        LogInPanel.add(labels, BorderLayout.LINE_START);

        JPanel inputs = new JPanel(new GridLayout(0,1,2,2));
        JTextField UserID = new JTextField("");
        inputs.add(UserID);
        JPasswordField Password = new JPasswordField("");
        inputs.add(Password);
        LogInPanel.add(inputs, BorderLayout.CENTER);
        boolean cont = true, valid;
        int res;
        do {
            res = JOptionPane.showConfirmDialog(this, LogInPanel, "Log In", JOptionPane.OK_CANCEL_OPTION);
            acc = new Account(UserID.getText(), new String(Password.getPassword()));
            valid = LogIn.checkValidity(acc, config);
            if (res == JOptionPane.CLOSED_OPTION || res == JOptionPane.CANCEL_OPTION) System.exit(0);
            else if (!valid) {
                JOptionPane.showMessageDialog(null, "Invalid login credential", "Log in unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
            else {
                switch (acc.getRole()) {
                    case "ACC-1":
                        initDealerPanel();
                        break;
                    case "ACC-2":
                        break;
                    default:
                        break;
                }
                PanelsContainer.setVisible(true);
                cont = !cont;
            }
        } while (cont);
    }
    
    private void initDealerPanel() 
    {
        LogIn loginObj = new LogIn(acc);
        
        dList = new DealerList(loginObj);
        dList.initWithFile();
        
        LoggedAccountLabel.setText("Account: " + acc.getAccName());
        LoggedRoleLabel.setText("Role: " + acc.getRole());
        
        dTableModel = new DealersTableModel(dList);
        
        refreshTable();
        
        ((CardLayout)PanelsContainer.getLayout()).show(PanelsContainer, "cards2");
    }
    
    private void refreshTable() 
    {
        Table.setModel(dTableModel);
        Table.getColumnModel().getColumn(0).setMinWidth(50);
        Table.getColumnModel().getColumn(0).setMaxWidth(50);
    }
    
    public static void setSaved(Boolean newsaved) {
        saved = newsaved;
    }
    
//    public static void main(String[] args) {
//        JFrameUI jframe = new JFrameUI();
//            jframe.initUI();
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JPanel DealerPanel;
    private javax.swing.JButton DeselectAll;
    private javax.swing.JLabel LoggedAccountLabel;
    private javax.swing.JLabel LoggedRoleLabel;
    private javax.swing.JPanel PanelsContainer;
    private javax.swing.JLabel RoleChooseLabel;
    private javax.swing.JPanel RoleChoosePanel;
    private javax.swing.JPanel RoleLabelPanel;
    private javax.swing.JComboBox<String> RoleOptionsBox;
    private javax.swing.JPanel RoleOptionsPanel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SelectAll;
    private javax.swing.JLabel ShowLabel;
    private javax.swing.JComboBox<String> ShowOptions;
    private javax.swing.JButton SortButton;
    private javax.swing.JLabel SortByLabel;
    private javax.swing.JComboBox<String> SortOptions;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TablePanel;
    // End of variables declaration//GEN-END:variables
}