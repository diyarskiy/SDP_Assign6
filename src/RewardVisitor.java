public class RewardVisitor implements QuestVisitor {
    private static final int GOLD_PER_MONSTER = 10;
    private static final int GOLD_PER_KM = 3;
    private int totalGold;

    @Override
    public void visitHunt(HuntQuest quest) {
        totalGold += quest.getCount() * GOLD_PER_MONSTER;
    }

    @Override
    public void visitDelivery(DeliveryQuest quest) {
        totalGold += quest.getDistanceKm() * GOLD_PER_KM;
    }

    public int getTotalGold() {
        return totalGold;
    }
}
