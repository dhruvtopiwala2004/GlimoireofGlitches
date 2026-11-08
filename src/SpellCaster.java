public class SpellCaster {

    public void castSpell(String spellName) throws SpellException {
        int result = (int) (Math.random() * 3);

        if (result == 0) {
            System.out.println(spellName + " cast successfully!");
        } else if (result == 1) {
            throw new ManaLeakException(spellName + " caused a mana leak!");
        } else {
            throw new FizzleException(spellName + " fizzled!");
        }
    }
}
