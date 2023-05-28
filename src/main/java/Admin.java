import java.util.List;

public class Admin {
    private int position;
    private List<Protector> protectors;

    Admin(int position, List<Protector> protectors){
        this.position = position;
        this.protectors = protectors;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setProtectors(List<Protector> protectors) {
        this.protectors = protectors;
    }

    public int getPosition() {
        return position;
    }

    public List<Protector> getProtectors() {
        return protectors;
    }
}
