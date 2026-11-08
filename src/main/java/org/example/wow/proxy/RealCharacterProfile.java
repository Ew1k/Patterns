package org.example.wow.proxy;

public class RealCharacterProfile implements CharacterProfile {

    private final String characterName;

    public RealCharacterProfile(String characterName) {
        this.characterName = characterName;
        loadProfile();
    }

    private void loadProfile() {
        System.out.println("Загрузка данных персонажа " + characterName + " с сервера...");
    }

    @Override
    public void displayProfile() {
        System.out.println("Профиль персонажа: " + characterName);
        System.out.println("Уровень: 80, фракция: Альянс/Орда");
    }
}
