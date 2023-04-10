package com.alura.type.currency;



public class BaseCoin {
    private String name;
    private String symbol;
    private String slug;


    public BaseCoin(String name, String symbol, String slug) {
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Coin {\n" +
                "name='" + name + '\'' + '\n' +
                ", symbol='" + symbol + '\'' + '\n' +
                ", slug='" + slug + '\'' + '\n' +
                '}';
    }
}
