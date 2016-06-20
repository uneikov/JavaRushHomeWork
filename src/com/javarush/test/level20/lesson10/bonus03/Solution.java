package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> word = new ArrayList<>();
        ArrayList<Word> temp;
        int[][] framedCrossword = setFrame(crossword);
        ArrayList<SeekPoint> seekPoints = getSeekPoints(framedCrossword, words);
        for (int i = 0; i < seekPoints.size(); i++){
            if (seekPoints.get(i).getDirections() != null) {
                temp = findWord(framedCrossword, seekPoints.get(i));
                if (temp != null) {
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j) != null) word.add(temp.get(j));
                    }
                }
            }
        }

        return word;
    }

    public static int[][] setFrame(int[][] crossword) {
        int height = crossword.length + 2;
        int width = crossword[0].length + 2;
        int[][] result = new int[height][width];
        for (int j = 1; j < height-1; j++){
            for (int i = 1; i < width-1; i++)
                result[j][i] = crossword[j-1][i-1];
        }
        return result;
    }

    public static ArrayList<SeekPoint> getSeekPoints(int[][] crossword, String... words ){
        ArrayList<SeekPoint> seekPoints = new ArrayList<>();
        int height = crossword.length;
        int width = crossword[0].length;
        for (int k = 0; k < words.length; k++){
            int seek = words[k].charAt(0);
            for (int j = 0; j < height; j++){
                for (int i = 0; i < width; i++) {
                    if ( crossword[j][i]  == seek ) {
                        seekPoints.add(new SeekPoint(i, j, words[k], getDirections(crossword, i, j, words[k].charAt(1))));
                    }
                }
            }
        }
        return seekPoints;
    }

    public static ArrayList<Word> findWord(int[][] crossword, SeekPoint seekPoint){

        StringBuilder sb;
        ArrayList<Word> words = new ArrayList<>();
        String word = seekPoint.getWord();
        Word newWord = new Word(word);
        newWord.setStartPoint(seekPoint.getX() - 1, seekPoint.getY() - 1);
        Radar radar = new Radar(seekPoint.getX(), seekPoint.getY());
        ArrayList<Direction> directions = seekPoint.getDirections();
        if (directions == null) return null;
        for (int i = 0; i < directions.size() ; i++) {
            Direction direction = directions.get(i);
            sb = new StringBuilder().append(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                radar.moveTo(direction);
                if (word.charAt(j) == crossword[ radar.getPointY() ][ radar.getPointX() ]) sb.append(word.charAt(j));
                else break;
            }
            if (word.equals(sb.toString())) {
                newWord.setEndPoint(radar.getPointX()-1, radar.getPointY()-1);
                words.add(newWord);
            }
            else words.add(null);

            radar.setPointX(seekPoint.getX());
            radar.setPointY(seekPoint.getY());
        }
        return words;
    }

    public static ArrayList<Direction> getDirections(int[][] crossword, int x, int y, int seek){
        ArrayList<Direction> directions = new ArrayList<>();
        Radar radar = new Radar(x, y);
        radar.initRadar(); //
        do {
            radar.scanToOneStep();
            if ( crossword[ radar.getPointY() ][ radar.getPointX() ] == seek ){
                directions.add(radar.getDirection(x, y));
            }
        }while (!radar.isScanned());
        if (directions.size() != 0) return directions;
        else return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
