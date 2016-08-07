import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class StatPAL {
    private final static int CELL_AUTHOR_AFFILIATION = 3;

    private String datapath;
    protected Workbook workbook;
    protected ArrayList<String> affiliations;
    protected ArrayList<String> countries;

    public StatPAL(String path) {
        this.datapath = path;
        this.workbook = null;
        this.affiliations = null;
        this.countries = null;
    }

    public boolean start() {
        try {
            this.workbook = new XSSFWorkbook(this.datapath);
            this.affiliations = new ArrayList<String>(1024);
            return true;
        } catch (IOException ex) {}

        return (this.workbook != null);
    }

    public void finish() {
        try {
            this.workbook.close();
        } catch (IOException ex) {} 
    }

    public void analyze() {
        if (this.workbook.getNumberOfSheets() == 0) return;

        Iterator<Sheet> sheets = this.workbook.sheetIterator();
        while (sheets.hasNext()) {
            this.analyzeSheet(sheets.next());
        }
    }

    protected void analyzeSheet(Sheet s) {
        assert(s != null);
        Iterator<Row> rows = s.iterator();
        while (rows.hasNext()) {
            this.analyzeRow(rows.next());
        }
    }

    protected void analyzeRow(Row r) {
        assert(r != null);
        int ncells = r.getPhysicalNumberOfCells();
        if (ncells < 9) return;
        
        Cell caf = r.getCell(CELL_AUTHOR_AFFILIATION);
        if (caf.getCellType() != Cell.CELL_TYPE_STRING) return;
        String saf = caf.getStringCellValue();
        
        this.affiliations.add(saf);
    }

    public ArrayList<String> getAffilications() {
        return this.affiliations;
    }

    public void collectCountryNames() {
        if (this.affiliations != null) {
            this.countries = new ArrayList<String>(32);
            for (String saf: this.affiliations) {
                String[] parts = saf.split(",");
                int countryIndex = parts.length - 1;
                this.countries.add(parts[countryIndex].trim());
            }
        }
    }
}
