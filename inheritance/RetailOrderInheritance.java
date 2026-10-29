public class RetailOrderInheritance {

    static class OrderRecord {
        protected int orderId;
        protected String orderDate;

        OrderRecord(int orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        String getOrderStatus() {
            return "Order Placed";
        }

        void displayOrder() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Order Date: " + orderDate);
            System.out.println("Status: " + getOrderStatus());
        }
    }

    static class ShippedOrder extends OrderRecord {
        protected String trackingNumber;

        ShippedOrder(int orderId, String orderDate,
                     String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        String getOrderStatus() {
            return "Shipped";
        }

        @Override
        void displayOrder() {
            super.displayOrder();
            System.out.println("Tracking Number: " + trackingNumber);
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        private String deliveryDate;

        DeliveredOrder(int orderId, String orderDate,
                       String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        String getOrderStatus() {
            return "Delivered";
        }

        @Override
        void displayOrder() {
            super.displayOrder();
            System.out.println("Delivery Date: " + deliveryDate);
        }
    }

    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(
                501, "2026-10-20", "TRK12345", "2026-10-24"
        );

        order.displayOrder();
    }
}