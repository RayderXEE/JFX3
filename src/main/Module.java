package main;

import java.util.ArrayList;

/**
 * Created by Artem on 30.01.2020.
 */
public class Module {

    static ArrayList<Module> list = new ArrayList<>();

    static void updateAll() {
        for (int i=0; i<list.size();i++) {
            Module module = list.get(i);
            module.update();
        }
    }

    public Module() {
        list.add(this);
    }

    void update() {

    }

}
