import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void readLog(String fileName) {
        try (Scanner reader = new Scanner(new File(fileName))) {

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

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

        System.out.println("\n--- Spell Casting History ---");
        readLog("spell_log.txt");

        System.out.println("\n--- Testing Missing File ---");
        readLog("missing_grimoire.txt");
    }
}