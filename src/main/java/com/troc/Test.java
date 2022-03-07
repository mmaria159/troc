package com.troc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT * FROM ")
                .append(innerJoinTables("claims", "contacts", "claims_id", "contact_id"))
                .append(innerJoinTables("debtors", "claims_id", "debtor_id"))
                .append(innerJoinTables("asfas", "asfasf", "afsfas"))
                .append(" WHERE ")
                .append(getWhereHandlersIds(ids));

        System.out.println(sqlBuilder);
    }

    private static String getWhereHandlersIds(List<Long> handlersIds) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> iter = handlersIds.iterator();
        while (iter.hasNext()) {
            sb.append("handler_id = '").append(iter.next()).append("'");
            if (iter.hasNext())
                sb.append(" OR ");
        }
        return sb.toString();
    }

    private static String innerJoinTables(String table1, String table2, String on1, String on2) {
        StringBuilder sb = new StringBuilder();
        sb.append(table1).append(" INNER JOIN ").append(table2).append(" ON ").append(on1).append(" = ").append(on2);
        return sb.toString();
    }

    private static String innerJoinTables(String table2, String on1, String on2) {
        StringBuilder sb = new StringBuilder();
        sb.append(" INNER JOIN ").append(table2).append(" ON ").append(on1).append(" = ").append(on2).append(" ");
        return sb.toString();
    }
}
