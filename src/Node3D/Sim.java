package Node3D;

import java.util.List;

public class Sim implements Node3D {

    public Sim()    {

    }

    public List<Node3D> getChildren() {
        return null;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public void paint() {

    }

    @Override
    public int getMinX() {
        return 0;
    }

    @Override
    public int getMaxX() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public double getDistance(int x, int y) {
        return 0;
    }

    @Override
    public int getColour(int x, int y) {
        return 0;
    }

    public void redrawScreen(Node3D root)   {

    }
}
