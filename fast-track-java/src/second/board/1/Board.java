import java.util.ArrayList;

class Cell {
    private IntPair pair;

    public Cell(int r, int c) {
        this.pair= new IntPair(r, c);
    }

    public int row() { return this.pair.first(); }
    public int col() { return this.pair.second(); }

    @Override
    public boolean equals(Object obj) {
        return this.pair.equals(obj);
    }
}

public class Board {
    private boolean[][] cells;
    private int cols;
    private int rows;

    public Board(int rows, int cols) {
        this.cells = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }
 
    public int columns() { return cols; }
    public int rows() { return rows; }

    public void giveLifeToCell(int r, int c) {
        this.cells[r][c] = true;
    }

    public ArrayList<Cell> listLivingCells() {
    	ArrayList<Cell> living = new ArrayList<Cell>();
        
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                if (this.cells[r][c] == true) {
                    living.add(new Cell(r, c));
                }
            }
        }

    	return living;
    }

    public static void main(String[] args) {
        Board board = new Board(8, 8);
        assert(board.rows() == 8);
        assert(board.columns() == board.rows());

        assert(board.listLivingCells().size() == 0);
        board.giveLifeToCell(0, 0);
        assert(board.listLivingCells().size() == 1);
        board.giveLifeToCell(7, 7);
        assert(board.listLivingCells().size() == 2);
        board.giveLifeToCell(3, 3);
        assert(board.listLivingCells().size() == 3);
    }
}
