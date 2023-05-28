import com.google.gson.Gson;
import javafx.scene.control.TextField;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    List<Cell> cells = new ArrayList<>();

    List<Admin> admins = new ArrayList<>();
    List<Hacker> hackers = new ArrayList<>();
    List<Threat> threats = new ArrayList<>();
    List<Protector> protectors = new ArrayList<>();

    private List<Double> hackPercents = new ArrayList<>();

    Matrix(List<Boolean> buffAdmins, List<Boolean> buffThreats){
        createMatrix(buffAdmins, buffThreats);
    }

    /**
     * Метод для создания игровой матрицы
     * buffAdmins и buffHackers это списки с значения, которые содержат информацию о том,
     * какие СЗ и угрозы используются в игровой матрице
     */
    private void createMatrix(List<Boolean> buffAdmins, List<Boolean> buffHackers){
        List<Protector> protectors = new ArrayList<>();
        List<Threat> threats = new ArrayList<>();
        try{
            for(int i = 1; i <= 5; i++){
                String fileName = "admin" + i;
                File file = new File("src\\main\\resources\\admins\\" + fileName + ".json");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null){
                    if(buffAdmins.get(i-1)) {
                        protectors.add(new Gson().fromJson(line, Protector.class));
                    }
                    line = br.readLine();
                }
            }
            for(int i = 1; i <= 14; i++){
                String fileName = "hacker" + i;
                File file = new File("src\\main\\resources\\hackers\\" + fileName + ".json");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null){
                    if(buffHackers.get(i-1)) {
                        threats.add(new Gson().fromJson(line, Threat.class));
                    }
                    line = br.readLine();
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        this.protectors = protectors;
        this.threats = threats;

        int counter = 1;
        for(int i = 0; i < protectors.size(); i++){
            for(int j = i + 1; j < protectors.size(); j++ ){
                if(buffAdmins.get(i) && buffAdmins.get(j)) {
                    this.admins.add(new Admin(counter, new ArrayList<>(Arrays.asList(protectors.get(i), protectors.get(j)))));
                    counter++;
                }
            }

        }

        counter = 1;
        for(int i = 0; i < threats.size(); i++){
            for(int j = i + 1; j < threats.size(); j++ ){
                if(buffHackers.get(i) && buffHackers.get(j)) {
                    this.hackers.add(new Hacker(counter, new ArrayList<>(Arrays.asList(threats.get(i), threats.get(j)))));
                    counter++;
                }
            }
        }

        int j = 2;
        for(Admin admin : admins){
            int i = 1;
            for(Hacker hacker : hackers){
                this.cells.add(new Cell(i, j, admin, hacker));
                i++;
            }
            j++;
        }
    }


    /**
     * Критерий Вальда
     *
     */
    public Cell critVald(){
        Cell output = null;
        int j = 2;
        int i = 1;
        int min = 999999999;
        int max = -999999999;

        for (Cell cell : cells){

            if(cell.getI() == i && cell.getValue() < min){
                j = cell.getJ();
                min = cell.getValue();
            }

        }

        for (Cell cell : cells){

            if(cell.getJ() == j && cell.getValue() > max){
                i = cell.getI();
                max = cell.getValue();
            }
        }


        for(Cell cell : cells){
            if(cell.getI() == i && cell.getJ() == j){
                output = cell;
            }
        }

        return output;
    }

    /**
     * Критерий Байеса
     *
     */
    public Admin critBayes(List<TextField> percentsStrings){

        if(hackPercents.size() != 0) hackPercents.clear();

        for(TextField str : percentsStrings){
            hackPercents.add(Double.parseDouble(str.getText()));
        }

        Admin output = null;
        int min = 999999999;
        int indexJ = 0;

        int[] sums = new int[admins.size()];


        for(int j = 0; j < admins.size(); j++){
            for(Cell cell : cells){
                if(cell.getJ()-2 == j){
                    sums[j] += cell.getValue() * hackPercents.get(cell.getI()-1);
                }
            }
        }
        for (int i : sums)
            System.out.println(i);

        for(int i = 0; i < sums.length; i++){
            if(sums[i] < min){
                min = sums[i];
                indexJ = i;
            }
        }
        System.out.println(min);
        System.out.println(indexJ);

        for(Cell cell : cells){
            if(cell.getJ()-2 == indexJ){
                output = cell.getProtectors();
                break;
            }
        }

        return output;
    }

    /**
     * Критерий Лапласа
     *
     */
    public Admin critLaplasa(){
        Admin output = null;

        double min = 999999999.0;
        int indexJ = 0;

        double[] sums = new double[admins.size()];

        for(int j = 0; j < admins.size(); j++){
            for(Cell cell : cells){
                if(cell.getJ() == j){
                    sums[j] += (double) (cell.getValue() / hackers.size());
                }
            }
        }

        for (int j = 0; j < admins.size(); j++){
            if(sums[j] < min){
                min = sums[j];
                indexJ = j;
            }
        }

        for(Cell cell : cells){
            if(cell.getJ()-2 == indexJ){
                output = cell.getProtectors();
                break;
            }
        }


        return output;
    }

    /**
     * Критерий Гурвица
     *
     */
    public Admin critGurvica(double c){
        Admin output = null;

        Cell max = null;
        Cell min = null;

        int minValue = 999999999;
        int maxValue = 0;
        int indexMin = -1;

        double[] sums = new double[admins.size()];

        for(Cell cell : cells){
            if(cell.getValue() < minValue){
                minValue = cell.getValue();
                min = cell;
            }
        }

        for(Cell cell : cells){
            if(cell.getValue() > maxValue){
                maxValue = cell.getValue();
                max = cell;
            }
        }

        for(int j = 0; j < admins.size(); j++){
            for(Cell cell : cells){
                if(cell.getJ()-2 == j && cell.getI()-1 == max.getI()-1){
                    sums[j] += cell.getValue() * c;
                }
                if(cell.getJ()-2 == j && cell.getI()-1 == min.getI()-1){
                    sums[j] += cell.getValue() * (1 - c);
                }
            }
        }

        for(int j = 0; j < 5; j++){
            double minBuff = 999999999.0;
            if(sums[j] < minBuff){
                indexMin = j;
            }
        }

        for(Cell cell : cells){
            if(cell.getJ() == indexMin){
                output = cell.getProtectors();
                break;
            }
        }

        return output;
    }

    public void setHackPercents(List<Double> hackPercents) {
        this.hackPercents = hackPercents;
    }

    public List<Double> getHackPercents() {
        return hackPercents;
    }
}
