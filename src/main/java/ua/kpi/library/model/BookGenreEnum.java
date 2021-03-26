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
        switch (this) {
            case ADVENTURE:
                return "Adventure";
            case CLASSICS:
                return "Classics";
            case FANTASY:
                return "Fantasy";
            case HORROR:
                return "Horror";
            case SCI_FI:
                return "Sci-fi";
            case BUSINESS:
                return "Business";
            default:
                throw new IllegalArgumentException();
        }
    }

    public Boolean isFiction() {
        return this.isFiction;
    }

}
