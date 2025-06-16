package classes;

import Interface.IReadable;

public class BookInfo implements IReadable {
    private final String info;

    // Constructor initializes info.
    public BookInfo(String info) {
        this.info = info;
    }

    // Displays book info
    @Override
    public void showMessage() {
        System.out.println();
        System.out.println(info);
    }
}
