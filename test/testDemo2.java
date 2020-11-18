public class testDemo2 {
    Saab95 sab = new Saab95();
    ChopShop<Saab95> saabverkstad = new ChopShop<>(10);
    saabverkstad.loadOn(sab);
}
