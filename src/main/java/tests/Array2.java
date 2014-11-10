package tests;

public class Array2 {

    private final Double[] delegate;
    private final int[] pows;

    public Array2(int... is) {

        pows = new int[is.length];

        int size = 1;
        /*
        for (int k = 0; k < is.length; ++k) {
            pows[k] = size;
            size *= is[k];
        }
        */
        
        for (int k = is.length-1; k >= 0; --k) {
            pows[k] = size;
            size *= is[k];
        }

        delegate = new Double[size];
    }
    
    private int getPosition(int i) {
        int pos = i*pows[0];
        return pos;
    }
    
    private int getPosition(int i, int j) {
        int pos = i*pows[0];
        pos += j*pows[1];
        return pos;
    }
    
    private int getPosition(int i, int j, int k) {
        int pos = i*pows[0];
        pos += j*pows[1];
        pos += k*pows[2];
        return pos;
    }
    
    private int getPosition(int i, int j, int k, int l) {
        int pos = i*pows[0];
        pos += j*pows[1];
        pos += k*pows[2];
        pos += l*pows[3];
        return pos;
    }

    private int getPosition(int i, int j, int k, int l, int... rest) {
        int pos = i*pows[0];
        pos += j*pows[1];
        pos += k*pows[2];
        pos += l*pows[3];

        for (int ii = 0; ii < rest.length; ++ii) {
            pos += rest[ii] * pows[ii+4];
        }

        return pos;
    }
    
    public Double get(int i) {
        return delegate[getPosition(i)];
    }
    
    public Double get(int i, int j) {
        return delegate[getPosition(i, j)];
    }
    
    public Double get(int i, int j, int k) {
        return delegate[getPosition(i, j, k)];
    }
    
    public Double get(int i, int j, int k, int l) {
        return delegate[getPosition(i, j, k, l)];
    }
    
    public Double get(int i, int j, int k, int l, int... rest) {
        return delegate[getPosition(i, j, k, l, rest)];
    }
    
    public void set(Double value, int i) {
        delegate[getPosition(i)] = value;
    }
    
    public void set(Double value, int i, int j) {
        delegate[getPosition(i, j)] = value;
    }
    
    public void set(Double value, int i, int j, int k) {
        delegate[getPosition(i, j, k)] = value;
    }
    
    public void set(Double value, int i, int j, int k, int l) {
        delegate[getPosition(i, j, k, l)] = value;
    }
    
    public void set(Double value, int i, int j, int k, int l, int ... rest) {
        delegate[getPosition(i, j, k, l, rest)] = value;
    }

}
