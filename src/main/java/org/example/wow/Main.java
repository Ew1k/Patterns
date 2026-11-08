package org.example.wow;

import org.example.wow.adapter.Consumable;
import org.example.wow.adapter.OldManaPotion;
import org.example.wow.adapter.OldManaPotionAdapter;
import org.example.wow.chain.ArmorHandler;
import org.example.wow.chain.DamageHandler;
import org.example.wow.chain.HealthHandler;
import org.example.wow.chain.ShieldHandler;
import org.example.wow.character.CharacterBuilder;
import org.example.wow.character.GameCharacter;
import org.example.wow.decorator.BasicCharacterEquipment;
import org.example.wow.decorator.BlessingDecorator;
import org.example.wow.decorator.CharacterEquipment;
import org.example.wow.decorator.EnchantedWeaponDecorator;
import org.example.wow.proxy.CharacterProfile;
import org.example.wow.proxy.CharacterProfileProxy;
import org.example.wow.strategy.RangeCombatStrategy;
import org.example.wow.strategy.PowerOfBanshiStrategy;

public class Main {

    public static void main(String[] args) {
        System.out.println("========== WORLD OF WARCRAFT ==========");
        demonstrateBuilder();
        demonstrateStrategy();
        demonstrateChainOfResponsibility();
        demonstrateDecorator();
        demonstrateAdapter();
        demonstrateProxy();
    }

    private static void demonstrateBuilder() {
        System.out.println("\n========== BUILDER ==========");
        GameCharacter warrior = new CharacterBuilder()
                .setName("Артас")
                .setRace("Человек")
                .setCharacterClass("Паладин")
                .setWeapon("Месть Света")
                .setHealth(150)
                .setMana(30)
                .build();

        warrior.showInfo();
    }

    private static void demonstrateStrategy() {
        System.out.println("\n========== STRATEGY ==========");
        GameCharacter mage = new CharacterBuilder()
                .setName("Сильвана")
                .setRace("Падший эльф")
                .setCharacterClass("Лучник")
                .setWeapon("Рэ’шалар, Шепот Смерти")
                .setHealth(160)
                .setMana(40)
                .build();

        mage.setCombatStrategy(new RangeCombatStrategy());
        mage.attack();

        mage.setCombatStrategy(new PowerOfBanshiStrategy());
        mage.attack();
    }

    private static void demonstrateChainOfResponsibility() {
        System.out.println("\n========== CHAIN OF RESPONSIBILITY ==========");
        GameCharacter paladin = new CharacterBuilder()
                .setName("Тирион")
                .setRace("Человек")
                .setCharacterClass("Паладин")
                .setWeapon("Испепелитель")
                .setHealth(120)
                .setMana(80)
                .build();

        DamageHandler armor = new ArmorHandler(20);
        DamageHandler shield = new ShieldHandler(15);
        DamageHandler health = new HealthHandler(paladin);

        armor.setNext(shield);
        shield.setNext(health);

        armor.handleDamage(70);
        System.out.println("Оставшееся здоровье: " + paladin.getHealth());
    }

    private static void demonstrateDecorator() {
        System.out.println("\n========== DECORATOR ==========");
        GameCharacter rogue = new CharacterBuilder()
                .setName("Вэйл")
                .setRace("Ночной эльф")
                .setCharacterClass("Разбойник")
                .setWeapon("Кинжалы")
                .setHealth(100)
                .setMana(60)
                .build();

        CharacterEquipment decorated = new BasicCharacterEquipment(rogue);
        decorated = new EnchantedWeaponDecorator(decorated);
        decorated = new BlessingDecorator(decorated);

        System.out.println(decorated.getDescription());
        System.out.println("Итоговый урон: " + decorated.getAttackPower());
    }

    private static void demonstrateAdapter() {
        System.out.println("\n========== ADAPTER ==========");
        GameCharacter mage = new CharacterBuilder()
                .setName("Медив")
                .setRace("Человек")
                .setCharacterClass("Маг")
                .setWeapon("Атиеш")
                .setHealth(90)
                .setMana(500)
                .build();

        Consumable manaPotion = new OldManaPotionAdapter(new OldManaPotion());
        manaPotion.use(mage);
        System.out.println("Мана после использования зелья: " + mage.getMana());
    }

    private static void demonstrateProxy() {
        System.out.println("\n========== PROXY ==========");
        CharacterProfile profile = new CharacterProfileProxy("Артас", true);
        profile.displayProfile();

        CharacterProfile restrictedProfile = new CharacterProfileProxy("Сильвана", false);
        restrictedProfile.displayProfile();
    }
}
