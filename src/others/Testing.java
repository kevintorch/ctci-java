package others;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Map<String, Object> map = new HashMap<>();
        map.put("date", timestamp);
        System.out.println(map);
    }
}
