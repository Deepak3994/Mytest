import java.util.ArrayList;

class Cell {
    public int r;
    public int c;
    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println(obj);
        Cell that = (Cell)obj;
        return (this == that) || 
               (this.r == that.r && this.c == that.c);
    }
}

class GameLife {
    private static int WIDTH  = 512;
    private static int HEIGHT = 512;

    private boolean[][] cells;
    private int width;
    private int height;

    private boolean isAlive(int r, int c) {
        //System.out.println("  r: " + r);
        //System.out.println("  c: " + c);
        assert(r >= 0 && r < this.height);
        assert(c >= 0 && c < this.width);

        return cells[r][c];
    }
    
    private Cell wrap(int r, int c) {
        int wr = r < 0 ? (r + this.height) : (r % this.height);
        int wc = c < 0 ? (c + this.width) : (c % this.width);

        //int wr = ((r-1) % this.height) + 1;
        //int wc = ((c-1) % this.width) + 1;

        return new Cell(wr, wc);
    }
    
    private ArrayList<Cell> listNeighbors(int r, int c) {
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
    
    private int countLiveNeighbors(int r, int c) {
        System.out.println("    (cln) r: " + r);
        System.out.println("    (cln) c: " + c);
        ArrayList<Cell> neighbors = listNeighbors(r, c);

        int n = neighbors.size();
        for (Cell cell: neighbors) {
            System.out.println("        (cln) cell: " + cell.r + ", " + cell.c);
            if (!isAlive(cell.r, cell.c)) {
                --n;
            }
        }
        System.out.println("        (cln) n: " + n);
        
        return n;
    }

    private boolean mayProduce(int r, int c) {
        //System.out.println("(mayp) r: " + r);
        //System.out.println("(mayp) c: " + c);
        
        return (!isAlive(r, c)) && (countLiveNeighbors(r, c) == 3);
    }

    private ArrayList<Cell> listSurvivors() {
        ArrayList<Cell> survivors = new ArrayList<Cell>();
        for (int r = 0; r < this.height; r++) {
                for (int c = 0; c < this.width; c++) {
                int live = countLiveNeighbors(r, c);
                if (live == 2 || live == 3) {
                    survivors.add(new Cell(r, c));
                }
            }
        }
        
        System.out.println("survivors: " + survivors.size());
        return survivors;
    }

    private ArrayList<Cell> listNewBirths() {
        ArrayList<Cell> births = new ArrayList<Cell>();

        for (int r = 0; r < this.height; r++) {
            for (int c = 0; c < this.width; c++) {
                if (mayProduce(r, c)) {
                    births.add(new Cell(r, c));
                }
            }
        }

        System.out.println("new births: " + births.size());
        return births;        
    }

    public GameLife(int width, int height) {
        this.cells = new boolean[height][width];
        this.width = width;
        this.height = height;
    }

    public void giveLifeToCell(int r, int c) {
        this.cells[r][c] = true;
    }

    // compute the next generation
    public ArrayList<Cell> step() {
        ArrayList<Cell> births = listNewBirths();
        ArrayList<Cell> survivors = listSurvivors();
        births.addAll(survivors);

        return births;
    }
    
    private void clearCells() {
        for (int r = 0; r < this.height; r++) {
            for (int c = 0; c < this.width; c++) {
                this.cells[r][c] = false;
            }
        }
    }

    public void run(int gens) {
        for (int cur = 0; cur < gens; ++cur) {
            this.clearCells();
            ArrayList<Cell> newgenCells = this.step();
            System.out.println("new gen size: " + newgenCells.size());

            for (Cell cell : newgenCells) {
                this.cells[cell.r][cell.c] = true;
            }
        }
    }

    public void stop() {

    }

    public boolean gameOver() {
        return true;
    }

    public static void main(String[] args) {
        GameLife gl = new GameLife(5, 5);
        gl.giveLifeToCell(4, 2);
        gl.giveLifeToCell(2, 3);
        gl.giveLifeToCell(4, 3);
        gl.giveLifeToCell(3, 4);
        gl.giveLifeToCell(4, 4);
        gl.run(1);
    }
}