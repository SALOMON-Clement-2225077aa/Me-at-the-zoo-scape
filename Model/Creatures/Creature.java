package Model.Creatures;

import Model.Creatures.Oviparous.Dragon;
import Model.Creatures.Oviparous.Kraken;
import Model.Creatures.Oviparous.Megalodon;
import Model.Creatures.Oviparous.Phoenix;
import Model.Creatures.Type.Renascent;
import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Creatures.Viviparous.Mermaid;
import Model.Creatures.Viviparous.Nymph;
import Model.Creatures.Viviparous.Unicorn;
import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZoo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * La classe abstraite représentant une créature générique dans le zoo.
 * Toutes les classes de créatures spécifiques étendent cette classe.
 */
public abstract class Creature {

    // Variables
    public String species;
    public String gender;
    public double weight;
    public double size;
    public int age;
    public int hungerLevel;
    public int health;
    public boolean isIll = false;
    public boolean isSleeping;
    public int[] possibleAction;
    public Enclosure enclosure;
    public boolean isDead = false;
    public boolean wantToReproduce = false;

    /**
     * Constructeur de la classe Creature.
     *
     * @param species      L'espèce de la créature.
     * @param gender       Le genre de la créature.
     * @param weight       Le poids de la créature.
     * @param size         La taille de la créature.
     * @param age          L'âge de la créature.
     * @param hungerLevel  Le niveau de faim initial de la créature.
     */
    public Creature(String species, String gender, double weight, double size, int age,int hungerLevel) {
        this.species = species;
        this.gender = gender;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hungerLevel = hungerLevel;
        this.health = 30;
        this.isSleeping = false;
        this.possibleAction = createPossibleAction();
    }

    /**
     * Obtient le genre de la créature.
     *
     * @return Le genre de la créature.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Crée un tableau d'actions possibles pour la créature en fonction des probabilités.
     *
     * @return Un tableau représentant les actions possibles pour la créature.
     */
    public int[] createPossibleAction() {
        // 0 = do nothing                     => 19%
        // 1 = -1 hunger                      => 35%
        // 2 = +1 age                         => 20%
        // 3 = poop (+1 enclosure dirtiness)  => 15%
        // 4 = make sound                     => 5%
        // 5 = sleep/wakeUp                   => 5%
        // 6 = change reproduce state         => 1%

        int[] possibleAction = new int[100];;
        int index = 0;

        for (int i = 0; i < 19; i++) {
            possibleAction[index++] = 0; // "do nothing"
        }
        for (int i = 0; i < 35; i++) {
            possibleAction[index++] = 1; // "-1 hunger"
        }
        for (int i = 0; i < 20; i++) {
            possibleAction[index++] = 2; // "+1 age"
        }
        for (int i = 0; i < 15; i++) {
            possibleAction[index++] = 3; // "poop"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 4; // "make sound"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 5; // "sleep/wakeUp"
        }
        for (int i = 0; i < 1; i++) {
            possibleAction[index++] = 6; // "reproduce state"
        }
        return possibleAction;
    }

    /**
     * Crée un tableau d'actions possibles spécifiquement pour les Lycanthropes en fonction des probabilités.
     *
     * @return Un tableau représentant les actions possibles pour les Lycanthropes.
     */
    public int[] createPossibleActionForLycanthropes() {
        // 0 = do nothing                     => 14%
        // 1 = -1 hunger                      => 30%
        // 2 = +1 age                         => 20%
        // 3 = poop (+1 enclosure dirtiness)  => 13%
        // 4 = howl                           => 8%
        // 5 = dominate                       => 7%
        // 6 = sleep/wakeUp                   => 5%
        // 7 = change reproduce state         => 2%
        // 8 = shift                          => 1%

        int[] possibleAction = new int[100];;
        int index = 0;

        for (int i = 0; i < 14; i++) {
            possibleAction[index++] = 0; // "do nothing"
        }
        for (int i = 0; i < 30; i++) {
            possibleAction[index++] = 1; // "-1 hunger"
        }
        for (int i = 0; i < 20; i++) {
            possibleAction[index++] = 2; // "+1 age"
        }
        for (int i = 0; i < 13; i++) {
            possibleAction[index++] = 3; // "poop"
        }
        for (int i = 0; i < 10; i++) {
            possibleAction[index++] = 4; // "dominate"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 5; // "howl"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 6; // "sleep/wakeUp"
        }
        for (int i = 0; i < 2; i++) {
            possibleAction[index++] = 7; // "reproduce state"
        }
        for (int i = 0; i < 1; i++) {
            possibleAction[index++] = 8; // "shift"
        }
        return possibleAction;
    }

