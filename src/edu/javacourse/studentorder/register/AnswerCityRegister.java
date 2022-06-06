package edu.javacourse.studentorder.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
    public boolean success;
    private List<AnswerCityRegisterItem> items;

    public List<AnswerCityRegisterItem> getItems() {
        return items;
    }

    public void addItem(AnswerCityRegisterItem item) {
        if (this.items == null)
            this.items = new ArrayList<>(10);
        this.items.add(item);
    }
}
