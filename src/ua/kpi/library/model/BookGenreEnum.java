package ua.kpi.library.model;

public enum BookGenreEnum {
    ADVENTURE(true),
    CLASSICS(true),
    FANTASY(true),
    HORROR(true),
    SCI_FI(true),
    BUSINESS(false);

    private final Boolean isFiction;

    BookGenreEnum(Boolean isFiction) {
        this.isFiction = isFiction;
    }

    @Override
    public String toString() {
        return switch (this) {
            case ADVENTURE -> "Adventure";
            case CLASSICS -> "Classics";
            case FANTASY -> "Fantasy";
            case HORROR -> "Horror";
            case SCI_FI -> "Sci-fi";
            case BUSINESS -> "Business";
        };
    }

    public Boolean isFiction() {
        return this.isFiction;
    }

}
