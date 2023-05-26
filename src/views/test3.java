//for (int i = 0; i < 15; i++) {
//        RowConstraints rowConstraints = new RowConstraints();
//        rowConstraints.setPercentHeight(50);
//        rowConstraints.setValignment(VPos.CENTER);
//        map.getRowConstraints().add(rowConstraints);
//        ColumnConstraints columnConstraints  = new ColumnConstraints();
//        columnConstraints.setPercentWidth(20);
//        columnConstraints.setHalignment(HPos.CENTER);
//        map.getColumnConstraints().add(columnConstraints);
//        for (int j = 0; j < 15; j++) {
//        Cell cell = Game.map[i][j];
//        if (cell instanceof CollectibleCell) {
//        if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Vaccine) {
//        Button Vaccine = new Button("V");
////                        Vaccine.setOnAction(e -> setInvalidTargetCellAsTarget(Vaccine));
////                        duringGameLayout = new Group(Vaccine);
//        Vaccine.setStyle("-fx-background-color: blue");
//        Vaccine.setMinWidth(40);
//        Vaccine.setMinHeight(20);
////                        map.setConstraints(Vaccine,  j ,14-i);
//        map.add(Vaccine, j ,14-i);
////                        map.getChildren().add(Vaccine);
//        } else if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Supply) {
//        Button Supply = new Button("S");
////                        Supply.setOnAction(e -> setInvalidTargetCellAsTarget(Supply));
////                        duringGameLayout = new Group(Supply);
//        Supply.setStyle("-fx-background-color: Yellow");
//        Supply.setMinWidth(40);
//        Supply.setMinHeight(20);
////                        GridPane.setConstraints(Supply, j ,14-i);
//        map.add(Supply , j , 14-i);
////                        map.getChildren().add(Supply);
//        }
//        } else if ((cell instanceof  CharacterCell)&&(((CharacterCell)cell).getCharacter() != null)) {
//        if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie) {
////                        Button zombie = new Button( "Z "+((Zombie)(Character)((CharacterCell) Game.map[i][j]).getCharacter()).getZombiesCount());
//        Button zombie = new Button("Z");
//        zombie.setOnAction(e -> {
//        try {
//        setZombieAsTarget(zombie);
//        } catch (IOException ex) {
//        throw new RuntimeException(ex);
//        }
//        });
////                        duringGameLayout = new Group(zombie);
//        zombie.setStyle("-fx-background-color: red");
//        zombie.setMinWidth(40);
//        zombie.setMinHeight(20);
////                        GridPane.setConstraints(zombie,   j ,14-i);
//        map.add(zombie,j,14-i);
////                        map.getChildren().add(zombie);
//        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
////                        Button Hero = new Button( ((CharacterCell) Game.map[i][j]).getCharacter().getName());
//        Button Hero = new Button("H");
//        Hero.setOnAction((e) -> {
//        setCurrentHero(Hero);
////                            setHeroAsTarget(Hero);
//        });
////                        duringGameLayout = new Group(Hero);
//        Hero.setStyle("-fx-background-color: black");
//        Hero.setMinWidth(40);
//        Hero.setMinHeight(20);
////                        GridPane.setConstraints(Hero,  j ,14-i);
//        map.add(Hero , j,14-i);
////                        map.getChildren().add(Hero);
//        }
//        } else {
//        Button empty = new Button("E");
////                    empty.setOnAction(e -> setInvalidTargetCellAsTarget(empty));
////                    duringGameLayout = new Group(empty);
//        empty.setMinWidth(40);
//        empty.setMinHeight(20);
////                    GridPane.setConstraints(empty, j ,14-i);
//        map.add(empty , j,14-i);
////                    map.getChildren().add(empty);
//        }
//        }
//        }