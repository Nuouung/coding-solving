public class SkillTree {

    public int solution(String skill, String[] skillTrees) {

        String[] compactTrees = new String[skillTrees.length];

        int result = 0;
        for (int i = 0; i < skillTrees.length; i++) {
            compactTrees[i] = inspect(skill, skillTrees[i]);
        }

        for (int i = 0; i < skillTrees.length; i++) {
            boolean check = skillTrueOrFalse(skill, compactTrees[i]);
            if (check) {
                result += 1;
            }
        }

        return result;
    }

    private boolean skillTrueOrFalse(String skill, String skillTree) {

        if (skillTree.length() == 0) {
            return true;
        }

        for (int i = 0; i < skillTree.length(); i++) {
            String currentTree = skillTree.substring(i, i + 1);
            String currentSkill = skill.substring(i, i + 1);
            if (currentTree.equals(currentSkill)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private String inspect(String skill, String skillTree) {

        String result = "";
        for (int i = 0; i < skillTree.length(); i++) {
            String currentTree = skillTree.substring(i, i + 1);
            for (int j = 0; j < skill.length(); j++) {
                String currentSkill = skill.substring(j, j + 1);

                if (currentTree.equals(currentSkill)) {
                    result += currentSkill;
                }
            }
        }
        return result;
    }
}