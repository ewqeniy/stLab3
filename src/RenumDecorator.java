import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RenumDecorator implements IMatrix {
    private IMatrix matrix;

    public RenumDecorator(IMatrix matrix) {
        this.matrix = matrix;
        SwapCol(matrix);
        SwapRow(matrix);
    }

    public void SwapCol(IMatrix matrix) {
        /*Генерируем рандомный порядок для перестановки.*/
        Random rnd = new Random();
        int swapedCol1=0;
        int swapedCol2=0;
        while (swapedCol1 == swapedCol2){
            swapedCol1 = rnd.nextInt(matrix.getSRows());
            swapedCol2 = rnd.nextInt(matrix.getSRows());
        }
        System.out.println(swapedCol1 + " " + swapedCol2);
        for (int i=0;i<matrix.getSCols();i++){
            int temp = matrix.get(swapedCol1,i);
            matrix.set(swapedCol1,i,matrix.get(swapedCol2,i));
            matrix.set(swapedCol2,i,temp);
        }
    }

    public void SwapRow(IMatrix matrix){
        Random rnd = new Random();
        int swapedRow1=0;
        int swapedRow2=0;
        while (swapedRow1 == swapedRow2){
            swapedRow1 = rnd.nextInt(matrix.getSCols());
            swapedRow2 = rnd.nextInt(matrix.getSCols());
        }
        System.out.println(swapedRow1 + " " + swapedRow2);
        for (int i=0;i<matrix.getSRows();i++){
            int temp = matrix.get(i,swapedRow1);
            matrix.set(i,swapedRow1,matrix.get(i,swapedRow2));
            matrix.set(i,swapedRow2,temp);
        }

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
