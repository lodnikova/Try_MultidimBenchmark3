package tests;

public class Array1 {

    private Object delegate;

    private Object allocate(Object delegate, int[] is, int pos) {
        if (pos < is.length) {
            delegate = new Object[is[pos]];
            for (int k = 0; k < is[pos]; ++k) {
                ((Object[]) delegate)[k] = allocate(((Object[]) delegate)[k], is, pos + 1);
            }
        }
        return delegate;
    }
    
    private Object[] getArray(Object delegate, int i) {
        Object[] subdelegate = (Object[]) delegate;
        subdelegate = (Object[]) ((Object[]) subdelegate)[i];
        return subdelegate;
    }
    
    private Object[] getArray(Object delegate, int i, int j) {
        Object[] subdelegate = (Object[]) delegate;
        subdelegate = (Object[]) ((Object[]) subdelegate)[i];
        subdelegate = (Object[]) ((Object[]) subdelegate)[j];
        return subdelegate;
    }
    
    private Object[] getArray(Object delegate, int i, int j, int k) {
        Object[] subdelegate = (Object[]) delegate;
        subdelegate = (Object[]) ((Object[]) subdelegate)[i];
        subdelegate = (Object[]) ((Object[]) subdelegate)[j];
        subdelegate = (Object[]) ((Object[]) subdelegate)[k];
        return subdelegate;
    }
    
    private Object[] getArray(Object delegate, int i, int j, int k, int[] is) {
        Object[] subdelegate = getArray(delegate, i, j, k);
        for(int ii=0; ii<is.length-1; ++ii) {
            subdelegate = (Object[]) ((Object[]) subdelegate)[is[ii]];
        }
        return subdelegate;
    }

    
    
    public Array1(int... is) {
        delegate = allocate(delegate, is, 0);
    }

    public Double get(int i) {
        Object[] subdelegate = (Object[]) delegate;
        return (Double) subdelegate[i];
    }
    
    public Double get(int i, int j) {
        Object[] subdelegate = getArray(delegate, i);
        return (Double) subdelegate[j];
    }
    
    public Double get(int i, int j, int k) {
        Object[] subdelegate = getArray(delegate, i, j);
        return (Double) subdelegate[k];
    }
    
    public Double get(int i, int j, int k, int l) {
        Object[] subdelegate = getArray(delegate, i, j, k);
        return (Double) subdelegate[l];
    }
    
    public Double get(int i, int j, int k, int l, int ... rest) {
        Object[] subdelegate = getArray(delegate, i, j, k, rest);
        return (Double) subdelegate[rest[rest.length-1]];
    }
    
    
    public void set(Double value, int i) {
        Object[] subdelegate = (Object[]) delegate;
        subdelegate[i] = value;
    }
    
    public void set(Double value, int i, int j) {
        Object[] subdelegate = getArray(delegate, i);
        subdelegate[j] = value;
    }
    
    public void set(Double value, int i, int j, int k) {
        Object[] subdelegate = getArray(delegate, i, j);
        subdelegate[k] = value;
    }
    
    public void set(Double value, int i, int j, int k, int l) {
        Object[] subdelegate = getArray(delegate, i, j, k);
        subdelegate[l] = value;
    }
    
    public void set(Double value, int i, int j, int k, int l, int ... rest) {
        Object[] subdelegate = getArray(delegate, i, j, k, rest);
        subdelegate[rest[rest.length-1]] = value;
    }
    
}