    /**
     * Effectue une action aléatoire en fonction des actions possibles de la créature.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void doSomething(ArrayList<String> creatureActionLog) {
        Random random = new Random();
        int rdNb = random.nextInt(100); //Nb entre 0 et 99
        int selectedAction = possibleAction[rdNb];
        int zeroOrOne = random.nextInt(2); //Nb entre 0 et 1 compris

        // Si l'enclos est sale la créature à 1/2 chance de perdre de la vie
        if(enclosure.enclosureDirtiness >= 95 && zeroOrOne == 1) {
            ill(creatureActionLog);
        } else if (enclosure.getCreatures().get(0) instanceof Lycanthrope) {
            possibleAction = createPossibleActionForLycanthropes();
            Lycanthrope lycanthrope = (Lycanthrope) this;
            switch (selectedAction) {
                case 0:
                    break;
                case 1:
                    hunger(creatureActionLog);
                    break;
                case 2:
                    age(creatureActionLog);
                    break;
                case 3:
                    poop(creatureActionLog);
                    break;
                case 4:
                    lycanthrope.domination(creatureActionLog);
                    break;
                case 5:
                    lycanthrope.affiliationsHowl(creatureActionLog);
                    break;
                case 6 :
                    sleepOrWakeUp();
                    break;
                case 7:
                    changeReproduceState();
                    break;
                case 8:
                    lycanthrope.shift(creatureActionLog);
                    break;
                default:
                    System.out.println("Invalid action : " + selectedAction);
                    break;
            }
        }
        // Sinon elle fait une action au hasard selon les probas définies plus haut
        else {
            switch (selectedAction) {
                case 0:
                    break;
                case 1:
                    hunger(creatureActionLog);
                    break;
                case 2:
                    age(creatureActionLog);
                    break;
                case 3:
                    poop(creatureActionLog);
                    break;
                case 4:
                    makeSound(creatureActionLog);
                    break;
                case 5:
                    sleepOrWakeUp();
                    break;
                case 6 :
                    changeReproduceState();
                    break;
                default:
                    System.out.println("Invalid action : " + selectedAction);
                    break;
            }
        }
    }

    /**
     * Obtient l'espèce de la créature.
     *
     * @return L'espèce de la créature.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gère la faim de la créature, en diminuant le niveau de faim et déclenchant des avertissements de famine.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void hunger(ArrayList<String> creatureActionLog) {
        hungerLevel -= 1;
        if(hungerLevel == 20) {
             creatureActionLog.add("\u001b[31mA " + this.getSpecies() + " is hungry\u001b[0m");
        }
        if(hungerLevel == 10) {
            creatureActionLog.add("\u001b[31;1mA " + this.getSpecies() + " is starving !\u001b[0m");
        }
        if(hungerLevel <= 10) {
            starve(creatureActionLog);
        }
        if(hungerLevel <= 5) {
            starve(creatureActionLog);
        }
        if(hungerLevel <= 3) {
            starve(creatureActionLog);
        }
        if(hungerLevel<0) {
            hungerLevel = 0;
            starve(creatureActionLog);
        }
    }

    public void eat(ArrayList<String> creatureActionLog){
        if(!isSleeping){
            if(hungerLevel >= 95){
                creatureActionLog.add("The " + species + "s aren't hungry");
            }
            else{
                hungerLevel += 5;
                creatureActionLog.add("You fed the " + species + "s");
            }
        }
        else{
            creatureActionLog.add("You can't feed a creature while it's asleep");
        }
    }

    /**
     * Méthode abstraite pour faire un son. Chaque créature implémente cette méthode (avec son bruit)
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public abstract void makeSound(ArrayList <String> creatureActionLog);

    public String heal() {
        if(health == 30){
            return "The " + species + " is already full health";
        }
        else{
            health += 15;
            if(health>30) {
                health = 30;
            }
            return "You heal the " + species;
        }
    }

    /**
     * Fait dormir ou réveille la créature en fonction de son état actuel.
     */
    public void sleepOrWakeUp() {
        isSleeping = !isSleeping;
    }

    /**
     * Fait vieillir la créature en augmentant son âge et gère le décès de la créature en cas de vieillesse extrême.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void age(ArrayList<String> creatureActionLog) {
        age += 1;
        if (age%100==0) {
            die("old age",creatureActionLog);
        }
    }

    /**
     * Modifie l'état de reproduction de la créature, activant ou désactivant son désir de se reproduire.
     */
    public void changeReproduceState() {
        wantToReproduce = !wantToReproduce;
    }

