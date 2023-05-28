import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cell {
    private int i;
    private int j;
    private int value;
    private int cumulativeDamage;
    private Admin protectors;
    private Hacker threats;

    public Cell() {}

    public Cell(int i, int j, Admin protectors, Hacker threats){
        this.i = i;
        this.j = j;
        this.protectors = protectors;
        this.threats = threats;
        value = 0;
        countValue();
        countCumulativeDamage();
    }

    public void setThreats(Hacker threats) {
        this.threats = threats;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setProtectors(Admin protectors) {
        this.protectors = protectors;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCumulativeDamage(int cumulativeDamage) {
        this.cumulativeDamage = cumulativeDamage;
    }

    public int getValue() {
        return value;
    }

    public Admin getProtectors() {
        return protectors;
    }

    public Hacker getThreats() {
        return threats;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getCumulativeDamage() {
        return cumulativeDamage;
    }

    /*Считаем стоимость клетки из матрицы, берем максимальную по ущербу угрозу,
            берем минимальное по стоимости СЗ: стоимость СЗ + ущерб угрозы = стоимость стратегии.


         */
    private void countValue(){

        Protector minCostProtector = protectors.getProtectors().get(0);
        Threat maxCostThreat = threats.getThreats().get(0);

        for (Protector i : protectors.getProtectors()){
            if( minCostProtector.getCost() > i.getCost()){
                minCostProtector = i;
            }
        }
        for (Threat i : threats.getThreats()){
            if( maxCostThreat.getCost() > i.getCost()){
                maxCostThreat = i;
            }
        }
        this.value = minCostProtector.getCost() + maxCostThreat.getCost();
    }

    private void countCumulativeDamage(){
        List<Threat> buffThreats = new ArrayList<>();
        int buff = 0;
        for(Protector protector : protectors.getProtectors()){
            for (Threat threat : threats.getThreats()){
                if(!protector.getThreats().contains(threat.getName())){
                    buffThreats.add(threat);
                }
            }
            if(buffThreats.size() == 0){
                break;
            }
        }
        Set<Threat> buffSet = new HashSet<>(buffThreats);
        buffThreats.clear();
        buffThreats.addAll(buffSet);
        for(Protector protector : protectors.getProtectors()){
            buff += protector.getCost();
        }
        for (Threat threat : buffThreats){
            buff += threat.getCost();
        }
        this.cumulativeDamage = buff;
    }

}
