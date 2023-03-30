package caesar.cipher;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {
        String secretMessage = "xyz";
        int key = 54;

        String encryptedMessage = encryptSecretMessage(secretMessage, key);
        System.out.println("encryptedMessage: " + encryptedMessage);
    }

    private static String encryptSecretMessage(String secretMessage, int key) {
        key = key % 26;
        StringBuilder stringBuilder = new StringBuilder();
        for(Character secretCharacter: secretMessage.toCharArray()){
            int unicodeValueOfSecretCharacter = secretCharacter.hashCode(); // (int) secretCharacter can also be done
            int encryptedCharacterUnicodeValue = unicodeValueOfSecretCharacter + key;

            if(encryptedCharacterUnicodeValue > 122){
                encryptedCharacterUnicodeValue = (encryptedCharacterUnicodeValue % 122) + 96;
            }
            stringBuilder.append((char) encryptedCharacterUnicodeValue);
        }
        return stringBuilder.toString();
    }
}
