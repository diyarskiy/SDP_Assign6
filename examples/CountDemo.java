import java.util.List;

public class CountDemo {
    public static void main(String[] args) {
        List<Quest> board = List.of(
                new DeliveryQuest("a letter", "North Gate", 3),
                new HuntQuest("bats", 5),
                new DeliveryQuest("a map", "Old Mill", 2)
        );

        QuestCountVisitor count = new QuestCountVisitor();
        Main.visitAll(board, count);
        System.out.println("Hunts: " + count.getHunts() + ", deliveries: " + count.getDeliveries());
    }
}
