package ceasar.cipher;

public class CaesarCipherEncryptor2 {

    public static void main(String[] args) {
        String secretMessage = "xyz";
        int key = 108;

        String allChars = "abcdefghijklmnopqrstuvwxyz";

        String encryptedMessage = encryptSecretMessage(secretMessage, key, allChars);
        System.out.println("encryptedMessage: " + encryptedMessage);
    }

    private static String encryptSecretMessage(String secretMessage, int key, String allCharsStr) {
        key = key % 26;
        StringBuilder stringBuilder = new StringBuilder();
        char[] allCharsArray = secretMessage.toCharArray();
        for(Character secretCharacter: allCharsArray){
            int indexOfSecretChar = allCharsStr.indexOf(secretCharacter);
            int encryptedCharacterIndex = indexOfSecretChar + key;

            if(encryptedCharacterIndex > 25){
                encryptedCharacterIndex = (encryptedCharacterIndex % 25) -1; //o indexed hence -1
            }
            stringBuilder.append(allCharsArray[encryptedCharacterIndex]);
        }
        return stringBuilder.toString();
    }
}
