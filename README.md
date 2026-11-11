# Assignment 6: Visitor — RPG Quest Board

The board holds two kinds of quests: hunts and deliveries. A player can read the objectives or see the total gold available on the board. The quests store the facts; visitors decide what to do with them.

| Pattern role | In this project |
| --- | --- |
| Element | `Quest` declares `accept(QuestVisitor visitor)`. |
| Concrete elements | `HuntQuest` stores the monster and target count. `DeliveryQuest` stores the item, destination and distance. |
| Visitor interface | `QuestVisitor` declares `visitHunt` and `visitDelivery`. |
| Concrete visitors | `JournalVisitor` prints the objectives. `RewardVisitor` adds up the gold: 10 per monster and 3 per kilometre. |
| Object structure and client | `Main` builds a `List<Quest>`; its `visitAll` loop calls `accept` on each quest. |

## Run the example

From the repository root, using a JDK (11 or newer):

```sh
mkdir -p out
javac --release 11 -d out src/*.java
java -cp out Main
```

```text
Quest journal
Hunt cave spiders (target: 4).
Take a mana potion to Oak Village (6 km).
Hunt forest wolves (target: 2).
Total reward: 78 gold
```

## How double dispatch works

Follow the delivery on the second pass. The loop only sees a `Quest`, but the object is a `DeliveryQuest`, so Java calls its version of `accept`. That method calls `visitor.visitDelivery(this)`. The visitor object on this pass is a `RewardVisitor`, so its delivery method runs and adds 6 × 3 = 18 gold. The same delivery produced a journal line on the first pass. Neither the quest nor the loop checks the visitor's type.

## Clean Code choices

1. **Meaningful names.** `visitDelivery` tells you which quest the method handles; `GOLD_PER_KM` explains why distance is multiplied by three.
2. **Single responsibility.** Changing a reward rate only affects `RewardVisitor`. Changing the wording of a quest only affects `JournalVisitor`.
3. **Encapsulation.** Quest fields are private and final. Visitors need to read the quest details, so the quests expose getters but no setters. This does couple the visitors to those details: changing the unit of distance would affect both visitors.
4. **Polymorphism instead of type checks.** Each quest passes itself to the matching visit method. The loop needs no casts or type flags, even for a mixed board.
5. **Avoid duplication.** The journal, reward calculation and optional counter all use the same traversal in `Main.visitAll`. Only the operation changes.
6. **Open for new operations.** The optional `QuestCountVisitor` counts hunts and deliveries independently of journal text and rewards. All its code and its demo are in `examples/`; it needs no edits to `src/`. The trade-off: a new quest type would require a new method in the visitor interface and in every concrete visitor.

## Run the third visitor

```sh
javac --release 11 -cp out -d out examples/*.java
java -cp out CountDemo
```

Expected: `Hunts: 1, deliveries: 2`. The counter counts quests, so one hunt for five bats counts as one hunt. [Defense notes in Russian](DEFENSE_RU.md) trace the calls by hand.
