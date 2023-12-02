public class nonMember<E extends Number & Comparable<E>> implements Price<E>  {

    @Override
    public double value(double i) {
        return i;
    }

    
}
