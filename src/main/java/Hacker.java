import java.util.List;

public class Hacker {
    private int position;
    private List<Threat> threats;

    Hacker(int position, List<Threat> threats){
        this.position = position;
        this.threats = threats;
    }

    public void setThreats(List<Threat> threats) {
        this.threats = threats;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Threat> getThreats() {
        return threats;
    }

    public int getPosition() {
        return position;
    }
}
