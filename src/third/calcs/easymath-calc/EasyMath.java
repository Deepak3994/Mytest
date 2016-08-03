interface EasyMath {
    int neg(int x);
    int inc(int x);
    int dec(int x);
    int add(int x, int y);
    int sub(int x, int y);
    int mul(int x, int y);
    int div(int x, int y);
    int mod(int x, int y);

    int save(int reg, int data);
    int read(int reg);
}