package main;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Module {

    public static ArrayList<Module> list = new ArrayList<>();

    public static void updateAll() {
        if (list.size() > 0) for (int i = 0; i < list.size(); i++) {
            Module module = list.get(i);
            module.update();
        }
        Frame.mousePressed = 0;
    }

    ArrayList<Module> modules = new ArrayList<>();

    Module addModule(Module module) {
        modules.add(module);
        return module;
    }

    public Module() {
        list.add(this);
    }

    public void update() {
        if (Frame.mousePressed > 0) mousePressed();
    }

    public void mousePressed() {

    }

    String getClassName() {
        return getClass().getSimpleName();
    }

    ArrayList<Module> getModulesWithClassName(String name) {
        ArrayList<Module> result = new ArrayList<>();
        for (Module module :
                modules) {
            System.out.println(module.getClassName());
            if (module.getClassName().equals(name)) {
                result.add(module);
            }
        }
        return result;
    }

    ArrayList<Module> getOwners() {
        ArrayList<Module> result = new ArrayList<>();
        for (Module module :
                list) {
            if (module.modules.contains(this)) {
                result.add(module);
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////

}
