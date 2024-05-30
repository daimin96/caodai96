package problem1.entities;

import java.util.ArrayList;

public class SkillList {
    private ArrayList<String> skillList;

    public SkillList() {
        skillList = new ArrayList<>();
        skillList.add("Java");
        skillList.add("Net");
        skillList.add("Android");
        skillList.add("NodeJS");
        skillList.add("Angular");
        skillList.add("AI");
    }

    public void display() {
        for (String skill : skillList) {
            System.out.println(skill);
        }
    }

    public boolean getHead(String skill) {
        return skillList.contains(skill);
    }


    public boolean remove(String skill) {
        return skillList.remove(skill);
    }

    public void update(int index, String skill) {
        if (index >= 0 && index < skillList.size()) {
            skillList.set(index, skill);
        }
    }
}
