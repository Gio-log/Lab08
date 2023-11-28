package edu.lab8;

public class CPlate extends CSphere{
    public CPlate(int r, int m) {
        super(r, m);
    }

    @Override
    double momentOfInertia() {
        return 0.5*Mass*R*R;
    }
}
