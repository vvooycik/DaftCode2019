public class ShipContainter {
    String
            countryOfOrigin,
            destinationCountry,
            number,
            contentType,
            companyName,
            companyCountry;

    double price;
    int weight;

    ShipContainter(String countryOfOrigin, String destinationCountry, String number, int weight, String contentType, String companyName, String companyCountry, double price){
        this.countryOfOrigin = countryOfOrigin;
        this.destinationCountry = destinationCountry;
        this.number = number;
        this.weight = weight;
        this.contentType = contentType;
        this.companyName = companyName;
        this.companyCountry = companyCountry;
        this.price = price;
    }

    public double getValue(){
        return price/weight;
    }
}
