import java.util.ArrayList;
import java.util.List;

public class PersonalizedMealPlanGenerator {

    // Common interface for all meal plans
    interface MealPlan {
        String getPlanName();

        boolean isValid();
    }

    static class VegetarianMeal implements MealPlan {
        public String getPlanName() {
            return "Vegetarian";
        }

        public boolean isValid() {
            return true;
        }
    }

    static class VeganMeal implements MealPlan {
        public String getPlanName() {
            return "Vegan";
        }

        public boolean isValid() {
            return true;
        }
    }

    static class KetoMeal implements MealPlan {
        public String getPlanName() {
            return "Keto";
        }

        public boolean isValid() {
            return true;
        }
    }

    static class HighProteinMeal implements MealPlan {
        public String getPlanName() {
            return "High-Protein";
        }

        public boolean isValid() {
            return true;
        }
    }

    // Generic meal class
    static class Meal<T extends MealPlan> {
        private String mealName;
        private T mealPlan;

        Meal(String mealName, T mealPlan) {
            this.mealName = mealName;
            this.mealPlan = mealPlan;
        }

        T getMealPlan() {
            return mealPlan;
        }

        @Override
        public String toString() {
            return mealName + " | " + mealPlan.getPlanName();
        }
    }

    // Generic method to validate and generate a meal
    static <T extends MealPlan> Meal<T> generateMeal(
            String mealName, T plan) {

        if (!plan.isValid()) {
            throw new IllegalArgumentException(
                    "Invalid meal plan");
        }

        return new Meal<>(mealName, plan);
    }

    // Wildcard method to display different meal plans
    static void displayMeals(List<? extends MealPlan> plans) {
        for (MealPlan plan : plans) {
            System.out.println(plan.getPlanName());
        }
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegetarian =
                generateMeal("Vegetable Salad", new VegetarianMeal());

        Meal<VeganMeal> vegan =
                generateMeal("Vegan Bowl", new VeganMeal());

        Meal<KetoMeal> keto =
                generateMeal("Keto Breakfast", new KetoMeal());

        Meal<HighProteinMeal> protein =
                generateMeal("Protein Bowl", new HighProteinMeal());

        System.out.println("--- Generated Meal Plans ---");

        System.out.println(vegetarian);
        System.out.println(vegan);
        System.out.println(keto);
        System.out.println(protein);

        List<MealPlan> allPlans = new ArrayList<>();

        allPlans.add(vegetarian.getMealPlan());
        allPlans.add(vegan.getMealPlan());
        allPlans.add(keto.getMealPlan());
        allPlans.add(protein.getMealPlan());

        System.out.println("\n--- Available Categories ---");
        displayMeals(allPlans);
    }
}