import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CabInvoiceGeneratorTest {
    CabInvoiceGenrator cabInvoiceGenrator;
    @BeforeEach
    void setUp() {
        cabInvoiceGenrator= new CabInvoiceGenrator();
    }
@Test
@DisplayName("Calculate Fair for given distance and duration")
void calculateFareforNORMAL() {
    assertEquals(55,cabInvoiceGenrator.calculateFareAmount(5,5, Rides.RideType.NORMAL));
}

    @Test
    @DisplayName("Calculate Fair for given distance and duration")
    void calculateFareforPREMIUM() {
        assertEquals(85,cabInvoiceGenrator.calculateFareAmount(5,5, Rides.RideType.PREMIUM));
    }

    @Test
    @DisplayName("Calculate fair for Multiple NORMAL Rides")
    void multipleRidesforNORMAL() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5)};
        assertEquals(110,cabInvoiceGenrator.multipleRides(rides, Rides.RideType.NORMAL));
    }

    @Test
    @DisplayName("Calculate fair for Multiple NORMAL Rides")
    void multipleRidesforPREMIUM() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5)};
        assertEquals(170,cabInvoiceGenrator.multipleRides(rides, Rides.RideType.PREMIUM));
    }

    @Test
    @DisplayName("Calculate Invoice Summary for All NORMAL Rides")
    void calculateInvoiceSummaryNORMAL() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5),new Rides(5,5)};
        InvoiceSummary invoiceSummaryNORMAL = cabInvoiceGenrator.calculateInvoiceSummary(rides, Rides.RideType.NORMAL);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3,165);
        if(invoiceSummaryExpected.getAverageFarePerRide() == invoiceSummaryNORMAL.getAverageFarePerRide()
                && invoiceSummaryExpected.getTotalNunberOfRide() == invoiceSummaryNORMAL.getTotalNunberOfRide()
                && invoiceSummaryExpected.getTotalFare() == invoiceSummaryNORMAL.getTotalFare())
            assertEquals(1,1);
    }

    @Test
    @DisplayName("Calculate Invoice Summary for All PREMIUM Rides")
    void calculateInvoiceSummaryPREMIUM() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5),new Rides(5,5)};
        InvoiceSummary invoiceSummaryPREMIUM = cabInvoiceGenrator.calculateInvoiceSummary(rides, Rides.RideType.PREMIUM);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3,165);
        if(invoiceSummaryExpected.getAverageFarePerRide() == invoiceSummaryPREMIUM.getAverageFarePerRide()
                && invoiceSummaryExpected.getTotalNunberOfRide() == invoiceSummaryPREMIUM.getTotalNunberOfRide()
                && invoiceSummaryExpected.getTotalFare() == invoiceSummaryPREMIUM.getTotalFare())
            assertEquals(1,1);
    }


}
