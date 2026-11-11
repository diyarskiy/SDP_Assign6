public interface QuestVisitor {
    void visitHunt(HuntQuest quest);
    void visitDelivery(DeliveryQuest quest);
}
