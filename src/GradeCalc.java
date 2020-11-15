import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalc extends JFrame
        implements ChangeListener,
        ActionListener {

    private JSlider practice, labs, midterms, finals;
    private JTextField practiceVal, labsVal, midtermsVal, finalsVal;
    private JButton button;
    private final JTextField textBox;

    /*
    Below is the constructer method which helps create the GUI window and implements
    a grid layout when opening.
    */
    public GradeCalc() {

        setTitle("Sliders");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        practice = new JSlider(SwingConstants.HORIZONTAL,
                0, 44, 0);

        labs = new JSlider(SwingConstants.HORIZONTAL,
                0, 16, 0);

        midterms = new JSlider(SwingConstants.HORIZONTAL,
                0, 20, 0);

        finals = new JSlider(SwingConstants.HORIZONTAL,
                0, 20, 0);

        practice.setMajorTickSpacing(4);
        labs.setMajorTickSpacing(2);
        midterms.setMajorTickSpacing(2);
        finals.setMajorTickSpacing(2);

        practice.setPaintTicks(true);
        practice.setPaintLabels(true);
        labs.setPaintTicks(true);
        labs.setPaintLabels(true);
        midterms.setPaintTicks(true);
        midterms.setPaintLabels(true);
        finals.setPaintTicks(true);
        finals.setPaintLabels(true);

        practice.addChangeListener(this);
        labs.addChangeListener(this);
        midterms.addChangeListener(this);
        finals.addChangeListener(this);

        practiceVal = new JTextField(2);
        labsVal = new JTextField(2);
        midtermsVal = new JTextField(2);
        finalsVal = new JTextField(2);

        practiceVal.setText("Enter points made for Practice Problems(Using Sliders)");
        labsVal.setText("For labs");
        midtermsVal.setText("For Midterms");
        finalsVal.setText("For Final");

        practiceVal.setEditable(false);
        labsVal.setEditable(false);
        midtermsVal.setEditable(false);
        finalsVal.setEditable(false);

        button = new JButton("Final Point Grade");

        textBox = new JTextField(15);

        button.addActionListener(this);

        setLayout(new GridLayout(5, 2));

        add(practiceVal);
        add(practice);
        add(labsVal);
        add(labs);
        add(midtermsVal);
        add(midterms);
        add(finalsVal);
        add(finals);
        add(button);
        add(textBox);

        setVisible(true);

    }

    /*
    The method is for the button in which it takes the values inputed by the sliders
    and then calculates thier sum and prints it out.
    */

    public void actionPerformed(ActionEvent e) {

        int prob = this.practice.getValue();
        int lab = this.labs.getValue();
        int midterm = this.midterms.getValue();
        int fin = this.finals.getValue();

        int sum = prob + lab + midterm + fin;

        String text = Integer.toString(sum);

        textBox.setText(text);

    }

    /*
    This method creates the effect for the slider and the text field to change with
    each other when moved.
    */

    public void stateChanged(ChangeEvent e) {

        practiceVal.setText(Integer.toString(practice.getValue()));

        labsVal.setText(Integer.toString(
                labs.getValue()));

        midtermsVal.setText(Integer.toString(
                midterms.getValue()));

        finalsVal.setText(Integer.toString(
                finals.getValue()));

    }

    public static void main(String[] args) {
        GradeCalc gradeCalc = new GradeCalc();
    }

}
