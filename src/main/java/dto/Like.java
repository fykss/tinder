package dto;

public class Like implements Identifiable {
    private int id;
    private int id_who;
    private int id_whom;

    public Like(int id, int id_who, int id_whom) {
        this.id = id;
        this.id_who = id_who;
        this.id_whom = id_whom;
    }

    public int getId_who() {
        return id_who;
    }

    public int getId_whom() {
        return id_whom;
    }

    @Override
    public int getId() {
        return id;
    }
}
