import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Formatter;

public class App extends JFrame{


    private JPanel panel1;
    private JButton buttonN;
    private JButton buttonR;
    private JCheckBox CheckBox;
    private JLabel textS;
    private JButton Decor;
    private JButton Undecor;
    private IMatrix matrix;
    private int swRow1,swRow2,swCol1,swCol2;


    boolean isFlag() {
        return CheckBox.isSelected();
    }
    JPanel getPanel1() {
        return panel1;
    }

    public App() {
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                IDrawer id = new CDrawer();
                IMatrix m = new MatrixS(4,4,id);
                initMatrix.fill(m,10,30);
                matrix = m;
                m.Draw();
                Decor.setEnabled(true);
                Undecor.setEnabled(false);
            }
        });
        buttonN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                IDrawer id = new CDrawer();
                IMatrix m = new MatrixN(5,5,id);
                initMatrix.fill(m,14,25);
                matrix = m;
                m.Draw();
                Decor.setEnabled(true);
                Undecor.setEnabled(false);
            }
        });
        Decor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrix = new RenumDecorator(matrix);
                matrix.Draw();
                Undecor.setEnabled(true);
            }
        });
        Undecor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrix = new RenumDecorator(matrix).getComponent();
                matrix.Draw();
                Undecor.setEnabled(false);
            }
        });
    }

    public static App app = new App();

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        IDrawer d = new CDrawer();
        IMatrix matr = new MatrixN(3,4,d);
        initMatrix.fill(matr,5,10);
        matr.Draw();
        System.out.println(" ");
        matr = new RenumDecorator(matr);
        matr.Draw();
    }
}


