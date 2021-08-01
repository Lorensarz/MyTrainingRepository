public class Printer {
    private String queue = "Очередь печати: ";
    private int pagesCount = 0;
    private int documentCount = 0;

    private int totalDocumentsPrinted = 0;
    private int totalPagesPrinted = 0;

    public void append(String docText) {
        append(docText, "Undefined", 1);
    }

    public void append(String docText, String docName) {
        append(docText, docName, 1);
    }

    public void append(String docText, String docName, int pagesCount) {
        queue += "\n\t" + docText + " - " + docName + " - " + pagesCount;
        this.pagesCount += pagesCount;
        documentCount++;
    }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста!");
        }
        System.out.println(queue);

        totalDocumentsPrinted += documentCount;
        totalPagesPrinted += pagesCount;

        clear();
    }

    public String getTotalPrints() {
        String total = "Распечатано всего: \n" + "\tДокументов: " + totalDocumentsPrinted + "\n\tСтраниц: " + totalPagesPrinted;
        return total;
    }

    public int getDocumentCount() {
        return documentCount;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void clear() {
        queue = "Printer's queue: ";
        pagesCount = 0;
        documentCount = 0;
    }
}