import java.util.ArrayList;

class BoardTest {
	private static void testBoardCreation() {
        Board board = new Board(8, 8);
        assert(board.rows() == 8);
        assert(board.columns() == board.rows());
	}

    private static void testListLivingCells() {
        Board board = new Board(8, 8);

        assert(board.listLivingCells().size() == 0);
        board.giveLifeToCell(0, 0);
        assert(board.listLivingCells().size() == 1);
        board.giveLifeToCell(7, 7);
        assert(board.listLivingCells().size() == 2);
        board.giveLifeToCell(3, 3);
        assert(board.listLivingCells().size() == 3);
    }

    private static void testListNeighborsOfZeroZero() {
        Board board = new Board(8, 8);
        ArrayList<Cell> neighbs = board.listNeighbors(0, 0);
        assert(neighbs.size() == 8);
        ArrayList<Cell> allneighbs = new ArrayList<Cell>();

        allneighbs.add(new Cell(0, 1));
        allneighbs.add(new Cell(0, 7));
        allneighbs.add(new Cell(1, 0));
        allneighbs.add(new Cell(1, 1));
        allneighbs.add(new Cell(1, 7));
        allneighbs.add(new Cell(7, 0));
        allneighbs.add(new Cell(7, 1));
        allneighbs.add(new Cell(7, 7));

        assert(neighbs.containsAll(allneighbs));
    }

    public static void main(String[] args) {
    	testBoardCreation();
        testListLivingCells();
        testListNeighborsOfZeroZero();
    }
}
