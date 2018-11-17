// Jisoo Park
 
package cheatershangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class cheatershangman{
    public String file;
    public int remainingTries;
    public String mostRecentTry;
    public static HashSet<String> wordList;
    public HashSet<Character> charactersGuessed;


    cheatershangman(String file) {
        this.file = file;
        charactersGuessed = new HashSet<>();
        wordList = readFile(this.file);
        gameSetup();
    }

    public HashSet<String> readFile(String fileName) {
        HashSet<String> strings = new HashSet<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("\\W", "").toLowerCase();
                    strings.add(word);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e1) {
            System.out.println("Couldn't reach file");
        }
        return strings;
    }

    public void gameSetup() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Number of tries: ");
            remainingTries = Integer.parseInt(scan.nextLine());
            System.out.println();

            System.out.print("Size of word: ");
            int size = Integer.parseInt(scan.nextLine());
            System.out.println();


            if (size > 29 || size < 1 || remainingTries <= 0) {
                throw new Exception();
            }

            this.setListSize(size);
            this.mostRecentTry = guessInstantiate(size);
            System.out.println("Welcome to HangmanGame!");
        } catch (Exception e) {
            System.out.println("Sorry, you entered the wrong thing, once more please!");
            wordList = readFile(this.file);
            gameSetup();
        }

    }

    void gameStart() {
        while (this.mostRecentTry.contains(String.valueOf('*')) && this.remainingTries > 0) {
            System.out.println("Updated word: " + this.mostRecentTry + "    " + "Remaining tries: " + this.remainingTries + "    " + "Already guessed letters: " + charactersGuessed.toString() + "    " + "size: " + wordList.size());
            Scanner s = new Scanner(System.in);

            System.out.print("Guess please: ");
            String input = s.nextLine();
            System.out.println();


            if (guessIsAllowed(input)) {
                Character c = input.charAt(0);
                if (charactersGuessed.contains(c)) {
                    System.out.println("Already guessed!");
                    continue;
                }
                wordGroupSwitch(c);
                if (!this.mostRecentTry.contains(String.valueOf('*'))) {
                    System.out.println("Wow, I'm surprised you guessed " + wordRandomize() + " correctly. Kudos.");
                    break;
                } else if (remainingTries == 0) {
                    System.out.println("You Lose! I knew you would never guess " + wordRandomize());
                    break;
                }
                this.charactersGuessed.add(c);
            } else {
                System.out.println("Oops, invalid guess");
            }
        }
    }

    public HashMap<ArrayList<Integer>, Integer> familyCreation(Character c) {
        // Sorts the families based on grouping with key as indices of c and a value as occurrences

        HashMap<ArrayList<Integer>, Integer> fams = new HashMap<>();
        for (String str : wordList) {
            ArrayList<Integer> index = new ArrayList<>();
            if (!str.contains(String.valueOf(c))) {
                index.add(-1);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == c) {
                        index.add(i);
                    }
                }
            }
            fams.put(index, fams.getOrDefault(index, 0) + 1);  //update the occurrence
        }
        return fams;
    }

    public ArrayList<Integer> bigFamily(HashMap<ArrayList<Integer>, Integer> families) {
        // "cheating" strategy, find biggest family
        ArrayList<Integer> optimal = families.keySet().iterator().next();

        for (ArrayList<Integer> x : families.keySet()) {
            if (families.get(x) > families.get(optimal)) {
                optimal = x;
            }
        }
        return optimal;
    }
    public void wordListFit(String currentGuess, ArrayList<Integer> best) {
        Iterator<String> iter = wordList.iterator();

        while (iter.hasNext()) {
            String temp = iter.next();
            boolean sign = false;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != currentGuess.charAt(i) && currentGuess.charAt(i) != '*') {
                    sign = true;
                    break;
                } else {
                    for (Integer x : best) {
                        if (temp.charAt(x) != currentGuess.charAt(x)) {
                            sign = true;
                            break;
                        }
                    }
                }

            }
            if (sign) {
                iter.remove();
            }
        }
    }


    public void guessChange(ArrayList<Integer> optimal, Character c) {
        if (optimal.get(0) == -1) {
            deleteMatches(c);
            return;
        }

        StringBuilder sb = new StringBuilder(this.mostRecentTry);

        for (Integer i : optimal) {
            sb.setCharAt(i, c);
        }

        this.mostRecentTry = sb.toString();

        wordListFit(this.mostRecentTry, optimal);
    }

    public void wordGroupSwitch(Character c) {
        String recent = this.mostRecentTry;
        HashMap<ArrayList<Integer>, Integer> families = familyCreation(c);
        ArrayList<Integer> optimal = bigFamily(families);

        guessChange(optimal, c);

        if (recent.equals(this.mostRecentTry)) {
            this.remainingTries--;
        }
    }
    public String guessInstantiate(int size) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < size; i++) {
            temp.append('*');
        }
        return temp.toString();
    }
    public boolean guessIsAllowed(String input) {
        return input.replaceAll("[^a-zA-Z]", "").length() == 1;
    }

    public void deleteMatches(Character ch) {
        Iterator<String> iter = wordList.iterator();

        while (iter.hasNext()) {
            String current = iter.next();
            if (current.contains(String.valueOf(ch))) {
                iter.remove();
            }
        }
    }
    public void setListSize(int size) {
        Iterator<String> iter = wordList.iterator();

        while (iter.hasNext()) {
            String current = iter.next();
            if (current.length() != size) {
                iter.remove();
            }
        }
    }
    public String wordRandomize() {
        return wordList.toArray()[(int) (Math.random() * wordList.size())].toString();
    }
}
