import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        SpellCaster caster = new SpellCaster();

        String[] spells = {
                "Fireball",
                "Ice Storm",
                "Lightning Bolt",
                "Healing Light",
                "Shadow Blast"
        };

        try (FileWriter writer = new FileWriter("spell_log.txt", true)) {

            for (String spell : spells) {
                try {
                    caster.castSpell(spell);
                    writer.write(spell + " - Success\n");

                } catch (ManaLeakException e) {
                    System.out.println("Mana Leak Warning: " + e.getMessage());
                    writer.write(spell + " - ManaLeakException\n");

                } catch (FizzleException e) {
                    System.out.println("Fizzle Warning: " + e.getMessage());
                    writer.write(spell + " - FizzleException\n");

                } catch (SpellException e) {
                    System.out.println("General Spell Error: " + e.getMessage());
                    writer.write(spell + " - SpellException\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to spell log: " + e.getMessage());
        }
    }
}