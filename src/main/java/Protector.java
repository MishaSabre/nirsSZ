import java.util.List;

public class Protector {
    private String name;
    private int cost;
    private List<String> threats;

    Protector(){}
    Protector(String name, int cost, List<String> threats){

        this.name = name;
        this.cost = cost;
        this.threats = threats;

    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThreats(List<String> threats) {
        this.threats = threats;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public List<String> getThreats() {
        return threats;
    }

    //Метод для поиска угроз, от которых защищает данный продукт
    public boolean find(Threat threat){
        boolean output = false;

        for (String threat1 : threats){
            if(threat1.equals(threat.getName())){
                output = true;
            }
        }

        return output;
    }
}
