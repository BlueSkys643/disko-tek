package guiDemo;

import javafx.scene.control.TextField;

public class EmailField extends TextField {

    public EmailField() {
        this.setPromptText("user@domain.com");
    }

    @Override
    public void replaceText(int start, int end, String text) {
        String currentText = getText() == null ? "" : getText();
        String newText = currentText.substring(0, start) + text + currentText.substring(end);

        if (newText.matches("(^$|^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$)")) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (text.matches("[a-zA-Z0-9._%+-@]") || text.isEmpty()) {
            super.replaceSelection(text);
        }
    }
}
