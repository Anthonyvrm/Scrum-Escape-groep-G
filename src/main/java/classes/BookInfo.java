package classes;

import Interface.IReadable;

public class BookInfo implements IReadable {
    private String info;

    public BookInfo(String info) {
        this.info = info;
    }

    @Override
    public void showMessage() {
        //De info wordt meegegeven vanaf de constructor in de specifieke kamer.
        System.out.println(info);
    }
}
