package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, String> menu;

    public Menu() {
        this.menu = new HashMap<String, String>();
    }

    public void addMenu(String option, String menu) {
        this.menu.put(option, menu);
    }

    public String getMenu() {
        String menuList = "";
        for (Map.Entry<String, String> menu : this.menu.entrySet()) {
            menuList += menu.getKey() + ". " + menu.getValue() + '\n';
        }
        return menuList;
    }

    public void showMenu() {
        System.out.println(this.getMenu());
    }
}
