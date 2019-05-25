/*
 * Created by JFormDesigner on Mon May 13 19:43:29 CEST 2019
 */

package ch.epfl.database;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author Yann Gabbud
 */
public class App extends JFrame {
    public App() {
        initComponents();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App GUI = new App();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                GUI.pack(); // <=========== PACK
                GUI.setVisible(true);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yann Gabbud
        frame2 = new Frame();
        tabbedPane2 = new JTabbedPane();
        panel12 = new JPanel();
        textField7 = new JTextField();
        panel13 = new JPanel();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        checkBox4 = new JCheckBox();
        checkBox5 = new JCheckBox();
        checkBox6 = new JCheckBox();
        checkBox7 = new JCheckBox();
        checkBox8 = new JCheckBox();
        checkBox9 = new JCheckBox();
        checkBox10 = new JCheckBox();
        button2 = new JButton();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel14 = new JPanel();
        panel15 = new JPanel();
        formattedTextField19 = new JFormattedTextField();
        formattedTextField20 = new JFormattedTextField();
        formattedTextField21 = new JFormattedTextField();
        formattedTextField22 = new JFormattedTextField();
        formattedTextField23 = new JFormattedTextField();
        formattedTextField24 = new JFormattedTextField();
        formattedTextField25 = new JFormattedTextField();
        formattedTextField26 = new JFormattedTextField();
        formattedTextField27 = new JFormattedTextField();
        button4 = new JButton();
        label3 = new JLabel();
        panel16 = new JPanel();
        panel17 = new JPanel();
        formattedTextField28 = new JFormattedTextField();
        formattedTextField29 = new JFormattedTextField();
        formattedTextField30 = new JFormattedTextField();
        formattedTextField31 = new JFormattedTextField();
        formattedTextField32 = new JFormattedTextField();
        formattedTextField33 = new JFormattedTextField();
        formattedTextField34 = new JFormattedTextField();
        formattedTextField35 = new JFormattedTextField();
        formattedTextField36 = new JFormattedTextField();
        button5 = new JButton();
        label4 = new JLabel();
        panel18 = new JPanel();
        panel19 = new JPanel();
        formattedTextField37 = new JFormattedTextField();
        formattedTextField38 = new JFormattedTextField();
        formattedTextField39 = new JFormattedTextField();
        formattedTextField40 = new JFormattedTextField();
        formattedTextField41 = new JFormattedTextField();
        formattedTextField42 = new JFormattedTextField();
        formattedTextField43 = new JFormattedTextField();
        formattedTextField44 = new JFormattedTextField();
        formattedTextField45 = new JFormattedTextField();
        button6 = new JButton();
        label5 = new JLabel();
        panel20 = new JPanel();
        panel21 = new JPanel();
        formattedTextField46 = new JFormattedTextField();
        formattedTextField47 = new JFormattedTextField();
        formattedTextField48 = new JFormattedTextField();
        formattedTextField49 = new JFormattedTextField();
        formattedTextField50 = new JFormattedTextField();
        formattedTextField51 = new JFormattedTextField();
        formattedTextField52 = new JFormattedTextField();
        formattedTextField53 = new JFormattedTextField();
        formattedTextField54 = new JFormattedTextField();
        button7 = new JButton();
        label6 = new JLabel();
        panel22 = new JPanel();
        panel23 = new JPanel();
        formattedTextField55 = new JFormattedTextField();
        formattedTextField56 = new JFormattedTextField();
        formattedTextField57 = new JFormattedTextField();
        formattedTextField58 = new JFormattedTextField();
        formattedTextField59 = new JFormattedTextField();
        formattedTextField60 = new JFormattedTextField();
        formattedTextField61 = new JFormattedTextField();
        formattedTextField62 = new JFormattedTextField();
        formattedTextField63 = new JFormattedTextField();
        button8 = new JButton();
        label7 = new JLabel();
        panel24 = new JPanel();
        panel25 = new JPanel();
        formattedTextField64 = new JFormattedTextField();
        formattedTextField65 = new JFormattedTextField();
        formattedTextField66 = new JFormattedTextField();
        formattedTextField67 = new JFormattedTextField();
        formattedTextField68 = new JFormattedTextField();
        formattedTextField69 = new JFormattedTextField();
        formattedTextField70 = new JFormattedTextField();
        formattedTextField71 = new JFormattedTextField();
        formattedTextField72 = new JFormattedTextField();
        button9 = new JButton();
        label8 = new JLabel();
        panel26 = new JPanel();
        panel27 = new JPanel();
        formattedTextField73 = new JFormattedTextField();
        formattedTextField74 = new JFormattedTextField();
        formattedTextField75 = new JFormattedTextField();
        formattedTextField76 = new JFormattedTextField();
        formattedTextField77 = new JFormattedTextField();
        formattedTextField78 = new JFormattedTextField();
        formattedTextField79 = new JFormattedTextField();
        formattedTextField80 = new JFormattedTextField();
        formattedTextField81 = new JFormattedTextField();
        button10 = new JButton();
        label9 = new JLabel();
        panel28 = new JPanel();
        panel29 = new JPanel();
        formattedTextField82 = new JFormattedTextField();
        formattedTextField83 = new JFormattedTextField();
        formattedTextField84 = new JFormattedTextField();
        formattedTextField85 = new JFormattedTextField();
        formattedTextField86 = new JFormattedTextField();
        formattedTextField87 = new JFormattedTextField();
        formattedTextField88 = new JFormattedTextField();
        formattedTextField89 = new JFormattedTextField();
        formattedTextField90 = new JFormattedTextField();
        button11 = new JButton();
        label10 = new JLabel();
        panel30 = new JPanel();
        panel31 = new JPanel();
        formattedTextField91 = new JFormattedTextField();
        formattedTextField92 = new JFormattedTextField();
        formattedTextField93 = new JFormattedTextField();
        formattedTextField94 = new JFormattedTextField();
        formattedTextField95 = new JFormattedTextField();
        formattedTextField96 = new JFormattedTextField();
        formattedTextField97 = new JFormattedTextField();
        formattedTextField98 = new JFormattedTextField();
        formattedTextField99 = new JFormattedTextField();
        button12 = new JButton();
        label11 = new JLabel();
        panel32 = new JPanel();
        panel33 = new JPanel();
        formattedTextField100 = new JFormattedTextField();
        formattedTextField101 = new JFormattedTextField();
        formattedTextField102 = new JFormattedTextField();
        formattedTextField103 = new JFormattedTextField();
        formattedTextField104 = new JFormattedTextField();
        formattedTextField105 = new JFormattedTextField();
        formattedTextField106 = new JFormattedTextField();
        formattedTextField107 = new JFormattedTextField();
        formattedTextField108 = new JFormattedTextField();
        button13 = new JButton();
        label12 = new JLabel();
        panel54 = new JPanel();
        panel55 = new JPanel();
        formattedTextField199 = new JFormattedTextField();
        formattedTextField200 = new JFormattedTextField();
        formattedTextField201 = new JFormattedTextField();
        formattedTextField202 = new JFormattedTextField();
        formattedTextField203 = new JFormattedTextField();
        formattedTextField204 = new JFormattedTextField();
        formattedTextField205 = new JFormattedTextField();
        formattedTextField206 = new JFormattedTextField();
        formattedTextField207 = new JFormattedTextField();
        button25 = new JButton();
        label23 = new JLabel();
        tabbedPane3 = new JTabbedPane();
        panel34 = new JPanel();
        panel35 = new JPanel();
        formattedTextField109 = new JFormattedTextField();
        formattedTextField110 = new JFormattedTextField();
        formattedTextField111 = new JFormattedTextField();
        formattedTextField112 = new JFormattedTextField();
        formattedTextField113 = new JFormattedTextField();
        formattedTextField114 = new JFormattedTextField();
        formattedTextField115 = new JFormattedTextField();
        formattedTextField116 = new JFormattedTextField();
        formattedTextField117 = new JFormattedTextField();
        button14 = new JButton();
        button1 = new JButton();
        label13 = new JLabel();
        panel36 = new JPanel();
        panel37 = new JPanel();
        formattedTextField118 = new JFormattedTextField();
        formattedTextField119 = new JFormattedTextField();
        formattedTextField120 = new JFormattedTextField();
        formattedTextField121 = new JFormattedTextField();
        formattedTextField122 = new JFormattedTextField();
        formattedTextField123 = new JFormattedTextField();
        formattedTextField124 = new JFormattedTextField();
        formattedTextField125 = new JFormattedTextField();
        formattedTextField126 = new JFormattedTextField();
        button15 = new JButton();
        button3 = new JButton();
        label14 = new JLabel();
        panel38 = new JPanel();
        panel39 = new JPanel();
        formattedTextField127 = new JFormattedTextField();
        formattedTextField128 = new JFormattedTextField();
        formattedTextField129 = new JFormattedTextField();
        formattedTextField130 = new JFormattedTextField();
        formattedTextField131 = new JFormattedTextField();
        formattedTextField132 = new JFormattedTextField();
        formattedTextField133 = new JFormattedTextField();
        formattedTextField134 = new JFormattedTextField();
        formattedTextField135 = new JFormattedTextField();
        button16 = new JButton();
        button17 = new JButton();
        label15 = new JLabel();
        panel40 = new JPanel();
        panel41 = new JPanel();
        formattedTextField136 = new JFormattedTextField();
        formattedTextField137 = new JFormattedTextField();
        formattedTextField138 = new JFormattedTextField();
        formattedTextField139 = new JFormattedTextField();
        formattedTextField140 = new JFormattedTextField();
        formattedTextField141 = new JFormattedTextField();
        formattedTextField142 = new JFormattedTextField();
        formattedTextField143 = new JFormattedTextField();
        formattedTextField144 = new JFormattedTextField();
        button18 = new JButton();
        button19 = new JButton();
        label16 = new JLabel();
        panel42 = new JPanel();
        panel43 = new JPanel();
        formattedTextField145 = new JFormattedTextField();
        formattedTextField146 = new JFormattedTextField();
        formattedTextField147 = new JFormattedTextField();
        formattedTextField148 = new JFormattedTextField();
        formattedTextField149 = new JFormattedTextField();
        formattedTextField150 = new JFormattedTextField();
        formattedTextField151 = new JFormattedTextField();
        formattedTextField152 = new JFormattedTextField();
        formattedTextField153 = new JFormattedTextField();
        button20 = new JButton();
        button21 = new JButton();
        label17 = new JLabel();
        panel44 = new JPanel();
        label18 = new JLabel();
        panel46 = new JPanel();
        panel47 = new JPanel();
        formattedTextField163 = new JFormattedTextField();
        formattedTextField164 = new JFormattedTextField();
        formattedTextField165 = new JFormattedTextField();
        formattedTextField166 = new JFormattedTextField();
        formattedTextField167 = new JFormattedTextField();
        formattedTextField168 = new JFormattedTextField();
        formattedTextField169 = new JFormattedTextField();
        formattedTextField170 = new JFormattedTextField();
        formattedTextField171 = new JFormattedTextField();
        button24 = new JButton();
        button26 = new JButton();
        label19 = new JLabel();

        //======== frame2 ========
        {
            frame2.setBackground(new Color(242, 242, 242));
            frame2.setMinimumSize(new Dimension(1024, 700));
            frame2.setLayout(new BorderLayout());

            //======== tabbedPane2 ========
            {
                tabbedPane2.setPreferredSize(new Dimension(1024, 700));
                tabbedPane2.setMinimumSize(new Dimension(1024, 700));

                //======== panel12 ========
                {

                    // JFormDesigner evaluation mark
                    panel12.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel12.getBorder())); panel12.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel12.setLayout(new MigLayout(
                        "fill,insets 0,hidemode 3,gap 0 0",
                        // columns
                        "[grow,left]",
                        // rows
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]"));

                    //---- textField7 ----
                    textField7.setBorder(new TitledBorder("Search bar"));
                    panel12.add(textField7, "cell 0 0,growx");

                    //======== panel13 ========
                    {
                        panel13.setBorder(new TitledBorder("Tables"));
                        panel13.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]",
                            // rows
                            "[grow,center]"));

                        //---- checkBox2 ----
                        checkBox2.setText("Table 1");
                        panel13.add(checkBox2, "cell 0 0");

                        //---- checkBox3 ----
                        checkBox3.setText("Table 2");
                        panel13.add(checkBox3, "cell 1 0");

                        //---- checkBox4 ----
                        checkBox4.setText("text");
                        panel13.add(checkBox4, "cell 2 0");

                        //---- checkBox5 ----
                        checkBox5.setText("text");
                        panel13.add(checkBox5, "cell 3 0");

                        //---- checkBox6 ----
                        checkBox6.setText("text");
                        panel13.add(checkBox6, "cell 4 0");

                        //---- checkBox7 ----
                        checkBox7.setText("text");
                        panel13.add(checkBox7, "cell 5 0");

                        //---- checkBox8 ----
                        checkBox8.setText("text");
                        panel13.add(checkBox8, "cell 6 0");

                        //---- checkBox9 ----
                        checkBox9.setText("text");
                        panel13.add(checkBox9, "cell 7 0");

                        //---- checkBox10 ----
                        checkBox10.setText("text");
                        panel13.add(checkBox10, "cell 8 0");
                    }
                    panel12.add(panel13, "cell 0 1,growx");

