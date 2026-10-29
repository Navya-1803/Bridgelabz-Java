package level1;

public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378.0;
        double radiusMiles = radiusKm / 1.6;
        double pi = Math.PI;

        // Calculate volume using the sphere formula
        double volumeKm = (4.0 / 3.0) * pi
                * radiusKm * radiusKm * radiusKm;

        double volumeMiles = (4.0 / 3.0) * pi
                * radiusMiles * radiusMiles * radiusMiles;

        System.out.printf(
                "The volume of earth in cubic kilometers is %.2f "
                        + "and cubic miles is %.2f%n",
                volumeKm, volumeMiles
        );
    }
}
