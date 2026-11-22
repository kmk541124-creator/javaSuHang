package service;

import entity.interact.Interact;
import entity.scene.Sence;
import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DialogBoxService {
    private static final String ESC = "\033[";
    private static final int BOX_TOP = 21;
    private static final int BOX_HEIGHT = 7;
    private static final int BOX_LEFT = 5;
    private static final int BOX_WIDTH = 152;
    private static final int TEXT_WIDTH = BOX_WIDTH - 6;
    private static final int MAX_TEXT_LINES = BOX_HEIGHT - 4;
    private static final int TYPE_DELAY = 30;

    private final Scanner scanner;
    private String[] artLines = new String[0];

    public DialogBoxService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showArt(String art) {
        artLines = art.split("\n");
        System.out.print(ESC + "H" + ESC + "2J" + ESC + "3J");
        for (String line : artLines) {
            System.out.println(line);
        }
        System.out.flush();
    }

    public void say(String speaker, String text) {
        drawBox(speaker);
        List<String> lines = wrap(text);
        for (int i = 0; i < lines.size() && i < MAX_TEXT_LINES; i++) {
            moveTo(BOX_TOP + 2 + i, BOX_LEFT + 3);
            typeWrite(lines.get(i));
        }
        moveTo(BOX_TOP + BOX_HEIGHT - 2, BOX_LEFT + BOX_WIDTH - 12);
        System.out.print("[Enter >]");
        System.out.flush();
        scanner.nextLine();
    }

    public void close() {
        for (int row = BOX_TOP; row < BOX_TOP + BOX_HEIGHT; row++) {
            moveTo(row, 1);
            System.out.print(ESC + "K");
            if (row - 1 < artLines.length) {
                System.out.print(artLines[row - 1]);
            }
        }
        moveTo(artLines.length + 1, 1);
        System.out.flush();
    }

    private void drawBox(String speaker) {
        String name = (speaker == null || speaker.isEmpty()) ? "" : "[ " + speaker + " ]";
        String top = "+=" + name + "=".repeat(BOX_WIDTH - 3 - displayWidth(name)) + "+";
        String middle = "|" + " ".repeat(BOX_WIDTH - 2) + "|";
        String bottom = "+" + "=".repeat(BOX_WIDTH - 2) + "+";

        moveTo(BOX_TOP, BOX_LEFT);
        System.out.print(top);
        for (int i = 1; i < BOX_HEIGHT - 1; i++) {
            moveTo(BOX_TOP + i, BOX_LEFT);
            System.out.print(middle);
        }
        moveTo(BOX_TOP + BOX_HEIGHT - 1, BOX_LEFT);
        System.out.print(bottom);
        System.out.flush();
    }

    private void typeWrite(String line) {
        for (char ch : line.toCharArray()) {
            System.out.print(ch);
            System.out.flush();
            sleep(TYPE_DELAY);
        }
    }

    private List<String> wrap(String text) {
        List<String> lines = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int width = 0;
        for (char ch : text.toCharArray()) {
            if (ch == '\n') {
                lines.add(current.toString());
                current.setLength(0);
                width = 0;
                continue;
            }
            int w = charWidth(ch);
            if (width + w > TEXT_WIDTH) {
                lines.add(current.toString());
                current.setLength(0);
                width = 0;
            }
            current.append(ch);
            width += w;
        }
        if (current.length() > 0) {
            lines.add(current.toString());
        }
        return lines;
    }

    private int displayWidth(String s) {
        int width = 0;
        for (char ch : s.toCharArray()) {
            width += charWidth(ch);
        }
        return width;
    }

    private int charWidth(char ch) {
        boolean wide = (ch >= 0x1100 && ch <= 0x115F)
                || (ch >= 0x2E80 && ch <= 0xA4CF)
                || (ch >= 0xAC00 && ch <= 0xD7A3)
                || (ch >= 0xF900 && ch <= 0xFAFF)
                || (ch >= 0xFF00 && ch <= 0xFF60)
                || (ch >= 0xFFE0 && ch <= 0xFFE6);
        return wide ? 2 : 1;
    }

    private void moveTo(int row, int col) {
        System.out.print(ESC + row + ";" + col + "H");
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void use(Sence place, String speaker, String say){
        showArt(place.getSeance());
        say(speaker, say);
        close();
    }

    public void showInter(String title, List<Interact> items) {
        drawBox(title);
        int columns = (items.size() + MAX_TEXT_LINES - 1) / MAX_TEXT_LINES;
        int columnWidth = TEXT_WIDTH / Math.max(columns, 1);
        for (int i = 0; i < items.size(); i++) {
            int row = i % MAX_TEXT_LINES;
            int column = i / MAX_TEXT_LINES;
            moveTo(BOX_TOP + 2 + row, BOX_LEFT + 3 + column * columnWidth);
            System.out.print("[" + i + "] " + items.get(i).name);
        }
        moveTo(artLines.length + 1, 1);
        System.out.flush();
        scanner.nextLine();
        close();
    }

    public void showItem(String title, List<Item> items){
        drawBox(title);
        int columns = (items.size() + MAX_TEXT_LINES - 1) / MAX_TEXT_LINES;
        int columnWidth = TEXT_WIDTH / Math.max(columns, 1);
        for (int i = 0; i < items.size(); i++) {
            int row = i % MAX_TEXT_LINES;
            int column = i / MAX_TEXT_LINES;
            moveTo(BOX_TOP + 2 + row, BOX_LEFT + 3 + column * columnWidth);
            System.out.print("[" + i + "] " + items.get(i).itemName);
        }
        moveTo(artLines.length + 1, 1);
        System.out.flush();
        scanner.nextLine();
        close();
    }
}