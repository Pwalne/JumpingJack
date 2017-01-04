import java.util.ArrayList;
import java.util.List;

/**
 * Created by pwalne12 on 12/1/2016.
 */
public class JumpingJack {

    /**
     * Minimum and maximum value Coordinate X/Y may be.
     */
    public static final int MIN_BOUNDS = 0, MAX_BOUNDS = 106;

    /**
     * Main function.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            throw new Exception("Arguments are: n(1-1000) X1 Y1... 0");
        }
        int argsIndex = 0;
        int mobMovement = 1;
        while(true) {
            int n = Integer.parseInt(args[argsIndex++]); //number of mob members
            if(n == 0) //This is a terminating value.
                return;

            MobLocation[] mobs = new MobLocation[n];
            //Check if there is a valid number of arguments
            if((args.length - (2 * n)) <= 0) //0 as a terminating 0 should be at the end
                throw new Exception("Not enough x y variables to meet 'n' mob members.");
            for(int i = 0; i < n; i++) {
                int x = Integer.parseInt(args[argsIndex++]);
                int y = Integer.parseInt(args[argsIndex++]);
                mobs[i] = new MobLocation(x, y);
            }

            MobLocation closest = new MobLocation(MIN_BOUNDS, MIN_BOUNDS);
            int dist = Integer.MAX_VALUE;
            //Now calculate Closest Zone from (mix, min) to (max, max)
            for(int i2 = MIN_BOUNDS; i2 <= MAX_BOUNDS; i2++) {
                for(int j = MIN_BOUNDS; j <= MAX_BOUNDS; j++) {
                    int newDist = 0;
                    for(MobLocation loc : mobs)
                        newDist += loc.getStepsTo(i2, j);
                    if (newDist <= dist) {
                        if(newDist == dist) {//if they are the same distance, we need to check the coordinates.
                            closest = new MobLocation(i2 < closest.getX() ? i2 : closest.getX(), i2 == closest.getX() && j > closest.getY() ? closest.getY() : j);
                        }else {
                            closest = new MobLocation(i2, j);
                        }
                        dist = newDist;
                    }
                }
            }
            System.out.printf("Case %d Location: %d,%d Steps: %d\n", mobMovement++, closest.getX(), closest.getY(), dist);
            if(argsIndex == args.length) return; //Accounts for no '0' at end of string as required.
        }
    }
}
