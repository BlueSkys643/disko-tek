package guiDemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class UserRegistrationPage extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateUsername() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 12; // desired length of username
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return sb.toString();
    }

    int userAge;

    public boolean isOver21(TextField textField) {
        String dateInput = textField.getText();

        // Validate input format
        if (!dateInput.matches("^(0?[1-9]|1[0-2])/([0-2]?[0-9]|3[0-1])/\\d{4}$")) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        try {
            Date date = sdf.parse(dateInput);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1; // Note that Calendar.MONTH starts at 0
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int year = calendar.get(Calendar.YEAR);
            Calendar dob = Calendar.getInstance();
            dob.set(year, month - 1, day);
            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }
            return age >= 21;
        } catch (ParseException e) {
            // Invalid date format
            return false;
        }
    }

    public int extractAgeFromInputDate(NumberField numberField) {
        String dateInput = numberField.getText();
        LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();
        return Period.between(date, now).getYears();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        int userAge = 0;

        primaryStage.setTitle("Diskotek");

        Label pageDescription1 = new Label("Welcome to Diskotek!\nLet's set up your account.");
        pageDescription1.setStyle("-fx-font-size:19px;");

        // Create the login form fields
        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();
        nameField.setPromptText("Walter White");
        nameField.setPrefWidth(150);

        Label ageLabel = new Label("Date of birth: ");
        NumberField ageField = new NumberField();
        ageField.setPromptText("MM/DD/YYYY");

        nameField.setFocusTraversable(false);
        ageField.setFocusTraversable(false);


        // Create the login button
        Button loginButton = new Button("Continue");
        loginButton.getStyleClass().add("button");
        loginButton.setCursor(Cursor.HAND);

        loginButton.setFocusTraversable(false);

        // Set the font for the login button
        loginButton.setFont(Font.font(14));

        // Set the action for the login button
        loginButton.setOnAction(event -> {
            // Validate user credentials and log them in
        });

        // Create the login form grid layout
        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(15, 15, 15, 15));
        loginGrid.setVgap(12);
        loginGrid.setHgap(12);
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setStyle("-fx-background-color: #ffffff;");

        GridPane.setConstraints(pageDescription1, 0, 0, 2, 2, null, null, null, null, new Insets(0, 0, 10, 0));

        // Add the login form fields and login button to the grid
        GridPane.setConstraints(nameLabel, 0, 2);
        GridPane.setConstraints(nameField, 1, 2);
        GridPane.setConstraints(ageLabel, 0, 3);
        GridPane.setConstraints(ageField, 1, 3);

        GridPane.setConstraints(loginButton, 0, 5, 2, 1);
        loginGrid.setColumnSpan(loginButton, 1);
        loginButton.setMaxWidth(Double.MAX_VALUE);

        RowConstraints buttonConstraints = new RowConstraints();
        buttonConstraints.setVgrow(Priority.ALWAYS);
        buttonConstraints.setFillHeight(true);
        loginGrid.getRowConstraints().add(buttonConstraints);

        ImageView imageView = new ImageView(new Image("https://nuken.xyz/images/pink.jpg"));

// Set the size of the ImageView
        imageView.setFitWidth(200);
        imageView.setFitHeight(100);
        imageView.setTranslateX(25);
        imageView.setScaleX(6);
        imageView.setScaleY(6);


// Add the ImageView to the registration form grid layout
        GridPane.setConstraints(imageView, 0, 1, 2, 1, null, null, null, null, new Insets(10, 0, 10, 0));
        loginGrid.getChildren().add(imageView);

        GridPane.setConstraints(loginButton, 0, 5, 2, 1);
        loginGrid.setColumnSpan(loginButton, 2);
        loginButton.setMaxWidth(Double.MAX_VALUE);

        loginGrid.getChildren().addAll(pageDescription1, nameLabel, nameField, ageLabel, ageField, loginButton);

        // Create the login form scene and display it
        Scene loginScene = new Scene(loginGrid, 300, 350);
        loginScene.getStylesheets().add("https://nuken.xyz/images/disko.css");
        primaryStage.setResizable(false);

        Image icon = new Image("https://nuken.xyz/images/disko.png");

        // Set the icon of the primary stage
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(loginScene);
        primaryStage.show();

        Label registerLabel = new Label("Almost done!\nJust a few more things.");
        registerLabel.setStyle("-fx-font-size:19px;");

        // Create the registration form fields
        Label emailLabel = new Label("Email Address: ");
        TextField emailField = new TextField();
        emailField.setPromptText("user@domain.com");

        Label usernameLabel = new Label("Username: ");
        TextField usernameField = new TextField();
        usernameField.setPromptText("heisenberg");

        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Choose a password");

        emailField.setFocusTraversable(false);
        usernameField.setFocusTraversable(false);
        passwordField.setFocusTraversable(false);

        // Create the register button
        Button registerButton = new Button("Create an account");
        registerButton.getStyleClass().add("button");
        registerButton.setCursor(Cursor.HAND);


        // Set the font for the register button
        registerButton.setFont(Font.font(14));

        // Set the action for the register button
        registerButton.setOnAction(event -> {
            // Create a new user account
        });

        // Create the registration form grid layout
        GridPane registrationGrid = new GridPane();
        registrationGrid.setPadding(new Insets(15, 15, 15, 15));
        registrationGrid.setVgap(10);
        registrationGrid.setHgap(12);
        registrationGrid.setAlignment(Pos.CENTER);
        registrationGrid.setStyle("-fx-background-color: #ffffff;");

        // Add the registration form fields and registration button to the grid
        GridPane.setConstraints(registerLabel, 0, 0);
        GridPane.setConstraints(emailLabel, 0, 2);
        GridPane.setConstraints(emailField, 1, 2);
        GridPane.setConstraints(usernameLabel, 0, 3);
        GridPane.setConstraints(usernameField, 1, 3);
        GridPane.setConstraints(passwordLabel, 0, 4);
        GridPane.setConstraints(passwordField, 1, 4);

        GridPane.setConstraints(registerLabel, 0, 0, 2, 2, null, null, null, null, new Insets(0, 0, 0, 0));

        GridPane.setConstraints(registerButton, 0, 5, 2, 1, null,null,null,null, new Insets(10,0,0,0));
        registrationGrid.setColumnSpan(registerButton, 1);
        registerButton.setMaxWidth(Double.MAX_VALUE);

        RowConstraints buttonConstraints2 = new RowConstraints();
        buttonConstraints2.setVgrow(Priority.ALWAYS);
        buttonConstraints2.setFillHeight(true);
        registrationGrid.getRowConstraints().add(buttonConstraints2);

        ImageView imageView2 = new ImageView(new Image("https://nuken.xyz/images/pink.jpg"));

