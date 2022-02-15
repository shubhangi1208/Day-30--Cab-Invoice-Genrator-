
public class CabInvoiceGenrator {
    int perKmCost;
    int perMinuteCost;
    int minimumFare;
    public int calculateFareAmount(int distance,int time,Rides.RideType rideType) {
        if(rideType == Rides.RideType.NORMAL) {
            perKmCost = 10;
            perMinuteCost = 1;
            minimumFare = 5;
        } else {
            perKmCost = 15;
            perMinuteCost = 2;
            minimumFare = 20;
        }
        int totalFare = distance * perKmCost + time * perMinuteCost;
        if( totalFare < minimumFare) {
            totalFare = minimumFare;
        }
        return totalFare;
    }
    public int multipleRides(Rides[] rides, Rides.RideType rideType) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFareAmount(ride.distance,ride.duration,rideType);
        }
        return totalFare;
    }
    public InvoiceSummary calculateInvoiceSummary(Rides[] rides, Rides.RideType rideType) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFareAmount(ride.distance,ride.duration,rideType);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

}
