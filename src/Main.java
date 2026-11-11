import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Quest> board = List.of(
                new HuntQuest("cave spiders", 4),
                new DeliveryQuest("a mana potion", "Oak Village", 6),
                new HuntQuest("forest wolves", 2)
        );

        System.out.println("Quest journal");
        visitAll(board, new JournalVisitor());

        RewardVisitor rewards = new RewardVisitor();
        visitAll(board, rewards);
        System.out.println("Total reward: " + rewards.getTotalGold() + " gold");
    }

    public static void visitAll(List<Quest> board, QuestVisitor visitor) {
        for (Quest quest : board) {
            quest.accept(visitor);
        }
    }
}
