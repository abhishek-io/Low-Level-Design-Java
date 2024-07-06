public class Table {
    private int tableNo;
    private boolean isOccupied;

    public Table(int tableNo, boolean isOccupied) {
        this.tableNo = tableNo;
        this.isOccupied = isOccupied;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getTableNo() {
        return tableNo;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
