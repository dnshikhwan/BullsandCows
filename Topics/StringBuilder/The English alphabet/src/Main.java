class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder fullEnglishAlphabet = new StringBuilder();

        for (int i = 65; i <= 90; i++) {
            char temp = (char) i;
            fullEnglishAlphabet.append(temp).append(" ");
        }

        return fullEnglishAlphabet.delete(51, 52);
    }
}