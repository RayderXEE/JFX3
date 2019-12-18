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

    boolean wasFirstUpdate = false;

    ArrayList<Module> modules = new ArrayList<>();
    ArrayList<Module> owners = new ArrayList<>();

    Module addModule(Module module) {
        modules.add(module);
        module.owners.add(this);
        return this;
    }

    Module addOwner(Module module) {
        module.modules.add(this);
        owners.add(module);
        return this;
    }

    Module removeModule(Module module) {
        modules.remove(module);
        module.owners.remove(this);
        return this;
    }

    Module removeOwner(Module module) {
        module.modules.remove(this);
        owners.remove(module);
        return this;
    }

    public Module() {
        list.add(this);
    }

    public void update() {
        if (wasFirstUpdate == false) {
            wasFirstUpdate = true;
            firstUpdate();
        }

        if (Frame.mousePressed > 0) mousePressed();
    }

    public void firstUpdate() {

    }

    public void mousePressed() {

    }

    String getClassName() {
        return getClass().getSimpleName();
    }

    Module getOwner() {
        return owners.get(0);
    }

    Module getModuleWithClassName(String name) {
        ArrayList<Module> modulesWithSameName = getModulesWithClassName(name);
        if (modulesWithSameName.size() > 0) return getModulesWithClassName(name).get(0);
        return null;
    }

    ArrayList<Module> getModulesWithClassName(String name) {
        ArrayList<Module> result = new ArrayList<>();
        for (Module module :
                modules) {
            if (module.getClassName().equals(name)) {
                result.add(module);
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////

}
