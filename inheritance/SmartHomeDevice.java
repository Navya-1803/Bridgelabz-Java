public class SmartHomeDevice {

    static class Device {
        protected String deviceId;
        protected boolean status;

        Device(String deviceId, boolean status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId);
            System.out.println("Device Status: "
                    + (status ? "ON" : "OFF"));
        }
    }

    static class Thermostat extends Device {
        private double temperatureSetting;

        Thermostat(String deviceId, boolean status,
                   double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        void displayStatus() {
            super.displayStatus();
            System.out.println("Temperature: "
                    + temperatureSetting + "°C");
        }
    }

    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH101", true, 24.5);
        thermostat.displayStatus();
    }
}