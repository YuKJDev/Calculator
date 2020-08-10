import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.RIGHT;

public class Calc extends JFrame {
    private JTextField jTextField;
    private JButton btnDigits;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivision;
    private JButton btnEqual;
    private JButton btnClear;
    private JButton btnDot;
    private JPanel panelButtons;
    private JPanel panelText;
    private JPanel panelBtnDigits;
    int firstValue = 0;
    String operation = "";
    private final String[]  fonts = {"Serif", "Dialog", "DejaVu Sans"};



    public Calc(String title) throws HeadlessException {
        super();
        initComponents();

    }

    private void doExecute () {

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("0");
            }
        });

        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secondValue = Integer.valueOf(jTextField.getText());
                if ("+".equals(operation)) {
                    jTextField.setText((firstValue + secondValue) + "");
                }
                if ("-".equals(operation)) {
                    jTextField.setText((firstValue - secondValue) + "");
                }
                if ("*".equals(operation)) {
                    jTextField.setText((firstValue * secondValue) + "");
                }
                if ("/".equals(operation)) {
                    if(secondValue == 0) {

                        Font font = new Font(fonts[0], Font.PLAIN, 8);
                        jTextField.setFont(font);
                        jTextField.setText("Error: Division by zero. Please press 'C'");
                    } else
                    jTextField.setText((firstValue / secondValue) + "");
                }

            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(jTextField.getText());
                jTextField.setText(String.valueOf(0));
                operation = "+";
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(jTextField.getText());
              //  jTextField.setText(firstValue + "");
                jTextField.setText(String.valueOf(0));
                operation = "*";
            }
        });
        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(jTextField.getText());
             //   jTextField.setText(firstValue + "");
                jTextField.setText(String.valueOf(0));
                operation = "/";
            }
        });
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(jTextField.getText());
              //  jTextField.setText(firstValue + "");
                jTextField.setText(String.valueOf(0));
                operation = "-";
            }
        });


    }
    private void componentsCompare () {
        setBounds(100, 100, 300, 500);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        jTextField.setHorizontalAlignment(RIGHT);
        ButtonListener buttonListener = new ButtonListener(jTextField);
        for (int i = 7; i <= 9; i++) {
                    btnDigits = new JButton(String.valueOf(i));
                    if (!jTextField.getText().equals(0)) {
                        btnDigits.addActionListener(buttonListener);
                    }
                    panelBtnDigits.add(btnDigits);
        }

        for (int i = 4; i <= 6; i++) {
            btnDigits = new JButton(String.valueOf(i));
            if (!jTextField.getText().equals(0)) {
                btnDigits.addActionListener(buttonListener);
            }
            panelBtnDigits.add(btnDigits);
        }

        for (int i = 1; i <= 3; i++) {
            btnDigits = new JButton(String.valueOf(i));
            if (!jTextField.getText().equals(0)) {
                btnDigits.addActionListener(buttonListener);
            }
            panelBtnDigits.add(btnDigits);
        }
        btnDigits = new JButton(String.valueOf(0));
        if (!jTextField.getText().equals(0)) {
            btnDigits.addActionListener(buttonListener);
        }
        panelBtnDigits.add(btnDigits);



        panelBtnDigits.setLayout(new GridLayout(4, 3));
        panelBtnDigits.add(btnDot);
        btnDot.addActionListener(buttonListener);
        panelBtnDigits.add(btnEqual);
        panelButtons.setBackground(Color.black);
        jTextField.setEditable(false);
        panelButtons.setBackground(Color.black);
        panelButtons.add(btnClear);
        panelButtons.add(btnDivision);
        panelButtons.add(btnMultiply);
        panelButtons.add(btnMinus);
        panelButtons.add(btnPlus);
        panelButtons.setLayout(new GridLayout(5, 1));
        panelText.setLayout(new BorderLayout());
        panelText.add(jTextField, BorderLayout.NORTH);
        panelText.add(panelButtons, BorderLayout.EAST);
        panelText.add(panelBtnDigits, BorderLayout.CENTER);

        setContentPane(panelText);
        pack();
        doExecute();

    }


      private void initComponents() {

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextField = new JTextField("0");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivision = new JButton("/");
        btnEqual = new JButton("=");
        btnDot = new JButton(".");
        btnClear = new JButton("C");
        panelButtons = new JPanel();
        panelText = new JPanel();
        panelBtnDigits = new JPanel();

        componentsCompare();

    }


}