    /**
     * Donne la possibilité aux créatures de faire caca (c'est important), ajoutant de la saleté à l'enclos.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void poop(ArrayList<String> creatureActionLog) {
        if (enclosure != null) {
            enclosure.poopInside(creatureActionLog);
            if(enclosure.enclosureDirtiness > 100) {
                enclosure.enclosureDirtiness = 100;
                ill(creatureActionLog);
            }
        }
    }

    /**
     * Simule l'état de maladie de la créature, réduisant son niveau de santé et provoquant la mort si la santé atteint zéro.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void ill(ArrayList<String> creatureActionLog) {
        health -= 1;
        if (health == 0) {
            die("illness",creatureActionLog);
            FantasticZoo.nbOfLife-=1;
        }
    }

    /**
     * Simule la faim de la créature, réduisant son niveau de santé et provoquant la mort si la santé atteint zéro.
     *
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void starve(ArrayList<String> creatureActionLog) {
        health -= 1;
        if (health == 0) {
            die("starvation",creatureActionLog);
            FantasticZoo.nbOfLife-=1;
        }
    }

    /**
     * Simule la mort de la créature pour une cause donnée, en ajoutant un message approprié à l'ArrayList de journaux d'actions.
     * Si la créature est de type "Renascent", elle est ressuscitée avec des attributs modifiés.
     *
     * @param causeOfDeath      La cause du décès de la créature.
     * @param creatureActionLog Un ArrayList pour enregistrer les actions effectuées par la créature.
     */
    public void die (String causeOfDeath, ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[31mOh no, a " + species + " died of " + causeOfDeath + " :(\u001B[0m");
        if(this instanceof Renascent) {
            creatureActionLog.add("\u001B[32mWhat a miracle ! The " + species + " turned back to life !\u001B[0m");
            this.age = 1;
            this.health = 30;
            this.hungerLevel = 100;
            this.size = Math.round(this.size/1.5 * 10.0) / 10.0;
            this.weight = Math.round(this.weight/1.5 * 10.0) / 10.0;
        }
        else{
            isDead = true;
        }
    }

    /**
     * Associe l'enclos spécifié à la créature.
     *
     * @param enclosure L'enclos à associer à la créature.
     */
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    /**
     * Obtient l'enclos associé à la créature.
     *
     * @return L'enclos associé à la créature.
     */
    public Enclosure getEnclosure() { return enclosure; }

    /**
     * Obtient une représentation sous forme de chaîne de caractères de la créature avec des indications de couleur pour la santé, la faim, etc.
     *
     * @return Une représentation sous forme de chaîne de caractères de la créature.
     */
    @Override
    public String toString() {
        String color = "";
        String asleepOrAwake = "awake";
        String hunger = "fed up";
        String showHealth = ""+health;

        if(health <= 20){
            showHealth = "\u001B[31m" + health;
        }
        if(hungerLevel<=10) {
            color = "\u001b[31;1m"; // bright red
            hunger = "starving";
        }
        if (hungerLevel<=20) {
            color = "\u001B[31m"; //red
            hunger = "hungry";
        }
        if(isSleeping) {
            color = "\u001B[94m"; //light blue
            asleepOrAwake = "asleep";
        }
        return color+species + " : " +
                color +
                gender + ", " +
                weight + "kg"+
                ", "+ size + "m" +
                ", " + age + "yo" +
                ", " + asleepOrAwake +
                ", " + hunger +
                ", " + showHealth + "hp" +
                "\u001B[0m";
    }

    /**
     * Crée une nouvelle créature en fonction de la créature existante. Utilisé pour la reproduction.
     *
     * @param c La créature parente qui sera utilisée comme modèle pour la nouvelle créature.
     * @return Une nouvelle créature créée à partir du modèle parent.
     */
    public Creature createNewCreature(Creature c) {
        String species = c.getSpecies();
        if (Objects.equals(species, "Unicorn")) {
            Unicorn babyUnicorn = new Unicorn("Unicorn", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyUnicorn);
            babyUnicorn.setEnclosure(c.enclosure);
            return babyUnicorn;
        }
        if (Objects.equals(species, "Mermaid")) {
            Mermaid babyMermaid = new Mermaid("Mermaid", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyMermaid);
            babyMermaid.setEnclosure(c.enclosure);
            return babyMermaid;
        }
        if (Objects.equals(species, "Lycanthrope")) {
            Lycanthrope l = (Lycanthrope) c;
            Lycanthrope babyLycanthrope = new Lycanthrope("Lycanthrope", l.getGender(), l.weight / 2, l.size / 2, 1, 0, 100, l.getStrength() - 5, 10,(l.getHound() != null && l.getHound().getLycanthropesHound().isEmpty()) ? 1 : 2, l.getImpetuosity(), l.getHumanForm().getName() + "Jr.");
            l.enclosure.addCreature(babyLycanthrope);
            babyLycanthrope.setEnclosure(l.enclosure);
            return babyLycanthrope;
        }
        if (Objects.equals(species, "Nymph")) {
            Nymph babyNymph = new Nymph("Nymph", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyNymph);
            babyNymph.setEnclosure(c.enclosure);
            return babyNymph;
        }
        if (Objects.equals(species, "Dragon")) {
            Dragon babyDragon = new Dragon("Dragon", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyDragon);
            babyDragon.setEnclosure(c.enclosure);
            return babyDragon;
        }
        if (Objects.equals(species, "Megalodon")) {
            Megalodon babyMegalodon = new Megalodon("Megalodon", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyMegalodon);
            babyMegalodon.setEnclosure(c.enclosure);
            return babyMegalodon;
        }
        if (Objects.equals(species, "Kraken")) {
            Kraken babyKraken = new Kraken("Kraken", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyKraken);
            babyKraken.setEnclosure(c.enclosure);
            return babyKraken;
        }
        if (Objects.equals(species, "Phoenix")) {
            Phoenix babyPhoenix = new Phoenix("Phoenix", c.getGender(), c.weight / 2, c.size/ 2, 1, 100);
            c.enclosure.addCreature(babyPhoenix);
            babyPhoenix.setEnclosure(c.enclosure);
            return babyPhoenix;
        }
        return null;
    }
}
