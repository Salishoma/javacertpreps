package classes;

import java.util.*;

public class Main {


    public static void main(String[] args) {
//        String[][] res = new String[][]{{"SET", "A", "B", "E"}, {"SET", "A", "C", "F"},
//                {"GET", "A", "B"}, {"GET", "A", "D"}, {"DELETE", "A", "B"}, {"DELETE", "A", "D"}};

        String[][] res = new String[][]{{"SET", "a", "a", "b"}, {"GET", "a", "b"}, {"SET", "a", "A", "c"},
                {"GET", "a", "a"}, {"DELETE", "a", "a"}, {"DELETE", "a", "A"}, {"SET", "a", "A", "b"},
                {"SET", "a", "A", "c"}, {"SCAN", "a"}, {"GET", "a", "a"}, {"GET", "a", "A"}};
        System.out.println(Arrays.deepToString(solution(res)));
    }

    private static String[] solution(String[][] queries) {
        List<String> res = new ArrayList<>();
        Map<String, List<Query>> queryMap = new HashMap<>();


        for (String[] queryString : queries) {
            String op = queryString[0];
            String key = queryString[1];
            Query query;
            List<Query> queryList = queryMap.getOrDefault(key, new ArrayList<>());
            boolean exists = false;
            switch (op) {
                case "SET":
                    String field = queryString[2];
                    String value = queryString[3];
                    query = new Query(key, field, value);
                    for (int i = 0; i < queryList.size(); i++) {
                        Query query1 = queryList.get(i);
                        String field1 = query1.getField();
                        if (field1.equals(field)) {
                            queryList.set(i, query);
                            queryMap.put(key, queryList);
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                       queryList.add(query);
                        queryMap.put(key, queryList);
                    }
                    res.add("");
                    break;
                case "GET":
                    field = queryString[2];
                    for (Query query1 : queryList) {
                        String field1 = query1.getField();
                        if (field1.equals(field)) {
                            res.add(query1.getValue());
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        res.add("");
                    }
                    break;
                case "DELETE":
                    field = queryString[2];
                    int index = -1;
                    for (int i = 0; i < queryList.size(); i++) {
                        Query query1 = queryList.get(i);
                        String field1 = query1.getField();
                        if (field1.equals(field)) {
                            index = i;
                            break;
                        }
                    }
                    if (index != -1) {
                        queryList.remove(index);
                        res.add("true");
                    } else {
                        res.add("false");
                    }
                    break;

                case "SCAN":
//                    field = queryString[2];
//                    value = queryString[3];
                    queryList.sort(Comparator.comparing(Query::getField));
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < queryList.size(); i++) {
                        Query query1 = queryList.get(i);
                        String field1 = query1.getField();
                        String value1 = query1.getValue();
                        builder.append("<").append(field1).append(">").append("(<")
                                .append(value1).append(">)").append(",");
                    }
                    res.add(builder.substring(0, builder.length() - 1));
            }
        }
//        String[] res = new String[]

        return res.toArray(new String[0]);
    }



    static class Query {
        private String key;
        private String field;
        private String value;

        public Query(String key, String field, String value) {
            this.key = key;
            this.field = field;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
