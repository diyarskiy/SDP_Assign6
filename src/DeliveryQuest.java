public class DeliveryQuest implements Quest {
    private final String item;
    private final String destination;
    private final int distanceKm;

    public DeliveryQuest(String item, String destination, int distanceKm) {
        this.item = item;
        this.destination = destination;
        this.distanceKm = distanceKm;
    }

    public String getItem() {
        return item;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    @Override
    public void accept(QuestVisitor visitor) {
        visitor.visitDelivery(this);
    }
}
