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

        for (String spell : spells) {
            try {
                caster.castSpell(spell);

            } catch (ManaLeakException e) {
                System.out.println("Mana Leak Warning: " + e.getMessage());

            } catch (FizzleException e) {
                System.out.println("Fizzle Warning: " + e.getMessage());

            } catch (SpellException e) {
                System.out.println("General Spell Error: " + e.getMessage());
            }
        }
    }
}