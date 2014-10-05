import java.util.Arrays;

/**
 * Created by zhaoran on 10/5/14.
 */
public class MineSweeper {

    public static final int PADDING = 1;

    public String[] sweep(String input[]) {
        String[] paddingInput = addPadding(input);

        String[] output = new String[input.length];
        for (int row = 0; row < input.length; row++) {
            output[row] = "";
            for (int col = 0; col < input[row].length(); col++) {
                output[row] += sweepGrid(paddingInput, row, col);
            }
        }
        return output;
    }

    private String[] addPadding(String[] input) {
        String[] paddingInput = new String[PADDING + input.length + PADDING];

        char[] paddingCharArray = new char[PADDING + input[0].length() + PADDING];
        Arrays.fill(paddingCharArray, '.');
        String paddingString = new String(paddingCharArray);

        paddingInput[0] = paddingString;
        for (int row = 0; row < input.length; row++)
            paddingInput[PADDING + row] = "." + input[row] + ".";
        paddingInput[PADDING + input.length] = paddingString;

        return paddingInput;
    }

    private String sweepGrid(String[] paddingInput, int row, int col) {
        if (hasMineInGrid(paddingInput, row, col)) {
            return "*";
        } else {
            int minesAround = minesAround(paddingInput, row, col);
            return hasMineAround(minesAround) ? Integer.toString(minesAround) : ".";
        }
    }

    private boolean hasMineAround(int minesAround) {
        return minesAround > 0;
    }

    private int minesAround(String[] paddingInput, int row, int col) {
        int minesAround = 0;
        if (hasMineInLeftGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInRightGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInTopGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInBottomGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInTopLeftGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInTopRightGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInBottomLeftGrid(paddingInput, row, col)) minesAround++;
        if (hasMineInBottomRightGrid(paddingInput, row, col)) minesAround++;
        return minesAround;
    }

    private boolean hasMineInTopRightGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row - 1, col + 1);
    }

    private boolean hasMineInBottomRightGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row + 1, col + 1);
    }

    private boolean hasMineInBottomLeftGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row + 1, col - 1);
    }

    private boolean hasMineInTopLeftGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row - 1, col - 1);
    }

    private boolean hasMineInBottomGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row + 1, col);
    }

    private boolean hasMineInTopGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row - 1, col);
    }

    private boolean hasMineInRightGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row, col + 1);
    }

    private boolean hasMineInLeftGrid(String[] paddingInput, int row, int col) {
        return hasMineInGrid(paddingInput, row, col - 1);
    }

    private boolean hasMineInGrid(String[] paddingInput, int row, int col) {
        return paddingInput[PADDING + row].charAt(PADDING + col) == '*';
    }
}
