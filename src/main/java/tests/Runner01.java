package tests;

import mikera.arrayz.NDArray;

public class Runner01 {

    static private final int numattempts = 3;
    
    static private final int[] dims = {200, 100, 20, 150};
    static private double[] data;

    static private Array1 array1;
    static private Array2 array2;
    static private Double[][][][] array3;
    static private NDArray array4;

    public static void writing1() {
        String title = "Writing array1 (nested Object[])";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            array1.set(data[ii], i, j, k, l);
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
    
    public static void writing2() {
        String title = "Writing array2 (mapped plain Double[])";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            array2.set(data[ii], i, j, k, l);
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
    
     public static void writing3() {
        String title = "Writing array3 (conventional)";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            array3[i][j][k][l] = data[ii];
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
     
    public static void writing4() {
        String title = "Writing array4 (NDArray of Vectorz)";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            array4.set(new int[] {i, j, k, l}, data[ii]);
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
     
     public static void reading1() {
        String title = "Reading array1 (nested Object[])";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            assert (data[ii] == array1.get(i, j, k, l));
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
    
    public static void reading2() {
        String title = "Reading array2 (mapped plain Double[])";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            assert (data[ii] == array2.get(i, j, k, l));
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
    
     public static void reading3() {
        String title = "Reading array3 (conventional)";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            assert (array3[i][j][k][l] == data[ii]);
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }
     
     public static void reading4() {
        String title = "Reading array4 (NDArray of Vectorz)";
        long start, end;
        
        System.out.println(title);
        for( int attempt = 0; attempt < numattempts; ++attempt ) {
            System.out.println("Attempt: " + attempt);
            start = System.nanoTime();
            int ii = 0;
            for (int i = 0; i < dims[0]; ++i) {
                for (int j = 0; j < dims[1]; ++j) {
                    for (int k = 0; k < dims[2]; ++k) {
                        for (int l = 0; l < dims[3]; ++l) {
                            assert (array4.get(i, j, k, l) == data[ii]);
                            ii++;
                        }
                    }
                }
            }
            end = System.nanoTime();
            System.out.println("Attempt " + attempt + " done. " + ii + " elements in " + (double) (end - start) / 1000000000 + " seconds");
        }
        
    }

    public static void main(String[] args) {

        int ii;
        long start, end;
        
        start = System.nanoTime();

        System.out.println("Allocating all arrays...");

        int size = 1;
        for (int i = 0; i < dims.length; ++i) {
            size *= dims[i];
        }

        data = new double[size];
        for (int i = 0; i < data.length; ++i) {
            data[i] = Math.random();
        }

        array1 = new Array1(dims);
        array2 = new Array2(dims);
        array3 = new Double[dims[0]][dims[1]][dims[2]][dims[3]];
        array4 = NDArray.newArray(dims);

        System.out.println("Done.");

        writing1();
        writing2();
        writing3();
        writing4();
        
        reading1();
        reading2();
        reading3();
        reading4();
        
        end = System.nanoTime();
        //elapsed = end - start;

        System.out.println("Total application time is " + (double) (end - start) / 1000000000 + " seconds");
        
    }

}
