import java.util.*;

public class BankingSystem {

        static String[] processQueries(String[][] queries) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> accounts = new HashMap<>();
            Map<String, Integer> transactionValues = new HashMap<>();
          //  Map<String, Transfer> scheduledTransfers = new HashMap<>();
            int transferCount = 1;

            for (String[] query : queries) {
                String operation = query[0];
                String timestamp = query[1];
                String accountId = query[2];

                switch (operation) {
                    case "CREATE_ACCOUNT":
                        if (!accounts.containsKey(accountId)) {
                            accounts.put(accountId, 0);
                            transactionValues.put(accountId, 0);
                            result.add("true");
                        } else {
                            result.add("false");
                        }
                        break;
                    case "DEPOSIT":
                        int depositAmount = Integer.parseInt(query[3]);
                        if (accounts.containsKey(accountId)) {
                            int balance = accounts.get(accountId);
                            balance += depositAmount;
                            accounts.put(accountId, balance);
                            transactionValues.put(accountId, transactionValues.get(accountId) + Math.abs(depositAmount));
                            result.add(String.valueOf(balance));
                        } else {
                            result.add("");
                        }
                        break;
                    case "PAY":
                        int payAmount = Integer.parseInt(query[3]);
                        if (accounts.containsKey(accountId)) {
                            int balance = accounts.get(accountId);
                            if (balance >= payAmount) {
                                balance -= payAmount;
                                accounts.put(accountId, balance);
                                transactionValues.put(accountId, transactionValues.get(accountId) + Math.abs(payAmount));
                                result.add(String.valueOf(balance));
                            } else {
                                result.add("");
                            }
                        } else {
                            result.add("");
                        }
                        break;
                    default:
                        result.add("");
                }
            }
            return result.toArray(new String[0]);
        }


}
