import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RenumDecorator implements IMatrix {
    private IMatrix matrix;

    public RenumDecorator(IMatrix matrix) {
        this.matrix = matrix;
        SwapRow(matrix);
    }

    public void SwapRow(IMatrix matrix) {
        /*Генерируем рандомный порядок для перестановки.*/
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.getSRows(); i++) list.add(i);
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));

        
    }

    @Override
    public int getSRows() {
        return matrix.getSRows();
    }

    @Override
    public int getSCols() {
        return matrix.getSCols();
    }

    @Override
    public int get(int row, int col) {
        return matrix.get(row, col);
    }

    @Override
    public void set(int row, int col, int value) {
        matrix.set(row, col, value);
    }

    @Override
    public void Draw() {
        matrix.Draw();
    }

    @Override
    public void DrawBorder(AMatrix matrix, JPanel panel, boolean flag) {
        matrix.DrawBorder(matrix, panel, flag);
    }

    @Override
    public void DrawItem(AMatrix matrix, JPanel panel1, boolean flag) {
        matrix.DrawItem(matrix, panel1, flag);
    }
}
