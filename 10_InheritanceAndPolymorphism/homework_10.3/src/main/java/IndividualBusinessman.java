public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut - (amountToPut * 0.01));
        }
        if (amountToPut >= 1000) {
            super.put(amountToPut - (amountToPut * 0.005));
        }
    }
}
