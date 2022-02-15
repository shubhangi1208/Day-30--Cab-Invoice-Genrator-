public class InvoiceSummary {
    int totalNunberOfRide;
    int totalFare;
    double averageFarePerRide;

    public InvoiceSummary(int totalNoRide, int totalFare) {
        this.totalNunberOfRide = totalNoRide;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare / this.totalNunberOfRide;
    }

    public int getTotalNunberOfRide() {
        return totalNunberOfRide;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }
}