                    //---- button2 ----
                    button2.setText("Search");
                    panel12.add(button2, "cell 0 2");

                    //---- label1 ----
                    label1.setPreferredSize(new Dimension(672, 500));
                    label1.setBorder(new TitledBorder("Result"));
                    panel12.add(label1, "cell 0 3,grow");
                }
                tabbedPane2.addTab("Search", panel12);

                //======== tabbedPane1 ========
                {

                    //======== panel14 ========
                    {
                        panel14.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel15 ========
                        {
                            panel15.setBorder(new TitledBorder("field"));
                            panel15.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel15.add(formattedTextField19, "cell 0 0");
                            panel15.add(formattedTextField20, "cell 1 0");
                            panel15.add(formattedTextField21, "cell 2 0");
                            panel15.add(formattedTextField22, "cell 3 0");
                            panel15.add(formattedTextField23, "cell 4 0");
                            panel15.add(formattedTextField24, "cell 5 0");
                            panel15.add(formattedTextField25, "cell 6 0");
                            panel15.add(formattedTextField26, "cell 7 0");
                            panel15.add(formattedTextField27, "cell 8 0");

                            //---- button4 ----
                            button4.setText("Execute");
                            panel15.add(button4, "cell 9 0");
                        }
                        panel14.add(panel15, "cell 0 0,growx");

                        //---- label3 ----
                        label3.setPreferredSize(new Dimension(672, 500));
                        label3.setBorder(new TitledBorder("Result"));
                        label3.setMinimumSize(new Dimension(672, 500));
                        label3.setMaximumSize(new Dimension(32767, 32767));
                        panel14.add(label3, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel14);

                    //======== panel16 ========
                    {
                        panel16.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel17 ========
                        {
                            panel17.setBorder(new TitledBorder("field"));
                            panel17.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel17.add(formattedTextField28, "cell 0 0");
                            panel17.add(formattedTextField29, "cell 1 0");
                            panel17.add(formattedTextField30, "cell 2 0");
                            panel17.add(formattedTextField31, "cell 3 0");
                            panel17.add(formattedTextField32, "cell 4 0");
                            panel17.add(formattedTextField33, "cell 5 0");
                            panel17.add(formattedTextField34, "cell 6 0");
                            panel17.add(formattedTextField35, "cell 7 0");
                            panel17.add(formattedTextField36, "cell 8 0");

                            //---- button5 ----
                            button5.setText("Execute");
                            panel17.add(button5, "cell 9 0");
                        }
                        panel16.add(panel17, "cell 0 0,growx");

                        //---- label4 ----
                        label4.setPreferredSize(new Dimension(672, 500));
                        label4.setBorder(new TitledBorder("Result"));
                        label4.setMinimumSize(new Dimension(672, 500));
                        label4.setMaximumSize(new Dimension(32767, 32767));
                        panel16.add(label4, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 2", panel16);

                    //======== panel18 ========
                    {
                        panel18.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel19 ========
                        {
                            panel19.setBorder(new TitledBorder("field"));
                            panel19.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel19.add(formattedTextField37, "cell 0 0");
                            panel19.add(formattedTextField38, "cell 1 0");
                            panel19.add(formattedTextField39, "cell 2 0");
                            panel19.add(formattedTextField40, "cell 3 0");
                            panel19.add(formattedTextField41, "cell 4 0");
                            panel19.add(formattedTextField42, "cell 5 0");
                            panel19.add(formattedTextField43, "cell 6 0");
                            panel19.add(formattedTextField44, "cell 7 0");
                            panel19.add(formattedTextField45, "cell 8 0");

                            //---- button6 ----
                            button6.setText("Execute");
                            panel19.add(button6, "cell 9 0");
                        }
                        panel18.add(panel19, "cell 0 0,growx");

                        //---- label5 ----
                        label5.setPreferredSize(new Dimension(672, 500));
                        label5.setBorder(new TitledBorder("Result"));
                        label5.setMinimumSize(new Dimension(672, 500));
                        label5.setMaximumSize(new Dimension(32767, 32767));
                        panel18.add(label5, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 3", panel18);

                    //======== panel20 ========
                    {
                        panel20.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel21 ========
                        {
                            panel21.setBorder(new TitledBorder("field"));
                            panel21.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel21.add(formattedTextField46, "cell 0 0");
                            panel21.add(formattedTextField47, "cell 1 0");
                            panel21.add(formattedTextField48, "cell 2 0");
                            panel21.add(formattedTextField49, "cell 3 0");
                            panel21.add(formattedTextField50, "cell 4 0");
                            panel21.add(formattedTextField51, "cell 5 0");
                            panel21.add(formattedTextField52, "cell 6 0");
                            panel21.add(formattedTextField53, "cell 7 0");
                            panel21.add(formattedTextField54, "cell 8 0");

                            //---- button7 ----
                            button7.setText("Execute");
                            panel21.add(button7, "cell 9 0");
                        }
                        panel20.add(panel21, "cell 0 0,growx");

                        //---- label6 ----
                        label6.setPreferredSize(new Dimension(672, 500));
                        label6.setBorder(new TitledBorder("Result"));
                        label6.setMinimumSize(new Dimension(672, 500));
                        label6.setMaximumSize(new Dimension(32767, 32767));
                        panel20.add(label6, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 4", panel20);

                    //======== panel22 ========
                    {
                        panel22.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel23 ========
                        {
                            panel23.setBorder(new TitledBorder("field"));
                            panel23.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel23.add(formattedTextField55, "cell 0 0");
                            panel23.add(formattedTextField56, "cell 1 0");
                            panel23.add(formattedTextField57, "cell 2 0");
                            panel23.add(formattedTextField58, "cell 3 0");
                            panel23.add(formattedTextField59, "cell 4 0");
                            panel23.add(formattedTextField60, "cell 5 0");
                            panel23.add(formattedTextField61, "cell 6 0");
                            panel23.add(formattedTextField62, "cell 7 0");
                            panel23.add(formattedTextField63, "cell 8 0");

                            //---- button8 ----
                            button8.setText("Execute");
                            panel23.add(button8, "cell 9 0");
                        }
                        panel22.add(panel23, "cell 0 0,growx");

                        //---- label7 ----
                        label7.setPreferredSize(new Dimension(672, 500));
                        label7.setBorder(new TitledBorder("Result"));
                        label7.setMinimumSize(new Dimension(672, 500));
                        label7.setMaximumSize(new Dimension(32767, 32767));
                        panel22.add(label7, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel22);

                    //======== panel24 ========
                    {
                        panel24.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel25 ========
                        {
                            panel25.setBorder(new TitledBorder("field"));
                            panel25.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel25.add(formattedTextField64, "cell 0 0");
                            panel25.add(formattedTextField65, "cell 1 0");
                            panel25.add(formattedTextField66, "cell 2 0");
                            panel25.add(formattedTextField67, "cell 3 0");
                            panel25.add(formattedTextField68, "cell 4 0");
                            panel25.add(formattedTextField69, "cell 5 0");
                            panel25.add(formattedTextField70, "cell 6 0");
                            panel25.add(formattedTextField71, "cell 7 0");
                            panel25.add(formattedTextField72, "cell 8 0");

                            //---- button9 ----
                            button9.setText("Execute");
                            panel25.add(button9, "cell 9 0");
                        }
                        panel24.add(panel25, "cell 0 0,growx");

                        //---- label8 ----
                        label8.setPreferredSize(new Dimension(672, 500));
                        label8.setBorder(new TitledBorder("Result"));
                        label8.setMinimumSize(new Dimension(672, 500));
                        label8.setMaximumSize(new Dimension(32767, 32767));
                        panel24.add(label8, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel24);

                    //======== panel26 ========
                    {
                        panel26.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel27 ========
                        {
                            panel27.setBorder(new TitledBorder("field"));
                            panel27.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel27.add(formattedTextField73, "cell 0 0");
                            panel27.add(formattedTextField74, "cell 1 0");
                            panel27.add(formattedTextField75, "cell 2 0");
                            panel27.add(formattedTextField76, "cell 3 0");
                            panel27.add(formattedTextField77, "cell 4 0");
                            panel27.add(formattedTextField78, "cell 5 0");
                            panel27.add(formattedTextField79, "cell 6 0");
                            panel27.add(formattedTextField80, "cell 7 0");
                            panel27.add(formattedTextField81, "cell 8 0");

                            //---- button10 ----
                            button10.setText("Execute");
                            panel27.add(button10, "cell 9 0");
                        }
                        panel26.add(panel27, "cell 0 0,growx");

                        //---- label9 ----
                        label9.setPreferredSize(new Dimension(672, 500));
                        label9.setBorder(new TitledBorder("Result"));
                        label9.setMinimumSize(new Dimension(672, 500));
                        label9.setMaximumSize(new Dimension(32767, 32767));
                        panel26.add(label9, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel26);

                    //======== panel28 ========
                    {
                        panel28.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel29 ========
                        {
                            panel29.setBorder(new TitledBorder("field"));
                            panel29.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel29.add(formattedTextField82, "cell 0 0");
                            panel29.add(formattedTextField83, "cell 1 0");
                            panel29.add(formattedTextField84, "cell 2 0");
                            panel29.add(formattedTextField85, "cell 3 0");
                            panel29.add(formattedTextField86, "cell 4 0");
                            panel29.add(formattedTextField87, "cell 5 0");
                            panel29.add(formattedTextField88, "cell 6 0");
                            panel29.add(formattedTextField89, "cell 7 0");
                            panel29.add(formattedTextField90, "cell 8 0");

                            //---- button11 ----
                            button11.setText("Execute");
                            panel29.add(button11, "cell 9 0");
                        }
                        panel28.add(panel29, "cell 0 0,growx");

                        //---- label10 ----
                        label10.setPreferredSize(new Dimension(672, 500));
                        label10.setBorder(new TitledBorder("Result"));
                        label10.setMinimumSize(new Dimension(672, 500));
                        label10.setMaximumSize(new Dimension(32767, 32767));
                        panel28.add(label10, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel28);

                    //======== panel30 ========
                    {
                        panel30.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel31 ========
                        {
                            panel31.setBorder(new TitledBorder("field"));
                            panel31.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel31.add(formattedTextField91, "cell 0 0");
                            panel31.add(formattedTextField92, "cell 1 0");
                            panel31.add(formattedTextField93, "cell 2 0");
                            panel31.add(formattedTextField94, "cell 3 0");
                            panel31.add(formattedTextField95, "cell 4 0");
                            panel31.add(formattedTextField96, "cell 5 0");
                            panel31.add(formattedTextField97, "cell 6 0");
                            panel31.add(formattedTextField98, "cell 7 0");
                            panel31.add(formattedTextField99, "cell 8 0");

                            //---- button12 ----
                            button12.setText("Execute");
                            panel31.add(button12, "cell 9 0");
                        }
                        panel30.add(panel31, "cell 0 0,growx");

                        //---- label11 ----
                        label11.setPreferredSize(new Dimension(672, 500));
                        label11.setBorder(new TitledBorder("Result"));
                        label11.setMinimumSize(new Dimension(672, 500));
                        label11.setMaximumSize(new Dimension(32767, 32767));
                        panel30.add(label11, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel30);

                    //======== panel32 ========
                    {
                        panel32.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel33 ========
                        {
                            panel33.setBorder(new TitledBorder("field"));
                            panel33.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel33.add(formattedTextField100, "cell 0 0");
                            panel33.add(formattedTextField101, "cell 1 0");
                            panel33.add(formattedTextField102, "cell 2 0");
                            panel33.add(formattedTextField103, "cell 3 0");
                            panel33.add(formattedTextField104, "cell 4 0");
                            panel33.add(formattedTextField105, "cell 5 0");
                            panel33.add(formattedTextField106, "cell 6 0");
                            panel33.add(formattedTextField107, "cell 7 0");
                            panel33.add(formattedTextField108, "cell 8 0");

                            //---- button13 ----
                            button13.setText("Execute");
                            panel33.add(button13, "cell 9 0");
                        }
                        panel32.add(panel33, "cell 0 0,growx");

                        //---- label12 ----
                        label12.setPreferredSize(new Dimension(672, 500));
                        label12.setBorder(new TitledBorder("Result"));
                        label12.setMinimumSize(new Dimension(672, 500));
                        label12.setMaximumSize(new Dimension(32767, 32767));
                        panel32.add(label12, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel32);

                    //======== panel54 ========
                    {
                        panel54.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel55 ========
                        {
                            panel55.setBorder(new TitledBorder("field"));
                            panel55.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel55.add(formattedTextField199, "cell 0 0");
                            panel55.add(formattedTextField200, "cell 1 0");
                            panel55.add(formattedTextField201, "cell 2 0");
                            panel55.add(formattedTextField202, "cell 3 0");
                            panel55.add(formattedTextField203, "cell 4 0");
                            panel55.add(formattedTextField204, "cell 5 0");
                            panel55.add(formattedTextField205, "cell 6 0");
                            panel55.add(formattedTextField206, "cell 7 0");
                            panel55.add(formattedTextField207, "cell 8 0");

                            //---- button25 ----
                            button25.setText("Execute");
                            panel55.add(button25, "cell 9 0");
                        }
                        panel54.add(panel55, "cell 0 0,growx");

                        //---- label23 ----
                        label23.setPreferredSize(new Dimension(672, 500));
                        label23.setBorder(new TitledBorder("Result"));
                        label23.setMinimumSize(new Dimension(672, 500));
                        label23.setMaximumSize(new Dimension(32767, 32767));
                        panel54.add(label23, "cell 0 1,dock center");
                    }
                    tabbedPane1.addTab("Query 1", panel54);
                }
                tabbedPane2.addTab("Queries", tabbedPane1);

                //======== tabbedPane3 ========
                {

                    //======== panel34 ========
                    {
                        panel34.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel35 ========
                        {
                            panel35.setBorder(new TitledBorder("field"));
                            panel35.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel35.add(formattedTextField109, "cell 0 0");
                            panel35.add(formattedTextField110, "cell 1 0");
                            panel35.add(formattedTextField111, "cell 2 0");
                            panel35.add(formattedTextField112, "cell 3 0");
                            panel35.add(formattedTextField113, "cell 4 0");
                            panel35.add(formattedTextField114, "cell 5 0");
                            panel35.add(formattedTextField115, "cell 6 0");
                            panel35.add(formattedTextField116, "cell 7 0");
                            panel35.add(formattedTextField117, "cell 8 0");

                            //---- button14 ----
                            button14.setText("Insert");
                            panel35.add(button14, "cell 9 0");

                            //---- button1 ----
                            button1.setText("Delete");
                            panel35.add(button1, "cell 10 0");
                        }
                        panel34.add(panel35, "cell 0 0,growx");

                        //---- label13 ----
                        label13.setPreferredSize(new Dimension(672, 500));
                        label13.setBorder(new TitledBorder("Result"));
                        label13.setMinimumSize(new Dimension(672, 500));
                        label13.setMaximumSize(new Dimension(32767, 32767));
                        panel34.add(label13, "cell 0 1,dock center");
                    }
                    tabbedPane3.addTab("Table 1", panel34);

                    //======== panel36 ========
                    {
                        panel36.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel37 ========
                        {
                            panel37.setBorder(new TitledBorder("field"));
                            panel37.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel37.add(formattedTextField118, "cell 0 0");
                            panel37.add(formattedTextField119, "cell 1 0");
                            panel37.add(formattedTextField120, "cell 2 0");
                            panel37.add(formattedTextField121, "cell 3 0");
                            panel37.add(formattedTextField122, "cell 4 0");
                            panel37.add(formattedTextField123, "cell 5 0");
                            panel37.add(formattedTextField124, "cell 6 0");
                            panel37.add(formattedTextField125, "cell 7 0");
                            panel37.add(formattedTextField126, "cell 8 0");

                            //---- button15 ----
                            button15.setText("Insert");
                            panel37.add(button15, "cell 9 0");

                            //---- button3 ----
                            button3.setText("Delete");
                            panel37.add(button3, "cell 10 0");
                        }
                        panel36.add(panel37, "cell 0 0,growx");

                        //---- label14 ----
                        label14.setPreferredSize(new Dimension(672, 500));
                        label14.setBorder(new TitledBorder("Result"));
                        label14.setMinimumSize(new Dimension(672, 500));
                        label14.setMaximumSize(new Dimension(32767, 32767));
                        panel36.add(label14, "cell 0 1,dock center");
                    }
                    tabbedPane3.addTab("Table 2", panel36);

                    //======== panel38 ========
                    {
                        panel38.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel39 ========
                        {
                            panel39.setBorder(new TitledBorder("field"));
                            panel39.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel39.add(formattedTextField127, "cell 0 0");
                            panel39.add(formattedTextField128, "cell 1 0");
                            panel39.add(formattedTextField129, "cell 2 0");
                            panel39.add(formattedTextField130, "cell 3 0");
                            panel39.add(formattedTextField131, "cell 4 0");
                            panel39.add(formattedTextField132, "cell 5 0");
                            panel39.add(formattedTextField133, "cell 6 0");
                            panel39.add(formattedTextField134, "cell 7 0");
                            panel39.add(formattedTextField135, "cell 8 0");

                            //---- button16 ----
                            button16.setText("Insert");
                            panel39.add(button16, "cell 9 0");

                            //---- button17 ----
                            button17.setText("Delete");
                            panel39.add(button17, "cell 10 0");
                        }
                        panel38.add(panel39, "cell 0 0,growx");

                        //---- label15 ----
                        label15.setPreferredSize(new Dimension(672, 500));
                        label15.setBorder(new TitledBorder("Result"));
                        label15.setMinimumSize(new Dimension(672, 500));
                        label15.setMaximumSize(new Dimension(32767, 32767));
                        panel38.add(label15, "cell 0 1,dock center");
                    }
                    tabbedPane3.addTab("Table 3", panel38);

                    //======== panel40 ========
                    {
                        panel40.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel41 ========
                        {
                            panel41.setBorder(new TitledBorder("field"));
                            panel41.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel41.add(formattedTextField136, "cell 0 0");
                            panel41.add(formattedTextField137, "cell 1 0");
                            panel41.add(formattedTextField138, "cell 2 0");
                            panel41.add(formattedTextField139, "cell 3 0");
                            panel41.add(formattedTextField140, "cell 4 0");
                            panel41.add(formattedTextField141, "cell 5 0");
                            panel41.add(formattedTextField142, "cell 6 0");
                            panel41.add(formattedTextField143, "cell 7 0");
                            panel41.add(formattedTextField144, "cell 8 0");

                            //---- button18 ----
                            button18.setText("Insert");
                            panel41.add(button18, "cell 9 0");

                            //---- button19 ----
                            button19.setText("Delete");
                            panel41.add(button19, "cell 10 0");
                        }
                        panel40.add(panel41, "cell 0 0,growx");

                        //---- label16 ----
                        label16.setPreferredSize(new Dimension(672, 500));
                        label16.setBorder(new TitledBorder("Result"));
                        label16.setMinimumSize(new Dimension(672, 500));
                        label16.setMaximumSize(new Dimension(32767, 32767));
                        panel40.add(label16, "cell 0 1,dock center");
                    }
                    tabbedPane3.addTab("Table 4", panel40);

                    //======== panel42 ========
                    {
                        panel42.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]"));

                        //======== panel43 ========
                        {
                            panel43.setBorder(new TitledBorder("field"));
                            panel43.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                                // rows
                                "[grow,center]"));
                            panel43.add(formattedTextField145, "cell 0 0");
                            panel43.add(formattedTextField146, "cell 1 0");
                            panel43.add(formattedTextField147, "cell 2 0");
                            panel43.add(formattedTextField148, "cell 3 0");
                            panel43.add(formattedTextField149, "cell 4 0");
                            panel43.add(formattedTextField150, "cell 5 0");
                            panel43.add(formattedTextField151, "cell 6 0");
                            panel43.add(formattedTextField152, "cell 7 0");
                            panel43.add(formattedTextField153, "cell 8 0");

                            //---- button20 ----
                            button20.setText("Insert");
                            panel43.add(button20, "cell 9 0");

                            //---- button21 ----
                            button21.setText("Delete");
                            panel43.add(button21, "cell 10 0");
                        }
                        panel42.add(panel43, "cell 0 0,growx");

                        //---- label17 ----
                        label17.setPreferredSize(new Dimension(672, 500));
                        label17.setBorder(new TitledBorder("Result"));
                        label17.setMinimumSize(new Dimension(672, 500));
                        label17.setMaximumSize(new Dimension(32767, 32767));
                        panel42.add(label17, "cell 0 1,dock center");
                    }
                    tabbedPane3.addTab("Table 5", panel42);

                    //======== panel44 ========
                    {
                        panel44.setLayout(new MigLayout(
                            "insets 0,hidemode 3,gap 0 0",
                            // columns
                            "[grow,left]",
                            // rows
                            "[fill]" +
                            "[fill]" +
                            "[]"));

                        //---- label18 ----
                        label18.setPreferredSize(new Dimension(672, 500));
                        label18.setBorder(new TitledBorder("Result"));
                        label18.setMinimumSize(new Dimension(672, 500));
                        label18.setMaximumSize(new Dimension(32767, 32767));
                        panel44.add(label18, "cell 0 1,dock center");

                        //======== panel46 ========
                        {
                            panel46.setLayout(new MigLayout(
                                "insets 0,hidemode 3,gap 0 0",
                                // columns
                                "[grow,left]",
                                // rows
                                "[fill]" +
                                "[fill]"));

                            //======== panel47 ========
                            {
                                panel47.setBorder(new TitledBorder("field"));
                                panel47.setLayout(new MigLayout(
                                    "insets 0,hidemode 3,gap 0 0",
                                    // columns
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]" +
                                    "[fill]",
                                    // rows
                                    "[grow,center]"));
                                panel47.add(formattedTextField163, "cell 0 0");
                                panel47.add(formattedTextField164, "cell 1 0");
                                panel47.add(formattedTextField165, "cell 2 0");
                                panel47.add(formattedTextField166, "cell 3 0");
                                panel47.add(formattedTextField167, "cell 4 0");
                                panel47.add(formattedTextField168, "cell 5 0");
                                panel47.add(formattedTextField169, "cell 6 0");
                                panel47.add(formattedTextField170, "cell 7 0");
                                panel47.add(formattedTextField171, "cell 8 0");

                                //---- button24 ----
                                button24.setText("Insert");
                                panel47.add(button24, "cell 9 0");

                                //---- button26 ----
                                button26.setText("Delete");
                                panel47.add(button26, "cell 10 0");
                            }
                            panel46.add(panel47, "cell 0 0,growx");

                            //---- label19 ----
                            label19.setPreferredSize(new Dimension(672, 500));
                            label19.setBorder(new TitledBorder("Result"));
                            label19.setMinimumSize(new Dimension(672, 500));
                            label19.setMaximumSize(new Dimension(32767, 32767));
                            panel46.add(label19, "cell 0 1,dock center");
                        }
                        panel44.add(panel46, "cell 0 2");
                    }
                    tabbedPane3.addTab("Table 6", panel44);
                }
                tabbedPane2.addTab("Insert/Delete", tabbedPane3);
            }
            frame2.add(tabbedPane2, BorderLayout.NORTH);
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yann Gabbud
    private Frame frame2;
    private JTabbedPane tabbedPane2;
    private JPanel panel12;
    private JTextField textField7;
    private JPanel panel13;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JButton button2;
    private JLabel label1;
    private JTabbedPane tabbedPane1;
    private JPanel panel14;
    private JPanel panel15;
    private JFormattedTextField formattedTextField19;
    private JFormattedTextField formattedTextField20;
    private JFormattedTextField formattedTextField21;
    private JFormattedTextField formattedTextField22;
    private JFormattedTextField formattedTextField23;
    private JFormattedTextField formattedTextField24;
    private JFormattedTextField formattedTextField25;
    private JFormattedTextField formattedTextField26;
    private JFormattedTextField formattedTextField27;
    private JButton button4;
    private JLabel label3;
    private JPanel panel16;
    private JPanel panel17;
    private JFormattedTextField formattedTextField28;
    private JFormattedTextField formattedTextField29;
    private JFormattedTextField formattedTextField30;
    private JFormattedTextField formattedTextField31;
    private JFormattedTextField formattedTextField32;
    private JFormattedTextField formattedTextField33;
    private JFormattedTextField formattedTextField34;
    private JFormattedTextField formattedTextField35;
    private JFormattedTextField formattedTextField36;
    private JButton button5;
    private JLabel label4;
    private JPanel panel18;
    private JPanel panel19;
    private JFormattedTextField formattedTextField37;
    private JFormattedTextField formattedTextField38;
    private JFormattedTextField formattedTextField39;
    private JFormattedTextField formattedTextField40;
    private JFormattedTextField formattedTextField41;
    private JFormattedTextField formattedTextField42;
    private JFormattedTextField formattedTextField43;
    private JFormattedTextField formattedTextField44;
    private JFormattedTextField formattedTextField45;
    private JButton button6;
    private JLabel label5;
    private JPanel panel20;
    private JPanel panel21;
    private JFormattedTextField formattedTextField46;
    private JFormattedTextField formattedTextField47;
    private JFormattedTextField formattedTextField48;
    private JFormattedTextField formattedTextField49;
    private JFormattedTextField formattedTextField50;
    private JFormattedTextField formattedTextField51;
    private JFormattedTextField formattedTextField52;
    private JFormattedTextField formattedTextField53;
    private JFormattedTextField formattedTextField54;
    private JButton button7;
    private JLabel label6;
    private JPanel panel22;
    private JPanel panel23;
    private JFormattedTextField formattedTextField55;
    private JFormattedTextField formattedTextField56;
    private JFormattedTextField formattedTextField57;
    private JFormattedTextField formattedTextField58;
    private JFormattedTextField formattedTextField59;
    private JFormattedTextField formattedTextField60;
    private JFormattedTextField formattedTextField61;
    private JFormattedTextField formattedTextField62;
    private JFormattedTextField formattedTextField63;
    private JButton button8;
    private JLabel label7;
    private JPanel panel24;
    private JPanel panel25;
    private JFormattedTextField formattedTextField64;
    private JFormattedTextField formattedTextField65;
    private JFormattedTextField formattedTextField66;
    private JFormattedTextField formattedTextField67;
    private JFormattedTextField formattedTextField68;
    private JFormattedTextField formattedTextField69;
    private JFormattedTextField formattedTextField70;
    private JFormattedTextField formattedTextField71;
    private JFormattedTextField formattedTextField72;
    private JButton button9;
    private JLabel label8;
    private JPanel panel26;
    private JPanel panel27;
    private JFormattedTextField formattedTextField73;
    private JFormattedTextField formattedTextField74;
    private JFormattedTextField formattedTextField75;
    private JFormattedTextField formattedTextField76;
    private JFormattedTextField formattedTextField77;
    private JFormattedTextField formattedTextField78;
    private JFormattedTextField formattedTextField79;
    private JFormattedTextField formattedTextField80;
    private JFormattedTextField formattedTextField81;
    private JButton button10;
    private JLabel label9;
    private JPanel panel28;
    private JPanel panel29;
    private JFormattedTextField formattedTextField82;
    private JFormattedTextField formattedTextField83;
    private JFormattedTextField formattedTextField84;
    private JFormattedTextField formattedTextField85;
    private JFormattedTextField formattedTextField86;
    private JFormattedTextField formattedTextField87;
    private JFormattedTextField formattedTextField88;
    private JFormattedTextField formattedTextField89;
    private JFormattedTextField formattedTextField90;
    private JButton button11;
    private JLabel label10;
    private JPanel panel30;
    private JPanel panel31;
    private JFormattedTextField formattedTextField91;
    private JFormattedTextField formattedTextField92;
    private JFormattedTextField formattedTextField93;
    private JFormattedTextField formattedTextField94;
    private JFormattedTextField formattedTextField95;
    private JFormattedTextField formattedTextField96;
    private JFormattedTextField formattedTextField97;
    private JFormattedTextField formattedTextField98;
    private JFormattedTextField formattedTextField99;
    private JButton button12;
    private JLabel label11;
    private JPanel panel32;
    private JPanel panel33;
    private JFormattedTextField formattedTextField100;
    private JFormattedTextField formattedTextField101;
    private JFormattedTextField formattedTextField102;
    private JFormattedTextField formattedTextField103;
    private JFormattedTextField formattedTextField104;
    private JFormattedTextField formattedTextField105;
    private JFormattedTextField formattedTextField106;
    private JFormattedTextField formattedTextField107;
    private JFormattedTextField formattedTextField108;
    private JButton button13;
    private JLabel label12;
    private JPanel panel54;
    private JPanel panel55;
    private JFormattedTextField formattedTextField199;
    private JFormattedTextField formattedTextField200;
    private JFormattedTextField formattedTextField201;
    private JFormattedTextField formattedTextField202;
    private JFormattedTextField formattedTextField203;
    private JFormattedTextField formattedTextField204;
    private JFormattedTextField formattedTextField205;
    private JFormattedTextField formattedTextField206;
    private JFormattedTextField formattedTextField207;
    private JButton button25;
    private JLabel label23;
    private JTabbedPane tabbedPane3;
    private JPanel panel34;
    private JPanel panel35;
    private JFormattedTextField formattedTextField109;
    private JFormattedTextField formattedTextField110;
    private JFormattedTextField formattedTextField111;
    private JFormattedTextField formattedTextField112;
    private JFormattedTextField formattedTextField113;
    private JFormattedTextField formattedTextField114;
    private JFormattedTextField formattedTextField115;
    private JFormattedTextField formattedTextField116;
    private JFormattedTextField formattedTextField117;
    private JButton button14;
    private JButton button1;
    private JLabel label13;
    private JPanel panel36;
    private JPanel panel37;
    private JFormattedTextField formattedTextField118;
    private JFormattedTextField formattedTextField119;
    private JFormattedTextField formattedTextField120;
    private JFormattedTextField formattedTextField121;
    private JFormattedTextField formattedTextField122;
    private JFormattedTextField formattedTextField123;
    private JFormattedTextField formattedTextField124;
    private JFormattedTextField formattedTextField125;
    private JFormattedTextField formattedTextField126;
    private JButton button15;
    private JButton button3;
    private JLabel label14;
    private JPanel panel38;
    private JPanel panel39;
    private JFormattedTextField formattedTextField127;
    private JFormattedTextField formattedTextField128;
    private JFormattedTextField formattedTextField129;
    private JFormattedTextField formattedTextField130;
    private JFormattedTextField formattedTextField131;
    private JFormattedTextField formattedTextField132;
    private JFormattedTextField formattedTextField133;
    private JFormattedTextField formattedTextField134;
    private JFormattedTextField formattedTextField135;
    private JButton button16;
    private JButton button17;
    private JLabel label15;
    private JPanel panel40;
    private JPanel panel41;
    private JFormattedTextField formattedTextField136;
    private JFormattedTextField formattedTextField137;
    private JFormattedTextField formattedTextField138;
    private JFormattedTextField formattedTextField139;
    private JFormattedTextField formattedTextField140;
    private JFormattedTextField formattedTextField141;
    private JFormattedTextField formattedTextField142;
    private JFormattedTextField formattedTextField143;
    private JFormattedTextField formattedTextField144;
    private JButton button18;
    private JButton button19;
    private JLabel label16;
    private JPanel panel42;
    private JPanel panel43;
    private JFormattedTextField formattedTextField145;
    private JFormattedTextField formattedTextField146;
    private JFormattedTextField formattedTextField147;
    private JFormattedTextField formattedTextField148;
    private JFormattedTextField formattedTextField149;
    private JFormattedTextField formattedTextField150;
    private JFormattedTextField formattedTextField151;
    private JFormattedTextField formattedTextField152;
    private JFormattedTextField formattedTextField153;
    private JButton button20;
    private JButton button21;
    private JLabel label17;
    private JPanel panel44;
    private JLabel label18;
    private JPanel panel46;
    private JPanel panel47;
    private JFormattedTextField formattedTextField163;
    private JFormattedTextField formattedTextField164;
    private JFormattedTextField formattedTextField165;
    private JFormattedTextField formattedTextField166;
    private JFormattedTextField formattedTextField167;
    private JFormattedTextField formattedTextField168;
    private JFormattedTextField formattedTextField169;
    private JFormattedTextField formattedTextField170;
    private JFormattedTextField formattedTextField171;
    private JButton button24;
    private JButton button26;
    private JLabel label19;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
