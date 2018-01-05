package Snake;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Record> records = new ArrayList<>();

    public List<Record> getRecords() {
        sortRecords();
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecord(String player, int score) {
        Record record = new Record();
        record.setPlayer(player);
        record.setScore(score);
        records.add(record);
    }

    private void sortRecords() {
        records.sort((r1, r2) -> r2.getScore() - r1.getScore());
    }
}
