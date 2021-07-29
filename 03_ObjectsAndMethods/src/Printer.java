public class Printer {
    private static String queue = "";
    private static int count = 0;
    private static int totalPages = 0;

    public void append(String docs, int pages) {
        queue = queue + "\n" + docs + " - " + pages + " стр.";
        totalPages = totalPages + pages;

    }
    public void clear() {
        queue = "";
    }
    public static int getTotalPages() {
            return totalPages;
    }
    public static int totalCount() {
        count = totalPages;
        return count;
    }
    public void print(String docsTitle) {
        System.out.println(docsTitle);
        if (queue.isEmpty()) {
            System.out.println("Очередь печати пуста");
        }
        else {
            System.out.println(queue);
        }



    }
}
