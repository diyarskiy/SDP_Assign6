public class JournalVisitor implements QuestVisitor {
    @Override
    public void visitHunt(HuntQuest quest) {
        System.out.println("Hunt " + quest.getMonster() + " (target: " + quest.getCount() + ").");
    }

    @Override
    public void visitDelivery(DeliveryQuest quest) {
        System.out.println("Take " + quest.getItem() + " to " + quest.getDestination()
                + " (" + quest.getDistanceKm() + " km).");
    }
}
