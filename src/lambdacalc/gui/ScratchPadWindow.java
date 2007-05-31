/*
 * TeacherToolWindow.java
 *
 * Created on May 29th, 2007
 */

package lambdacalc.gui;

import java.io.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import lambdacalc.exercises.*;
import lambdacalc.logic.*;

/**
 *
 * @author  champoll 
 * @author tauberer
 */
public class ScratchPadWindow extends javax.swing.JFrame {
    private static ScratchPadWindow singleton=null;

    static ScratchPadWindow getSingleton() {
        return singleton;
    }    
    
    // states set by the radio buttons
    private static final boolean LAMBDA_CONVERSION = true;
    private static final boolean TYPE_SIMPLIFICATION = false;
    
    private boolean selection = LAMBDA_CONVERSION;
    
    private boolean userMod = false; // whether user is trying to modify a problem he's currently working on
    
    private Exercise ex=null; // contract: this must be null whenever a problem has been solved
    private Exercise previousEx; // whenever a problem is solved it is written in here
    
    private String currentProblemString = "";
    
    public static void prepareWindow() {
       if (singleton == null) {
            singleton = new ScratchPadWindow();
       }
       singleton.resetGUI();
    }
        
    public static void showWindow() {
        
        prepareWindow();
        singleton.show();
    }
    
    static void exit() {
        disposeWindow();
    }
    
    public static void disposeWindow() {
        if (singleton != null)
            singleton.dispose();
    }
    
