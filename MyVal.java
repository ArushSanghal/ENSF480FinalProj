public class MyVal<E>{

    double cost;
    boolean memCheck = false;
    Price<E> base;

    public MyVal(double i, boolean l){
        cost = i;
        memCheck = l;
    }

    public void isMem(Price<E> ifMem){
        base = ifMem;
    }

    public double finalPrice(double x){
        base.value(cost);
        return cost;
    }




}