package org.example.wow.character;

public class CharacterBuilder {

    private String name;
    private String race;
    private String characterClass;
    private String weapon;
    private int health = 100;
    private int mana = 100;

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setRace(String race) {
        this.race = race;
        return this;
    }

    public CharacterBuilder setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
        return this;
    }

    public CharacterBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public CharacterBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public CharacterBuilder setMana(int mana) {
        this.mana = mana;
        return this;
    }

    public GameCharacter build() {
        if (isBlank(name) || isBlank(race) || isBlank(characterClass) || isBlank(weapon)) {
            throw new IllegalStateException("Необходимо указать имя, расу, класс и оружие персонажа");
        }
        if (health <= 0 || mana < 0) {
            throw new IllegalStateException("Некорректные характеристики персонажа");
        }

        return new GameCharacter(name, race, characterClass, weapon, health, mana);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