    /** Creates new form ScratchPadWindow */
    public ScratchPadWindow() {
        initComponents();
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtEnterYourOwnProblem = new lambdacalc.gui.LambdaEnabledTextField();
        txtUserAnswer = new lambdacalc.gui.LambdaEnabledTextField();
        jButtonCheckAnswer = new javax.swing.JButton();
        jRadioButtonLambda = new javax.swing.JRadioButton();
        jRadioButtonType = new javax.swing.JRadioButton();
        jButtonDoAnotherProblem = new javax.swing.JButton();
        jButtonCloseWindow = new javax.swing.JButton();
        jScrollPaneFeedback = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();
        jButtonDoAgain = new javax.swing.JButton();
        jButtonConfirm = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jExitMenuItem = new javax.swing.JMenuItem();

        fileChooser.setApproveButtonText("Open Directory");
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setTitle("Lambda Teacher Tool");
        txtEnterYourOwnProblem.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Your Own Problem"));
        txtEnterYourOwnProblem.setFont(new java.awt.Font("Serif", 0, 18));
        txtEnterYourOwnProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterYourOwnProblemActionPerformed(evt);
            }
        });

        txtUserAnswer.setFont(new java.awt.Font("Serif", 0, 18));
        txtUserAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAnswerActionPerformed(evt);
                txtUserAnswerActionPerformed1(evt);
            }
        });

        jButtonCheckAnswer.setText("Check Answer");
        jButtonCheckAnswer.setActionCommand("Check Answer");
        jButtonCheckAnswer.setMaximumSize(new java.awt.Dimension(120, 25));
        jButtonCheckAnswer.setMinimumSize(new java.awt.Dimension(120, 25));
        jButtonCheckAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCheckAnswer(evt);
            }
        });

        buttonGroup1.add(jRadioButtonLambda);
        jRadioButtonLambda.setSelected(true);
        jRadioButtonLambda.setText("Lambda Conversion");
        jRadioButtonLambda.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonLambda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonLambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLambdaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonType);
        jRadioButtonType.setText("Type Simplification");
        jRadioButtonType.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTypeActionPerformed(evt);
            }
        });

        jButtonDoAnotherProblem.setText("Do Another Problem");
        jButtonDoAnotherProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoAnotherProblemActionPerformed(evt);
            }
        });

        jButtonCloseWindow.setText("Close Window");
        jButtonCloseWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseWindowActionPerformed(evt);
            }
        });

        jScrollPaneFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jScrollPaneFeedback.setBorder(javax.swing.BorderFactory.createTitledBorder("Feedback"));
        txtFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtFeedback.setColumns(20);
        txtFeedback.setEditable(false);
        txtFeedback.setFont(new java.awt.Font("SansSerif", 0, 12));
        txtFeedback.setLineWrap(true);
        txtFeedback.setRows(5);
        txtFeedback.setWrapStyleWord(true);
        txtFeedback.setBorder(null);
        jScrollPaneFeedback.setViewportView(txtFeedback);

        jButtonDoAgain.setText("Do Problem Again");
        jButtonDoAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoAgainActionPerformed(evt);
            }
        });

        jButtonConfirm.setText("Enter Problem");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        menuFile.setMnemonic('F');
        menuFile.setText("File");
        jExitMenuItem.setMnemonic('x');
        jExitMenuItem.setLabel("Exit Scratch Pad");
        jExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitMenuItemActionPerformed(evt);
            }
        });

        menuFile.add(jExitMenuItem);

        jMenuBar1.add(menuFile);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jButtonDoAgain)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButtonDoAnotherProblem)
                                .add(116, 116, 116)
                                .add(jButtonCloseWindow))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jRadioButtonType)
                                    .add(jRadioButtonLambda))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtEnterYourOwnProblem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                            .add(txtUserAnswer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jButtonCheckAnswer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(350, 350, 350)
                        .add(jButtonConfirm))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPaneFeedback, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jRadioButtonLambda)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButtonType)
                        .add(17, 17, 17))
                    .add(layout.createSequentialGroup()
                        .add(txtEnterYourOwnProblem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonConfirm, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtUserAnswer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonCheckAnswer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPaneFeedback, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonCloseWindow)
                    .add(jButtonDoAgain)
                    .add(jButtonDoAnotherProblem))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        
        Exercise enteredEx;
        
        switchOff(txtUserAnswer);
        
        IdentifierTyper it;
        Exercise currentMainWindowEx=null;
        
        if (TrainingWindow.getSingleton() != null) {
            currentMainWindowEx = 
                    TrainingWindow.getSingleton().getCurrentExercise();
        }
        if (currentMainWindowEx != null && currentMainWindowEx instanceof HasIdentifierTyper) {
            it = ((HasIdentifierTyper) currentMainWindowEx).getIdentifierTyper();
        } else {
            it = IdentifierTyper.createDefault();
        }

        // options for parsing lambda expressions
        ExpressionParser.ParseOptions exprParseOpts = new ExpressionParser.ParseOptions();
        exprParseOpts.ASCII = false; // LambdaEnabledTextBox will already do the conversion
        exprParseOpts.singleLetterIdentifiers = true; // Pa means P(a) 
        // TODO maybe singleLetterIdentifiers option should be parametrized
        // and/or dependent on whatever the state of the main window is?
        exprParseOpts.typer = it;
        
        String line = txtEnterYourOwnProblem.getText().trim();
            if (!line.equals(txtEnterYourOwnProblem.getText())) {
                txtEnterYourOwnProblem.setText(line);
            }
        
        try {
            if (this.selection==LAMBDA_CONVERSION) {
                enteredEx= new LambdaConversionExercise(line, exprParseOpts, 1, it);
                if (enteredEx == null) {
                  
                    throw new SyntaxException("Warning: TypeExercise constructor returned null",
                            txtUserAnswer.getText().length());
                    
                }
                
                // we don't want to bug people in the ScratchPad application
                ((LambdaConversionExercise) enteredEx).setNotSoFast(false);
                
            } else if (this.selection==TYPE_SIMPLIFICATION) {
                enteredEx= new TypeExercise(line, exprParseOpts, 1, it);
                if (enteredEx == null) {
                    
                    throw new SyntaxException("Warning: TypeExercise constructor returned null",
                            txtUserAnswer.getText().length());                   
                }
            } else {
                throw new RuntimeException("Scratch pad is in an illegal state");
            }
            
            // successfully entered a problem
            this.currentProblemString = line;
            previousEx=ex;
            ex=enteredEx;
            tellGUIProblemEntered();
        } catch (SyntaxException s) {
            
            if (this.ex!=null) { // user is trying to modify a problem on the fly
                undoOnTheFlyModification();
                displayFeedback("I could not understand your modification of the current problem: " + s.getMessage()
                +"I'm reverting your modification. If you would like to scratch the current problem " +
                        "and start a new one, click on Do Another Problem.");                
            } else { // user is trying to enter a problem at the beginning or after clicking "Do another problem"
                if (s.getPosition() >= 0 && s.getPosition() <= txtUserAnswer.getText().length())
                    txtUserAnswer.setCaretPosition(s.getPosition());
            }
        } catch (TypeEvaluationException t) {
            if (this.ex!=null) { // user is trying to modify a problem on the fly
                undoOnTheFlyModification();
                displayFeedback("I could not understand your modification of the current problem: " + t.getMessage()
                +"I'm reverting your modification. If you would like to scratch the current problem " +
                        "and start a new one, click on Do Another Problem.");
            } else {
            }
        }

    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void undoOnTheFlyModification() {
        txtEnterYourOwnProblem.setText(this.currentProblemString);
        //tellGUIProblemEntered();
    }
    
    private void jButtonDoAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAgainActionPerformed
        ex.reset();
        txtEnterYourOwnProblem.setText(this.currentProblemString);
        displayFeedback("");
        tellGUIProblemEntered();
    }//GEN-LAST:event_jButtonDoAgainActionPerformed

    private void jButtonDoAnotherProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAnotherProblemActionPerformed
        resetGUI();
        this.ex = null;
    }//GEN-LAST:event_jButtonDoAnotherProblemActionPerformed

    private void jButtonCloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseWindowActionPerformed
        jExitMenuItem.doClick();
    }//GEN-LAST:event_jButtonCloseWindowActionPerformed

    private void jRadioButtonTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTypeActionPerformed
        radioButtonSwitch(TYPE_SIMPLIFICATION);
    }//GEN-LAST:event_jRadioButtonTypeActionPerformed

    private void jRadioButtonLambdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLambdaActionPerformed
        radioButtonSwitch(LAMBDA_CONVERSION);
    }//GEN-LAST:event_jRadioButtonLambdaActionPerformed

    private void radioButtonSwitch(boolean userChoice) {
        selection = userChoice;
    }
    
    private void txtUserAnswerActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAnswerActionPerformed1
        jButtonCheckAnswer.doClick();
    }//GEN-LAST:event_txtUserAnswerActionPerformed1

      
    private void txtEnterYourOwnProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnterYourOwnProblemActionPerformed
        jButtonConfirm.doClick();
    }//GEN-LAST:event_txtEnterYourOwnProblemActionPerformed

    private void switchOn(javax.swing.JTextField j) {
        //j.setEnabled(true);
        j.setEditable(true);
        //j.setBackground(javax.swing.UIManager.getColor("TextField.activeBackground"));
    }
    
    private void switchOff(javax.swing.JTextField j) {
        //j.setEnabled(false);
        j.setEditable(false);
        //if (j.getText().equals("")) {
        //    j.setBackground(javax.swing.UIManager.getColor("TextField.inactiveBackground"));
        //}
    }
    
    // before user has entered anything -- waiting for a problem
    private void resetGUI() {
        displayFeedback("Entering resetGUI");
        switchOn(txtEnterYourOwnProblem);
        jButtonConfirm.setEnabled(true);
        jButtonCheckAnswer.setEnabled(false);
        txtUserAnswer.setText("");
        switchOff(txtUserAnswer);
        setRadioButtonsEnabled(true);
        jButtonDoAnotherProblem.setEnabled(false);
        txtFeedback.setText("");
        jButtonDoAgain.setEnabled(false);
        
        txtEnterYourOwnProblem.requestFocus();
    }
    
    // after user has entered a problem and clicked "Enter problem" or hit Return
    private void tellGUIProblemEntered() {

        switchOn(txtEnterYourOwnProblem); // switch off if you don't want to allow users
        // to allow entering a problem while they're working on another one
        jButtonConfirm.setEnabled(true);
        jButtonCheckAnswer.setEnabled(true);
        txtUserAnswer.setText("");
        setRadioButtonsEnabled(false);
        jButtonDoAnotherProblem.setEnabled(true);
        jButtonDoAgain.setEnabled(true);
        switchOn(txtUserAnswer);
        
        if (selection==LAMBDA_CONVERSION) {
            displayFeedback("I got your problem. Now enter a lambda expression into the highlighted text field.");
        } else { // selection==TYPE+SIMPLIFICATION
            displayFeedback("I got your problem. Now enter a type into the highlighted text field.");
        }
        
        txtUserAnswer.requestFocus();
    }
    
    // when problem is solved
    private void tellGUIProblemSolved() {
        txtEnterYourOwnProblem.setEnabled(true);
        jButtonConfirm.setEnabled(true);
        txtUserAnswer.setEnabled(false);
        jButtonCheckAnswer.setEnabled(false);
        setRadioButtonsEnabled(false);
        jButtonDoAnotherProblem.setEnabled(true);
        jButtonDoAgain.setEnabled(true);
    }

    
    private void displayFeedback(String msg) {
        txtFeedback.setText(msg);
    }
    
    private void setRadioButtonsEnabled(boolean b) {
        jRadioButtonLambda.setEnabled(b);
        jRadioButtonType.setEnabled(b);
    }
    
    private void onCheckAnswer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCheckAnswer
        try {
            String string = txtUserAnswer.getText().trim();
            if (!string.equals(txtUserAnswer.getText())) {
                txtUserAnswer.setText(string);
            }
            
            if (ex == null) {
                // TODO exception handling
            }
            AnswerStatus status = ex.checkAnswer(string);
            displayFeedback(status.getMessage());
            if (status.isCorrect()) {
                if (status.endsExercise()) {
                    tellGUIProblemSolved();
                    
                    previousEx=ex;
                    ex=null;
                } else { // "Correct! Now simplify..."
                    txtEnterYourOwnProblem.setText(ex.getLastAnswer());
                }
            }
        } catch (SyntaxException s) {
            displayFeedback(s.getMessage());
            if (s.getPosition() >= 0 && s.getPosition() <= txtUserAnswer.getText().length())
                txtUserAnswer.setCaretPosition(s.getPosition());
        }
        txtUserAnswer.requestFocus();
    }//GEN-LAST:event_onCheckAnswer

    
    private void txtUserAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAnswerActionPerformed
        onCheckAnswer(evt);
    }//GEN-LAST:event_txtUserAnswerActionPerformed

    private void jExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitMenuItemActionPerformed
        this.hide();
    }//GEN-LAST:event_jExitMenuItemActionPerformed
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScratchPadWindow().setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButtonCheckAnswer;
    private javax.swing.JButton jButtonCloseWindow;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonDoAgain;
    private javax.swing.JButton jButtonDoAnotherProblem;
    private javax.swing.JMenuItem jExitMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButtonLambda;
    private javax.swing.JRadioButton jRadioButtonType;
    private javax.swing.JScrollPane jScrollPaneFeedback;
    private javax.swing.JMenu menuFile;
    private lambdacalc.gui.LambdaEnabledTextField txtEnterYourOwnProblem;
    private javax.swing.JTextArea txtFeedback;
    private lambdacalc.gui.LambdaEnabledTextField txtUserAnswer;
    // End of variables declaration//GEN-END:variables
    
    
}
