package TDD;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {

    private CabInvoiceGenerator.InvoiceGenerator invoiceGenerator;

    private CabInvoiceGenerator.RideRepository rideRepository;

    private CabInvoiceGenerator.InvoiceService invoiceService;

    @BeforeEach
    void setUp() {

        invoiceGenerator =
                new CabInvoiceGenerator.InvoiceGenerator();

        rideRepository =
                new CabInvoiceGenerator.RideRepository();

        invoiceService =
                new CabInvoiceGenerator.InvoiceService(
                        rideRepository,
                        invoiceGenerator
                );
    }

    // Step 1: Test fare calculation for a normal ride.
    @Test
    void testCalculateFareForNormalRide() {

        double fare = invoiceGenerator.calculateFare(5.0, 10);

        assertEquals(60.0, fare, 0.001);
    }

    // Step 1: Test minimum fare for a short ride.
    @Test
    void testMinimumFareForNormalRide() {

        double fare = invoiceGenerator.calculateFare(0.1, 1);

        assertEquals(5.0, fare, 0.001);
    }

    // Step 1: Test fare calculation for zero distance and time.
    @Test
    void testZeroDistanceAndTime() {

        double fare = invoiceGenerator.calculateFare(0, 0);

        assertEquals(5.0, fare, 0.001);
    }

    // Step 1: Negative distance should not be accepted.
    @Test
    void testNegativeDistance() {

        assertThrows(
                IllegalArgumentException.class,
                () -> invoiceGenerator.calculateFare(-5.0, 10)
        );
    }

    // Step 1: Negative time should not be accepted.
    @Test
    void testNegativeTime() {

        assertThrows(
                IllegalArgumentException.class,
                () -> invoiceGenerator.calculateFare(5.0, -10)
        );
    }

    // Step 2: Test total fare for multiple normal rides.
    @Test
    void testCalculateTotalFareForMultipleRides() {

        List<CabInvoiceGenerator.Ride> rides = Arrays.asList(
                new CabInvoiceGenerator.Ride(5.0, 10),
                new CabInvoiceGenerator.Ride(10.0, 15),
                new CabInvoiceGenerator.Ride(2.0, 5)
        );

        double totalFare =
                invoiceGenerator.calculateTotalFare(rides);

        assertEquals(200.0, totalFare, 0.001);
    }

    // Step 2: Test total fare when the ride list is empty.
    @Test
    void testCalculateTotalFareForEmptyRideList() {

        double totalFare =
                invoiceGenerator.calculateTotalFare(
                        Collections.emptyList()
                );

        assertEquals(0.0, totalFare, 0.001);
    }

    // Step 3: Test invoice summary for multiple rides.
    @Test
    void testGenerateInvoiceSummary() {

        List<CabInvoiceGenerator.Ride> rides = Arrays.asList(
                new CabInvoiceGenerator.Ride(5.0, 10),
                new CabInvoiceGenerator.Ride(10.0, 15),
                new CabInvoiceGenerator.Ride(2.0, 5)
        );

        CabInvoiceGenerator.InvoiceSummary summary =
                invoiceGenerator.calculateInvoice(rides);

        assertEquals(3, summary.getNumberOfRides());
        assertEquals(200.0, summary.getTotalFare(), 0.001);
        assertEquals(200.0 / 3, summary.getAverageFare(), 0.001);
    }

    // Step 3: Test invoice summary when there are no rides.
    @Test
    void testGenerateInvoiceForEmptyRideList() {

        CabInvoiceGenerator.InvoiceSummary summary =
                invoiceGenerator.calculateInvoice(
                        Collections.emptyList()
                );

        assertEquals(0, summary.getNumberOfRides());
        assertEquals(0.0, summary.getTotalFare(), 0.001);
        assertEquals(0.0, summary.getAverageFare(), 0.001);
    }

    // Step 4: Test adding rides to a particular user.
    @Test
    void testAddRidesToRepository() {

        rideRepository.addRide(
                "USER101",
                new CabInvoiceGenerator.Ride(5.0, 10)
        );

        rideRepository.addRide(
                "USER101",
                new CabInvoiceGenerator.Ride(10.0, 15)
        );

        List<CabInvoiceGenerator.Ride> rides =
                rideRepository.getRides("USER101");

        assertEquals(2, rides.size());
    }

    // Step 4: Test that different users have separate rides.
    @Test
    void testRidesAreStoredSeparatelyForUsers() {

        rideRepository.addRide(
                "USER101",
                new CabInvoiceGenerator.Ride(5.0, 10)
        );

        rideRepository.addRide(
                "USER102",
                new CabInvoiceGenerator.Ride(10.0, 15)
        );

        assertEquals(1, rideRepository.getRides("USER101").size());
        assertEquals(1, rideRepository.getRides("USER102").size());
    }

    // Step 4: Test generating an invoice for a particular user.
    @Test
    void testInvoiceServiceForUser() {

        rideRepository.addRide(
                "USER101",
                new CabInvoiceGenerator.Ride(5.0, 10)
        );

        rideRepository.addRide(
                "USER101",
                new CabInvoiceGenerator.Ride(10.0, 15)
        );

        CabInvoiceGenerator.InvoiceSummary summary =
                invoiceService.getInvoice("USER101");

        assertEquals(2, summary.getNumberOfRides());
        assertEquals(175.0, summary.getTotalFare(), 0.001);
        assertEquals(87.5, summary.getAverageFare(), 0.001);
    }

    // Step 4: Test invoice for a user who has no rides.
    @Test
    void testInvoiceForUserWithoutRides() {

        CabInvoiceGenerator.InvoiceSummary summary =
                invoiceService.getInvoice("USER999");

        assertEquals(0, summary.getNumberOfRides());
        assertEquals(0.0, summary.getTotalFare(), 0.001);
        assertEquals(0.0, summary.getAverageFare(), 0.001);
    }

    // Step 5: Test premium ride fare calculation.
    @Test
    void testPremiumRideFare() {

        CabInvoiceGenerator.Ride ride =
                new CabInvoiceGenerator.Ride(
                        5.0,
                        10,
                        CabInvoiceGenerator.RideType.PREMIUM
                );

        double fare = invoiceGenerator.calculateFare(ride);

        assertEquals(95.0, fare, 0.001);
    }

    // Step 5: Test minimum fare for a premium ride.
    @Test
    void testPremiumRideMinimumFare() {

        CabInvoiceGenerator.Ride ride =
                new CabInvoiceGenerator.Ride(
                        0.1,
                        1,
                        CabInvoiceGenerator.RideType.PREMIUM
                );

        double fare = invoiceGenerator.calculateFare(ride);

        assertEquals(20.0, fare, 0.001);
    }

    // Step 5: Test invoice containing both normal and premium rides.
    @Test
    void testInvoiceWithNormalAndPremiumRides() {

        List<CabInvoiceGenerator.Ride> rides = Arrays.asList(

                new CabInvoiceGenerator.Ride(
                        5.0, 10,
                        CabInvoiceGenerator.RideType.NORMAL
                ),

                new CabInvoiceGenerator.Ride(
                        10.0, 15,
                        CabInvoiceGenerator.RideType.PREMIUM
                ),

                new CabInvoiceGenerator.Ride(
                        2.0, 5,
                        CabInvoiceGenerator.RideType.NORMAL
                )
        );

        CabInvoiceGenerator.InvoiceSummary summary =
                invoiceGenerator.calculateInvoice(rides);

        assertEquals(3, summary.getNumberOfRides());
        assertEquals(265.0, summary.getTotalFare(), 0.001);
        assertEquals(265.0 / 3, summary.getAverageFare(), 0.001);
    }

    // Validate that null ride lists are rejected.
    @Test
    void testNullRideList() {

        assertThrows(
                IllegalArgumentException.class,
                () -> invoiceGenerator.calculateTotalFare(null)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> invoiceGenerator.calculateInvoice(null)
        );
    }

    // Validate that null rides cannot be added to the repository.
    @Test
    void testAddingNullRide() {

        assertThrows(
                IllegalArgumentException.class,
                () -> rideRepository.addRide("USER101", null)
        );
    }

    // Validate that an empty user ID is rejected.
    @Test
    void testEmptyUserId() {

        assertThrows(
                IllegalArgumentException.class,
                () -> rideRepository.addRide(
                        "",
                        new CabInvoiceGenerator.Ride(5.0, 10)
                )
        );
    }

    // Validate that null ride categories are rejected.
    @Test
    void testNullRideType() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CabInvoiceGenerator.Ride(
                        5.0,
                        10,
                        null
                )
        );
    }
}

