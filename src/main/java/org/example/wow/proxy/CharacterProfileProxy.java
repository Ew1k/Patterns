package org.example.wow.proxy;

public class CharacterProfileProxy implements CharacterProfile {

    private final String characterName;
    private final boolean accessAllowed;
    private RealCharacterProfile realProfile;

    public CharacterProfileProxy(String characterName, boolean accessAllowed) {
        this.characterName = characterName;
        this.accessAllowed = accessAllowed;
    }

    @Override
    public void displayProfile() {
        if (!accessAllowed) {
            System.out.println("Доступ к профилю " + characterName + " запрещён.");
            return;
        }

        if (realProfile == null) {
            realProfile = new RealCharacterProfile(characterName);
        }

        realProfile.displayProfile();
    }
}
