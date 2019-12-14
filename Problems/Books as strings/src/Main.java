class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            stringBuilder.append(authors[i]);
            if (i + 1 < authors.length) {
                stringBuilder.append(",");
            }
        }
        String authors = "[" + stringBuilder.toString() + "]";
        return "title=" + title +
                ",yearOfPublishing=" + yearOfPublishing +
                ",authors=" + authors;
    }
}