// Set the size of the ImageView
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(100);
        imageView2.setTranslateX(25);
        imageView2.setScaleX(6);
        imageView2.setScaleY(6);


// Add the ImageView to the registration form grid layout
        GridPane.setConstraints(imageView2, 0, 0, 2, 1, null, null, null, null, new Insets(10, 0, 10, 0));
        registrationGrid.getChildren().add(imageView2);

        GridPane.setConstraints(registerButton, 0, 5, 2, 1);
        registrationGrid.setColumnSpan(registerButton, 2);
        registerButton.setMaxWidth(Double.MAX_VALUE);

        registrationGrid.getChildren().addAll(registerLabel, emailLabel, emailField, usernameLabel, usernameField, passwordLabel, passwordField, registerButton);

        // Create the registration form scene
        Scene registrationScene = new Scene(registrationGrid, 300, 350);

        registrationScene.getStylesheets().add("https://nuken.xyz/images/disko.css");

        GridPane successGrid = new GridPane();
        successGrid.setPadding(new Insets(15, 15, 15, 15));
        successGrid.setVgap(1);
        successGrid.setHgap(1);
        successGrid.setAlignment(Pos.CENTER);
        successGrid.setStyle("-fx-background-color: #ffffff;");

        ImageView imageView3 = new ImageView(new Image("https://nuken.xyz/images/pink.jpg"));

// Set the size of the ImageView
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(100);
        imageView3.setTranslateX(25);
        imageView3.setScaleX(6);
        imageView3.setScaleY(6);


        GridPane.setConstraints(imageView3, 0, 2, 2, 1, null, null, null, null, new Insets(10, 0, 10, 0));
        successGrid.getChildren().add(imageView3);


        Scene successScene = new Scene(successGrid, 300, 350);

        Label successLabel = new Label("Success!");
        successLabel.setStyle("-fx-font-size: 22pt;");
        Label successLabel2 = new Label("This demo is over.\nAn account object has been created,\nand is ready to be shippped elsewhere.");
        GridPane.setConstraints(successLabel, 0, 0,1,1);
        GridPane.setConstraints(successLabel2, 0, 2,1,1);
        successLabel.getStyleClass().add(".label");
        successLabel2.getStyleClass().add(".label");

        successGrid.getChildren().addAll(successLabel,successLabel2);

        successScene.getStylesheets().add("https://nuken.xyz/images/disko.css");


        // Set the action for the login button to switch to the registration form
        loginButton.setOnAction(event -> {

            boolean verifiedUser = isOver21(ageField);


            if (verifiedUser) {
                loginButton.setStyle("-fx-opacity:1.0;");
                loginButton.setText("...");
                primaryStage.setScene(registrationScene);


                if (nameField.getText().isEmpty()){
                    nameField.setText("John Smith");
                }

            } else {
loginButton.setStyle("-fx-opacity:0.5;");
loginButton.setText("Must be 21+");
            }



        });

        // Set the action for the register button to switch back to the login form
        registerButton.setOnAction(event -> {
            // Create a new user account

            //if both username field and password field contain input, continue.
            if (!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty() ) {

                if (emailField.getText().isEmpty()) {

                    emailField.setText("USER_DECLINED");

                }

                    String preName = nameField.getText();
                    int age = userAge;
                    String dob = ageField.getText();
                    String email = emailField.getText();
                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    String firstname = preName.split(" ")[0];
                    String lastname = preName.split(" ")[1];


                    UserAccount userAccount = new UserAccount(firstname, lastname, dob, age, email, username, password);

                    // TODO: Save the user account to a database or file

                    // Print the user account information to the console
                    System.out.println("User account created:");
                    System.out.println("First Name: " + userAccount.getFirstName());
                    System.out.println("Last Name: " + userAccount.getLastName());
                    System.out.println("Date of Birth: " + userAccount.getDOB());
                    System.out.println("Age: " + extractAgeFromInputDate(ageField));
                    System.out.println("Email: " + userAccount.getEmail());
                    System.out.println("Username: " + userAccount.getUsername());
                    System.out.println("Password: " + userAccount.getPassword());


                    primaryStage.setScene(successScene);

            } else {


                if (usernameField.getText().isEmpty()){

                    usernameField.setText(generateUsername());

                }

                if (passwordField.getText().isEmpty()){
                    registerButton.setStyle("-fx-opacity:0.5;");
                    registerButton.setText("Choose a password.");
                }

            }

        });

    }}
