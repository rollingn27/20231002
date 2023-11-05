public class MinNumberOfHours {
    public static void main(String[] args) {
        int initialEnergy = 11;
        int initialExperience = 23;
        int[] energy = { 69,22,93,68,57,76,54,72,8,78,88,15,58,61,25,70,58,91,79,22,91,74,90,75,31,53,31,7,51,96,76,17,64,89,83,54,28,33,32,45,20 };
        int[] experience = { 51,81,46,80,56,7,46,74,64,20,84,66,13,91,49,30,75,43,74,88,82,51,72,4,80,30,10,19,40,27,21,71,24,94,79,13,40,28,63,85,70 };

        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

//    1, 1, [1, 1, 1, 1], [1, 1, 1, 50]

//    initialEnergy = 2, initialExperience = 4, energy = [1], experience = [3]
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int energyTime = 0;
        int experienceTime = 0;

        int energySum = 0;

        for (int i = 0; i < energy.length; i++) {
            energySum += energy[i];
        }

        if (initialEnergy <= energySum) {
            energyTime = energySum - initialEnergy + 1;
        }


        for (int i = 0; i < experience.length; i++) {

            if (initialExperience <= experience[i]) {
                int trainingTime = experience[i] - initialExperience + 1;
                experienceTime += trainingTime;
                initialExperience += trainingTime + experience[i];
            } else {
                initialExperience += experience[i];
            }
        }

        return energyTime + experienceTime;
    }
}