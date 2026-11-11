public class HuntQuest implements Quest {
    private final String monster;
    private final int count;

    public HuntQuest(String monster, int count) {
        this.monster = monster;
        this.count = count;
    }

    public String getMonster() {
        return monster;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void accept(QuestVisitor visitor) {
        visitor.visitHunt(this);
    }
}
