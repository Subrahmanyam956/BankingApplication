public class Main {
    public static void main(String[] args) {

        String[][] queries = new String[1][3];
        // "CREATE_ACCOUNT", "DEPOSIT", "PAY", "TRANSFER"
        String[] query = new String[3];
        query[0] = "CREATE_ACCOUNT";
        query[1] = "1";
        query[2] = "1";


        queries[0] = query;

        BankingSystem bankingSystem = new BankingSystem();
        String[] result = bankingSystem.processQueries(queries);
        for(String response: result) {
            System.out.println(response);
        }
    }
}