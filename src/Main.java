public class Main {
    public static void main(String[] args) {

        SpellCaster caster = new SpellCaster();

        try {
            caster.castSpell("Fireball");
        } catch (SpellException e) {
            System.out.println("Spell failed: " + e.getMessage());
        }
    }
}