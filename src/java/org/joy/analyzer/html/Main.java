/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 2009-1-31, 15:06:11
 */
package org.joy.analyzer.html;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.joy.analyzer.Hit;
import org.joy.analyzer.HitAnalyzer;
import org.joy.analyzer.Paragraph;
import org.joy.nlp.ACWordSpliter;
import org.joy.nlp.HLWordSpliter;
import org.joy.nlp.WordSpliter;

/**
 *
 * @author Administrator
 */
public class Main extends javax.swing.JFrame {

    public void insert(String str, AttributeSet attrSet) {
        javax.swing.text.Document doc = textArea.getDocument();
        try {
            doc.insertString(doc.getLength(), str, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e);
        }
    }

    public void setDocs(String str, Color col, boolean bold, int fontSize) {
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, col);
        //颜色
        if (bold == true) {
            StyleConstants.setBold(attrSet, true);
        }//字体类型
        StyleConstants.setFontSize(attrSet, fontSize);
        //字体大小
        insert(str, attrSet);
    }

    /** Creates new form MainFrame */
    public Main() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        urlText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        urlArea = new javax.swing.JTextArea();
        doAnalysis = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        hitList = new javax.swing.JList();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JoyHTML功能演示");

        textArea.setText("这里显示文章的段落分析结果");
        jScrollPane1.setViewportView(textArea);

        urlText.setText("http://news.sina.com.cn/c/2009-01-30/214515091857s.shtml");
        urlText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlTextActionPerformed(evt);
            }
        });

        jLabel1.setText("URL");

        urlArea.setColumns(20);
        urlArea.setRows(5);
        urlArea.setText("该网页中的所有链接");
        jScrollPane2.setViewportView(urlArea);

        doAnalysis.setText("JoyHTML!");
        doAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doAnalysisActionPerformed(evt);
            }
        });

        hitList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "关键词列表" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(hitList);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("中科院分词");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("海量分词");

        jLabel2.setText("分词器选择：");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlText, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(doAnalysis))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(urlText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doAnalysis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urlTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlTextActionPerformed
        try {
            urlArea.setText("");
            textArea.setText("");
            // TODO add your handling code here:
            HTMLDocument doc = HTMLDocument.createHTMLDocument(urlText.getText(), Utility.getWebContent(urlText.getText()));
            for (Anchor a : doc.getAnchors()) {
                if (a != null) {
                    urlArea.setText(urlArea.getText() + a.getText() + "   =>   " + a.getURL() + "\n");
                }
            }
            int offset = 0;
            for (Paragraph p : doc.getParagraphs()) {
                if (p != null) {
                    setDocs(p.getText() + "     -----" + new DecimalFormat("0.00").format(p.getWeight()) + "偏移:" + p.getOffset() + "\n", Color.red, false, (int) (p.getWeight() * 30 + 10));
                    offset += p.getText().length();
                }
            }
            WordSpliter w = null;
            if (jRadioButton1.isSelected()) {
                w = new ACWordSpliter();
            } else {
                w = new HLWordSpliter();
            }

            HitAnalyzer a = new HitAnalyzer(doc, w);
            a.doAnalyze();
            hitList.setListData(a.getHits().toArray(new Hit[0]));
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);
        } catch (Exception ex) {
            hitList.setListData(new String[0]);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "错误：" + ex, "发生错误咯！", 0);
        }
}//GEN-LAST:event_urlTextActionPerformed

    private void doAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doAnalysisActionPerformed
        // TODO add your handling code here:
        urlTextActionPerformed(evt);
}//GEN-LAST:event_doAnalysisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton doAnalysis;
    private javax.swing.JList hitList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane textArea;
    private javax.swing.JTextArea urlArea;
    private javax.swing.JTextField urlText;
    // End of variables declaration//GEN-END:variables
}
