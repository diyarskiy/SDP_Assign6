public class QuestCountVisitor implements QuestVisitor {
    private int hunts;
    private int deliveries;

    @Override
    public void visitHunt(HuntQuest quest) {
        hunts++;
    }

    @Override
    public void visitDelivery(DeliveryQuest quest) {
        deliveries++;
    }

    public int getHunts() {
        return hunts;
    }

    public int getDeliveries() {
        return deliveries;
    }
}
