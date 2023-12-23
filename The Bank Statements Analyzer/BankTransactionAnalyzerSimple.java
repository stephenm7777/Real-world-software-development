public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]); // reads the first line of the cvs
        final List<String> lines = Files.readAllLines(path); // returns the lines from cvs into strings
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for(final String line: lines){
            final String[] columns = line.split(",");
            final LocateDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is " + total);
    }
}