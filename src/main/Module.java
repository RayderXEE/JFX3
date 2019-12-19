package main;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Module {

    public static ArrayList<Module> list = new ArrayList<>();
    public static Module game = new Game();

    public static void updateAll() {
        if (list.size() > 0) for (int i = 0; i < list.size(); i++) {
            Module module = list.get(i);
            module.update();
        }
        Frame.mousePressed = 0;
    }

    boolean wasFirstUpdate = false;

    ArrayList<Module> modules = new ArrayList<>();
    Module owner;

    Module addModule(Module module) {
        modules.add(module);
        module.owner = this;
        return this;
    }

    Module setOwner(Module module) {
        if (owner != null) {
            owner.modules.remove(this);
        }
        module.modules.add(this);
        owner = module;
        return this;
    }

    Module removeModule(Module module) {
        modules.remove(module);
        module.owner = null;
        return this;
    }

    Module removeOwner(Module module) {
        module.modules.remove(this);
        owner = null;
        return this;
    }

    public Module() {
        list.add(this);
        if (!(this instanceof Game)) {
            Module.game.addModule(this);
        }
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
