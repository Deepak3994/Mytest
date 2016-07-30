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
        Cell that = (Cell) obj;
        return this.pair.equals(that.pair);
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

    private Cell wrap(int r, int c) {
        int wr = r < 0 ? (r + this.rows()) : (r % this.rows());
        int wc = c < 0 ? (c + this.columns()) : (c % this.columns());

        return new Cell(wr, wc);
    }

    public ArrayList<Cell> listNeighbors(int r, int c) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>(8);

        neighbors.add(wrap(r-1, c-1));
        neighbors.add(wrap(r,   c-1));
        neighbors.add(wrap(r+1, c-1));
        neighbors.add(wrap(r-1, c));
        neighbors.add(wrap(r+1, c));
        neighbors.add(wrap(r-1, c+1));
        neighbors.add(wrap(r,   c+1));
        neighbors.add(wrap(r+1, c+1));

        return neighbors;
    }
}
