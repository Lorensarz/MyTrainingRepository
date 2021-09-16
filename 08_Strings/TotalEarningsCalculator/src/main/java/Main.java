public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(getEarnings(text));

        //TODO: напишите ваш код, результат вывести в консоль

    }

    public static int getEarnings (String text) {

        //Strings

        String earningsVasya = "заработал";
        String earningsPetya = "Петя - ";
        String earningsMasha = "Маша - ";

        //Start

        int startVasya = text.indexOf(earningsVasya) + earningsVasya.length();
        int startPetya = text.indexOf(earningsPetya) + earningsPetya.length();
        int startMasha = text.indexOf(earningsMasha) + earningsMasha.length();

        //Ends

        int endVasya = text.indexOf("рублей", startVasya);
        int endPetya = text.indexOf("рубля", startPetya);
        int endMasha = text.indexOf("рублей", startMasha);

        //Substrings

        String vasya = text.substring(startVasya, endVasya);
        String petya = text.substring(startPetya, endPetya);
        String masha = text.substring(startMasha, endMasha);

        //Total earnings

        int totalEarnings = Integer.parseInt(vasya.trim()) +
                            Integer.parseInt(petya.trim()) +
                            Integer.parseInt(masha.trim());

        return totalEarnings;

    }


}