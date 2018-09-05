
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LAB03 extends JFrame implements ActionListener {
    private final String[] KEYS = { "1", "2", "3", "/", "sqrt", "4", "5", "6",
            "*", "%", "7", "8", "9", "-", "1/x", "0", "+/-", ".", "+", "=" };
    private JButton keys[] = new JButton[KEYS.length];
    private JTextField resultText = new JTextField("0");
    private boolean firstDigit = true;
    private double resultNum = 0.0;
    private String operator = "=";
    private boolean operateValidFlag = true;
    JMenuBar Menubar;
    JMenu file;
    JMenu Help;
    JMenuItem HELP;
    JMenuItem EXIT;

    
    
    

    public LAB03() {
        super();
        init();
        this.setTitle("Calculator");
        this.setLocation(400, 300);
        this.setResizable(false);//FRAME RESIZABLE
        this.pack();
       //setLayout(new FlowLayout());
       Menubar = new JMenuBar();
       setJMenuBar(Menubar);
       file = new JMenu("File");
       Menubar.add(file);
       EXIT = new JMenuItem("EXIT");
       file.add(EXIT);
       
       
       
       //LAB03 e = new LAB03();
      //EXIT.addActionListener(e);
      EXIT.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  System.exit(0);
    	  }
      });
       
       Help = new JMenu("HELP");
       Menubar.add(Help);
       HELP = new JMenuItem("dialog");
       Help.add(HELP);
       HELP.addActionListener(new ActionListener() {
     	  public void actionPerformed(ActionEvent e) {
     		 JOptionPane.showMessageDialog(LAB03.this, "Li Shen");
     	  }
       });
        
    }
    
    
    
     // GET FUNCTION get the number on the text
    
    public double getNumberFromText() {
        double result = 0;
        try {
            result = Double.valueOf(resultText.getText()).doubleValue();
        } catch (NumberFormatException e) {
        }
        return result;
    }
  

 
    public void init() {
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setEditable(false);
        resultText.setBackground(Color.WHITE);
        JPanel calckeysPanel = new JPanel();
        calckeysPanel.setLayout(new GridLayout(4, 5, 5,5));
        for (int i = 0; i < KEYS.length; i++) {
            keys[i] = new JButton(KEYS[i]);
            calckeysPanel.add(keys[i]);
            keys[i].setForeground(Color.BLACK);
        }
        // CALCULATION USE RED, OTHER USE B;ACK
        keys[3].setForeground(Color.red);
        keys[8].setForeground(Color.red);
        keys[13].setForeground(Color.red);
        keys[18].setForeground(Color.red);
        keys[19].setForeground(Color.red);
 
       
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(3, 3));
      //  panel1.add("North", commandsPanel);
        panel1.add("Center", calckeysPanel);
        	JPanel top = new JPanel();
        	top.setLayout(new BorderLayout());
        	top.add("Center", resultText);
 
        getContentPane().setLayout(new BorderLayout(3, 5));
        getContentPane().add("North", top);
        getContentPane().add("Center", panel1);
 
        for (int i = 0; i < KEYS.length; i++) {
            keys[i].addActionListener(this);
        }
        	}
 
    /**
     * DO ACYION
     */
    public void actionPerformed(ActionEvent e) {
        // GET THE COMMAND
        String label = e.getActionCommand();
         if ("0123456789.".indexOf(label) >= 0) {
            // IF USER POINT OUT THE UNIT
            handleNumber(label);
        } else {
            handleOperator(label);
        }
    }

    private void handleNumber(String key) {
        if (firstDigit) {
            resultText.setText(key);
        } else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
            resultText.setText(resultText.getText() + ".");
        } else if (!key.equals(".")) {
            resultText.setText(resultText.getText() + key);
        }
        // WILL NEVER BE THE FIRST NUMBER
        firstDigit = false;
    }
 
    /**
     handle operator logic
     */
    private void handleOperator(String key) {
        if (operator.equals("/")) {
            if (getNumberFromText() == 0.0) {
                // valid
                operateValidFlag = false;
                resultText.setText("Invalid");
            } else {
                resultNum /= getNumberFromText();
            }
        } else if (operator.equals("1/x")) {
            if (resultNum == 0.0) {
                // valid
                operateValidFlag = false;
                resultText.setText("Invalid");
            } else {
                resultNum = 1 / resultNum;
            }
        } else if (operator.equals("+")) {
            // add
            resultNum += getNumberFromText();
        } else if (operator.equals("-")) {
            // minus
            resultNum -= getNumberFromText();
        } else if (operator.equals("*")) {
            // times
            resultNum *= getNumberFromText();
        } else if (operator.equals("sqrt")) {
            // root
            resultNum = Math.sqrt(resultNum);
        } else if (operator.equals("%")) {
            // %
        	resultNum %= getNumberFromText();
        } else if (operator.equals("+/-")) {
            // +/-
            resultNum = resultNum * (-1);
        } else if (operator.equals("=")) {
            resultNum = getNumberFromText();
        }
        if (operateValidFlag) {
            // double calculator
            long CAL;
            double TOR;
            CAL= (long) resultNum;
            TOR = resultNum - CAL;
            if (TOR == 0) {
                resultText.setText(String.valueOf(CAL));
            } else {
                resultText.setText(String.valueOf(resultNum));
            }
        }
        operator = key;
        firstDigit = true;
        operateValidFlag = true;
    }


public static void main(String args[]) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    server = new CalcServer(8189);
    System.out.println(" \\ Server Started \\ ");
}

// Create Application && Initialize GUI
public LAB03() {

    initialize();
}

private void initialize() {
    // Create JFrame
    createJFrame();

    // Create Text Fields
    createJTextField();

    // Create  Buttons
    createButtons();
}

	LAB03 calculator1 = new LAB03();
        calculator1.setVisible(true);
        calculator1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

