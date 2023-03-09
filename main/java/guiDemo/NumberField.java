package guiDemo;

import javafx.scene.control.TextField;

public class NumberField extends TextField {

    public NumberField() {
        this.setPromptText("MM/DD/YYYY");
    }

    @Override
    public void replaceText(int start, int end, String text) {
        String currentText = getText() == null ? "" : getText();
        String newText = currentText.substring(0, start) + text + currentText.substring(end);

        if (newText.matches("(^$|^\\d{1,2}$|^\\d{1,2}/$|^\\d{1,2}/\\d{1,2}$|^\\d{1,2}/\\d{1,2}/\\d{0,4}$|^\\d{1,2}/\\d{1,2}/\\d{1,4}$)")) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (text.matches("[0-9/]") || text.isEmpty()) {
            super.replaceSelection(text);
        }
    }
}
