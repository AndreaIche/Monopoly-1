package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.Cell;
import edu.ncsu.monopoly.Player;

public class RRCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        Cell c = cell;
        StringBuilder buf = new StringBuilder();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
