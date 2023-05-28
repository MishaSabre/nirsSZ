import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Controller {

    List<TextField> textFields = new ArrayList<>();
    private int countAtack = 14;
    private int countProtecrors = 5;

    GridPane gridPaneAnswer = new GridPane();


    List<Boolean> hackersCheckersFirst = new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true, true, true,
            true, true, true, true, true));
    List<Boolean> adminsCheckersFirst = new ArrayList<>(Arrays.asList(true, true, true, true, true));

    List<Boolean> hackersCheckersSecond = new ArrayList<>(Arrays.asList(false, false, false, false, false, false, false, false, false, false,
            false, false, false, false));
    List<Boolean> adminsCheckersSecond = new ArrayList<>(Arrays.asList(false, false, false, false, false));
    List<Double> hackersPercents = new ArrayList<>();

    Matrix matrix;

    @FXML
    private CheckBox atackCheck1;

    @FXML
    private CheckBox atackCheck10;

    @FXML
    private CheckBox atackCheck11;

    @FXML
    private CheckBox atackCheck12;

    @FXML
    private CheckBox atackCheck13;

    @FXML
    private CheckBox atackCheck14;

    @FXML
    private CheckBox atackCheck2;

    @FXML
    private CheckBox atackCheck3;

    @FXML
    private CheckBox atackCheck4;

    @FXML
    private CheckBox atackCheck5;

    @FXML
    private CheckBox atackCheck6;

    @FXML
    private CheckBox atackCheck7;

    @FXML
    private CheckBox atackCheck8;

    @FXML
    private CheckBox atackCheck9;

    @FXML
    private Button buttonGenerateOnClick;

    @FXML
    private Button buttonSchetOnClick;

    @FXML
    private Button buttonSumOnClick;

    @FXML
    private CheckBox checkerAtack1;

    @FXML
    private CheckBox checkerAtack10;

    @FXML
    private CheckBox checkerAtack11;

    @FXML
    private CheckBox checkerAtack12;

    @FXML
    private CheckBox checkerAtack13;

    @FXML
    private CheckBox checkerAtack14;

    @FXML
    private CheckBox checkerAtack2;

    @FXML
    private CheckBox checkerAtack3;

    @FXML
    private CheckBox checkerAtack4;

    @FXML
    private CheckBox checkerAtack5;

    @FXML
    private CheckBox checkerAtack6;

    @FXML
    private CheckBox checkerAtack7;

    @FXML
    private CheckBox checkerAtack8;

    @FXML
    private CheckBox checkerAtack9;

    @FXML
    private CheckBox checkerProtect1;

    @FXML
    private CheckBox checkerProtect2;

    @FXML
    private CheckBox checkerProtect3;

    @FXML
    private CheckBox checkerProtect4;

    @FXML
    private CheckBox checkerProtect5;

    @FXML
    private RadioButton critBayes;

    @FXML
    private RadioButton critGurvic;

    @FXML
    private RadioButton critLaplas;

    @FXML
    private RadioButton critVald;

    @FXML
    private GridPane gridForAdmins;

    @FXML
    private GridPane gridForAtacks;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane matrixPane;

    @FXML
    private TextArea outputWindow;

    @FXML
    private TextField paramC;

    @FXML
    private CheckBox protectCheck1;

    @FXML
    private CheckBox protectCheck2;

    @FXML
    private CheckBox protectCheck3;

    @FXML
    private CheckBox protectCheck4;

    @FXML
    private CheckBox protectCheck5;

    @FXML
    private ScrollPane scrollForAdmins;

    @FXML
    private ScrollPane scrollForHackers;

    @FXML
    private ScrollPane scrollWindow;

    @FXML
    private AnchorPane strategyAnchor;

    @FXML
    private GridPane strategyGridPane;

    @FXML
    private Tab strategyPane;

    @FXML
    private TabPane tabPane;







    @FXML
    void initialize() {
        /*
          Часть кода для первой вкладки "Расчет оптимальной стратегии"
         */
        strategyAnchor.getChildren().add(gridPaneAnswer);

        critBayes.setOnAction(actionEvent -> {
            if(critBayes.isSelected()){
                if(critGurvic.isSelected()) critGurvic.setSelected(false);
                if(critLaplas.isSelected()) critLaplas.setSelected(false);
                if(critVald.isSelected()) critVald.setSelected(false);
            }
        });
        critGurvic.setOnAction(actionEvent -> {
            if(critGurvic.isSelected()){
                if(critBayes.isSelected()) critBayes.setSelected(false);
                if(critLaplas.isSelected()) critLaplas.setSelected(false);
                if(critVald.isSelected()) critVald.setSelected(false);
            }
        });
        critLaplas.setOnAction(actionEvent -> {
            if(critLaplas.isSelected()){
                if(critBayes.isSelected()) critBayes.setSelected(false);
                if(critGurvic.isSelected()) critGurvic.setSelected(false);
                if(critVald.isSelected()) critVald.setSelected(false);
            }
        });
        critVald.setOnAction(actionEvent -> {
            if(critVald.isSelected()){
                if(critBayes.isSelected()) critBayes.setSelected(false);
                if(critGurvic.isSelected()) critGurvic.setSelected(false);
                if(critLaplas.isSelected()) critLaplas.setSelected(false);
            }
        });

        atackCheck1.setOnAction(actionEvent -> {
            if(!atackCheck1.isSelected()) {
                countAtack--;
                hackersCheckersFirst.remove(0);
                hackersCheckersFirst.add(0, false);
            }
            else if (atackCheck1.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(0);
                hackersCheckersFirst.add(0, true);
            }


        });
        atackCheck2.setOnAction(actionEvent -> {
            if(!atackCheck2.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(1);
                hackersCheckersFirst.add(1, false);
            }
            else if (atackCheck2.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(1);
                hackersCheckersFirst.add(1, true);
            }


        });
        atackCheck3.setOnAction(actionEvent -> {
            if(!atackCheck3.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(2);
                hackersCheckersFirst.add(2, false);
            }
            else if (atackCheck3.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(2);
                hackersCheckersFirst.add(2, true);
            }


        });
        atackCheck4.setOnAction(actionEvent -> {
            if(!atackCheck4.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(3);
                hackersCheckersFirst.add(3, false);
            }
            else if (atackCheck4.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(3);
                hackersCheckersFirst.add(3, true);
            }


        });
        atackCheck5.setOnAction(actionEvent -> {
            if(!atackCheck5.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(4);
                hackersCheckersFirst.add(4, false);
            }
            else if (atackCheck5.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(4);
                hackersCheckersFirst.add(4, true);
            }


        });
        atackCheck6.setOnAction(actionEvent -> {
            if(!atackCheck6.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(5);
                hackersCheckersFirst.add(5, false);
            }
            else if (atackCheck6.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(5);
                hackersCheckersFirst.add(5, true);
            }


        });
        atackCheck7.setOnAction(actionEvent -> {
            if(!atackCheck7.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(6);
                hackersCheckersFirst.add(6, false);
            }
            else if (atackCheck7.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(6);
                hackersCheckersFirst.add(6, true);
            }


        });
        atackCheck8.setOnAction(actionEvent -> {
            if(!atackCheck8.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(7);
                hackersCheckersFirst.add(7, false);
            }
            else if (atackCheck8.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(7);
                hackersCheckersFirst.add(7, true);
            }


        });
        atackCheck9.setOnAction(actionEvent -> {
            if(!atackCheck9.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(8);
                hackersCheckersFirst.add(8, false);
            }
            else if (atackCheck9.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(8);
                hackersCheckersFirst.add(8, true);
            }


        });
        atackCheck10.setOnAction(actionEvent -> {
            if(!atackCheck10.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(9);
                hackersCheckersFirst.add(9, false);
            }
            else if (atackCheck10.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(9);
                hackersCheckersFirst.add(9, true);
            }


        });
        atackCheck11.setOnAction(actionEvent -> {
            if(!atackCheck11.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(10);
                hackersCheckersFirst.add(10, false);
            }
            else if (atackCheck11.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(10);
                hackersCheckersFirst.add(10, true);
            }


        });
        atackCheck12.setOnAction(actionEvent -> {
            if(!atackCheck12.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(11);
                hackersCheckersFirst.add(11, false);
            }
            else if (atackCheck12.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(11);
                hackersCheckersFirst.add(11, true);
            }


        });
        atackCheck13.setOnAction(actionEvent -> {
            if(!atackCheck13.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(12);
                hackersCheckersFirst.add(12, false);
            }
            else if (atackCheck13.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(12);
                hackersCheckersFirst.add(12, true);
            }


        });
        atackCheck14.setOnAction(actionEvent -> {
            if(!atackCheck14.isSelected()){
                countAtack--;
                hackersCheckersFirst.remove(13);
                hackersCheckersFirst.add(13, false);
            }
            else if (atackCheck14.isSelected()){
                countAtack++;
                hackersCheckersFirst.remove(13);
                hackersCheckersFirst.add(13, true);
            }


        });

        protectCheck1.setOnAction(actionEvent -> {
            if(!protectCheck1.isSelected()){
                countProtecrors--;
                adminsCheckersFirst.remove(0);
                adminsCheckersFirst.add(0, false);
            }
            else if (protectCheck1.isSelected()){
                countProtecrors++;
                adminsCheckersFirst.remove(0);
                adminsCheckersFirst.add(0, true);
            }


        });
        protectCheck2.setOnAction(actionEvent -> {
            if(!protectCheck2.isSelected()){
                countProtecrors--;
                adminsCheckersFirst.remove(1);
                adminsCheckersFirst.add(1, false);
            }
            else if (protectCheck2.isSelected()){
                countProtecrors++;
                adminsCheckersFirst.remove(1);
                adminsCheckersFirst.add(1, true);
            }



        });
        protectCheck3.setOnAction(actionEvent -> {
            if(!protectCheck3.isSelected()){
                countProtecrors--;
                adminsCheckersFirst.remove(2);
                adminsCheckersFirst.add(2, false);
            }
            else if (protectCheck3.isSelected()){
                countProtecrors++;
                adminsCheckersFirst.remove(2);
                adminsCheckersFirst.add(2, true);
            }


        });
        protectCheck4.setOnAction(actionEvent -> {
            if(!protectCheck4.isSelected()){
                countProtecrors--;
                adminsCheckersFirst.remove(3);
                adminsCheckersFirst.add(3, false);
            }
            else if (protectCheck4.isSelected()){
                countProtecrors++;
                adminsCheckersFirst.remove(3);
                adminsCheckersFirst.add(3, true);
            }


        });
        protectCheck5.setOnAction(actionEvent -> {
            if(!protectCheck5.isSelected()){
                countProtecrors--;
                adminsCheckersFirst.remove(4);
                adminsCheckersFirst.add(4, false);
            }
            else if (protectCheck5.isSelected()){
                countProtecrors++;
                adminsCheckersFirst.remove(4);
                adminsCheckersFirst.add(4, true);
            }


        });

        buttonGenerateOnClick.setOnAction(actionEvent -> {

            matrix = new Matrix(adminsCheckersFirst, hackersCheckersFirst);

            scrollWindow.setContent(strategyGridPane);
            strategyGridPane.setGridLinesVisible(false);
            strategyGridPane.getColumnConstraints().clear();
            strategyGridPane.getRowConstraints().clear();
            strategyGridPane.getChildren().clear();
            strategyGridPane.setGridLinesVisible(true);

            int i = countProtecrors;
            int j = countAtack;
            int buffCountOfAdmins = 0;
            int buffCountOfHackers = 0;


            for (int k = 0; k < i; k++){
                buffCountOfAdmins += k;
            }
            for (int k = 0; k < j; k++){
                buffCountOfHackers += k;
            }

            strategyGridPane.getColumnConstraints().add(new ColumnConstraints(90));
            strategyGridPane.add(new Label("  Вероятность "), 0, 0);

            for(i = 2; i < buffCountOfAdmins+2; i++){
                strategyGridPane.getColumnConstraints().add(new ColumnConstraints(70));
                strategyGridPane.add(new Label("  Админ" + (i - 1)), i, 0);
            }

            strategyGridPane.getColumnConstraints().add(new ColumnConstraints(70));
            for(j = 1; j < buffCountOfHackers+1; j++){
                strategyGridPane.getRowConstraints().add(new RowConstraints(50));
                strategyGridPane.add(new Label("  Хакер" + j), 1, j);
            }
            strategyGridPane.getRowConstraints().add(new RowConstraints(50));

            for(j = 1; j < buffCountOfHackers+1; j++){
                textFields.add(j-1,new TextField("0.0"));
                strategyGridPane.add(textFields.get(j-1), 0, j);
            }

            for(Cell cell : matrix.cells){
                    strategyGridPane.add(new Label("  " + cell.getValue()), cell.getJ(), cell.getI());
            }


        });


        buttonSchetOnClick.setOnAction(actionEvent -> {

            gridPaneAnswer.setGridLinesVisible(false);
            gridPaneAnswer.getColumnConstraints().clear();
            gridPaneAnswer.getRowConstraints().clear();
            gridPaneAnswer.getChildren().clear();
            gridPaneAnswer.setGridLinesVisible(true);
            for (int i = 0; i < 5; i++) {
                gridPaneAnswer.getColumnConstraints().add(new ColumnConstraints(150));
            }
            gridPaneAnswer.getRowConstraints().add(new RowConstraints(50));
            gridPaneAnswer.getRowConstraints().add(new RowConstraints(50));
            gridPaneAnswer.add(new Label("  Название\n"+ "  оптимальной\n" + "  статегии"), 0,0);
            gridPaneAnswer.add(new Label("  Критерий\n"+ "  оптимальности"), 1,0);
            gridPaneAnswer.add(new Label("  Стоимость\n"+ "  стратегии"), 2,0);
            gridPaneAnswer.add(new Label("  Возможный\n"+ "  ущерб"), 3,0);
            gridPaneAnswer.add(new Label("  Суммарные\n"+ "  затраты"), 4,0);

            if(strategyGridPane.getChildren().size() > 2 && countAtack >= 2 && countProtecrors >= 2 &&
                    (critVald.isSelected() || critLaplas.isSelected() || critGurvic.isSelected() || critBayes.isSelected())
            ){
                if(critVald.isSelected()){

                    Cell output = matrix.critVald();
                    gridPaneAnswer.add(new Label("Админ" + output.getProtectors().getPosition()), 0, 1);
                    gridPaneAnswer.add(new Label("Критерий Вальда"), 1, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(output.getProtectors().getProtectors().get(0).getCost() +
                            output.getProtectors().getProtectors().get(1).getCost())), 2, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(output.getThreats().getThreats().get(0).getCost() +
                            output.getThreats().getThreats().get(1).getCost())), 3, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(output.getCumulativeDamage())),4,1);

                    AnchorPane.setBottomAnchor(gridPaneAnswer, 50.0);
                    AnchorPane.setLeftAnchor(gridPaneAnswer, 278.0);


                }else if(critBayes.isSelected()){
                    int maxDoubleIndex = 1;
                    int cumulativeDamage = 0;
                    double maxDouble = 0.0;
                    Admin admin = matrix.critBayes(textFields);
                    for(TextField str : textFields){
                       if (Double.parseDouble(str.getText()) > maxDouble){
                           maxDouble = Double.parseDouble(str.getText());
                           maxDoubleIndex = textFields.indexOf(str);
                       }
                    }
                    cumulativeDamage += admin.getProtectors().get(0).getCost() + admin.getProtectors().get(1).getCost();
                    if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    gridPaneAnswer.add(new Label("Админ" + admin.getPosition()), 0, 1);
                    gridPaneAnswer.add(new Label("Критерий Байеса"), 1, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(admin.getProtectors().get(0).getCost() +
                            admin.getProtectors().get(1).getCost())), 2, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost() +
                            matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost())), 3, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(cumulativeDamage)), 4, 1);

                    AnchorPane.setBottomAnchor(gridPaneAnswer, 50.0);
                    AnchorPane.setLeftAnchor(gridPaneAnswer, 278.0);

                }else if(critLaplas.isSelected()){
                    int maxDoubleIndex = 1;
                    int cumulativeDamage = 0;
                    double maxDouble = 0.0;
                    Admin admin = matrix.critLaplasa();
                    for(TextField str : textFields){
                        if (Double.parseDouble(str.getText()) > maxDouble){
                            maxDouble = Double.parseDouble(str.getText());
                            maxDoubleIndex = textFields.indexOf(str);
                        }
                    }
                    cumulativeDamage += admin.getProtectors().get(0).getCost() + admin.getProtectors().get(1).getCost();
                    if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    gridPaneAnswer.add(new Label("Админ" + admin.getPosition()), 0, 1);
                    gridPaneAnswer.add(new Label("Критерий Лапласа"), 1, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(admin.getProtectors().get(0).getCost() +
                            admin.getProtectors().get(1).getCost())), 2, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost() +
                            matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost())), 3, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(cumulativeDamage)), 4, 1);

                    AnchorPane.setBottomAnchor(gridPaneAnswer, 50.0);
                    AnchorPane.setLeftAnchor(gridPaneAnswer, 278.0);

                }else{
                    int maxDoubleIndex = 1;
                    int cumulativeDamage = 0;
                    double maxDouble = 0.0;
                    Admin admin = matrix.critGurvica(Double.parseDouble(paramC.getText()));
                    for(TextField str : textFields){
                        if (Double.parseDouble(str.getText()) > maxDouble){
                            maxDouble = Double.parseDouble(str.getText());
                            maxDoubleIndex = textFields.indexOf(str);
                        }
                    }
                    cumulativeDamage += admin.getProtectors().get(0).getCost() + admin.getProtectors().get(1).getCost();
                    if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(0).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost();
                    }else if(!admin.getProtectors().get(1).getThreats().contains(matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getName())){
                        cumulativeDamage +=  matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost();
                    }
                    gridPaneAnswer.add(new Label("Админ" + admin.getPosition()), 0, 1);
                    gridPaneAnswer.add(new Label("Критерий Гурвица"), 1, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(admin.getProtectors().get(0).getCost() +
                            admin.getProtectors().get(1).getCost())), 2, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(matrix.hackers.get(maxDoubleIndex).getThreats().get(0).getCost() +
                            matrix.hackers.get(maxDoubleIndex).getThreats().get(1).getCost())), 3, 1);
                    gridPaneAnswer.add(new Label(String.valueOf(cumulativeDamage)), 4, 1);

                    AnchorPane.setBottomAnchor(gridPaneAnswer, 50.0);
                    AnchorPane.setLeftAnchor(gridPaneAnswer, 278.0);

                }

            }

        });

        /*
            Часть кода для вкладки "Рассчет возможного ущерба"
         */
        checkerAtack1.setOnAction(actionEvent -> {
            if (!checkerAtack1.isSelected()) {
                hackersCheckersSecond.remove(0);
                hackersCheckersSecond.add(0, false);
            } else if (checkerAtack1.isSelected()) {
                hackersCheckersSecond.remove(0);
                hackersCheckersSecond.add(0, true);
            }

        });

        checkerAtack2.setOnAction(actionEvent -> {
            if (!checkerAtack2.isSelected()) {
                hackersCheckersSecond.remove(1);
                hackersCheckersSecond.add(1, false);
            } else if (checkerAtack2.isSelected()) {
                hackersCheckersSecond.remove(1);
                hackersCheckersSecond.add(1, true);
            }

        });

        checkerAtack3.setOnAction(actionEvent -> {
            if (!checkerAtack3.isSelected()) {
                hackersCheckersSecond.remove(2);
                hackersCheckersSecond.add(2, false);
            } else if (checkerAtack3.isSelected()) {
                hackersCheckersSecond.remove(2);
                hackersCheckersSecond.add(2, true);
            }

        });

        checkerAtack4.setOnAction(actionEvent -> {
            if (!checkerAtack4.isSelected()) {
                hackersCheckersSecond.remove(3);
                hackersCheckersSecond.add(3, false);
            } else if (checkerAtack4.isSelected()) {
                hackersCheckersSecond.remove(3);
                hackersCheckersSecond.add(3, true);
            }

        });

        checkerAtack5.setOnAction(actionEvent -> {
            if (!checkerAtack5.isSelected()) {
                hackersCheckersSecond.remove(4);
                hackersCheckersSecond.add(4, false);
            } else if (checkerAtack5.isSelected()) {
                hackersCheckersSecond.remove(4);
                hackersCheckersSecond.add(4, true);
            }

        });

        checkerAtack6.setOnAction(actionEvent -> {
            if (!checkerAtack6.isSelected()) {
                hackersCheckersSecond.remove(5);
                hackersCheckersSecond.add(5, false);
            } else if (checkerAtack6.isSelected()) {
                hackersCheckersSecond.remove(5);
                hackersCheckersSecond.add(5, true);
            }

        });

        checkerAtack7.setOnAction(actionEvent -> {
            if (!checkerAtack7.isSelected()) {
                hackersCheckersSecond.remove(6);
                hackersCheckersSecond.add(6, false);
            } else if (checkerAtack7.isSelected()) {
                hackersCheckersSecond.remove(6);
                hackersCheckersSecond.add(6, true);
            }

        });

        checkerAtack8.setOnAction(actionEvent -> {
            if (!checkerAtack8.isSelected()) {
                hackersCheckersSecond.remove(7);
                hackersCheckersSecond.add(7, false);
            } else if (checkerAtack8.isSelected()) {
                hackersCheckersSecond.remove(7);
                hackersCheckersSecond.add(7, true);
            }

        });

        checkerAtack9.setOnAction(actionEvent -> {
            if (!checkerAtack9.isSelected()) {
                hackersCheckersSecond.remove(8);
                hackersCheckersSecond.add(8, false);
            } else if (checkerAtack9.isSelected()) {
                hackersCheckersSecond.remove(8);
                hackersCheckersSecond.add(8, true);
            }

        });

        checkerAtack10.setOnAction(actionEvent -> {
            if (!checkerAtack10.isSelected()) {
                hackersCheckersSecond.remove(9);
                hackersCheckersSecond.add(9, false);
            } else if (checkerAtack10.isSelected()) {
                hackersCheckersSecond.remove(9);
                hackersCheckersSecond.add(9, true);
            }

        });

        checkerAtack11.setOnAction(actionEvent -> {
            if (!checkerAtack11.isSelected()) {
                hackersCheckersSecond.remove(10);
                hackersCheckersSecond.add(10, false);
            } else if (checkerAtack11.isSelected()) {
                hackersCheckersSecond.remove(10);
                hackersCheckersSecond.add(10, true);
            }

        });

        checkerAtack12.setOnAction(actionEvent -> {
            if (!checkerAtack12.isSelected()) {
                hackersCheckersSecond.remove(11);
                hackersCheckersSecond.add(11, false);
            } else if (checkerAtack12.isSelected()) {
                hackersCheckersSecond.remove(11);
                hackersCheckersSecond.add(11, true);
            }

        });

        checkerAtack13.setOnAction(actionEvent -> {
            if (!checkerAtack13.isSelected()) {
                hackersCheckersSecond.remove(12);
                hackersCheckersSecond.add(12, false);
            } else if (checkerAtack13.isSelected()) {
                hackersCheckersSecond.remove(12);
                hackersCheckersSecond.add(12, true);
            }

        });

        checkerAtack14.setOnAction(actionEvent -> {
            if (!checkerAtack14.isSelected()) {
                hackersCheckersSecond.remove(13);
                hackersCheckersSecond.add(13, false);
            } else if (checkerAtack14.isSelected()) {
                hackersCheckersSecond.remove(13);
                hackersCheckersSecond.add(13, true);
            }

        });

        checkerProtect1.setOnAction(actionEvent -> {
            if (!checkerProtect1.isSelected()) {
                adminsCheckersSecond.remove(0);
                adminsCheckersSecond.add(0, false);
            } else if (checkerProtect1.isSelected()) {
                adminsCheckersSecond.remove(0);
                adminsCheckersSecond.add(0, true);
            }

        });

        checkerProtect2.setOnAction(actionEvent -> {
            if (!checkerProtect2.isSelected()) {
                adminsCheckersSecond.remove(1);
                adminsCheckersSecond.add(1, false);
            } else if (checkerProtect2.isSelected()) {
                adminsCheckersSecond.remove(1);
                adminsCheckersSecond.add(1, true);
            }

        });

        checkerProtect3.setOnAction(actionEvent -> {
            if (!checkerProtect3.isSelected()) {
                adminsCheckersSecond.remove(2);
                adminsCheckersSecond.add(2, false);
            } else if (checkerProtect3.isSelected()) {
                adminsCheckersSecond.remove(2);
                adminsCheckersSecond.add(2, true);
            }

        });

        checkerProtect4.setOnAction(actionEvent -> {
            if (!checkerProtect4.isSelected()) {
                adminsCheckersSecond.remove(3);
                adminsCheckersSecond.add(3, false);
            } else if (checkerProtect4.isSelected()) {
                adminsCheckersSecond.remove(3);
                adminsCheckersSecond.add(3, true);
            }

        });

        checkerProtect5.setOnAction(actionEvent -> {
            if (!checkerProtect5.isSelected()) {
                adminsCheckersSecond.remove(4);
                adminsCheckersSecond.add(4, false);
            } else if (checkerProtect5.isSelected()) {
                adminsCheckersSecond.remove(4);
                adminsCheckersSecond.add(4, true);
            }

        });

        buttonSumOnClick.setOnAction(actionEvent -> {
            matrix = new Matrix(adminsCheckersSecond, hackersCheckersSecond);
            int output = 0;
            List<Protector> buffProtectors = new ArrayList<>(matrix.protectors);
            List<Threat> buffThreats = new ArrayList<>(matrix.threats);

            scrollForAdmins.setContent(gridForAdmins);
            gridForAdmins.setGridLinesVisible(false);
            gridForAdmins.getColumnConstraints().clear();
            gridForAdmins.getRowConstraints().clear();
            gridForAdmins.getChildren().clear();
            gridForAdmins.setGridLinesVisible(true);

            scrollForHackers.setContent(gridForAtacks);
            gridForAtacks.setGridLinesVisible(false);
            gridForAtacks.getColumnConstraints().clear();
            gridForAtacks.getRowConstraints().clear();
            gridForAtacks.getChildren().clear();
            gridForAtacks.setGridLinesVisible(true);

            for (int i = 0; i < 4; i++){
                if(i == 3) gridForAdmins.getColumnConstraints().add(new ColumnConstraints(300));
                else gridForAdmins.getColumnConstraints().add(new ColumnConstraints(150));
            }
            for (int i = 0; i < 3; i++){
                gridForAtacks.getColumnConstraints().add(new ColumnConstraints(150));
            }

            gridForAdmins.add(new Label("  №"), 0, 0);
            gridForAdmins.add(new Label("  Название"), 1, 0);
            gridForAdmins.add(new Label("  Стоимость"), 2, 0);
            gridForAdmins.add(new Label("  От каких угроз защищает"), 3, 0);

            gridForAtacks.add(new Label("  №"),0,0);
            gridForAtacks.add(new Label("  Название"),1,0);
            gridForAtacks.add(new Label("  Возможный ущерб"),2,0);

            /*
            Set<Protector> a = new HashSet<>(buffProtectors);
            Set<Threat> b = new HashSet<>(buffThreats);

            buffProtectors.clear();
            buffThreats.clear();

            buffProtectors.addAll(a);
            buffThreats.addAll(b);

             */

            for (int i = 0; i < buffProtectors.size(); i++) {
                gridForAdmins.getRowConstraints().add(new RowConstraints(50));
                gridForAdmins.add(new Label("  " + String.valueOf(i + 1)), 0, i + 1);
                gridForAdmins.add(new Label(buffProtectors.get(i).getName()), 1, i + 1);
                gridForAdmins.add(new Label(String.valueOf(buffProtectors.get(i).getCost())), 2, i + 1);
                if (buffProtectors.get(i).getThreats().size() == 3) {
                    gridForAdmins.add(new Label(buffProtectors.get(i).getThreats().get(0) + " " +
                            buffProtectors.get(i).getThreats().get(1) + " " + buffProtectors.get(i).getThreats().get(2)), 3, i + 1);

                } else {
                    gridForAdmins.add(new Label(buffProtectors.get(i).getThreats().get(0) + " " +
                            buffProtectors.get(i).getThreats().get(1) + " "), 3, i + 1);
                }
            }
            gridForAdmins.getRowConstraints().add(new RowConstraints(50));
            for (int i = 0; i < buffThreats.size(); i++){
                gridForAtacks.getRowConstraints().add(new RowConstraints(50));
                gridForAtacks.add(new Label("  " + String.valueOf(i)),0,i+1);
                gridForAtacks.add(new Label(buffThreats.get(i).getName()),1,i+1);
                gridForAtacks.add(new Label(String.valueOf(buffThreats.get(i).getCost())),2,i+1);
            }
            gridForAtacks.getRowConstraints().add(new RowConstraints(50));

            for(Protector protector : buffProtectors){
                buffThreats.removeIf(threat -> protector.getThreats().contains(threat.getName()));
            }

            for(Protector protector: buffProtectors){
                output += protector.getCost();
            }
            for(Threat threat : buffThreats){
                output += threat.getCost();
            }

            outputWindow.clear();
            outputWindow.insertText(0, "  Возможный ущерб " + output);


        });
    }


}

