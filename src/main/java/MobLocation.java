/**
 * Created by pwalne12 on 12/1/2016.
 */
public class MobLocation {

    public MobLocation(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }
    /**
     * North/South, and East/West
     */
    private int xCoord, yCoord;

    public int getX() { return xCoord;}
    public int getY() { return yCoord;}

    /**
     * Gets the number of steps required to reach the destination.
     * @param otherX Destination X Coord
     * @param otherY Destination Y Coord
     * @return Amount of steps between points.
     */
    public int getStepsTo(int otherX, int otherY) {
        return Math.abs(this.xCoord - otherX) + Math.abs(this.yCoord - otherY);
    }
}
