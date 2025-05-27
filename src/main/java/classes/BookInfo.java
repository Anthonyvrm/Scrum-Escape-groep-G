package classes;

import Interface.IBook;

public class BookInfo implements IBook {
    private String info;

    public BookInfo(String info) {
        this.info = info;
    }

    @Override
    public void readBook() {
        //De info wordt meegegeven vanaf de constructor in de specifieke kamer.
        System.out.println(info);
    }
}
