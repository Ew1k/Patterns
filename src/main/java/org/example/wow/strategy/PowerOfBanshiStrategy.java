package org.example.wow.strategy;

public class PowerOfBanshiStrategy implements CombatStrategy {

    @Override
    public void attack(String characterName, String weapon) {
        System.out.println(characterName + " Использует силы банши " );
    }
}
